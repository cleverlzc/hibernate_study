package entity.onetoone;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by root on 17-3-2.
 */
@Entity
@Table(name = "person_onetoone")
public class Person1 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    @OneToOne(targetEntity = Address1.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id", unique = true)
    @Cascade(CascadeType.ALL)
    private Address1 address1;

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

    public Address1 getAddress1() {
        return address1;
    }

    public void setAddress1(Address1 address1) {
        this.address1 = address1;
    }
}
