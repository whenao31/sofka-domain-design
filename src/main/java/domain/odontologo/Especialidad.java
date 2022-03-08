package domain.odontologo;

import co.com.sofka.domain.generic.Entity;
import domain.odontologo.valor.Descripcion;
import domain.odontologo.valor.EspecialidadId;
import domain.odontologo.valor.Tipo;

public class Especialidad extends Entity<EspecialidadId> {
    private Tipo tipo;
    private Descripcion descripcion;

    public Especialidad(EspecialidadId entityId, Tipo tipo, Descripcion descripcion) {
        super(entityId);
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public void cambiarDescripcion(Descripcion descripcion){
        this.descripcion = descripcion;
    }

    public void modificarTipo(Tipo tipo){
        this.tipo = tipo;
    }

    public Tipo tipo() {
        return tipo;
    }

    public Descripcion descripcion() {
        return descripcion;
    }
}
