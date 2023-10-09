
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

class Order {
    private List<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

public class RestaurantOrderingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Burger", 8.99));
        menu.add(new MenuItem("Pizza", 10.99));
        menu.add(new MenuItem("Salad", 5.99));

        Order order = new Order();

        while (true) {
            System.out.println("Menu:");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println(i + 1 + ". " + menu.get(i));
            }

            System.out.println("Enter the number of the item you want to order (0 to finish):");
            int choice = scanner.nextInt();
            
            if (choice == 0) {
                break;
            } else if (choice >= 1 && choice <= menu.size()) {
                MenuItem selectedItem = menu.get(choice - 1);
                order.addItem(selectedItem);
                System.out.println(selectedItem.getName() + " added to your order.");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Your order:");
        for (MenuItem item : order.getItems()) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }

        double total = order.calculateTotal();
        System.out.println("Total: $" + total);

        System.out.println("Thank you for your order!");
    }
}
