package lib.browser;

public class User {
    private int    id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;

    public User(int id, String firstName, String lastName, String username, String email, String password) {
        this.id        = id;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.username  = username;
        this.email     = email;
        this.password  = password;
    }

    public static User defaultUser() {
        return new User(1, "Visitante", "", "", "", "");
    }

    public void validateUsername() {
        if (username.length() < 4) {
            throw new IllegalArgumentException("O nome de usuário deve conter pelo menos 4 caracteres");
        }
    }

    public void validatePassword() {
        if (password.length() < 8) {
            throw new IllegalArgumentException("A senha deve possuir pelo menos 8 caracteres");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
}
