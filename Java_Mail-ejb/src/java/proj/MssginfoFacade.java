/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;


import static com.sun.xml.ws.security.addressing.impl.policy.Constants.logger;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;



/**
 *
 * @author lenovo
 */
@Stateless
public class MssginfoFacade extends AbstractFacade<Mssginfo> implements MssginfoFacadeLocal {

    @PersistenceContext(unitName = "Java_Mail-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MssginfoFacade() {
        super(Mssginfo.class);
    }

    @Override
    public List<Mssginfo> get_msgs(Mailusers too) {
        return em.createQuery(
    "SELECT c FROM Mssginfo c WHERE c.too = :too")
    .setParameter("too", too)
    .setMaxResults(10)
    .getResultList();
    }

    @Override
    public boolean add_msg(Mailusers too, String sub, String msg,String fromm,Date date) {
        
        Mssginfo m = new Mssginfo();
        //Mailusers mm = em.find(Mailusers.class, too.getUsername());
        m.setMid(1);
        m.setBodyy(msg);
        m.setSubjectt(sub);
        m.setDate(date);
        m.setFromm(fromm);
        m.setToo(too);
        try
        {em.persist(m);
        
        }catch (ConstraintViolationException e) {
       System.out.println(e.getConstraintViolations());
    }
        return true;
        
    }
    
}
