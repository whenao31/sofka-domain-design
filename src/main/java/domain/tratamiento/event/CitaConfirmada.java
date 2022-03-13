package domain.tratamiento.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.tratamiento.valueobject.CitaId;
import domain.tratamiento.valueobject.Estado;

public class CitaConfirmada extends DomainEvent {

    private final CitaId citaId;
    private final Estado estado;

    public CitaConfirmada(CitaId citaId, Estado estado) {
        super("tratamiento.citaconfirmada");
        this.citaId = citaId;
        this.estado = estado;
    }

    public CitaId getCitaId() {
        return citaId;
    }

    public Estado getEstado() {
        return estado;
    }
}
