package by.bsuir.shop.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Entity
public class PlacedOrder
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int idOrder;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Column
    private Date orderingDate;

    @NotEmpty
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private List<Laptop> laptopList;

    public PlacedOrder() {}

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Date getOrderingDate() {
        return orderingDate;
    }

    public void setOrderingDate(Date orderingDate) {
        this.orderingDate = orderingDate;
    }

    public List<Laptop> getLaptopList() {
        return laptopList;
    }

    public void setLaptopList(List<Laptop> laptopList) {
        this.laptopList = laptopList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlacedOrder)) return false;

        PlacedOrder that = (PlacedOrder) o;

        if (idOrder != that.idOrder) return false;
        if (!orderingDate.equals(that.orderingDate)) return false;
        return laptopList.equals(that.laptopList);

    }

    @Override
    public int hashCode() {
        int result = idOrder;
        result = 31 * result + orderingDate.hashCode();
        result = 31 * result + laptopList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PlacedOrder{" +
                "idOrder=" + idOrder +
                ", orderingDate=" + orderingDate +
                ", laptopList=" + laptopList +
                '}';
    }
}
