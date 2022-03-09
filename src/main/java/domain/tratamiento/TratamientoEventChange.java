package domain.tratamiento;

import co.com.sofka.domain.generic.EventChange;
import domain.tratamiento.event.TratamientoCreado;

import java.util.HashMap;

public class TratamientoEventChange  extends EventChange {
    public TratamientoEventChange(Tratamiento tratamiento) {

        apply((TratamientoCreado event) -> {
            tratamiento.pacienteId = event.getPacienteId();
            tratamiento.odontologoId = event.getOdontologoId();
            tratamiento.citas = new HashMap<>();
            tratamiento.cotizacion = null;
        });
    }
}
