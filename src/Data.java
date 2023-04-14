import java.util.ArrayList;

public class Data {
    // Array list untuk menyimpan data restoran
    private static ArrayList<Restaurant> restaurants = new ArrayList<>();

    // Array list untuk menyimpan data restoran
    private static ArrayList<Order> orders = new ArrayList<>();

    // Method untuk menampilkan data restoran
    public static int showRestaurant() {
        App.clearScreen();
        System.out.println(App.BOLD + "\nRestoran" + App.NORMAL);
        System.out.println("---------------");

        // Jika belum ada restaruant yang ditambahkan maka akan tampil teks berikut
        if (restaurants.size() == 0) {
            System.out.println("Tidak ada restoran teregistrasi.");
            System.out.print("*(Masukkan apapun untuk melanjutkan....)");
            Input.getAnyKey();
            return 0;
        }

        // Melakukan looping untuk menampilkan daftar restoran yang ditambahkan
        int id = 1;
        for (Restaurant restaurant : restaurants) {
            System.out.printf("%d. %s-%s\n", id, restaurant.getName(), restaurant.getAddress());
            id++;
        }

        // Menerima input untuk memilih detail menu dari restaurant dengan ID yang
        // diinput
        System.out.println("Masukkan ID restoran untuk detail menu. (ex: 1)");
        System.out.print("*(masukkan 0 untuk kembali)\n> ");
        int idRestaurant = 0;
        do {
            idRestaurant = Input.getInteger();
            if (idRestaurant == 0) {
                return 0;
            } else if (idRestaurant < 0 && idRestaurant >= restaurants.size()) {
                System.out.print("Input invalid. Mohon ulangi\n> ");
            }
        } while (idRestaurant < 0 && idRestaurant >= restaurants.size());

        // Penyimpanan sementara untuk menu makanan dan minuman
        ArrayList<ArrayList<String>> foods = new ArrayList<>();
        ArrayList<ArrayList<String>> drinks = new ArrayList<>();
        foods = restaurants.get(idRestaurant - 1).getFoods();
        drinks = restaurants.get(idRestaurant - 1).getDrinks();

        // Menampilkan daftar menu makanan dari restoran yang dipilih
        App.clearScreen();
        System.out.printf(App.BOLD + "\n%s-%s" + App.NORMAL, restaurants.get(idRestaurant - 1).getName(),
                restaurants.get(idRestaurant - 1).getAddress());
        System.out.println(App.BOLD + "\nMenu Makanan" + App.NORMAL);
        System.out.println("---------------");
        if (foods.size() == 0) {
            System.out.println("Tidak ada makanan.");
        } else {
            int idFood = 1;
            for (ArrayList<String> food : restaurants.get(idRestaurant - 1).getFoods()) {
                System.out.printf("%d-F. %s\t\tRp. %s\n", idFood, food.get(0),
                        food.get(1));
                idFood++;
            }
        }

        // Menampilkan daftar menu minuman dari restoran yang dipilih
        System.out.println(App.BOLD + "\nMenu Minuman" + App.NORMAL);
        System.out.println("---------------");
        if (drinks.size() == 0) {
            System.out.println("Tidak ada minuman.");
        } else {
            int idDrink = 1;
            for (ArrayList<String> drink : restaurants.get(idRestaurant - 1).getDrinks()) {
                System.out.printf("%d-D. %s\t\tRp. %s\n", idDrink, drink.get(0),
                        drink.get(1));
                idDrink++;
            }
        }

        System.out.print("\n*(Masukkan apapun untuk lanjutkan)");
        Input.getAnyKey();
        return idRestaurant;
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

    public static double showOrder() {
        System.out.println(App.BOLD + "\nPesanan" + App.NORMAL);
        System.out.println("---------------");

        if (orders.size() == 0) {
            System.out.println("Tidak ada pesanan teregistrasi.");
            System.out.print("*(Tekan enter untuk melanjutkan....)");
            Input.getAnyKey();
            return 0.0;
        }

        int id = 1;
        double totalPayment = 0.0;
        for (Order order : orders) {
            System.out.printf("\n%d. %s-%s\t\t : %s\t\tRp. %.2f %dx \t\t : Rp. %.2f\n",
                    id,
                    order.getResaturantName(),
                    order.getResaturantAddress(),
                    order.getMenuName(),
                    order.getMenuPrice(),
                    order.getQuantity(),
                    order.getTotalPrice());
            totalPayment += order.getTotalPrice();
            id++;
        }
        System.out.printf("%s\nTotal : Rp. %.2f%s\n", App.BOLD, totalPayment, App.NORMAL);
        System.out.print("\n*(Masukkan apapun untuk lanjutkan)");
        Input.getAnyKey();
        return totalPayment;
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

    public static void removeAllOrders() {
        orders.removeAll(orders);
    }
}
