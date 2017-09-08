/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author mpluas
 */
@Entity
@Table(name = "usuarios_rol")
@NamedQueries({
    @NamedQuery(name = "UsuariosRol.findAll", query = "SELECT u FROM UsuariosRol u")})
public class UsuariosRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 150)
    @Column(name = "observacion")
    private String observacion;
    @Id
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_idrol", referencedColumnName = "idrol")
    private Rol rol;
    @Id
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "personas_idpersonas", referencedColumnName = "personas_idpersonas")
    private Usuarios usuarios;

    public UsuariosRol() {
    }

    public UsuariosRol(Rol rol, Usuarios usuarios) {
        this.rol = rol;
        this.usuarios = usuarios;
    }

    public UsuariosRol(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
        if(!this.rol.getUsuariosRolList().contains(this)){
            this.rol.getUsuariosRolList().add(this);
        }
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
        if(!this.usuarios.getUsuariosRolList().contains(this)){
            this.usuarios.getUsuariosRolList().add(this);
        }
    }

}
