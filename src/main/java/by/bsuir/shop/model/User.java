package by.bsuir.shop.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"idUser", "username", "email"})})
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idUser;

    @Column
    @Size(min=3, max=40, message="Username must be between 3 and 20 characters long.")
    @Pattern(regexp="^[a-zA-Z0-9]+$", message="Username must be alphanumeric with no spaces")
    private String username;

    @Column
    @Size(min=6, max=32, message="The password must be at least 6 characters long.")
    @NotBlank
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PlacedOrder> placedOrders;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ShoppingBasket_Laptop")
    private List<Laptop> laptopList;

    @Column
    @Pattern(regexp="[A-Za-z0-9%\\+-\\.]+@[A-Za-z0-9\\.-]+\\.[A-Za-z]{2,4}", message="Invalid email address.")
    private String email;

    @Column(columnDefinition = "BIT")
    private boolean available;

    @ElementCollection
    @CollectionTable(name ="Roles")
    private Set<String> userRoles;

    public User() {}

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPlacedOrders(List<PlacedOrder> messages) {
        this.placedOrders = placedOrders;
    }

    public List<PlacedOrder> getPlacedOrders() {
        return placedOrders;
    }

    public List<Laptop> getLaptopList() {
        return laptopList;
    }

    public void setLaptopList(List<Laptop> laptopList) {
        this.laptopList = laptopList;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean enabled) {
        this.available = enabled;
    }

    public Set<String> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<String> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (available != user.available) return false;
        if (!idUser.equals(user.idUser)) return false;
        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
        if (!placedOrders.equals(user.placedOrders)) return false;
        if (!laptopList.equals(user.laptopList)) return false;
        if (!email.equals(user.email)) return false;
        return userRoles.equals(user.userRoles);

    }

    @Override
    public int hashCode() {
        int result = idUser.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + placedOrders.hashCode();
        result = 31 * result + laptopList.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (available ? 1 : 0);
        result = 31 * result + userRoles.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", placedOrders=" + placedOrders +
                ", laptopList=" + laptopList +
                ", email='" + email + '\'' +
                ", available=" + available +
                ", userRoles=" + userRoles +
                '}';
    }
}
