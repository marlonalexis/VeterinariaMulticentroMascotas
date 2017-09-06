/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.controller;

import com.desarrollo.ejb.PersonalFacadeLocal;
import com.desarrollo.ejb.UsuariosFacadeLocal;
import com.desarrollo.entidades.Personal;
import com.desarrollo.entidades.Usuarios;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.apache.commons.codec.digest.DigestUtils;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author mpluas
 */
@Named
@ViewScoped
public class personalController implements Serializable{
    
    @EJB
    private PersonalFacadeLocal personalEJB;
    @EJB
    private UsuariosFacadeLocal usuariosEJB;
    private Personal personal;
    private Usuarios usuarios;
    private UploadedFile archivo;
    
    @PostConstruct
    public void init(){
        personal = new Personal();
        usuarios = new Usuarios();
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }
    
    public void registrarPersonal(){
        try {
            /*personal.setFechaRegistro(new Date());
            personal.setEstado("A");
            this.personalEJB.create(this.personal);
            usuarios.setPersonas(this.personal);
            usuarios.setImagen(archivo.getContents());
            rol.addUsuarios(usuarios);
            this.usuariosEJB.create(this.usuarios);
            
            //this.usuariosEJB.create(this.usuarios);
            //rol.addUsuarios(usuarios);
            //this.rolEJB.create(this.rol);
            System.out.println("nombres " + personal.getNombres());
            System.out.println("id " + personal.getIdpersonas());
            System.out.println("username " + usuarios.getUsername());
            System.out.println("rol " + usuarios.getRol().getIdrol());
            
*/          
            personal.setFechaRegistro(new Date());
            personal.setEstado("A");
            //personal.setIdpersonas(10);
            //personal.setUsuarios(this.usuarios);
            //personal.setUsuarios(this.usuarios);
            this.personalEJB.create(this.personal);
            personal.setUsuarios(this.usuarios);
            
            usuarios.setImagen(archivo.getContents());
            usuarios.setPassword(DigestUtils.md5Hex(usuarios.getPassword()));
            System.out.println("nombres " + personal.getNombres());
            System.out.println("password " + usuarios.getPassword());
            
            System.out.println("id usuario " + usuarios.getPersonas().getIdpersonas());
            this.usuariosEJB.create(this.usuarios);
            
        } catch (Exception e) {
        }
    }
}
