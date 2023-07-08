import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class _08_GetEmployeeWithProject {
    public static void main(String[] args) {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();
        Scanner sc = new Scanner(System.in);
        final int employeeId = sc.nextInt();


        System.out.println(entityManager.createQuery("SELECT e FROM Employee WHERE e.id = :id", Employee.class)
                .setParameter("id", employeeId)
                .getSingleResult().toString());

    }


}
