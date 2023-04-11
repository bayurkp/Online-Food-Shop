import java.util.*;

public class Data {
    // Array list untuk menyimpan data restaurant
    private static ArrayList<Restaurant> restaurants = new ArrayList<>();
    
    // Array list untuk menyimpan data pemesanan
    private static ArrayList<Order> orders = new ArrayList<>();

    // Method untuk menampilkan data restaruant
    public static void showRestaurant() {
        App.clearScreen();
        System.out.println(App.BOLD + "\nTampilkan Restaurant" + App.NORMAL);
        System.out.println("---------------");

        // Jika belum ada restaruant yang ditambahkan maka akan tampil teks berikut
        if (restaurants.size() == 0) {
            System.out.println("Tidak ada restaurant teregistrasi.");
            System.out.print("*(Tekan enter untuk melanjutkan....)");
            Input.getString();
            return;
        }

        // Melakukan looping untuk menampilkan daftar restaurant yang ditambahkan
        for (int i = 0; i < restaurants.size(); i++) {
            String restaurantName = restaurants.get(i).getName();
            String restaurantAddress = restaurants.get(i).getAddress();
            System.out.printf("%d. %s-%s\n", i + 1, restaurantName, restaurantAddress);
        }

        // Menerima input untuk memilih detail menu dari restaurant dengan ID yang diinput
        System.out.println("Masukkan ID restaurant untuk detail menu");
        System.out.print("*(masukkan 0 untuk kembali)\n> ");
        int idRestaurant = 0;
        do {
            idRestaurant = Input.getInteger();
            if (idRestaurant == 0) {
                return;
            } else if (idRestaurant < 0 && idRestaurant >= restaurants.size()) {
                System.out.print("Input invalid. Mohon ulangi\n> ");
            }
        } while (idRestaurant < 0 && idRestaurant >= restaurants.size());

        // Penyimpanan sementara untuk menu makanan dan minuman
        ArrayList<ArrayList<String>> foods = new ArrayList<>();
        ArrayList<ArrayList<String>> drinks = new ArrayList<>();
        foods = restaurants.get(idRestaurant - 1).getFoods();
        drinks = restaurants.get(idRestaurant - 1).getDrinks();

        // Menampilkan daftar menu makanan dari restaurant yang dipilih
        App.clearScreen();
        System.out.printf(App.BOLD + "\n%s-%s" + App.NORMAL, restaurants.get(idRestaurant - 1).getName(), restaurants.get(idRestaurant - 1).getAddress());
        System.out.println(App.BOLD + "\nMenu Makanan" + App.NORMAL);
        System.out.println("---------------");
        if (foods.size() == 0) {
            System.out.println("Tidak ada makanan.");
        } else {
            for (int i = 0; i < foods.size(); i++) {
                System.out.printf("%dF. %s\t\tRp. %s\n", i + 1, foods.get(i).get(0), foods.get(i).get(1));
            }
        }

        // Menampilkan daftar menu minuman dari restaurant yang dipilih
        System.out.println(App.BOLD + "\nMenu Minuman" + App.NORMAL);
        System.out.println("---------------");
        if (drinks.size() == 0) {
            System.out.println("Tidak ada minuman.");
        } else {
            for (int i = 0; i < drinks.size(); i++) {
                System.out.printf("%dD. %s\t\tRp. %s\n", i + 1, drinks.get(i).get(0), drinks.get(i).get(1));
            }        
        }
        Input.getString();
    }

    public static ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }

    public static void addRestaurants(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public static void removeRestaurant(int idRestaurant) {
        restaurants.remove(idRestaurant);
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static void addOrder(Order order) {
        orders.add(order);
    }

    public static void removeOrder(int idOrder) {
        orders.remove(idOrder);
    }
}
