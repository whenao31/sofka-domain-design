package domain.odontologo;

import co.com.sofka.domain.generic.AggregateEvent;
import domain.odontologo.event.AsistenteAdicionado;
import domain.odontologo.event.CambiarDisponibilidadDelAuxiliar;
import domain.odontologo.event.EspecialidadAdicionada;
import domain.odontologo.event.OdontologoCreado;
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

//    public void adicionarAsistente(AuxiliarId auxiliarId){
//        appendChange(new AsistenteAdicionado(auxiliarId)).apply();
//    }

    public void adicionarEspecialidad(EspecialidadId especialidadId, Tipo tipo, Descripcion descripcion){
        appendChange(new EspecialidadAdicionada(especialidadId,tipo,descripcion)).apply();
    }

    public void cambiarDisponibilidadAuxiliar(AuxiliarId auxiliarId){
        appendChange(new CambiarDisponibilidadDelAuxiliar(auxiliarId)).apply();
    }
}
