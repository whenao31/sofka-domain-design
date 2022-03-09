package domain.odontologo.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.odontologo.valor.EspecialidadId;
import domain.odontologo.valor.Tipo;

public class TipoEspecialidadModificada extends DomainEvent {
    private final EspecialidadId especialidadId;
    private final Tipo tipo;

    public TipoEspecialidadModificada(EspecialidadId especialidadId, Tipo tipo) {
        super("odontologo.tipoespecialidadmodificada");
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
