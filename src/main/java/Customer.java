import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", columnDefinition = "serial")
    private int id;

    @Column(name = "customer_name", length = 100, nullable = false)
    //nullable false olursa null olamaz bir değer eklenmek zorunda olur.
    private String name;

    @Column(name = "customer_mail", unique = true, nullable = false)
    //unique true olduğunda benzersiz olur.Yani aynı türde mail eklenemez demektir.
    private String mail;


    @Temporal(TemporalType.DATE) //Bu anotasyon bize burada date işlemi yapacağımızı belirtiyor.
    @Column(name = "customer_on_date")
    private LocalDate onDate;


    @Enumerated(EnumType.STRING)
    @Column(name = "customer_gender")
    private GENDER gender;

    public enum GENDER {
        Male, Female
    }


    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getOnDate() {
        return onDate;
    }

    public void setOnDate(LocalDate onDate) {
        this.onDate = onDate;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }
}
