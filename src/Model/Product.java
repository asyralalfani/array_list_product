package Model;

public class Product {
    private final String name;
    private final int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public static void printTableHeader() {
        System.out.println("List Data Produk:");
        System.out.printf("%20s %15s %10s %5s%n", "Item", "|", "Quantity", "|");
        System.out.printf("%s%n", "-" + "-".repeat(52));
    }

    public void printData() {
        System.out.printf("%20s %15s %10s %5s%n", this.getName(), "|", this.getQuantity(), "|");
    }
}

