package domain.odontologo.comand;

import co.com.sofka.domain.generic.Command;
import domain.odontologo.valor.EspecialidadId;
import domain.odontologo.valor.Tipo;

public class ModificarTipoEspecialidad extends Command {
    private final EspecialidadId especialidadId;
    private final Tipo tipo;

    public ModificarTipoEspecialidad(EspecialidadId especialidadId, Tipo tipo) {
        this.especialidadId = especialidadId;
        this.tipo = tipo;
    }

    public EspecialidadId getEspecialidadId() {
        return especialidadId;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
