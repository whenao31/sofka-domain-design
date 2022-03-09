package domain.tratamiento;

import co.com.sofka.domain.generic.Entity;
import domain.tratamiento.valueobject.*;

public class Cita extends Entity<CitaId> {
    private Fecha fecha;
    private Hora hora;
    private Factura factura;
    private Estado estado;

    public Cita(CitaId citaId) {
        super(citaId);
        this.fecha = new Fecha();
        this.hora = new Hora();
        this.factura = new Factura();
        this.estado = new Estado(Estado.Fase.PENDIENTE);
    }

    public Cita(CitaId entityId, Fecha fecha, Hora hora) {
        super(entityId);
        this.fecha = fecha;
        this.hora = hora;
        this.factura = new Factura();
        this.estado = new Estado(Estado.Fase.PENDIENTE);
    }

    public void confirmarCita(){
        this.estado = new Estado(Estado.Fase.CONFIRMADO);
    }

    public void cancelarCita(){
        this.estado = new Estado(Estado.Fase.CANCELADO);
    }

    public void modificarFechaYHora(Fecha fecha, Hora hora){
        if (this.estado.value().equals(Estado.Fase.CONFIRMADO) && validarDiasACita(fecha)){
            this.fecha = fecha;
            this.hora = hora;
        }else{
            throw new IllegalArgumentException("No se puede cambiar la fecha y hora a una cita no confirmada");
        }
    }

    private boolean validarDiasACita(Fecha fecha){
        return fecha.calcularDiasDesdeAhora() >= 1;
    }

    public Fecha fecha() {
        return fecha;
    }

    public Hora hora() {
        return hora;
    }

    public Factura factura() {
        return factura;
    }

    public Estado estado() {
        return estado;
    }
}
