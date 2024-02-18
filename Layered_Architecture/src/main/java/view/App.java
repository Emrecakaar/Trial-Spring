package view;

import business.congretes.CustomerManager;
import dao.congretes.CustomerDao;
import entities.Customer;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {

        CustomerManager customerManager = new CustomerManager(new CustomerDao());
/*
//Customer Ekleme
        Customer customer = new Customer();
        customer.setName("Test");
        customer.setMail("test@info.com");
        customer.setGender(Customer.GENDER.Female);
        customer.setOnDate(LocalDate.now());

        customerManager.save(customer);
  */

        /*
        //Customerdan veri bulma
        Customer firstCustomer = customerManager.findById(1);
        System.out.println(firstCustomer.toString());
             */

        /*
        //Customer silme
        customerManager.deleteById(2);
         */

        /*
        //Burada hem update işlemi hemde veriyi idye göre çekme işlemi yapıyoruz
        Customer customer = customerManager.findById(1);
        System.out.println(customer.toString());
        //customer.setName("EMRECAN");
        customer.setMail("test@info.com");
        customerManager.update(customer);
         */

        List<Customer> customerList = customerManager.findAll();
        System.out.println(customerList.toString());

    }
}
