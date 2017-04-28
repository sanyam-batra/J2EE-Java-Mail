/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lenovo
 */
@Entity
@Table(name = "mssginfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mssginfo.findAll", query = "SELECT m FROM Mssginfo m")
    , @NamedQuery(name = "Mssginfo.findByMid", query = "SELECT m FROM Mssginfo m WHERE m.mid = :mid")
    , @NamedQuery(name = "Mssginfo.findByFromm", query = "SELECT m FROM Mssginfo m WHERE m.fromm = :fromm")
    , @NamedQuery(name = "Mssginfo.findBySubjectt", query = "SELECT m FROM Mssginfo m WHERE m.subjectt = :subjectt")
    , @NamedQuery(name = "Mssginfo.findByBodyy", query = "SELECT m FROM Mssginfo m WHERE m.bodyy = :bodyy")
    , @NamedQuery(name = "Mssginfo.findByCcc", query = "SELECT m FROM Mssginfo m WHERE m.ccc = :ccc")
    , @NamedQuery(name = "Mssginfo.findByBccc", query = "SELECT m FROM Mssginfo m WHERE m.bccc = :bccc")})
public class Mssginfo implements Serializable {

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "mid")
    private Integer mid;
    @Size(max = 20)
    @Column(name = "fromm")
    private String fromm;
    @Size(max = 100)
    @Column(name = "subjectt")
    private String subjectt;
    @Size(max = 500)
    @Column(name = "bodyy")
    private String bodyy;
    @Size(max = 100)
    @Column(name = "ccc")
    private String ccc;
    @Size(max = 100)
    @Column(name = "bccc")
    private String bccc;
    //@OneToMany(mappedBy = "mid")
    private Collection<Mailusers> mailusersCollection;
    @JoinColumn(name = "too", referencedColumnName = "username")
    @ManyToOne
    private Mailusers too;

    public Mssginfo() {
    }

    public Mssginfo(Integer mid) {
        this.mid = mid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getFromm() {
        return fromm;
    }

    public void setFromm(String fromm) {
        this.fromm = fromm;
    }

    public String getSubjectt() {
        return subjectt;
    }

    public void setSubjectt(String subjectt) {
        this.subjectt = subjectt;
    }

    public String getBodyy() {
        return bodyy;
    }

    public void setBodyy(String bodyy) {
        this.bodyy = bodyy;
    }

    public String getCcc() {
        return ccc;
    }

    public void setCcc(String ccc) {
        this.ccc = ccc;
    }

    public String getBccc() {
        return bccc;
    }

    public void setBccc(String bccc) {
        this.bccc = bccc;
    }

    @XmlTransient
    public Collection<Mailusers> getMailusersCollection() {
        return mailusersCollection;
    }

    public void setMailusersCollection(Collection<Mailusers> mailusersCollection) {
        this.mailusersCollection = mailusersCollection;
    }

    public Mailusers getToo() {
        return too;
    }

    public void setToo(Mailusers too) {
        this.too = too;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mid != null ? mid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mssginfo)) {
            return false;
        }
        Mssginfo other = (Mssginfo) object;
        if ((this.mid == null && other.mid != null) || (this.mid != null && !this.mid.equals(other.mid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proj.Mssginfo[ mid=" + mid + " ]";
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
