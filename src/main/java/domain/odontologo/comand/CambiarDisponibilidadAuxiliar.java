package domain.odontologo.comand;

import co.com.sofka.domain.generic.Command;
import domain.odontologo.valor.AuxiliarId;

public class CambiarDisponibilidadAuxiliar extends Command {
    private final AuxiliarId auxiliarId;

    public CambiarDisponibilidadAuxiliar(AuxiliarId auxiliarId) {
        this.auxiliarId = auxiliarId;
    }

    public AuxiliarId getAuxiliarId() {
        return auxiliarId;
    }
}
