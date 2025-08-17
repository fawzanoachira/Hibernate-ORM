package entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CourseBiDirectional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseName;

    @OneToMany(mappedBy = "course") // If mappedBy not set, 3 tables will create
    private List<StudentBiDirectional> students;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<StudentBiDirectional> getStudents() {
        return students;
    }

    public void setStudents(List<StudentBiDirectional> students) {
        this.students = students;
    }

    public CourseBiDirectional() {
    }

    public CourseBiDirectional(String courseName, List<StudentBiDirectional> students) {
        this.courseName = courseName;
        this.students = students;
    }

    @Override
    public String toString() {
        return "CourseBiDirectional [courseId=" + courseId + ", courseName=" + courseName + ", students=" + students
                + "]";
    }

}
