package domain.odontologo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.odontologo.event.*;
import domain.odontologo.valor.*;

import java.util.List;

public class Odontologo extends AggregateEvent<OdontologoId> {
    protected List<Especialidad> especialidades;
    protected Auxiliar auxiliar;

    public Odontologo(OdontologoId entityId, Auxiliar auxiliar) {
        super(entityId);
        appendChange(new OdontologoCreado(entityId, auxiliar)).apply(); //no se
        subscribe(new OdontologoEventChange(this));
    }

    private Odontologo(OdontologoId odontologoId) {
        super(odontologoId);
        subscribe(new OdontologoEventChange(this));
    }

    public static Odontologo from(OdontologoId odontologoId, List<DomainEvent> events) {
        var odontologo = new Odontologo(odontologoId);
        events.forEach(odontologo::applyEvent);
        return odontologo;
    }

    public void adicionarEspecialidad(EspecialidadId especialidadId, Tipo tipo, Descripcion descripcion){
        appendChange(new EspecialidadAdicionada(especialidadId,tipo,descripcion)).apply();
    }

    public void cambiarDisponibilidadAuxiliar(AuxiliarId auxiliarId, Disponibilidad disponible){
        appendChange(new DisponibilidadDelAuxiliarCambiada(auxiliarId, disponible)).apply();
    }

    public void cambiarDescripcionEspecialidad(EspecialidadId especialidadId, Descripcion descripcion){
        appendChange(new DescripciónEspecialidadCambiada(especialidadId, descripcion)).apply();
    }

    public void modificarTipoEspecialidad(EspecialidadId especialidadId, Tipo tipo){
        appendChange(new TipoEspecialidadModificada(especialidadId, tipo)).apply();
    }

    public List<Especialidad> especialidades() {
        return especialidades;
    }

    public Auxiliar auxiliar() {
        return auxiliar;
    }
}
