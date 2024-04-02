import jakarta.persistence.*;

@Entity
@Embeddable
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {
    @EmbeddedId
    private LinkedPurchaseListKey linkedPurchaseListKey;

    @Column (name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column (name = "course_id", insertable = false, updatable = false)
    private int courseId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LinkedPurchaseListKey getLinkedPurchaseListKey() {
        return linkedPurchaseListKey;
    }

    public void setLinkedPurchaseListKey(LinkedPurchaseListKey linkedPurchaseListKey) {
        this.linkedPurchaseListKey = linkedPurchaseListKey;
    }
}
