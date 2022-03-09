package domain.tratamiento.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Hora implements ValueObject<String> {

    private final LocalTime hora;
    private final String formato;

    public Hora(){
        this(LocalTime.now().getHour(), LocalTime.now().getMinute());
    }

    public Hora(int horas, int minutos){
        try {
            hora = LocalTime.of(horas, minutos);
            if(hora.isBefore(LocalTime.now())){
                throw new IllegalArgumentException("Hora no valida");
            }
        }catch(DateTimeException e){
            throw new IllegalArgumentException(e.getMessage());
        }
        formato = generarFormato();
    }

    private String generarFormato(){
        return hora.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public Long calcularHorasDesdeAhora(){
        return ChronoUnit.HOURS.between(LocalTime.now(), hora);
    }

    @Override
    public String value(){
        return formato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hora)) return false;
        Hora hora = (Hora) o;
        return formato.equals(hora.formato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formato);
    }
}
