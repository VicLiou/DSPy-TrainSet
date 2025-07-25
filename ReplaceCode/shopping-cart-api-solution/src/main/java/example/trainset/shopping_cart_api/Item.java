package example.trainset.shopping_cart_api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class Item {
    @NotBlank(message = "Name cannot be empty")
    private final String name;

    @PositiveOrZero(message = "Price cannot be negative")
    private final double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
