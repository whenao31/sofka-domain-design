package domain.tratamiento.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.tratamiento.valueobject.CitaId;
import domain.tratamiento.valueobject.Fecha;
import domain.tratamiento.valueobject.Hora;

public class CitaCreada extends DomainEvent {
    private final CitaId citaId;
    private final Fecha fecha;
    private final Hora hora;

    public CitaCreada(CitaId citaId, Fecha fecha, Hora hora){
        super("tratamiento.citacreada");
        this.citaId = citaId;
        this.fecha = fecha;
        this.hora = hora;
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
