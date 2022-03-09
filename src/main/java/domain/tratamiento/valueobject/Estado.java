package domain.tratamiento.valueobject;

import co.com.sofka.domain.generic.ValueObject;

public class Estado implements ValueObject<Estado.Fase> {
    private final Fase value;

    public Estado(Fase value) {
        this.value = value;
    }

    @Override
    public Fase value() {
        return value;
    }

    public enum Fase {
        CONFIRMADO, PENDIENTE, CANCELADO
    }
}
