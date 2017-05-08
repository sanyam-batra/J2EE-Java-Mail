package proj;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import proj.Mssginfo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-04T16:09:06")
@StaticMetamodel(Mailusers.class)
public class Mailusers_ { 

    public static volatile SingularAttribute<Mailusers, Integer> pincode;
    public static volatile CollectionAttribute<Mailusers, Mssginfo> mssginfoCollection;
    public static volatile SingularAttribute<Mailusers, String> password;
    public static volatile SingularAttribute<Mailusers, String> gender;
    public static volatile SingularAttribute<Mailusers, String> city;
    public static volatile SingularAttribute<Mailusers, String> nation;
    public static volatile SingularAttribute<Mailusers, String> state;
    public static volatile SingularAttribute<Mailusers, Integer> age;
    public static volatile SingularAttribute<Mailusers, String> username;

}