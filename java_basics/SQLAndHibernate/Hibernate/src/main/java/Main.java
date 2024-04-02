import jakarta.persistence.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
    public static void main(String[] args) {
        Session session = Connection.connect();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseList> query = builder.createQuery(PurchaseList.class);

        Root<PurchaseList> purchaseListRoot = query.from(PurchaseList.class);
        Join<PurchaseList, Students> studentsJoin = purchaseListRoot.join(PurchaseList_.studentName);






//        Transaction transaction = session.getTransaction();
//
//        transaction.begin();
//        Query query = session.createQuery("insert into LinkedPurchaseList (studentId, courseId) " +
//                "SELECT st.id, c.id from " + PurchaseList.class.getSimpleName() + " p " +
//                "join " + Students.class.getSimpleName() + " st ON p.studentName = st.name " +
//                "join " + Courses.class.getSimpleName() + " c ON p.courseName = c.name");
//        query.executeUpdate();
//
//        transaction.commit();
        session.close();

    }
}
