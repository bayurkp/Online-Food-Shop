import java.util.*;

public class Data {
    // Array untuk menyimpan data restaurant
    private static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        
    // Method untuk menambahkan data restaurant
    public static void addRestaurant() {
        App.clearScreen();
        System.out.println(App.BOLD + "\nTambah Restaurant" + App.NORMAL);
        System.out.println("---------------");

        System.out.print("Masukkan nama restaurant\n> ");
        String restaurantName = Input.getString();
        restaurantName = App.capitalizeWord(restaurantName);

        System.out.print("Masukkan alamat restaurant\n> ");
        String restaurantAddress = Input.getString();
        restaurantAddress = App.capitalizeWord(restaurantAddress);
        App.clearScreen();

        Restaurant restaurant = new Restaurant(restaurantName, restaurantAddress);
        int select = 0;
        int confirm = 0;
        do {
            App.clearScreen();
            System.out.printf(App.BOLD + "Restaurant %s - %s\n" + App.NORMAL, restaurantName, restaurantAddress);
            System.out.println("---------------");
            System.out.println("1. Makanan");
            System.out.println("2. Minuman");
            System.out.print("*(Mohon masukkan kode angka untuk melanjutkan)\n> ");
            do {
                select = Input.getInteger();
                if (select != 1 && select != 2) {
                    System.out.print("Input invalid. Mohon ulangi\n> ");
                }
            } while (select != 1 && select != 2);
            
            System.out.print("Masukkan nama menu\n> ");
            String menuName = Input.getString();
            menuName = App.capitalizeWord(menuName);

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

            System.out.print("Apakah Anda ingin menambah menu lainnya?\n*(1 untuk melanjutkan dan 0 untuk tidak)\n> ");
            do {
                confirm = Input.getInteger();
                System.out.println(confirm);
                if (confirm == 1 && confirm == 0) {
                    System.out.print("Input invalid. Mohon ulangi\n> ");
                }
            } while (confirm == 1 && confirm == 0);

        } while (confirm != 0);
        
        restaurants.add(restaurant);
    }

    // Method untuk menampilkan data restaruant
    public static void showRestaurant() {
        App.clearScreen();
        System.out.println(App.BOLD + "\nTampilkan Restaurant" + App.NORMAL);
        System.out.println("---------------");

        if (restaurants.size() == 0) {
            System.out.println("Tidak ada restaurant teregistrasi.");
            return;
        }

        for (int i = 0; i < restaurants.size(); i++) {
            String restaurantName = restaurants.get(i).getName();
            String restaurantAddress = restaurants.get(i).getAddress();
            System.out.printf("%d. %s-%s\n", i + 1, restaurantName, restaurantAddress);
        }

        System.out.println("Masukkan ID restaurant untuk detail menu");
        System.out.print("*(masukkan 0 untuk kembali)\n> ");
        int idRestaurant = 0;
        do {
            idRestaurant = Input.getInteger();
            if (idRestaurant == 0) {
                return;
            } else if (idRestaurant < 0 && idRestaurant > restaurants.size()) {
                System.out.print("Input invalid. Mohon ulangi\n> ");
            }
        } while (idRestaurant >= 0 && idRestaurant <= restaurants.size());

        ArrayList<ArrayList<String>> foods = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> drinks = new ArrayList<ArrayList<String>>();

        foods = restaurants.get(idRestaurant - 1).getFoods();
        drinks = restaurants.get(idRestaurant - 1).getDrinks();
        System.out.println(App.BOLD + "\nMenu Makanan" + App.NORMAL);
        System.out.println("---------------");
        for (int i = 0; i < foods.size(); i++) {
            System.out.printf("%d. %s\t\t%s", i + 1, foods.get(i), foods.get(i).get(0));
        }

        System.out.println(App.BOLD + "\nMenu Minuman" + App.NORMAL);
        System.out.println("---------------");
        for (int i = 0; i < drinks.size(); i++) {
            System.out.printf("%d. %s\t\t%s", i + 1, drinks.get(i), drinks.get(i).get(0));
        }
    }

    public static ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }
}
