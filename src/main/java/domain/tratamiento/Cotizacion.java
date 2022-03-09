package domain.tratamiento;

import co.com.sofka.domain.generic.Entity;
import domain.tratamiento.valueobject.CotizacionId;
import domain.tratamiento.valueobject.Diente;
import domain.tratamiento.valueobject.Dinero;

import java.util.Set;

public class Cotizacion extends Entity<CotizacionId> {
    private Dinero costo;
    private Set<Diente> dientes;

    public Cotizacion(CotizacionId entityId, Dinero costo, Set<Diente> dientes) {
        super(entityId);
        this.costo = costo;
        this.dientes = dientes;
    }

    public void adicionarDiente(Diente diente){
        this.dientes.add(diente);
    }

    public void modificarCosto(Dinero costo){
        this.costo = costo;
    }
}
