package domain.tratamiento.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.tratamiento.command.CrearTratamiento;
import domain.tratamiento.event.TratamientoCreado;
import domain.tratamiento.valueobject.OdontologoId;
import domain.tratamiento.valueobject.PacienteId;
import domain.tratamiento.valueobject.TratamientoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearTratamientoUseCaseTest {

    @Test
    void crearTratamiento() {
        //Arrange
        TratamientoId tratamientoId = TratamientoId.of("tratamientoId1");
        PacienteId pacienteId = PacienteId.of("pacienteId1");
        OdontologoId odontologoId = OdontologoId.of("odontologoId1");

        CrearTratamiento crearTratamiento = new CrearTratamiento(tratamientoId,pacienteId,odontologoId);

        //Act
        CrearTratamientoUseCase useCase = new CrearTratamientoUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(crearTratamiento))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var event = (TratamientoCreado) events.get(0);
        Assertions.assertEquals("tratamiento.tratamientocreado", event.type);
        Assertions.assertEquals("tratamientoId1", event.aggregateRootId());
        Assertions.assertEquals("pacienteId1", event.getPacienteId().value());
        Assertions.assertEquals("odontologoId1", event.getOdontologoId().value());
    }
}