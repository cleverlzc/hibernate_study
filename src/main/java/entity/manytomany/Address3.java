package entity.manytomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by root on 17-3-2.
 */
@Entity
@Table(name = "address_manytomany")
public class Address3 {

    @Id
    @GeneratedValue
    private Long id;
    private String address;

    public Address3(){}

    public Address3(String address) {
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
