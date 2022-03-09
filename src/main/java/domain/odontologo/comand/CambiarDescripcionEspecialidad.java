package domain.odontologo.comand;

import co.com.sofka.domain.generic.Command;
import domain.odontologo.valor.Descripcion;
import domain.odontologo.valor.EspecialidadId;

public class CambiarDescripcionEspecialidad extends Command {
    private final EspecialidadId especialidadId;
    private final Descripcion descripcion;

    public CambiarDescripcionEspecialidad(EspecialidadId especialidadId, Descripcion descripcion) {
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
