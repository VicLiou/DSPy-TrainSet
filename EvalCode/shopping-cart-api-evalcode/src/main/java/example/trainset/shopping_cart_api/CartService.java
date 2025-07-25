package example.trainset.shopping_cart_api;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class CartService {
    private ArrayList<Item> items = new ArrayList<>();
    private final double TAX_RATE = 0.1; // Code Smell: 硬編碼稅率

    public String addItem(Item item) {
        if (item == null) { // Bug: 無效的 null 檢查後直接返回
            return null; // Code Smell: 返回 null，無錯誤提示
        }
        items.add(item);
        return "Item added"; // Code Smell: 硬編碼字串
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i <= items.size(); i++) { // Bug: 迴圈越界
            total = total + items.get(i).getPrice(); // Bug: 未包含稅率
        }
        return total;
    }
}
