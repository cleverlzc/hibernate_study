package entity.oneandone;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by root on 17-3-3.
 */
@Entity
@Table(name = "person_oneandone")
public class Person6 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    @OneToOne(targetEntity = Address6.class, mappedBy = "person6")
    private Address6 address6;

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


    public Address6 getAddress6() {
        return address6;
    }

    public void setAddress6(Address6 address6) {
        this.address6 = address6;
    }
}
