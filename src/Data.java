import java.util.*;

public class Data {
    private static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        
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

    public static ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }
}
