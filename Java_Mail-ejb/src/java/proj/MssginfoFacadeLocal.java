/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lenovo
 */
@Local
public interface MssginfoFacadeLocal {

    void create(Mssginfo mssginfo);

    void edit(Mssginfo mssginfo);

    void remove(Mssginfo mssginfo);

    Mssginfo find(Object id);

    List<Mssginfo> findAll();

    List<Mssginfo> findRange(int[] range);

    int count();

    List<Mssginfo> get_msgs(Mailusers too);

    boolean add_msg(Mailusers too, String sub, String msg,String fromm,Date d);
    
}
