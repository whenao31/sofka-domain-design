package domain.odontologo.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.odontologo.valor.AuxiliarId;

public class DisponibilidadDelAuxiliarCambiada extends DomainEvent {
    private final AuxiliarId auxiliarId;

    public DisponibilidadDelAuxiliarCambiada(AuxiliarId auxiliarId) {
        super("odontologo.cambiardisponibilidaddelauxiliar");
        this.auxiliarId = auxiliarId;
    }

    public AuxiliarId getAuxiliarId() {
        return auxiliarId;
    }
}
