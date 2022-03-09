package domain.tratamiento.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.tratamiento.valueobject.CitaId;

public class CitaCancelada extends DomainEvent {
    private final CitaId citaId;
    public CitaCancelada(CitaId citaId) {
        super("tratamiento.citacancelada");
        this.citaId = citaId;
    }

    public CitaId getCitaId() {
        return citaId;
    }
}
