import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class OnlineStoreApp {
    static HashMap<String, Product> onlineStores = new HashMap<>();
    static List<Product> products = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // no need for UnicodeSet field
    // private static UnicodeSet cart;

    static boolean initializedMap() {
        onlineStores.put("AV1051", new Product("AV1051", "JBL Bluetooth Speaker", 89.95, "Audio Video"));
        onlineStores.put("AV1312", new Product("AV1312", "Mini 1000 Lumen's Projector", 149.95, "Audio Video"));
        onlineStores.put("GM1148", new Product("GM1148", "Retro Handheld Arcade", 24.45, "Games"));
        onlineStores.put("PW1001", new Product("PW1001", "Solar Powered Battery Charger", 19.99, "Electronics"));

        return true; // changed from false to true, as the map is successfully initialized
    }

    public static void main(String[] args) {
        initializedMap();
        showMainScreen();
    }

    private static void showMainScreen() {
        // removed unnecessary variable
        // boolean screen_done = false;
        while (true) {
            System.out.println("Welcome to the online store app!");
            System.out.println("Please choose one of the following options:");
            System.out.println("1. Display Products");
            System.out.println("2. Display Cart");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    displayCart();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again!");
                    break;
            }
        }
    }

    private static void displayCart() {
        double total = 0;
        System.out.println("Current Cart:");
        for (Product p : products) {
            System.out.println("- " + p.getName() + " (Qty: 1)");
            total += p.getPrice();
        }
        System.out.println("Total: $" + total);

        System.out.println("What would you like to do?");
        System.out.println("1. Check Out");
        System.out.println("2. Remove Product from Cart");
        System.out.println("3. Go Back to Home Screen");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                checkOut();
                break;
            case 2:
                removeProduct();
                break;
            case 3:
                // corrected method name
                displayHomeScreen();
                break;
            default:
                System.out.println("Invalid choice.");
                displayCart();
                break;
        }
    }

    // corrected method name
    private static void displayHomeScreen() {
        System.out.println("Returning to home screen...");
    }

    private static void removeProduct() {
        System.out.println("Enter the SKU of the product to remove:");
        String sku = scanner.next();
        Product productToRemove = null;
        for (Product p : products) {
            if (p.getSku().equals(sku)) {
                productToRemove = p;
                break;
            }
        }
        if (productToRemove == null) {
            System.out.println("Invalid SKU. Please try again.");
            return;
        }
        products.remove(productToRemove);
        System.out.println("Product removed from cart.");
    }

    private static void checkOut() {
        double total = 0;
        System.out.println("Checking out...");
        System.out.println("Order Details:");
        for (Product p : products) {
            System.out.println("- " + p.getName() + " (Qty: 1) $" + p.getPrice());
            total += p.getPrice();
        }
        System.out.println("Total: $" + total);
        products.clear();
        System.out.println("Thank you for shopping with us!");
    }

    static void displayProducts() {
        while (true) {
            System.out.println("Products:");
            System.out.println("");
            for (Product p : onlineStores.values()) {
                System.out.println(p.getSku() + " |" + p.getName() + "|" + p.getPrice() + "|" + p.getDepartment());
            }
            System.out.println("Please choose from the following options:");
            System.out.println("1. Add a product to cart");
            System.out.println("2. Search products");
            System.out.println("3. Go back to home screen");
            int choice = scanner.nextInt();
            String input = promptForInput("");
            switch (choice) {
                case 1:
                    String sku = promptForInput("Enter the Product SKU:");
                    Product p = onlineStores.get(sku.toUpperCase());
                    if (p != null)
                    addProductToCart(p);
                    break;
                case 2:
                    searchProducts();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }

    private static String promptForInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static void addProductToCart() {
    }

    private static void searchProducts() {
        System.out.println("Enter a search query:");
        String query = scanner.next();
        System.out.println("Matching Products:");
        System.out.println("SKU | Name | Price | Department");
        for (Product p : products) {
            if (p.getName().contains(query)) {
                System.out.println(p.getSku() + " | " + p.getName() + " | " + p.getPrice() + " | " + p.getDepartment());
            }
        }
    }


    private static void searchProductsByDepartment() {
        System.out.println("Enter a department:");
        String department = scanner.next();
        System.out.println("Matching Products:");
        System.out.println("SKU | Name | Price | Department");
        for (Product p : onlineStores.values()) {
            if (p.getDepartment().equals(department)) {
                System.out.println(p.getSku() + " | " + p.getName() + " | " + p.getPrice() + " | " + p.getDepartment());
            }
        }
    }

    private static void searchProductsByPrice() {
        Scanner price2 = new Scanner(System.in);
        System.out.println("Enter a maximum price:");
        String price = price2.nextLine();



        System.out.println("Matching Products:");
        System.out.println("SKU | Name | Price | Department");
        for (Product p : onlineStores.values()) {
            p.getPrice();{
                System.out.println(p.getSku() + " | " + p.getName() + " | " + p.getPrice() + " | " + p.getDepartment());
            }
        }
    }

    static void addProductToCart(Product p) {
        System.out.println("Enter the SKU of the product to add:");
        String sku = scanner.next();
        Product product = onlineStores.get(sku);
        if (product == null) {
            System.out.println("Invalid SKU. Please try again.");
            return;
        }






        }

    }




