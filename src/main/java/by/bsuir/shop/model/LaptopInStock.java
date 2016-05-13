package by.bsuir.shop.model;


import javax.persistence.*;
import javax.validation.constraints.DecimalMin;

@Entity
public class LaptopInStock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idLaptopInStock;
    @DecimalMin("1")
    @Column
    private Double cost;
    @Column(columnDefinition = "BIT")
    private boolean available;

    public LaptopInStock() {}

    public Long getIdLaptopInStock() {
        return idLaptopInStock;
    }

    public void setIdLaptopInStock(Long idLaptopInStock) {
        this.idLaptopInStock = idLaptopInStock;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LaptopInStock)) return false;

        LaptopInStock that = (LaptopInStock) o;

        if (available != that.available) return false;
        if (!idLaptopInStock.equals(that.idLaptopInStock)) return false;
        return cost.equals(that.cost);

    }

    @Override
    public int hashCode() {
        int result = idLaptopInStock.hashCode();
        result = 31 * result + cost.hashCode();
        result = 31 * result + (available ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LaptopInStock{" +
                "idLaptopInStock=" + idLaptopInStock +
                ", cost=" + cost +
                ", available=" + available +
                '}';
    }
}
