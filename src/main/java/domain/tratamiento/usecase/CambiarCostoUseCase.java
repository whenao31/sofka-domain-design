package domain.tratamiento.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.tratamiento.Tratamiento;
import domain.tratamiento.command.CambiarCosto;

import java.util.Objects;

public class CambiarCostoUseCase extends UseCase<RequestCommand<CambiarCosto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarCosto> input) {
        var command = input.getCommand();

        var tratamiento = Tratamiento.from(command.getTratamientoId(), retrieveEvents());

        if(Objects.nonNull(command.getCotizacionId())){
            tratamiento.modificarCosto(command.getCotizacionId(), command.getCosto());
            emit().onResponse(new ResponseEvents(tratamiento.getUncommittedChanges()));
        }else {
            throw new BusinessException(command.getTratamientoId().value(), "Cotizacion no encontrada");
        }
    }
}
