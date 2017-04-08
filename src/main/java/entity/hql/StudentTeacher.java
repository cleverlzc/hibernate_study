package entity.hql;

/**
 * Created by root on 17-4-8.
 */
public class StudentTeacher {
    private String studentName;
    private String teacherName;

    public StudentTeacher(String studentName, String teacherName) {
        this.studentName = studentName;
        this.teacherName = teacherName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
