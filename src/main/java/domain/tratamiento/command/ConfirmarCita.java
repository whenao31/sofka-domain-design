package domain.tratamiento.command;

import co.com.sofka.domain.generic.Command;
import domain.tratamiento.valueobject.CitaId;
import domain.tratamiento.valueobject.Estado;
import domain.tratamiento.valueobject.TratamientoId;

public class ConfirmarCita extends Command {
    private final CitaId citaId;
    private final TratamientoId tratamientoId;
    private final Estado estado;

    public ConfirmarCita(CitaId citaId, TratamientoId tratamientoId, Estado estado) {
        this.citaId = citaId;
        this.tratamientoId = tratamientoId;
        this.estado = estado;
    }

    public CitaId getCitaId() {
        return citaId;
    }

    public TratamientoId getTratamientoId() {
        return tratamientoId;
    }

    public Estado getEstado() {
        return estado;
    }
}
