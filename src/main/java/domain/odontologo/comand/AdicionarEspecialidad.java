package domain.odontologo.comand;

import co.com.sofka.domain.generic.Command;
import domain.odontologo.valor.Descripcion;
import domain.odontologo.valor.EspecialidadId;
import domain.odontologo.valor.Tipo;

public class AdicionarEspecialidad extends Command {
    private final EspecialidadId especialidadId;
    private final Tipo tipo;
    private final Descripcion descripcion;

    public AdicionarEspecialidad(EspecialidadId especialidadId, Tipo tipo, Descripcion descripcion) {
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
