package domain.tratamiento.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Diente implements ValueObject<Diente.Props> {

    private final Codigo codigo;
    private final String diagnostico;

    public Diente(Codigo codigo, String diagnostico) {
        this.codigo = codigo;
        this.diagnostico = Objects.requireNonNull(diagnostico);

    }

    public Diente() {
        this(Codigo.ESCOGER,"Ingresar Diagnostico");
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Codigo codigo() {
                return codigo;
            }

            @Override
            public String diagnostico() {
                return diagnostico;
            }
        };
    }

    public enum Codigo{
        ESCOGER, ONCE, DOCE, TRECE,
        VEINTIUNO, VEINTIDOS, VENTITRES,
        TREINTAYUNO, TREINTAYDOS, TREINTAYTRES,
        CUARENTAYUNO, CUARENTAYDOS, CUARENTAYTRES
    }

    public interface Props {
        Codigo codigo();
        String diagnostico();
    }
}
