package domain.tratamiento.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.tratamiento.valueobject.CotizacionId;
import domain.tratamiento.valueobject.Dinero;

public class CostoModificado extends DomainEvent {
    private final CotizacionId cotizacionId;
    private final Dinero costo;

    public CostoModificado(CotizacionId cotizacionId, Dinero costo){
        super("tratamiento.costomodificado");
        this.cotizacionId = cotizacionId;
        this.costo = costo;
    }

    public CotizacionId getCotizacionId() {
        return cotizacionId;
    }

    public Dinero getCosto() {
        return costo;
    }

}
