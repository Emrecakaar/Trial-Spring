package dao.congretes;

import core.HibernateSession;
import dao.abstracts.ICustomerDao;
import entities.Customer;
import org.hibernate.Session;
import org.hibernate.query.SelectionQuery;

import java.util.List;

public class CustomerDao implements ICustomerDao {//Veri tabanı işlemleri dao da yapılır

    private final Session session;

    public CustomerDao() {
        this.session = HibernateSession.getSession();
    }

    @Override
    public void save(Customer customer) {
        this.session.beginTransaction();
        this.session.persist(customer);
        this.session.getTransaction().commit();
    }

    @Override
    public Customer findById(int id) {
        return this.session.get(Customer.class, id);
    }

    @Override
    public void update(Customer customer) {
        this.session.beginTransaction();
        this.session.persist(customer);
        this.session.getTransaction().commit();
    }

    @Override
    public void delete(Customer customer) {
        this.session.beginTransaction();
        this.session.remove(customer);
        this.session.getTransaction().commit();

    }

    @Override
    public List<Customer> findAll() {
        // Bu yöntemi de kullanabiliriz --> List<Customer> customers = this.session.createSelectionQuery("FROM Customer", Customer.class).getResultList();
        //return customers.
        //Ancak mantıklı olan alttaki kullanım.Kodun okunaklığı açısından
        return this.session.createSelectionQuery("FROM Customer", Customer.class).getResultList();
    }

    @Override
    public Customer findByMail(String mail) {
        SelectionQuery<Customer> query = this.session.createSelectionQuery("FROM Customer WHERE mail = :mail", Customer.class);
        query.setParameter("mail", mail);
        return query.getSingleResultOrNull();//Boş gelmesinde veri hata almamak için getSingleResultOrNull kullanıyoruz.
    }
}
