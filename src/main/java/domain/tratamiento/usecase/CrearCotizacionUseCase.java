package domain.tratamiento.usecase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.tratamiento.Tratamiento;
import domain.tratamiento.command.CrearCotizacion;

import java.util.Objects;

public class CrearCotizacionUseCase extends UseCase<RequestCommand<CrearCotizacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCotizacion> input) {
        var command = input.getCommand();

        var tratamiento = Tratamiento.from(command.getTratamientoId(), retrieveEvents());

        if (Objects.nonNull(tratamiento.cotizacion())){
            throw new BusinessException(command.getTratamientoId().value(), "Cotizacion ya creda");
        }

        tratamiento.crearCotizacion(command.getCotizacionId(), command.getCosto(), command.getDientes());
        emit().onResponse(new ResponseEvents(tratamiento.getUncommittedChanges()));
    }
}
