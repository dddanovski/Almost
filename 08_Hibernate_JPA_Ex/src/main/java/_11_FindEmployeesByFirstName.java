import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class _11_FindEmployeesByFirstName {

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();

        TypedQuery<Object[]> query = entityManager.createQuery(
                "SELECT e.firstName, e.lastName, e.jobTitle, e.salary " +
                        "FROM Employee e " +
                        "WHERE e.firstName LIKE :pattern",
                Object[].class);

        query.setParameter("pattern", pattern + "%");

        List<Object[]> resultList = query.getResultList();

        for (Object[] result : resultList) {
            String firstName = (String) result[0];
            String lastName = (String) result[1];
            String jobTitle = (String) result[2];
            Double salary = (Double) result[3];

            System.out.println(firstName + " " + lastName + " - " + jobTitle + " - ($" + salary + ")");
        }

        entityManager.close();
    }
}
