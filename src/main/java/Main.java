import entity.Employee;
import org.hibernate.boot.registry.selector.spi.StrategyCreator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("phan nguyen");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        System.out.println(entityManagerFactory.isOpen());
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println(entityManagerFactory.isOpen());
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

            Employee phannguyen = new Employee();
            phannguyen.setId(7);
            phannguyen.setFirstName("Phan");
            phannguyen.setLastName("Nguyen");
            phannguyen.setDepartmentId(1);

            entityManager.persist(phannguyen);
            transaction.commit();
            System.out.print(phannguyen);
        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
