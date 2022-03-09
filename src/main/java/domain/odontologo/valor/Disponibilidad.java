package domain.odontologo.valor;

import co.com.sofka.domain.generic.ValueObject;

public class Disponibilidad implements ValueObject<Disponibilidad.Disponible> {
    private final Disponible value;

    public Disponibilidad(Disponible value) {
        this.value = value;
    }

    @Override
    public Disponible value() {
        return value;
    }

    public enum Disponible {
        DISPONIBLE, NO_DISPONIBLE
    }
}
