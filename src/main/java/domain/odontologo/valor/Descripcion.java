package domain.odontologo.valor;

import co.com.sofka.domain.generic.ValueObject;

public class Descripcion implements ValueObject<String> {

    private final String descripcion;

    public Descripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Descripcion(){
        this("");
    }

    @Override
    public String value() {
        return descripcion;
    }
}
