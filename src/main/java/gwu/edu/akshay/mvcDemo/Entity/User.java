package gwu.edu.akshay.mvcDemo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String LastName;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "feedback")
    String feedback;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
