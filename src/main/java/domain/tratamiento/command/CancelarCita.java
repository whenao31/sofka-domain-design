package domain.tratamiento.command;

import co.com.sofka.domain.generic.Command;
import domain.tratamiento.valueobject.CitaId;
import domain.tratamiento.valueobject.TratamientoId;

public class CancelarCita extends Command {
    private final CitaId citaId;
    private final TratamientoId tratamientoId;

    public CancelarCita(CitaId citaId, TratamientoId tratamientoId) {
        this.citaId = citaId;
        this.tratamientoId = tratamientoId;
    }

    public CitaId getCitaId() {
        return citaId;
    }

    public TratamientoId getTratamientoId() {
        return tratamientoId;
    }
}
