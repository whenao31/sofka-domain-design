package domain.odontologo.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.odontologo.Auxiliar;
import domain.odontologo.comand.CrearOdontologo;
import domain.odontologo.event.OdontologoCreado;
import domain.odontologo.valor.AuxiliarId;
import domain.odontologo.valor.OdontologoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearOdontologoUseCaseTest {
    @Test
    void crearOdontologo() {
        //Arrange
        OdontologoId odontologoId = OdontologoId.of("odontologoId1");
        Auxiliar auxiliar = new Auxiliar(AuxiliarId.of("auxiliarId1"));

        CrearOdontologo crearOdontologo = new CrearOdontologo(odontologoId, auxiliar);

        //Act
        CrearOdontologoUseCase useCase = new CrearOdontologoUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(crearOdontologo))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (OdontologoCreado) events.get(0);
        Assertions.assertEquals("odontologo.odontologocreado", event.type);
        Assertions.assertEquals("odontologoId1", event.aggregateRootId());
        Assertions.assertEquals("auxiliarId1", event.getAuxiliar().identity().value());

    }
}