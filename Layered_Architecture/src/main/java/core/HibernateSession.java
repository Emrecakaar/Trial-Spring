package core;

import entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {

    public static Session session = null;//org.hibernate den gelen bir sessiona ihtiyacımız var çünkü
    // transactionlarımızı Sessiondan yöneteceğim

public static Session getSession(){//Bu metod ile hafızadan sürekli Session oluşturma isteğini ortadan kaldırıyoruz.
    if(session == null){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")//hibernate ayarımız
                .addAnnotatedClass(Customer.class)//Hangi entitylerimizin olduğunu belirtiyoruz.
                .buildSessionFactory();//fabrikamızdan Sessionı alıyoruz

        session = factory.openSession();
    }
    return session;
}

}

