package domain.odontologo;

import co.com.sofka.domain.generic.EventChange;
import domain.odontologo.event.*;
import domain.odontologo.valor.AuxiliarId;

import java.util.ArrayList;

public class OdontologoEventChange extends EventChange {
    public OdontologoEventChange(Odontologo odontologo) {

        apply((OdontologoCreado event) -> {
            odontologo.auxiliar = new Auxiliar(new AuxiliarId());
            odontologo.especialidades = new ArrayList<>();
        });

        apply((EspecialidadAdicionada event) -> {
           odontologo.especialidades
                   .add(new Especialidad(event.getEspecialidadId(),event.getTipo(),event.getDescripcion()));
        });

        apply((DisponibilidadDelAuxiliarCambiada event) -> {
            odontologo.auxiliar.cambiarDisponibilidad();
        });

        apply((DescripciónEspecialidadCambiada event) -> {
            odontologo.especialidades.get(Integer.parseInt(event.getEspecialidadId().value()))
                    .cambiarDescripcion(event.getDescripcion());
        });

        apply((TipoEspecialidadModificada event) -> {
            odontologo.especialidades.get(Integer.parseInt(event.getEspecialidadId().value()))
                    .modificarTipo(event.getTipo());
        });

    }
}
