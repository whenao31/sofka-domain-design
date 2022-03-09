package domain.tratamiento.valueobject;

import co.com.sofka.domain.generic.Identity;

public class OdontologoId extends Identity {

    private OdontologoId(String valor){
        super(valor);
    }

    public OdontologoId(){}

    public static OdontologoId of(String valor){
        return new OdontologoId(valor);
    }
}
