package domain.tratamiento.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.tratamiento.Tratamiento;
import domain.tratamiento.command.ConfirmarCita;
import domain.tratamiento.valueobject.Estado;

import java.util.Objects;

public class ConfirmarCitaUseCase extends UseCase<RequestCommand<ConfirmarCita>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ConfirmarCita> input) {
        var command = input.getCommand();

        var tratamiento = Tratamiento.from(command.getTratamientoId(),retrieveEvents());
        if (tratamiento.citas().get(command.getCitaId().value()).estado().value().equals(Estado.Fase.CONFIRMADO)){
            throw new BusinessException(command.getCitaId().value(),"Cita ya Confirmada");
        }
        tratamiento.confirmarCita(command.getCitaId(), command.getEstado());

        emit().onResponse(new ResponseEvents(tratamiento.getUncommittedChanges()));
    }
}
