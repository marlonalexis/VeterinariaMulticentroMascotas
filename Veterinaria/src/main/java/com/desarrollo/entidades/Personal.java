/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author mpluas
 * Titulo: Veterinaria Multicentro de las mascotas
 * 
 */

@Entity
@Table(name = "personal")
@DiscriminatorValue("PE")
public class Personal extends Personas implements Serializable {

    @Column(name = "sueldo")
    private Integer sueldo;

    public Personal() {
        super();
    }

    public Personal(String cedula, String nombres, String apellidos, Date fechaNacimiento, String celular, String telefono, String email, String direccion, Date fechaRegistro, String estado, Integer sueldo) {
        super(cedula, nombres, apellidos, fechaNacimiento, celular, telefono, email, direccion, fechaRegistro, estado);
        this.sueldo = sueldo;
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }
    
}
