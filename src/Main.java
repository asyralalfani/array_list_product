import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

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

    private static void listProduct() {}
    private static void addProduct() {}
    private static void updateProduct() {}
    private static void deleteProduct() {}
}
