package domain.tratamiento.command;

import co.com.sofka.domain.generic.Command;
import domain.tratamiento.valueobject.CotizacionId;
import domain.tratamiento.valueobject.Dinero;
import domain.tratamiento.valueobject.TratamientoId;

public class CambiarCosto extends Command {
    private final TratamientoId tratamientoId;
    private final CotizacionId cotizacionId;
    private final Dinero costo;

    public CambiarCosto(TratamientoId tratamientoId, CotizacionId cotizacionId, Dinero costo) {
        this.tratamientoId = tratamientoId;
        this.cotizacionId = cotizacionId;
        this.costo = costo;
    }

    public TratamientoId getTratamientoId() {
        return tratamientoId;
    }

    public CotizacionId getCotizacionId() {
        return cotizacionId;
    }

    public Dinero getCosto() {
        return costo;
    }
}
