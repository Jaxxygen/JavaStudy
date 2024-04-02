import jakarta.persistence.*;

@Entity
@Embeddable
@Table( name = "subscriptions")
public class Subscriptions {

    @EmbeddedId
    private SubscriptionsKey subscriptionsKey;

    @ManyToOne
    @JoinColumn (name = "student_id", insertable = false, updatable = false)
    private Students student;

    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Courses course;
    @Column(name = "subscription_date")
    private String subscriptionDate;

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public String getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(String subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public SubscriptionsKey getSubscriptionsKey() {
        return subscriptionsKey;
    }

    public void setSubscriptionsKey(SubscriptionsKey subscriptionsKey) {
        this.subscriptionsKey = subscriptionsKey;
    }
}
