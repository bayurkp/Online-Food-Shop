import java.util.*;

public class Data {
    // Array untuk menyimpan data restaurant
    private static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        
    // Method untuk menambahkan data restaurant
    public static void addRestaurant() {
        System.out.println(App.BOLD + "Tambah Restaurant\n" + App.NORMAL);
        System.out.println("---------------");
        System.out.print("Masukkan nama restaurant\n> ");
        String restaurantName = Input.getString();
        System.out.print("Masukkan alamat restaurant\n> ");
        String restaurantAddress = Input.getString();
        App.clearScreen();

        Restaurant restaurant = new Restaurant(restaurantName, restaurantAddress);
        int select = 0;
        int confirm = 0;
        do {
            System.out.printf(App.BOLD + "Restaurant %s - %s\n" + App.NORMAL, restaurantName, restaurantAddress);
            System.out.println("---------------");
            System.out.println("1. Makanan");
            System.out.println("2. Minuman");
            System.out.print("(Mohon masukkan kode angka untuk melanjutkan)\n> ");
            do {
                select = Input.getInteger();
                if (select != 1 && select != 2) System.out.print("Input invalid. Mohon ulangi\n> ");
            } while (select != 1 && select != 2);

            System.out.print("Apakah Anda yakin untuk menambahkan menu?\n(1 untuk melanjutkan dan 0 untuk tidak)\n> ");
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
                default:
                    System.out.print("Input invalid. Mohon ulangi\n> ");
            }
        } while (confirm == 0);
        
        restaurants.add(restaurant);
    }

    public static ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }
}
