package domain.tratamiento.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.tratamiento.valueobject.CotizacionId;
import domain.tratamiento.valueobject.Diente;

public class DienteAdicionado extends DomainEvent {
    private final Diente diente;

    public DienteAdicionado(Diente diente){
        super("tratamiento.dienteadicionado");
        this.diente = diente;
    }

    public Diente getDiente() {
        return diente;
    }

}
