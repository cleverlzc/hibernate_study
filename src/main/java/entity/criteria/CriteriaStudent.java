package entity.criteria;

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
@Table(name = "criteria_student")
public class CriteriaStudent {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne(targetEntity = CriteriaTeacher.class)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
    private CriteriaTeacher criteriaTeacher;

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

    public CriteriaTeacher getCriteriaTeacher() {
        return criteriaTeacher;
    }

    public void setCriteriaTeacher(CriteriaTeacher criteriaTeacher) {
        this.criteriaTeacher = criteriaTeacher;
    }
}
