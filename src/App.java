import java.util.*;

public class App {
    private static String adminUsername = "admin";
    private static String adminPass = "admin";
    private static String custUsername = "customer";
    private static String custPass = "customer";

    private static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

    public static void login() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Username > ");
        String username = sc.nextLine();
        System.out.print("Password > ");
        String password = Input.getPassword();

        System.out.println(password);
        if (username.equals(adminUsername) && password.equals(adminPass)) {
            adminMenu();
        } else if (username.equals(custUsername) && password.equals(custPass)) {
            custMenu();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            login();
        }

        sc.close();
    }

    public static void adminMenu() {
        System.out.println("Selamat datang kembali, Admin!");
        System.out.println("1. Lihat restaurant");
        System.out.println("2. Tambah restaurant");
        System.out.println("3. Hapus restaurant");
        System.out.println("4. Kembali ke menu Login");
        
        System.out.print("(Mohon masukkan kode angka untuk melanjutkan)\n> ");
        int select = 0;
        do {
            select = Input.getInteger();
            if (select <= 1 && select >= 4) System.out.print("Input invalid. Mohon ulangi\n> ");
        } while (select <= 1 && select >= 4);
        
        switch (select) {
            case 1:
                // showRestaurant();
                break;
            case 2:
                addRestaurant();
                break;
            case 3:
                // deleteRestaurant();
                break;
            case 4:
                login();
                break;
            default:
                break;
        }
    }

    public static void custMenu() {
        System.out.println("Selamat datang kembali, Customer!");
        System.out.println("1. Lihat restaurant");
        System.out.println("2. Buat pesanan");
        System.out.println("3. Lihat pesanan");
        System.out.println("4. Kembali ke menu Login");
        
        System.out.print("(Mohon masukkan kode angka untuk melanjutkan)\n> ");
        int select = 0;
        do {
            select = Input.getInteger();
            if (select <= 1 && select >= 4) System.out.print("Input invalid. Mohon ulangi\n> ");
        } while (select <= 1 && select >= 4);
        
        switch (select) {
            case 1:
                // showRestaurant();
                break;
            case 2:
                // addOrder();
                break;
            case 3:
                // showOrder();
                break;
            case 4:
                login();
                break;
        }
    }

    public static void addRestaurant() {
        // System.out.println("Tambah restaurant");
        // System.out.print("Masukkan nama restaurant\n> ");
        // String restaurantName = Input.getString();
        // System.out.print("Masukkan alamat restaurant\n> ");
        // String restaurantAddress = Input.getString();

        // Restaurant restaurant = new Restaurant(restaurantName, restaurantAddress);
        Restaurant restaurant = new Restaurant("Starfood", "Surabaya");
        
        // System.out.printf("Restaurant %s - %s\n", restaurantName, restaurantAddress);
        System.out.println("1. Makanan");
        System.out.println("2. Minuman");

        System.out.print("(Mohon masukkan kode angka untuk melanjutkan)\n> ");
        int select = 0;
        do {
            select = Input.getInteger();
            System.out.println(select);
            if (select != 1 && select != 2) System.out.print("Input invalid. Mohon ulangi\n> ");
            else break;
        } while (select != 1 && select != 2);

        int confirm = 0;
        do {
            System.out.print("Apakah Anda yakin untuk menambahkan menu?\n(1 untuk lanjutkan dan 0 untuk kembali)\n> ");
            do {
                confirm = Input.getInteger();
                if (confirm == 1 && confirm == 0) System.out.print("Input invalid. Mohon ulangi\n> ");
            } while (confirm == 1 && confirm == 0);
            
            System.out.print("Masukkan nama menu\n> ");
            String menuName = Input.getString();
            System.out.print("Masukkan harga menu (Rp)\n> ");
            String menuPrice = Double.toString(Input.getDouble());

            switch (select) {
                case 1:
                    restaurant.addFood(menuName, menuPrice);
                    break;
                case 2:
                    restaurant.addDrinks(menuName, menuPrice);
                    break;
            }
        } while (confirm == 0);
        
        restaurants.add(restaurant);
    }

    public static void main(String[] args) {
        // login();
        addRestaurant();
        System.out.println(restaurants.get(0).getFoods());
        // restaurants.get(0).getDrinks();
    }
}
