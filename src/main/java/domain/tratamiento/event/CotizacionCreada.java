package domain.tratamiento.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.tratamiento.valueobject.CotizacionId;
import domain.tratamiento.valueobject.Diente;
import domain.tratamiento.valueobject.Dinero;

import java.util.Set;

public class CotizacionCreada extends DomainEvent {
    private final CotizacionId cotizacionId;
    private final Dinero costo;
    private final Set<Diente> dientes;

    public CotizacionCreada(CotizacionId cotizacionId, Dinero costo, Set<Diente> dientes){
        super("tratamiento.cotizacioncreada");
        this.cotizacionId = cotizacionId;
        this.costo = costo;
        this.dientes = dientes;
    }

    public CotizacionId getCotizacionId() {
        return cotizacionId;
    }

    public Dinero getCosto() {
        return costo;
    }

    public Set<Diente> getDientes() {
        return dientes;
    }

}
