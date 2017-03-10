package entity.oneandmany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by root on 17-3-3.
 */
@Entity
@Table(name = "person_oneandmany")
public class Person4 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    @OneToMany(targetEntity = Address4.class, mappedBy = "person4")
    @Cascade(CascadeType.ALL)
    private Set<Address4> address4s = new HashSet<Address4>();

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

    public Set<Address4> getAddress4s() {
        return address4s;
    }

    public void setAddress4s(Set<Address4> address4s) {
        this.address4s = address4s;
    }
}
