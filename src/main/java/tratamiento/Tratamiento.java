package tratamiento;

import co.com.sofka.domain.generic.AggregateEvent;
import tratamiento.valueobject.TratamientoId;

import java.util.Map;

public class Tratamiento extends AggregateEvent<TratamientoId> {

    protected Map<String, Cita> citas;

    public Tratamiento(TratamientoId tratamientoId) {
        super(tratamientoId);
    }
}
