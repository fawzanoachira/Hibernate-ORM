package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class StudentBiDirectional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;

    @ManyToOne
    private CourseBiDirectional course;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public CourseBiDirectional getCourse() {
        return course;
    }

    public void setCourse(CourseBiDirectional course) {
        this.course = course;
    }

    public StudentBiDirectional(String studentName, CourseBiDirectional course) {
        this.studentName = studentName;
        this.course = course;
    }

    public StudentBiDirectional() {
    }

    @Override
    public String toString() {
        return "StudentBiDirectional [studentId=" + studentId + ", studentName=" + studentName + ", course=" + course
                + "]";
    }

}
