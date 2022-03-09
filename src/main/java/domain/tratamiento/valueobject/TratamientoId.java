package domain.tratamiento.valueobject;

import co.com.sofka.domain.generic.Identity;

public class TratamientoId extends Identity {

    private TratamientoId(String valor){
        super(valor);
    }

    public TratamientoId(){}

    public static TratamientoId of(String valor){
        return new TratamientoId(valor);
    }
}
