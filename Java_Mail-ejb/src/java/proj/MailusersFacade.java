/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lenovo
 */
@Stateless
public class MailusersFacade extends AbstractFacade<Mailusers> implements MailusersFacadeLocal {

    @PersistenceContext(unitName = "Java_Mail-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MailusersFacade() {
        super(Mailusers.class);
    }

    @Override
    public boolean add_user(String username, String password, int age, String city, String state, int pincode, String nation,String sex) {
        Mailusers m=new Mailusers();
        m.setUsername(username);
        m.setPassword(password);
        m.setAge(age);
        m.setCity(city);
        m.setState(state);
        m.setPincode(pincode);
        m.setNation(nation);
        m.setGender(sex);
        em.persist(m);
        
        return true;
    }

    @Override
    public Mailusers login_user(String username, String password) {
        return (Mailusers) em.createQuery(
    "SELECT c FROM Mailusers c WHERE c.username = :user")
    .setParameter("user", username)
    .setMaxResults(10)
    .getSingleResult();
    }

    @Override
    public Mailusers get_user(String username) {
        return (Mailusers) em.createQuery(
    "SELECT c FROM Mailusers c WHERE c.username = :user")
    .setParameter("user", username)
    .setMaxResults(10)
    .getSingleResult();
    }

   
        
    }

  
    

