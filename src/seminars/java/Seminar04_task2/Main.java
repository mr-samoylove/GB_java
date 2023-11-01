package Seminar04_task2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1));
        customers.add(new Customer(2));
        customers.add(new Customer(3));

        List<Item> items = new ArrayList<>();
        items.add(new Item(1));
        items.add(new Item(2));
        items.add(new Item(3));

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, customers.get(0)));
        orders.add(new Order(2, customers.get(0)));
        orders.add(new Order(3, customers.get(1)));

        Order.buy(orders.get(0), items.get(0), 4);
        Order.buy(orders.get(0), items.get(2), 1);
        Order.buy(orders.get(2), items.get(1), 2);


        try {
            Order.buy(orders.get(2), null, 2);
        } catch (RuntimeException e) {
            System.out.println("No such item");
        }

        try {
            Order.buy(orders.get(2), items.get(1), -6);
        } catch (Exception e) {
            System.out.println("Amount is negative");
        }

        int salesAmount = 0;
        for (Order order : orders) {
            salesAmount += order.getItemsAmount();
        }
        System.out.println("Всего продаж: " + salesAmount);
    }
}
