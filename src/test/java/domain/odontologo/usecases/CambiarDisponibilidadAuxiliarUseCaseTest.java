package domain.odontologo.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.odontologo.Auxiliar;
import domain.odontologo.Odontologo;
import domain.odontologo.comand.CambiarDisponibilidadAuxiliar;
import domain.odontologo.event.DisponibilidadDelAuxiliarCambiada;
import domain.odontologo.event.OdontologoCreado;
import domain.odontologo.valor.AuxiliarId;
import domain.odontologo.valor.Disponibilidad;
import domain.odontologo.valor.OdontologoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.EventListener;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CambiarDisponibilidadAuxiliarUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void cambiarDisponibilidadAuxiliar() {
        //Arrange
        OdontologoId odontologoId = OdontologoId.of("odontologoId1");
        AuxiliarId auxiliarId = AuxiliarId.of("auxiliarId1");
        Disponibilidad disponible = new Disponibilidad(Disponibilidad.Disponible.DISPONIBLE);

        var command = new CambiarDisponibilidadAuxiliar(odontologoId,auxiliarId,disponible);

        var useCase = new CambiarDisponibilidadAuxiliarUseCase();
        Mockito.when(repository.getEventsBy("odontologoId1")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(odontologoId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (DisponibilidadDelAuxiliarCambiada) events.get(0);
        Assertions.assertEquals("odontologo.disponibilidaddelauxiliarcambiada", event.type);
        Assertions.assertEquals("auxiliarId1", event.getAuxiliarId().value());
        Assertions.assertEquals(Disponibilidad.Disponible.DISPONIBLE, event.getDisponible().value());

    }

    private List<DomainEvent> history() {
        return List.of(
                new OdontologoCreado(OdontologoId.of("odontologoId1"),new Auxiliar(AuxiliarId.of("auxiliarId1")))
        );
    }
}