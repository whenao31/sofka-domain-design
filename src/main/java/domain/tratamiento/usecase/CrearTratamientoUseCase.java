package domain.tratamiento.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.tratamiento.Tratamiento;
import domain.tratamiento.command.CrearTratamiento;

public class CrearTratamientoUseCase extends UseCase<RequestCommand<CrearTratamiento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearTratamiento> input) {
        CrearTratamiento crearTratamiento = input.getCommand();

        Tratamiento tratatamiento = new Tratamiento(
                crearTratamiento.getTratamientoId(),
                crearTratamiento.getPacienteId(),
                crearTratamiento.getOdontologoId());

        emit().onResponse(new ResponseEvents(tratatamiento.getUncommittedChanges()));
    }
}
