package model;

public class Contact {
    int id;
    String name;
    String lastName;
    String email;
    String category;

    public Contact() {
    }

    public Contact(int id, String name, String lastName, String email, String category) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.category = category;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", category=" + category + '}';
    }
}
