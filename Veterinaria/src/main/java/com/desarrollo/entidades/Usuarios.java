/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author mplua
 */
@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    @Size(max = 150)
    @Column(name = "password")
    private String password;
    @Size(max = 250)
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Column(name = "ultima_sesion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaSesion;
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personas_idpersonas")
    private Personas personas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios", fetch = FetchType.LAZY)
    private List<UsuariosRol> usuariosRolList;
    
    public Usuarios() {
        this.usuariosRolList = new ArrayList<>();
    }

    public Usuarios(String username, String password, String nombreCompleto, byte[] imagen, Date ultimaSesion) {
        this.username = username;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.imagen = imagen;
        this.ultimaSesion = ultimaSesion;
        this.usuariosRolList = new ArrayList<>();
    }

    public Usuarios(Personas personas) {
        this.personas = personas;
        this.usuariosRolList = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }


    public Date getUltimaSesion() {
        return ultimaSesion;
    }

    public void setUltimaSesion(Date ultimaSesion) {
        this.ultimaSesion = ultimaSesion;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
        if(this.personas.getUsuarios()!= this){
            this.personas.setUsuarios(this);
        }
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public List<UsuariosRol> getUsuariosRolList() {
        return usuariosRolList;
    }

    public void setUsuariosRolList(List<UsuariosRol> usuariosRolList) {
        this.usuariosRolList = usuariosRolList;
    }
    
    public void addUsuariosRol(UsuariosRol usuariosRol){
        this.usuariosRolList.add(usuariosRol);
        if(usuariosRol.getUsuarios()!= this){
            usuariosRol.setUsuarios(this);
        }
    }
}
