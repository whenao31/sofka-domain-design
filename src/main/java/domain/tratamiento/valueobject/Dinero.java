package domain.tratamiento.valueobject;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Dinero implements ValueObject<Integer> {

    private final Integer value;

    public Dinero(Integer value){
        this.value = Objects.requireNonNull(value);
        if (this.value < 0){
            throw new IllegalArgumentException("Ingresar una cantidad de dinero valida");
        }
    }

    @Override
    public  Integer value(){
        return value;
    }
}
