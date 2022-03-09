package domain.odontologo.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.odontologo.valor.Descripcion;
import domain.odontologo.valor.EspecialidadId;

public class DescripciónEspecialidadCambiada extends DomainEvent {
    private final EspecialidadId especialidadId;
    private final Descripcion descripcion;


    public DescripciónEspecialidadCambiada(EspecialidadId especialidadId, Descripcion descripcion) {
        super("odontologo.cambiardescripciondeespecialidad");
        this.especialidadId = especialidadId;
        this.descripcion = descripcion;
    }

    public EspecialidadId getEspecialidadId() {
        return especialidadId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
