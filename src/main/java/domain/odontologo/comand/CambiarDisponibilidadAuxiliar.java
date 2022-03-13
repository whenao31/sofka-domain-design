package domain.odontologo.comand;

import co.com.sofka.domain.generic.Command;
import domain.odontologo.valor.AuxiliarId;
import domain.odontologo.valor.Disponibilidad;
import domain.odontologo.valor.OdontologoId;

public class CambiarDisponibilidadAuxiliar extends Command {
    private final OdontologoId odontologoId;
    private final AuxiliarId auxiliarId;
    private final Disponibilidad disponible;

    public CambiarDisponibilidadAuxiliar(
            OdontologoId odontologoId,
            AuxiliarId auxiliarId,
            Disponibilidad disponible) {
        this.auxiliarId = auxiliarId;
        this.odontologoId = odontologoId;
        this.disponible = disponible;
    }

    public AuxiliarId getAuxiliarId() {
        return auxiliarId;
    }

    public OdontologoId getOdontologoId() {
        return odontologoId;
    }

    public Disponibilidad getDisponible() {
        return disponible;
    }
}
