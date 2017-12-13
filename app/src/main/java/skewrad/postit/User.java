package skewrad.postit;

/**
 * Created by skewrad on 13/12/17.
 */

public class User {
    private int id;
    private String username;
    private String lastname;
    private String firstname;
    private String mail;
    private String password;

    public User()
    {

    }

    public User(String username, String firstname, String lastname, String mail, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.password = password;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Username='" + username + '\'' +
                ", Firstname='" + firstname + '\'' +
                ", Lastname='" + lastname + '\'' +
                ", Mail='" + mail + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }
}
