package domain.odontologo.valor;

import co.com.sofka.domain.generic.Identity;

public class AuxiliarId extends Identity {
    private AuxiliarId(String valor){
        super(valor);
    }

    public AuxiliarId(){}
    public static AuxiliarId of(String valor){
        return new AuxiliarId(valor);
    }
}
