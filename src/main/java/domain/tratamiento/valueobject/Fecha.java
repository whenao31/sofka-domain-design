package domain.tratamiento.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Fecha implements ValueObject<String> {

    private final LocalDate date;
    private final String format;

    public Fecha(){
        this(LocalDate.now().getDayOfMonth(),
                LocalDate.now().getMonthValue(),
                LocalDate.now().getYear());
    }

    public Fecha(int dia, int mes, int year) {
        try {
            date = LocalDate.of(year, mes, dia);
            if(date.isBefore(LocalDate.now())){
                throw new IllegalArgumentException("Fecha no valida");
            }
        } catch (DateTimeException e){
            throw new IllegalArgumentException(e.getMessage());
        }
        format = generarFormato();
    }

    private String generarFormato(){
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public Long calcularDiasDesdeAhora(){
        return ChronoUnit.DAYS.between(LocalDate.now(), date);
    }

    @Override
    public String value() {//(3)
        return format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fecha that = (Fecha) o;
        return Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {//(5)
        return Objects.hash(format);
    }
}
