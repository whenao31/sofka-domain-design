package domain.tratamiento;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.tratamiento.event.*;
import domain.tratamiento.valueobject.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tratamiento extends AggregateEvent<TratamientoId> {

    protected PacienteId pacienteId;
    protected OdontologoId odontologoId;
    protected Map<String, Cita> citas;
    protected Cotizacion cotizacion;

    public Tratamiento(TratamientoId tratamientoId, PacienteId pacienteId, OdontologoId odontologoId) {
        super(tratamientoId);
        appendChange(new TratamientoCreado(pacienteId, odontologoId)).apply();
        subscribe(new TratamientoEventChange(this));
    }

    private Tratamiento(TratamientoId tratamientoId){
        super(tratamientoId);
        subscribe(new TratamientoEventChange(this));
    }

    private static Tratamiento from(TratamientoId tratamientoId, List<DomainEvent> events){
        var tratamiento = new Tratamiento(tratamientoId);
        events.forEach(tratamiento::applyEvent);
        return tratamiento;
    }

    public void crearCita(CitaId citaId, Fecha fecha, Hora hora){
        appendChange(new CitaCreada(citaId, fecha, hora));
    }

    public void confirmarCita(CitaId citaId){
        appendChange(new CitaConfirmada(citaId)).apply();
    }

    public void cancelarCita(CitaId citaId){
        appendChange(new CitaCancelada(citaId)).apply();
    }

    public void crearCotizacion(CotizacionId cotizacionId, Dinero costo, Set<Diente> dientes){
        appendChange(new CotizacionCreada(cotizacionId, costo, dientes)).apply();
    }


    public void adicionarDiente(Diente diente ){
        appendChange(new DienteAdicionado(diente)).apply();
    }

    public void modificarCosto(CotizacionId cotizacionId, Dinero costo){
        appendChange(new CostoModificado(cotizacionId, costo)).apply();
    }

    public Map<String, Cita> citas(){
        return citas;
    }
}
