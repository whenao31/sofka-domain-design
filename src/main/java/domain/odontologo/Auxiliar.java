package domain.odontologo;

import co.com.sofka.domain.generic.Entity;
import domain.odontologo.valor.AuxiliarId;
import domain.odontologo.valor.Disponibilidad;

import javax.swing.*;

public class Auxiliar extends Entity<AuxiliarId> {
    private Disponibilidad disponibilidad;


    public Auxiliar(AuxiliarId entityId) {
        super(entityId);
        this.disponibilidad = new Disponibilidad(Disponibilidad.Disponible.NO_DISPONIBLE);
    }

    public void cambiarDisponibilidad(Disponibilidad disponibilidad){
        this.disponibilidad = disponibilidad;

    }

    public Disponibilidad disponibilidad() {
        return disponibilidad;
    }
}
