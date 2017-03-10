package entity;

import org.hibernate.annotations.Parent;

import javax.persistence.Embeddable;

/**
 * Created by root on 17-3-2.
 */
@Embeddable
public class Parents {

    private String mother;
    private String father;
    @Parent
    private Student student;

    public Parents() {
    }

    public Parents(String mother, String father) {
        this.mother = mother;
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
