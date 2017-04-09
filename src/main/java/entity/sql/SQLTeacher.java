package entity.sql;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by root on 17-3-8.
 */
@Entity
@Table(name = "sql_teacher")
public class SQLTeacher {
    @Id
    @GeneratedValue
    @Column(name = "tid")
    private Long id;
    @Column(name = "tname")
    private String tname;
    @OneToMany(targetEntity = SQLStudent.class, mappedBy = "sqlTeacher")
    private Set<SQLStudent> sqlStudents = new HashSet<SQLStudent>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Set<SQLStudent> getSqlStudents() {
        return sqlStudents;
    }

    public void setSqlStudents(Set<SQLStudent> sqlStudents) {
        this.sqlStudents = sqlStudents;
    }
}
