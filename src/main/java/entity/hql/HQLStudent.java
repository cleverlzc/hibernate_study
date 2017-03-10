package entity.hql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by root on 17-3-8.
 */
@Entity
@Table(name = "hql_student")
public class HQLStudent {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne(targetEntity = HQLTeacher.class)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private HQLTeacher hqlTeacher;


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

    public HQLTeacher getHqlTeacher() {
        return hqlTeacher;
    }

    public void setHqlTeacher(HQLTeacher hqlTeacher) {
        this.hqlTeacher = hqlTeacher;
    }
}
