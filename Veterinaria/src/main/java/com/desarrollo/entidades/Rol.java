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
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author mpluas
 */
@Entity
@Table(name = "rol")
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrol")
    private Integer idrol;
    @Size(max = 45)
    @Column(name = "rol")
    private String rol;
    @Size(max = 150)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Size(max = 2)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol", fetch = FetchType.LAZY)
    private List<Menu> menuList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol", fetch = FetchType.LAZY)
    private List<UsuariosRol> usuariosRolList;
    
    public Rol() {
        this.menuList = new ArrayList<>();
        this.usuariosRolList = new ArrayList<>();
    }

    public Rol(Integer idrol) {
        this.idrol = idrol;
        this.menuList = new ArrayList<>();
        this.usuariosRolList = new ArrayList<>();
    }

    public Rol(String rol, String observacion, Date fechaRegistro, String estado) {
        this.rol = rol;
        this.observacion = observacion;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.menuList = new ArrayList<>();
        this.usuariosRolList = new ArrayList<>();
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<UsuariosRol> getUsuariosRolList() {
        return usuariosRolList;
    }

    public void setUsuariosRolList(List<UsuariosRol> usuariosRolList) {
        this.usuariosRolList = usuariosRolList;
    }
    
    public void addMenu(Menu menu){
        this.menuList.add(menu);
        if(menu.getRol()!= this){
            menu.setRol(this);
        }
    }
    
    public void addUsuariosRol(UsuariosRol usuariosRol){
        this.usuariosRolList.add(usuariosRol);
        if(usuariosRol.getRol()!= this){
            usuariosRol.setRol(this);
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrol != null ? idrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.idrol == null && other.idrol != null) || (this.idrol != null && !this.idrol.equals(other.idrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.desarrollo.entidades.Rol[ idrol=" + idrol + " ]";
    }
    
}
