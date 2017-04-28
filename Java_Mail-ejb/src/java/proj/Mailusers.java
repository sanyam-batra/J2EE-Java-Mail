/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lenovo
 */
@Entity
@Table(name = "mailusers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mailusers.findAll", query = "SELECT m FROM Mailusers m")
    , @NamedQuery(name = "Mailusers.findByUsername", query = "SELECT m FROM Mailusers m WHERE m.username = :username")
    , @NamedQuery(name = "Mailusers.findByPassword", query = "SELECT m FROM Mailusers m WHERE m.password = :password")
    , @NamedQuery(name = "Mailusers.findByAge", query = "SELECT m FROM Mailusers m WHERE m.age = :age")
    , @NamedQuery(name = "Mailusers.findByGender", query = "SELECT m FROM Mailusers m WHERE m.gender = :gender")
    , @NamedQuery(name = "Mailusers.findByCity", query = "SELECT m FROM Mailusers m WHERE m.city = :city")
    , @NamedQuery(name = "Mailusers.findByState", query = "SELECT m FROM Mailusers m WHERE m.state = :state")
    , @NamedQuery(name = "Mailusers.findByPincode", query = "SELECT m FROM Mailusers m WHERE m.pincode = :pincode")
    , @NamedQuery(name = "Mailusers.findByNation", query = "SELECT m FROM Mailusers m WHERE m.nation = :nation")})
public class Mailusers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "username")
    private String username;
    @Size(max = 20)
    @Column(name = "password")
    private String password;
    @Column(name = "age")
    private Integer age;
    @Size(max = 10)
    @Column(name = "gender")
    private String gender;
    @Size(max = 20)
    @Column(name = "city")
    private String city;
    @Size(max = 20)
    @Column(name = "state")
    private String state;
    @Column(name = "pincode")
    private Integer pincode;
    @Size(max = 20)
    @Column(name = "nation")
    private String nation;
    //@JoinColumn(name = "mid", referencedColumnName = "mid")
    //@ManyToOne
    //private Mssginfo mid;
    @OneToMany(mappedBy = "too")
    private Collection<Mssginfo> mssginfoCollection;

    public Mailusers() {
    }

    public Mailusers(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    

    @XmlTransient
    public Collection<Mssginfo> getMssginfoCollection() {
        return mssginfoCollection;
    }

    public void setMssginfoCollection(Collection<Mssginfo> mssginfoCollection) {
        this.mssginfoCollection = mssginfoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mailusers)) {
            return false;
        }
        Mailusers other = (Mailusers) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proj.Mailusers[ username=" + username + " ]";
    }
    
}
