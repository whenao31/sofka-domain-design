package domain.tratamiento.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.tratamiento.command.CambiarCosto;
import domain.tratamiento.event.CostoModificado;
import domain.tratamiento.event.CotizacionCreada;
import domain.tratamiento.event.TratamientoCreado;
import domain.tratamiento.valueobject.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CambiarCostoUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    void CambiarCosto(){
//        Arrange
        TratamientoId tratamientoId = TratamientoId.of("tratamientoId1");
        CotizacionId cotizacionId = CotizacionId.of("cotizacionId1");

        var command = new CambiarCosto(tratamientoId, cotizacionId, new Dinero(500000));

        var useCase = new CambiarCostoUseCase();
        Mockito.when(repository.getEventsBy("tratamientoId1")).thenReturn(history());
        useCase.addRepository(repository);
//        Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(tratamientoId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
//        Assert
        var event = (CostoModificado) events.get(0);
        Assertions.assertEquals("tratamiento.costomodificado", event.type);
        Assertions.assertEquals("cotizacionId1", event.getCotizacionId().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new TratamientoCreado(PacienteId.of("pacienteId1"), OdontologoId.of("odontologoId1")),
                new CotizacionCreada(CotizacionId.of("cotizacionId1"), new Dinero(450000), new HashSet<>())
        );
    }
}