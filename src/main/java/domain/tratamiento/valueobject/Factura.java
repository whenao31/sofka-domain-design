package domain.tratamiento.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Factura implements ValueObject<Factura.Props> {

    private final String numeroFactura;
    private final Fecha fecha;
    private final Dinero total;

    public Factura() {
        this(
                "",
                new Fecha(),
                new Dinero(0));
    }

    public Factura(String numeroFactura, Fecha fecha, Dinero total) {
        this.numeroFactura = Objects.requireNonNull(numeroFactura);
        this.fecha = Objects.requireNonNull(fecha);
        this.total = Objects.requireNonNull(total);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String numeroFactura() {
                return numeroFactura;
            }

            @Override
            public Fecha fecha() {
                return fecha;
            }

            @Override
            public Dinero dinero() {
                return total;
            }
        };
    }

    public interface Props {
        String numeroFactura();
        Fecha fecha();
        Dinero dinero();
    }
}
