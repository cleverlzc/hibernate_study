package entity.manyandmany;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Created by root on 17-3-3.
 */
@Entity
@Table(name = "address_manyandmany")
public class Address5 {
    @Id
    @GeneratedValue
    private Long id;
    private String address;
    @ManyToMany(targetEntity = Person5.class, mappedBy = "address5s")
    /*@JoinTable(name = "person_and_address",
            joinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false))*/
    private Set<Person5> person5s = new HashSet<Person5>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Person5> getPerson5s() {
        return person5s;
    }

    public void setPerson5s(Set<Person5> person5s) {
        this.person5s = person5s;
    }
}
