package domain.tratamiento.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.odontologo.event.OdontologoCreado;
import domain.tratamiento.command.ConfirmarCita;
import domain.tratamiento.event.CitaConfirmada;
import domain.tratamiento.event.CitaCreada;
import domain.tratamiento.event.TratamientoCreado;
import domain.tratamiento.valueobject.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ConfirmarCitaUseCaseTest {

    @Mock
    private DomainEventRepository repository;
    
    @Test
    void confirmarCita() {
        //Arrange
        TratamientoId tratamientoId = TratamientoId.of("tratamientoId1");
        CitaId citaId = CitaId.of("citaId1");


        var command = new ConfirmarCita(citaId, tratamientoId, new Estado(Estado.Fase.CONFIRMADO));
        
        var useCase = new ConfirmarCitaUseCase();
        Mockito.when(repository.getEventsBy("tratamientoId1")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(tratamientoId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        
        //Asserts
        var event = (CitaConfirmada) events.get(0);
        Assertions.assertEquals("tratamiento.citaconfirmada", event.type);
        Assertions.assertEquals("citaId1", event.getCitaId().value());
        Assertions.assertEquals(Estado.Fase.CONFIRMADO,event.getEstado().value());
        
    }

    private List<DomainEvent> history() {
        return List.of(
                new TratamientoCreado(PacienteId.of("pacienteId1"), OdontologoId.of("odontologoId1")),
                new CitaCreada(CitaId.of("citaId1"),new Fecha(),new Hora(14,30))
        );
    }
}