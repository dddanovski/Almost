import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Scanner;

public class _13_RemoveTowns {

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the town to remove: ");
        String townName = scanner.nextLine();

        entityManager.getTransaction().begin();

        TypedQuery<Long> addressCountQuery = entityManager.createQuery(
                "SELECT COUNT(a) FROM Address a WHERE a.town = :town",
                Long.class);
        addressCountQuery.setParameter("town", townName);
        Long addressCount = addressCountQuery.getSingleResult();

        TypedQuery<Address> addressDeleteQuery = entityManager.createQuery(
                "DELETE FROM Address a WHERE a.town = :town",
                Address.class);
        addressDeleteQuery.setParameter("town", townName);
        int deletedCount = addressDeleteQuery.executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println(addressCount + " addresses in " + townName + " deleted");
    }
}