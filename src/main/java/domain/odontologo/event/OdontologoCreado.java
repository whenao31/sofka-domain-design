package domain.odontologo.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.odontologo.Auxiliar;
import domain.odontologo.valor.AuxiliarId;
import domain.odontologo.valor.OdontologoId;

public class OdontologoCreado extends DomainEvent {
    private final OdontologoId odontologoId;
    private final Auxiliar auxiliar;

    public OdontologoCreado(OdontologoId odontologoId, Auxiliar auxiliar) {
        super("odontologo.odontologocreado");
        this.odontologoId = odontologoId;
        this.auxiliar = auxiliar;
    }

    public OdontologoId getOdontologoId() {
        return odontologoId;
    }

    public Auxiliar getAuxiliar() {
        return auxiliar;
    }
}
