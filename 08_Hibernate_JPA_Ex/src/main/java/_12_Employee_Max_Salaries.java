import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class _12_Employee_Max_Salaries {
    public static void main(String[] args) {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("PU_Name");

        EntityManager entityManager = factory.createEntityManager();


        entityManager.createQuery("SELECT department.name, max(salary) FROM Employee" +
                " GROUP BY department.name HAVIG max(salary) nOT BETWEEn 30000 AnD 70000", Object[].class)
                ///  Object[].class е обект, който съдържа селектираите полета при селект-а: (SELECT departmet.mame, max(salary))
                .getResultList()
                .forEach(objs -> System.out.println(objs[0] + " " + objs[1]));


    }
}
