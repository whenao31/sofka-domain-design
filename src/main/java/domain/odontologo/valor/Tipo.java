package domain.odontologo.valor;

import co.com.sofka.domain.generic.ValueObject;

public class Tipo implements ValueObject<String> {
    private final String value;

    public Tipo(String value) {
        this.value = value;
    }
    public Tipo(){
        this("");
    }

    @Override
    public String value() {
        return null;
    }
}
