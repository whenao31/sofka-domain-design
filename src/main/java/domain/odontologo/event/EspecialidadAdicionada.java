package domain.odontologo.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.odontologo.valor.Descripcion;
import domain.odontologo.valor.EspecialidadId;
import domain.odontologo.valor.Tipo;

public class EspecialidadAdicionada extends DomainEvent {
    private final EspecialidadId especialidadId;
    private final Tipo tipo;
    private final Descripcion descripcion;


    public EspecialidadAdicionada(EspecialidadId especialidadId, Tipo tipo, Descripcion descripcion) {
        super("odontologo.especialidadadicionada");
        this.especialidadId = especialidadId;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public EspecialidadId getEspecialidadId() {
        return especialidadId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
