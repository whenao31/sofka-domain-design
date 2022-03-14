package domain.tratamiento.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.tratamiento.command.CrearCotizacion;
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
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearCotizacionUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearCotizacion(){
//        Arrange
        TratamientoId tratamientoId = TratamientoId.of("tratamientoId1");

        CotizacionId cotizacionId = CotizacionId.of("cotizacionId1");
        Set<Diente> dientes = new HashSet<>();
        dientes.add(new Diente(Diente.Codigo.DOCE, "caries"));
        dientes.add(new Diente(Diente.Codigo.CUARENTAYDOS, "fisura menor"));

        var command = new CrearCotizacion(
                tratamientoId,
                cotizacionId,
                new Dinero(450000),
                dientes
        );
        var useCase = new CrearCotizacionUseCase();
        Mockito.when(repository.getEventsBy("tratamientoId1")).thenReturn(history());
        useCase.addRepository(repository);
//        Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(tratamientoId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
//        Assert
        var event = (CotizacionCreada) events.get(0);
        Assertions.assertEquals("tratamiento.cotizacioncreada", event.type);
        Assertions.assertEquals("cotizacionId1", event.getCotizacionId().value());
        Assertions.assertEquals(2, event.getDientes().size());
        Assertions.assertEquals(450000, event.getCosto().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new TratamientoCreado(PacienteId.of("pacienteId1"), OdontologoId.of("odontologoId1"))
        );
    }
}