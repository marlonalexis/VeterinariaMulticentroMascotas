/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.ejb;

import com.desarrollo.entidades.Menu;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mpluas
 */
@Stateless
public class MenuFacade extends AbstractFacade<Menu> implements MenuFacadeLocal {

    @PersistenceContext(unitName = "VeterinariaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuFacade() {
        super(Menu.class);
    }
    
}
