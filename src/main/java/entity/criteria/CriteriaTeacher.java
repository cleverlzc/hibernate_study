package entity.criteria;

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
@Table(name = "criteria_teacher")
public class CriteriaTeacher {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(targetEntity = CriteriaStudent.class, mappedBy = "criteriaTeacher")
    private Set<CriteriaStudent> criteriaStudents = new HashSet<CriteriaStudent>();

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

    public Set<CriteriaStudent> getCriteriaStudents() {
        return criteriaStudents;
    }

    public void setCriteriaStudents(Set<CriteriaStudent> criteriaStudents) {
        this.criteriaStudents = criteriaStudents;
    }
}
