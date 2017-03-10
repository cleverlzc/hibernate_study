package entity.oneandmany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by root on 17-3-3.
 */
@Entity
@Table(name = "address_oneandmany")
public class Address4 {

    @Id
    @GeneratedValue
    private Long id;
    private String address;
    @ManyToOne(targetEntity = Person4.class)
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    private Person4 person4;

    public Address4() {
    }

    public Address4(String address) {
        this.address = address;
    }

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

    public Person4 getPerson4() {
        return person4;
    }

    public void setPerson4(Person4 person4) {
        this.person4 = person4;
    }
}
