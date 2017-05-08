/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;



import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        m.setMid(UUID.randomUUID().toString());
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

    @Override
    public List<Mssginfo> get_msg_date(String uid) {
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Mssginfo> query = cb.createQuery(Mssginfo.class);
        Root<Mssginfo> assignment = query.from(Mssginfo.class);

        query.where(
            cb.equal(assignment.get("mid"), uid));
            

        return em.createQuery(query).getResultList();
        
//         return em.createQuery(
//    "SELECT c FROM Mssginfo c WHERE c.too = :too and c.date = :date")
//    .setParameter("too", too)
//    .setParameter("date", date)
//    .setMaxResults(10)
//    .getResultList();
    }

    @Override
    public boolean delete_mail(String mid) {
        System.out.println(mid);
        Mssginfo mm =new Mssginfo();
        mm = em.find(Mssginfo.class, mid);
        //System.out.println(mm);
        em.remove(mm);
        //em.remove(em.find(Mssginfo.class, uid));
//         Query query = em.createQuery(
//        "DELETE FROM Mssginfo c WHERE c.mid = :uuid");
//        int deletedCount = query.setParameter("uuid", uid).executeUpdate();
        return true;
    }
    @Override
    public List<Mssginfo> sent_mail(String mid) {
        System.out.println(mid);
        return em.createQuery(
        "SELECT c FROM Mssginfo c WHERE c.fromm = :mid")
        .setParameter("mid", mid)
        .setMaxResults(10)
        .getResultList();
        }
//        Mssginfo mm =new Mssginfo();
//        mm = em.find(Mssginfo.class, mid);
//        //System.out.println(mm);
//        em.remove(mm);
        //em.remove(em.find(Mssginfo.class, uid));
//         Query query = em.createQuery(
//        "DELETE FROM Mssginfo c WHERE c.mid = :uuid");
//        int deletedCount = query.setParameter("uuid", uid).executeUpdate();
       
    }
    

