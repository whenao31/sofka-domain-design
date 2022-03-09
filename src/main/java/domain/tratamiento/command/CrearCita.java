package domain.tratamiento.command;

import co.com.sofka.domain.generic.Command;
import domain.tratamiento.valueobject.CitaId;
import domain.tratamiento.valueobject.Fecha;
import domain.tratamiento.valueobject.Hora;
import domain.tratamiento.valueobject.TratamientoId;

public class CrearCita extends Command {
    private final TratamientoId tratamientoId;
    private final CitaId citaId;
    private final Fecha fecha;
    private final Hora hora;

    public CrearCita(TratamientoId tratamientoId, CitaId citaId, Fecha fecha, Hora hora) {
        this.tratamientoId = tratamientoId;
        this.citaId = citaId;
        this.fecha = fecha;
        this.hora = hora;
    }

    public TratamientoId getTratamientoId() {
        return tratamientoId;
    }

    public CitaId getCitaId() {
        return citaId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Hora getHora() {
        return hora;
    }
}
