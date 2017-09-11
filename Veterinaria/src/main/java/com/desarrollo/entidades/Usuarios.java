/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.entidades;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
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
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import javax.validation.constraints.Size;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

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
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_idrol", referencedColumnName = "idrol")
    private Rol rol;
    
    public Usuarios() {
    }

    public Usuarios(String username, String password, String nombreCompleto, byte[] imagen, Date ultimaSesion) {
        this.username = username;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.imagen = imagen;
        this.ultimaSesion = ultimaSesion;
    }

    public Usuarios(Personas personas) {
        this.personas = personas;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
        if(!this.rol.getUsuariosList().contains(this)){
            this.rol.getUsuariosList().add(this);
        }
    }

}
    
