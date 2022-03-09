package domain.tratamiento.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.tratamiento.valueobject.OdontologoId;
import domain.tratamiento.valueobject.PacienteId;

public class TratamientoCreado extends DomainEvent {
    private final PacienteId pacienteId;
    private final OdontologoId odontologoId;

    public TratamientoCreado(PacienteId pacienteId, OdontologoId odontologoId){
        super("tratamiento.tratamientocreado");
        this.pacienteId = pacienteId;
        this.odontologoId = odontologoId;
    }

    public PacienteId getPacienteId() {
        return pacienteId;
    }

    public OdontologoId getOdontologoId() {
        return odontologoId;
    }
}
