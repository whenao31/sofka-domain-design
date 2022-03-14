package domain.tratamiento.command;

import co.com.sofka.domain.generic.Command;
import domain.tratamiento.valueobject.CotizacionId;
import domain.tratamiento.valueobject.Diente;
import domain.tratamiento.valueobject.Dinero;
import domain.tratamiento.valueobject.TratamientoId;

import java.util.Set;

public class CrearCotizacion extends Command {
    private final TratamientoId tratamientoId;
    private final CotizacionId cotizacionId;
    private final Dinero costo;
    private final Set<Diente> dientes;

    public CrearCotizacion(TratamientoId tratamientoId, CotizacionId cotizacionId, Dinero costo, Set<Diente> dientes) {
        this.tratamientoId = tratamientoId;
        this.cotizacionId = cotizacionId;
        this.costo = costo;
        this.dientes = dientes;
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

    public Set<Diente> getDientes() {
        return dientes;
    }
}
