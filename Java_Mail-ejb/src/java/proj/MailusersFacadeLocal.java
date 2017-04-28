/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lenovo
 */
@Local
public interface MailusersFacadeLocal {

    void create(Mailusers mailusers);

    void edit(Mailusers mailusers);

    void remove(Mailusers mailusers);

    Mailusers find(Object id);

    List<Mailusers> findAll();

    List<Mailusers> findRange(int[] range);

    int count();

    boolean add_user(String username, String password, int age, String city, String state, int pincode, String nation,String sex);

    Mailusers login_user(String username, String password);

    Mailusers get_user(String username);

 

   
    
}
