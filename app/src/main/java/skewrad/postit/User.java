package skewrad.postit;

/**
 * Created by skewrad on 13/12/17.
 */

public class User {
    private int id;
    private String username;
    private String lastname;
    private String firstname;
    private String date;
    private String password;

    public User()
    {

    }

    public User(String username, String firstname, String lastname, String date, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
                ", Date='" + date + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }
}
