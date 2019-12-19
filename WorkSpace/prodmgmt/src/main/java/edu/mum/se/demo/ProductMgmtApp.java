package edu.mum.se.demo;

import edu.mum.se.demo.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.Month;

/**
 * Hello world!
 *
 */
public class ProductMgmtApp
{
    private static final String PERSISTENT_UNIT_NAME = "MyProductMgmtApp1PU";
    private static EntityManagerFactory emf;

    public ProductMgmtApp(){
        this.emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
    }

    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        ProductMgmtApp app = new ProductMgmtApp();
        Product p = new Product(1001L,"iPhone XS Max", 1500.00f,
                LocalDate.of(2019, Month.OCTOBER,22));
        app.saveProduct(p);
        System.out.println("Saved data :" +p.toString());
    }

    private  void saveProduct(Product p){
        if(p!=null){
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            em.close();
            emf.close();
        }
    }
}
