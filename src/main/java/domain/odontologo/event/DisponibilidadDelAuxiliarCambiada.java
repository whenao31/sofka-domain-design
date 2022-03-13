package domain.odontologo.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.odontologo.valor.AuxiliarId;
import domain.odontologo.valor.Disponibilidad;

public class DisponibilidadDelAuxiliarCambiada extends DomainEvent {
    private final AuxiliarId auxiliarId;
    private final Disponibilidad disponible;

    public DisponibilidadDelAuxiliarCambiada(AuxiliarId auxiliarId, Disponibilidad disponible) {
        super("odontologo.disponibilidaddelauxiliarcambiada");
        this.auxiliarId = auxiliarId;
        this.disponible = disponible;
    }

    public AuxiliarId getAuxiliarId() {
        return auxiliarId;
    }

    public Disponibilidad getDisponible() {
        return disponible;
    }
}
