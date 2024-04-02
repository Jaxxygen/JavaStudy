import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SubscriptionsKey implements Serializable {
    @Column(name = "student_id")
    private int student;

    @Column(name = "course_id")
    private int course;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionsKey that = (SubscriptionsKey) o;
        return student == that.student && course == that.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course);
    }

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}
