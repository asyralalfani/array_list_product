import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Mie", 10));
        products.add(new Product("Soap", 2));

        products.forEach(product -> System.out.println("Name : " + product.getName() + ", Quantity : " + product.getQuantity()));
    }
}
