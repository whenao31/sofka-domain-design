package domain.tratamiento;

import co.com.sofka.domain.generic.EventChange;
import domain.tratamiento.event.*;

import java.util.HashMap;

public class TratamientoEventChange  extends EventChange {
    public TratamientoEventChange(Tratamiento tratamiento) {

        apply((TratamientoCreado event) -> {
            tratamiento.pacienteId = event.getPacienteId();
            tratamiento.odontologoId = event.getOdontologoId();
            tratamiento.citas = new HashMap<>();
            tratamiento.cotizacion = null;
        });

        apply((CitaCreada event) -> {
            tratamiento.citas.put(
                    event.getCitaId().value(),
                    new Cita(event.getCitaId(), event.getFecha(), event.getHora())
            );
        });

        apply((CitaConfirmada event) -> {
            tratamiento.citas.get(event.getCitaId().value()).confirmarCita();
        });

        apply((CitaCancelada event) -> {
            tratamiento.citas.get(event.getCitaId().value()).cancelarCita();
        });

        apply((CotizacionCreada event) -> {
            tratamiento.cotizacion = new Cotizacion(event.getCotizacionId(), event.getCosto(), event.getDientes());
        });

        apply((DienteAdicionado event) -> {
            tratamiento.cotizacion.adicionarDiente(event.getDiente());
        });

        apply((CostoModificado event) -> {
            tratamiento.cotizacion.modificarCosto(event.getCosto());
        });
    }
}
