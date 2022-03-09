package domain.tratamiento;

import co.com.sofka.domain.generic.AggregateEvent;
import domain.tratamiento.event.CitaCreada;
import domain.tratamiento.event.TratamientoCreado;
import domain.tratamiento.valueobject.*;
import tratamiento.valueobject.*;

import java.util.Map;

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

    public void crearCita(CitaId citaId, Fecha fecha, Hora hora){
        appendChange(new CitaCreada(citaId, fecha, hora));
    }



    public Map<String, Cita> citas(){
        return citas;
    }
}
