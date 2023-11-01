package Seminar04_task2;

import lombok.*;

import java.util.ArrayList;

@RequiredArgsConstructor
@Getter
public class Order {
    private final int id;
    private final Customer customer;
    private ArrayList<Item> items = new ArrayList<>();

    public int getItemsAmount() {
        return items.size();
    }

    public static Order buy(Order order, Item item, int amount) {
        if (amount < 0) {
            throw new RuntimeException("amount < 0");
        }

        if (order == null || item == null) {
            throw new RuntimeException("order == null || item == null");
        }

        for (int i = 0; i < amount; i++) {
            order.items.add(item);
        }

        return order;
    }
}
