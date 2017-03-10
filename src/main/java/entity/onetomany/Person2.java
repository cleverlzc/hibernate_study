package entity.onetomany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by root on 17-3-2.
 */
@Entity
@Table(name = "person_onetomany")
public class Person2 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    @OneToMany(targetEntity = Address2.class)
    @JoinColumn(name = "person_id")//指定多的一方外键
    @Cascade(CascadeType.ALL)
    private Set<Address2> address2s = new HashSet<Address2>();

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

    public Set<Address2> getAddress2s() {
        return address2s;
    }

    public void setAddress2s(Set<Address2> address2s) {
        this.address2s = address2s;
    }
}
