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
@Table(name = "address_oneandone")
public class Address6 {
    @Id
    @GeneratedValue
    private Long id;
    private String address;
    @OneToOne(targetEntity = Person6.class)
    @JoinColumn(name = "person_id", referencedColumnName = "id", unique = true)
    private Person6 person6;

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

    public Person6 getPerson6() {
        return person6;
    }

    public void setPerson6(Person6 person6) {
        this.person6 = person6;
    }
}
