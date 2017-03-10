package entity.hql;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by root on 17-3-8.
 */
@Entity
@Table(name = "hql_teacher")
public class HQLTeacher {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(targetEntity = HQLStudent.class, mappedBy = "hqlTeacher")
    private Set<HQLStudent> hqlStudents = new HashSet<HQLStudent>();

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

    public Set<HQLStudent> getHqlStudents() {
        return hqlStudents;
    }

    public void setHqlStudents(Set<HQLStudent> hqlStudents) {
        this.hqlStudents = hqlStudents;
    }
}
