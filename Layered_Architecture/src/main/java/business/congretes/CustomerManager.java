package business.congretes;

import business.abstracts.ICustomerService;
import dao.abstracts.ICustomerDao;
import entities.Customer;

import java.util.List;

public class CustomerManager implements ICustomerService { //İşin yönetim şeklini business da yapıyoruz


    private final ICustomerDao customerDao;

    //Bu işlem Dependency Injektiondur.
    public CustomerManager(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void save(Customer customer) {
        Customer checkMailCustomer = this.customerDao.findByMail(customer.getMail());
        if (checkMailCustomer != null) {
            throw new RuntimeException(customer.getMail() + " Bu mail adresi daha önce eklenmiştir.");
        }
        this.customerDao.save(customer);

    }

    @Override
    public Customer findById(int id) {
        return this.customerDao.findById(id);
    }

    @Override
    public void update(Customer customer) {
        Customer checkCustomer = this.customerDao.findByMail(customer.getMail());
        if (checkCustomer != null && checkCustomer.getId() != customer.getId())
        //bu id dışardan update edeceğimiz id ye eşit değilse yani veritabanında ki e posta adresimi değiştirmedim
        // sadece isim vs değiştirdiğim için bunu kabul etmeli ancak maili değiştirmek istesek bu kez diğer mailleri de check edip ona göre update işlemi sonlanacak.
        {
            throw new RuntimeException(customer.getMail() + " Bu mail adresi daha önce eklenmiştir.");

        }
        this.customerDao.update(customer);

    }

    @Override
    public void deleteById(int id) {
        //this.customerDao.delete(this.findById(id)) de bir yöntemdir.
        Customer customer = this.findById(id);
        this.customerDao.delete(customer);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerDao.findAll();
    }
}
