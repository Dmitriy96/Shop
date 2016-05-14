package by.bsuir.shop.model;

import javax.persistence.*;

@Entity
@Table(name = "PlacedOrder_Laptop")
public class PlacedOrderLaptop {
    private Integer PlacedOrder_idOrder;
    @Id
    private Long laptopList_idLaptop;

    public Integer getPlacedOrder_idOrder() {
        return PlacedOrder_idOrder;
    }

    public void setPlacedOrder_idOrder(Integer placedOrder_idOrder) {
        PlacedOrder_idOrder = placedOrder_idOrder;
    }

    public Long getLaptopList_idLaptop() {
        return laptopList_idLaptop;
    }

    public void setLaptopList_idLaptop(Long laptopList_idLaptop) {
        this.laptopList_idLaptop = laptopList_idLaptop;
    }
}
