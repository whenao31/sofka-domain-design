package domain.odontologo;

import co.com.sofka.domain.generic.EventChange;
import domain.odontologo.event.AsistenteAdicionado;
import domain.odontologo.event.CambiarDisponibilidadDelAuxiliar;
import domain.odontologo.event.EspecialidadAdicionada;
import domain.odontologo.event.OdontologoCreado;

import java.util.ArrayList;

public class OdontologoEventChange extends EventChange {
    public OdontologoEventChange(Odontologo odontologo) {

        apply((OdontologoCreado event) -> {
            odontologo.auxiliarId = event.getAuxiliarId();
            odontologo.especialidades = new ArrayList<>();
        });

        apply((AsistenteAdicionado event) ->{

        });

        apply((EspecialidadAdicionada event) -> {
           odontologo.especialidades.add(new Especialidad(event.getEspecialidadId(),event.getTipo(),event.getDescripcion()));
        });

        apply((CambiarDisponibilidadDelAuxiliar event) ->{
            odontologo.auxiliarId
        });


    }
}
