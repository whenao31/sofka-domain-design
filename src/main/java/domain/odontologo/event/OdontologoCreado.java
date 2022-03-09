package domain.odontologo.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.odontologo.valor.AuxiliarId;

public class OdontologoCreado extends DomainEvent {

    public OdontologoCreado() {
        super("odontologo.odontologocreado");
    }


}
