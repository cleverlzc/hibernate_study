package entity.sql;

import javax.persistence.Column;
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
@Table(name = "sql_student")
public class SQLStudent {
    @Id
    @GeneratedValue
    @Column(name = "sid")
    private Long id;
    @Column(name = "sname")
    private String sname;
    @ManyToOne(targetEntity = SQLTeacher.class)
    @JoinColumn(name = "teacher_id", referencedColumnName = "tid", nullable = false)
    private SQLTeacher sqlTeacher;
    //@Column(name = "teacher_id")
    //private Long teacherId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public SQLTeacher getSqlTeacher() {
        return sqlTeacher;
    }

    public void setSqlTeacher(SQLTeacher sqlTeacher) {
        this.sqlTeacher = sqlTeacher;
    }

    /*public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }*/
}
