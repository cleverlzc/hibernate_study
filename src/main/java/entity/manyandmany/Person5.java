package entity.manyandmany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.HashSet;
import java.util.Set;

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
@Table(name = "person_manyandmany")
public class Person5 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    @ManyToMany(targetEntity = Address5.class)
    @JoinTable(name = "person_and_address",
            joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false, updatable = false))
    private Set<Address5> address5s = new HashSet<Address5>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Address5> getAddress5s() {
        return address5s;
    }

    public void setAddress5s(Set<Address5> address5s) {
        this.address5s = address5s;
    }
}
