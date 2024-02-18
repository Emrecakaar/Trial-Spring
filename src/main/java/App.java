import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
/*    //Supplier ekleme
      Supplier supplier = new Supplier();
        supplier.setAddress("adres");
        supplier.setCompany("patika");
        supplier.setContact("5131654518");
        supplier.setPerson("Emre");
        supplier.setMail("nsadfhuıas@gmail");
        entityManager.persist(supplier);

        //Category Ekleme
        Category category = new Category();
        category.setName("Telefonlar");
        entityManager.persist(category);


//Code ekleme
        Code code = new Code();
        code.setGroup("15451");
        code.setSerial("445456");
        entityManager.persist(code);
//Product ekleme
        Product product = new Product();
        product.setName("Iphone 15 Pro");
        product.setPrice(1234);
        product.setStock(15);
        product.setCode(code);
        product.setSupplier(supplier);
        product.setCategory(category);
       entityManager.persist(product);


        Supplier supplier = entityManager.find(Supplier.class, 1);

        Code code = new Code();
        code.setGroup("15451");
        code.setSerial("445456");
        entityManager.persist(code);

        Product product = new Product();
        product.setName("Samsung Galaxy");
        product.setPrice(1234);
        product.setStock(15);
        product.setCode(code);
        product.setSupplier(supplier);
        entityManager.persist(product);

        Supplier supplier = entityManager.find(Supplier.class, 1);
        for (Product product: supplier.getProductList())
            System.out.println(product.toString());



        Color blue = new Color("blue");
        Color red = new Color("red");
        Color white = new Color("white");
        entityManager.persist(blue);
        entityManager.persist(red);
        entityManager.persist(white);

        Product product = entityManager.find(Product.class,1);
        List<Color> colorList = new ArrayList<>();//new ArrayList<>() yerine prdouct.getColorListte doğru olur!!
        colorList.add(blue);
        colorList.add(red);
        product.setColorList(colorList);

        Product product = entityManager.find(Product.class,1);
        System.out.println(product.getColorList().toString());

       Color color = entityManager.find(Color.class,1);
        System.out.println(color.getProductList().toString());


        //SELECT * FROM categories
        //Bu kod ile birlikte Categorylerde olan isimleri görebiliyoruz...
        Query getAllCategory = entityManager.createQuery("SELECT cat FROM Category cat");
        //Tamamen nesneler üzerinde bir şeyler ürettiğimiz için ORM ve JPA ile o yüzden JPQL kullanılır.

        List<Category> categoryList = getAllCategory.getResultList();

        for (Category category : categoryList)
            System.out.println(category.getName());
*/


        transaction.commit();

    }
}
