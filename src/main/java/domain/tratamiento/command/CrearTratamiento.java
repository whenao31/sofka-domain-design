package domain.tratamiento.command;

import co.com.sofka.domain.generic.Command;
import domain.tratamiento.valueobject.OdontologoId;
import domain.tratamiento.valueobject.PacienteId;
import domain.tratamiento.valueobject.TratamientoId;

public class CrearTratamiento extends Command {
    private final TratamientoId tratamientoId;
    private final PacienteId pacienteId;
    private final OdontologoId odontologoId;

    public CrearTratamiento(TratamientoId tratamientoId, PacienteId pacienteId, OdontologoId odontologoId) {
        this.tratamientoId = tratamientoId;
        this.pacienteId = pacienteId;
        this.odontologoId = odontologoId;
    }

    public TratamientoId getTratamientoId() {
        return tratamientoId;
    }

    public PacienteId getPacienteId() {
        return pacienteId;
    }

    public OdontologoId getOdontologoId() {
        return odontologoId;
    }
}
