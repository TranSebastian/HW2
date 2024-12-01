import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class restaurantHashTable{
    static class Order {
        String customerName;
        List<String> items;
        List<Integer> quantities;
    }

    static Map<String, Double> itemPrices = new HashMap<>(); // Hash table to store item prices
    static Map<Integer, Order> orderHash = new HashMap<>(); // Hash table to store order details

    static void placeOrder(int orderId, String customerName, List<String> items, List<Integer> quantities) {
        Order order = new Order();
        order.customerName = customerName;
        order.items = items;
        order.quantities = quantities;
        orderHash.put(orderId, order);
    }

    static double calculateBill(int orderId) {
        double total = 0;
        if (orderHash.get(orderId) != null)
        {
            ArrayList<String> orderedItems = (ArrayList<String>) orderHash.get(orderId).items;
            ArrayList<Integer> quantOrders = (ArrayList<Integer>) orderHash.get(orderId).quantities;
            
            for (int i = 0; i < orderedItems.size(); i++){
                total += itemPrices.get(orderedItems.get(i)) * quantOrders.get(i);
            }
        }

        return total;
    }

    static void displayOrder(int orderId) {
        System.out.println("OrderID: " + orderId);
        if (orderHash.get(orderId) != null)
        {
            System.out.println("Customer Name: " + orderHash.get(orderId).customerName);

            ArrayList<String> orderedItems = (ArrayList<String>) orderHash.get(orderId).items;
            ArrayList<Integer> quantOrders = (ArrayList<Integer>) orderHash.get(orderId).quantities;

            System.out.print("Items: ");
            int i = 0;
            for (i = 0; i < orderedItems.size()-1; i++)
            {
                System.out.print(orderedItems.get(i) + " (Quantity: " + quantOrders.get(i) + "), ");
            }
            System.out.print(orderedItems.get(i) + " (Quantity: " + quantOrders.get(i) + ")");
            System.out.println("\nTotal Bill: $" + calculateBill(orderId));

        }
        else
        {
            System.out.println("Order not found!");
        }
    }

    public static void main(String[] args) {
        // Set prices for items
        itemPrices.put("Burger", 8.5);
        itemPrices.put("Sandwitch", 7.5);
        itemPrices.put("Fries", 2.5);
        itemPrices.put("Coke", 1.5);
        itemPrices.put("Pizza", 9.0);
        itemPrices.put("Pasta", 8.5);
        itemPrices.put("Salad", 5.5);

        // Place some orders
        List<String> items1 = new ArrayList<>();
        items1.add("Burger");
        items1.add("Fries");
        items1.add("Salad");
        items1.add("Coke");
        List<Integer> quantities1 = new ArrayList<>();
        quantities1.add(1);
        quantities1.add(2);
        quantities1.add(1);
        quantities1.add(2);
        placeOrder(101, "Alice", items1, quantities1);

        List<String> items2 = new ArrayList<>();
        items2.add("Pizza");
        items2.add("Pasta");
        items2.add("Salad");
        List<Integer> quantities2 = new ArrayList<>();
        quantities2.add(2);
        quantities2.add(1);
        quantities2.add(1);
        placeOrder(102, "Bob", items2, quantities2);
        

        // Display order details with bills
        displayOrder(101);
        calculateBill(101);
        System.out.println("====================");
        displayOrder(102);
        calculateBill(102);
        System.out.println("====================");
        displayOrder(103);
        calculateBill(103);
    }
}
