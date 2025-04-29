package us.feyrouzbackend.backend.model.dto;

public class SignUpDTO {
    private String email;
    private String password;
    private String name;
    private String phone;
    private boolean emailUpdates;

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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public boolean isEmailUpdates() {
        return emailUpdates;
    }
    public void setEmailUpdates(boolean emailUpdates) {
        this.emailUpdates = emailUpdates;
    }

}
