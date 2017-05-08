package proj;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import proj.Mailusers;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-04T16:09:06")
@StaticMetamodel(Mssginfo.class)
public class Mssginfo_ { 

    public static volatile SingularAttribute<Mssginfo, Date> date;
    public static volatile SingularAttribute<Mssginfo, String> fromm;
    public static volatile SingularAttribute<Mssginfo, String> ccc;
    public static volatile SingularAttribute<Mssginfo, Mailusers> too;
    public static volatile SingularAttribute<Mssginfo, String> subjectt;
    public static volatile SingularAttribute<Mssginfo, String> mid;
    public static volatile CollectionAttribute<Mssginfo, Mailusers> mailusersCollection;
    public static volatile SingularAttribute<Mssginfo, String> bodyy;
    public static volatile SingularAttribute<Mssginfo, String> bccc;

}