package domain.odontologo.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.odontologo.Odontologo;
import domain.odontologo.comand.CambiarDisponibilidadAuxiliar;
import domain.odontologo.valor.Disponibilidad;

public class CambiarDisponibilidadAuxiliarUseCase extends UseCase<RequestCommand<CambiarDisponibilidadAuxiliar>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarDisponibilidadAuxiliar> input) {
        var command = input.getCommand();

        var odontologo = Odontologo.from(command.getOdontologoId(), retrieveEvents());
        if (odontologo.auxiliar()
                .disponibilidad()
                .value().equals(Disponibilidad.Disponible.DISPONIBLE)
        ){
            throw new BusinessException(command.getOdontologoId().value(), "Ya esta disponible el auxiliar");
        }

        odontologo.cambiarDisponibilidadAuxiliar(command.getAuxiliarId(),command.getDisponible());
        emit().onResponse(new ResponseEvents(odontologo.getUncommittedChanges()));
    }
}
