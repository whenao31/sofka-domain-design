package domain.odontologo.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.odontologo.valor.AuxiliarId;

public class OdontologoCreado extends DomainEvent {
    private final AuxiliarId auxiliarId;

    public OdontologoCreado(AuxiliarId auxiliarId) {
        super("odontologo.odontologocreado");
        this.auxiliarId = auxiliarId;
    }

    public AuxiliarId getAuxiliarId() {
        return auxiliarId;
    }
}
