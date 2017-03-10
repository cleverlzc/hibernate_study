package entity;

import org.hibernate.annotations.Formula;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Created by root on 17-2-27.
 */
@Entity
@Table(name = "t_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @Formula(value = "(select concat(s.id, s.name, s.age) from t_student s where s.id = id)")
    private String info;
    @Transient //修饰不想持久保存的属性
    private String company;

    @Enumerated
    private Season sex;
    @Enumerated(EnumType.STRING)
    private Season boy_or_girl;

    @Temporal(TemporalType.DATE)
    private Date date;
    @Temporal(TemporalType.TIME)
    private Date time;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    /**
     * 集合属性
     */
    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "student_list_teachers", joinColumns = @JoinColumn(name = "student_id", nullable = false))
    @Column(name = "teacher_name")
    @OrderColumn(name = "id")
    private List<String> teachers = new ArrayList<String>();

    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "student_array_teachers", joinColumns = @JoinColumn(name = "student_id", nullable = false))
    @Column(name = "teacher_name")
    @OrderColumn(name = "id")
    private String[] arrayTeacher;

    //无需使用@OrderColumn，因为set是无序不可重复的
    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "student_set_teachers", joinColumns = @JoinColumn(name = "student_id", nullable = false))
    @Column(name = "teacher_name")
    @OrderColumn(name = "id")
    private Set<String> setTeacher = new HashSet<String>();

    @ElementCollection(targetClass = Float.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "student_map_scores", joinColumns = @JoinColumn(name = "student_id", nullable = false))
    @MapKeyColumn(name = "score_key")
    @MapKeyClass(String.class)
    @Column(name = "score_value")
    private Map<String, Float> mapScores = new HashMap<String, Float>();

    /**
     * 组件属性
     */
    private Parents parents;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Season getSex() {
        return sex;
    }

    public void setSex(Season sex) {
        this.sex = sex;
    }

    public Season getBoy_or_girl() {
        return boy_or_girl;
    }

    public void setBoy_or_girl(Season boy_or_girl) {
        this.boy_or_girl = boy_or_girl;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<String> teachers) {
        this.teachers = teachers;
    }

    public String[] getArrayTeacher() {
        return arrayTeacher;
    }

    public void setArrayTeacher(String[] arrayTeacher) {
        this.arrayTeacher = arrayTeacher;
    }

    public Set<String> getSetTeacher() {
        return setTeacher;
    }

    public void setSetTeacher(Set<String> setTeacher) {
        this.setTeacher = setTeacher;
    }

    public Map<String, Float> getMapScores() {
        return mapScores;
    }

    public void setMapScores(Map<String, Float> mapScores) {
        this.mapScores = mapScores;
    }

    public Parents getParents() {
        return parents;
    }

    public void setParents(Parents parents) {
        this.parents = parents;
    }
}
