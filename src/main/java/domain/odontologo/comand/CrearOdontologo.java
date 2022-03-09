package domain.odontologo.comand;

import co.com.sofka.domain.generic.Command;
import domain.odontologo.valor.OdontologoId;

public class CrearOdontologo extends Command {
    private final OdontologoId odontologoId;

    public CrearOdontologo(OdontologoId odontologoId) {
        this.odontologoId = odontologoId;
    }

    public OdontologoId getOdontologoId() {
        return odontologoId;
    }
}
