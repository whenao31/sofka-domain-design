package domain.odontologo;

import co.com.sofka.domain.generic.AggregateEvent;
import domain.odontologo.event.*;
import domain.odontologo.valor.*;

import java.util.List;

public class Odontologo extends AggregateEvent<OdontologoId> {
    protected List<Especialidad> especialidades;
    protected Auxiliar auxiliar;

    public Odontologo(OdontologoId entityId) {
        super(entityId);
        appendChange(new OdontologoCreado()).apply(); //no se
        subscribe(new OdontologoEventChange(this));
    }

    public void adicionarEspecialidad(EspecialidadId especialidadId, Tipo tipo, Descripcion descripcion){
        appendChange(new EspecialidadAdicionada(especialidadId,tipo,descripcion)).apply();
    }

    public void cambiarDisponibilidadAuxiliar(AuxiliarId auxiliarId){
        appendChange(new DisponibilidadDelAuxiliarCambiada(auxiliarId)).apply();
    }

    public void cambiarDescripcionEspecialidad(EspecialidadId especialidadId, Descripcion descripcion){
        appendChange(new DescripciónEspecialidadCambiada(especialidadId, descripcion)).apply();
    }

    public void modificarTipoEspecialidad(EspecialidadId especialidadId, Tipo tipo){
        appendChange(new TipoEspecialidadModificada(especialidadId, tipo)).apply();
    }
}
