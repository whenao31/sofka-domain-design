package domain.odontologo.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.odontologo.Odontologo;
import domain.odontologo.comand.CrearOdontologo;

public class CrearOdontologoUseCase extends UseCase<RequestCommand<CrearOdontologo>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearOdontologo> input) {
        CrearOdontologo crearOdontologo = input.getCommand();

        Odontologo odontologo = new Odontologo(crearOdontologo.getOdontologoId(),crearOdontologo.getAuxiliar());

        emit().onResponse(new ResponseEvents(odontologo.getUncommittedChanges()));
    }
}
