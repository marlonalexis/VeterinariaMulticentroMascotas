/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.ejb;

import com.desarrollo.entidades.Usuarios;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author mplua
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> implements UsuariosFacadeLocal {

    @PersistenceContext(unitName = "VeterinariaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    @Override
    public Usuarios autenticar(Usuarios usu){
        Usuarios usuarios = null;
        String consulta;
        try {
            consulta = "FROM Usuarios u WHERE u.username = ?1 AND u.password = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, usu.getUsername());
            query.setParameter(2, DigestUtils.md5Hex(usu.getPassword()));
            List<Usuarios> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuarios = lista.get(0);
            }
        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(UsuariosFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuarios;
    }
}
