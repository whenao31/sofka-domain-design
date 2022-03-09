package domain.odontologo.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.odontologo.valor.AuxiliarId;

public class AsistenteAdicionado extends DomainEvent {
    private final AuxiliarId auxiliarId;

    public AsistenteAdicionado(AuxiliarId auxiliarId) {
        super("transporte.asistenteadicionado");
        this.auxiliarId = auxiliarId;
    }

    public AuxiliarId getAuxiliarId() {
        return auxiliarId;
    }
}
