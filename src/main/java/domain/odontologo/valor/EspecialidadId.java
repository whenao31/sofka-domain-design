package domain.odontologo.valor;

import co.com.sofka.domain.generic.Identity;

public class EspecialidadId extends Identity  {
    private EspecialidadId(String valor){
        super(valor);
    }

    public EspecialidadId(){}
    public static EspecialidadId of(String valor){
        return new EspecialidadId(valor);
    }

}
