import Model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        while (true) {
            String [] menu = {"Tambah Produk", "Hapus Produk", "Ubah Produk", "Lihat Produk", "Keluar"};
            StringBuilder range = new StringBuilder();
            String error,choose;

            System.out.println("================ Menu Utama ================");
            for (int i = 0; i < menu.length; i++) {
                int no = i + 1;
                System.out.println(no + ". " + menu[i]);
                range.append(no).append("/");
            }

            do {
                System.out.print("Masukkan pilihan [" + range + "] : ");
                choose = scanner.next();
                error = Validation.validation("Menu", choose);
                if (!error.isEmpty()) {
                    Validation.printError(error);
                }
            } while (!error.isEmpty());

            switch (Integer.parseInt(choose)) {
                case 1 -> addProduct();
                case 2 -> deleteProduct();
                case 3 -> updateProduct();
                case 4 -> listProduct();
                case 5 -> System.exit(0);
                default -> Validation.printError("Masukkan angka antara 1-5");
            }
        }
    }

    private static void listProduct() {
        products.forEach(product -> System.out.println("Name : " + product.getName() + ", Quantity : " + product.getQuantity()));
    }

    private static String findProduct(String name) {
        String [] find = new String[1];
        products.forEach(product -> {
            if (product.getName().equals(name)) find[0] = "ditemukan";
        });
        return find[0] != null ? "" : "Produk yang dicari tidak ada";
    }

    private static void addProduct() {
        String name, quantity, confirm = "y", error_name, error_quantity;

        System.out.println("================ Data Produk ================");
        do {
            scanner.nextLine();
            do {
                System.out.print("Masukkan nama produk : ");
                name = scanner.nextLine();
                error_name = Validation.validation("Name", name);
                if (!error_name.isEmpty()) {
                    Validation.printError(error_name);
                }
            } while (!error_name.isEmpty());

            do {
                System.out.print("Masukkan jumlah produk : ");
                quantity = scanner.next();
                error_quantity = Validation.validation("Quantity", quantity);
                if (!error_quantity.isEmpty()) {
                    Validation.printError(error_quantity);
                }
            } while (!error_quantity.isEmpty());

            products.add(new Product(name, Integer.parseInt(quantity)));

            do {
                if (!confirm.equals("y")) Validation.printError("Masukkan Y atau N");

                System.out.print("Apakah anda ingin menambah produk? [y|n] : ");
                confirm = scanner.next().toLowerCase();
                confirm = String.valueOf(confirm.charAt(0));

            } while(!confirm.equals("n") && !confirm.equals("y"));

        } while (confirm.equalsIgnoreCase("y"));
    }
    private static void updateProduct() {}

    private static void deleteProduct() {
        String name, confirm = "ya", error_name;
        System.out.println("================ Hapus Data Produk ================");

        scanner.nextLine();

        do {
            System.out.print("Masukkan nama produk : ");
            name = scanner.nextLine();
            error_name = Validation.validation("Name", name);
            if (!error_name.isEmpty()) {
                Validation.printError(error_name);
            }
        } while (!error_name.isEmpty());

        String find_result = findProduct(name);
        if (!find_result.isEmpty()) {
            Validation.printError(find_result);
        } else {
            do {
                if (!confirm.equals("ya")) Validation.printError("Masukkan Ya atau Tidak");

                System.out.print("Apakah Anda yakin mau menghapus produk ini dari keranjang Anda? [Ya | Tidak] : ");
                confirm = scanner.next().toLowerCase();

            } while(!confirm.equals("tidak") && !confirm.equals("ya"));

            if (confirm.equals("ya")) {
                String finalName = name;
                products.removeIf(product -> product.getName().equals(finalName));
                System.out.println("Data produk berhasil dihapus");
            }
        }
    }
}
