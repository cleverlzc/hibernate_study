package entity.manytoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by root on 17-3-2.
 */
@Entity
@Table(name = "address_manytoone")
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String address;

    public Address() {
    }

    public Address(String address) {
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
}
