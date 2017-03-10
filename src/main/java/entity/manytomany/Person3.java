package entity.manytomany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Created by root on 17-3-2.
 */
@Entity
@Table(name = "person_manytomany")
public class Person3 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    @ManyToOne(targetEntity = Address3.class)
    @JoinTable(name = "person_to_address",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<Address3> address3s = new HashSet<Address3>();

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

    public Set<Address3> getAddress3s() {
        return address3s;
    }

    public void setAddress3s(Set<Address3> address3s) {
        this.address3s = address3s;
    }
}
