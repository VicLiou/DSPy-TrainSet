package example.trainset.shopping_cart_api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class CartService {
    private static final double TAX_RATE = 0.1; // 定義為常數，易於配置
    private final List<Item> items = new ArrayList<>();

    public void addItem(@Valid Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        items.add(item);
    }

    public double calculateTotal() {
        return items.stream()
                .mapToDouble(item -> item.getPrice() * (1 + TAX_RATE))
                .sum();
    }
}
