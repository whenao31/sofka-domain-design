package domain.odontologo.comand;

import co.com.sofka.domain.generic.Command;
import domain.odontologo.Auxiliar;
import domain.odontologo.valor.OdontologoId;

public class CrearOdontologo extends Command {
    private final OdontologoId odontologoId;
    private final Auxiliar auxiliar;

    public CrearOdontologo(OdontologoId odontologoId, Auxiliar auxiliar) {
        this.odontologoId = odontologoId;
        this.auxiliar = auxiliar;
    }

    public OdontologoId getOdontologoId() {
        return odontologoId;
    }

    public Auxiliar getAuxiliar() {
        return auxiliar;
    }
}
