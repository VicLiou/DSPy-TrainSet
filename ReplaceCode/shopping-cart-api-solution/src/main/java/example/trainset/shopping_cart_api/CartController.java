package example.trainset.shopping_cart_api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addItem(@Valid @RequestBody Item item) {
        cartService.addItem(item);
        return ResponseEntity.ok("Item added successfully");
    }

    @GetMapping("/total")
    public ResponseEntity<Double> getTotal() {
        return ResponseEntity.ok(cartService.calculateTotal());
    }
}