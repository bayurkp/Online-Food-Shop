public class Admin {
    private static String username = "admin";
    private static String password = "admin";

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    // Method menu untuk admin
    public static void menu() {
        App.clearScreen();
        System.out.println(App.BOLD + "\nSelamat datang, Admin!" + App.NORMAL);
        System.out.println("---------------");
        System.out.println("1. Lihat restoran");
        System.out.println("2. Tambah restoran");
        System.out.println("3. Hapus restoran");
        System.out.println("0. Kembali ke menu Login");

        System.out.print("*(Mohon masukkan kode angka untuk melanjutkan)\n> ");
        int select = Input.getInteger(0, 3);

        switch (select) {
            case 1:
                Data.showRestaurant();
                break;
            case 2:
                addRestaurant();
                break;
            case 3:
                removeRestaurant();
                break;
            case 0:
                App.login();
                return;
        }

        menu();
    }

    // Method untuk menambahkan data restoran
    public static void addRestaurant() {
        App.clearScreen();
        System.out.println(App.BOLD + "\nTambah Restoran" + App.NORMAL);
        System.out.println("---------------");

        System.out.println("Masukkan nama restoran.");
        System.out.print("*(Masukkan 0 untuk kembali)\n> ");
        String restaurantName = Input.getString();
        if (restaurantName.equals("0")) {
            menu();
            return;
        }
        restaurantName = App.capitalizeWord(restaurantName);

        System.out.println("Masukkan alamat restoran.");
        System.out.print("*(Masukkan 0 untuk kembali)\n> ");
        String restaurantAddress = Input.getString();
        if (restaurantAddress.equals("0")) {
            menu();
            return;
        }
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
            System.out.println("0. Kembali");
            System.out.print("*(Mohon masukkan kode angka untuk melanjutkan)\n> ");
            select = Input.getInteger(0, 2);

            if (select == 0) {
                addRestaurant();
                return;
            }

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
                    restaurant.addDrink(menuName, menuPrice);
                    break;
            }

            System.out.print("Apakah Anda ingin menambah menu lainnya?\n*(1 untuk melanjutkan dan 0 untuk tidak)\n> ");
            confirm = Input.getInteger(0, 1);
        } while (confirm != 0);

        Data.addRestaurants(restaurant);
        System.out.println("Restoran dan menu berhasil ditambahkan.");
        System.out.print("*(Masukkan apapun untuk melanjutkan)");
        Input.getAnyKey();
    }

    // Method untuk mengahpus data restoran
    public static void removeRestaurant() {
        App.clearScreen();
        // Cek apakah data restoran dimiliki oleh list restaurants
        if (Data.getRestaurants().size() == 0) {
            System.out.println("Tidak ada restoran teregistrasi.");
            System.out.print("*(Tekan enter untuk melanjutkan....)");
            Input.getAnyKey();
            menu();
        }

        // Menampilkan menu hapus restoran
        System.out.println(App.BOLD + "\nHapus Restoran" + App.NORMAL);
        System.out.println("---------------");
        System.out.println("1. Tampilkan Restoran");
        System.out.println("2. Hapus Restoran");
        System.out.println("0. Kembali");

        System.out.print("*(Mohon masukkan kode angka untuk melanjutkan)\n> ");
        int select = Input.getInteger(0, 2);

        if (select == 0) {
            // Kembali ke menu admin
            menu();
        } else if (select == 1) {
            // Menampilkan data restoran
            Data.showRestaurant();
        } else {
            // Meminta input ID restoran yang akan dihapus
            App.clearScreen();
            System.out.println(App.BOLD + "\nHapus Restoran" + App.NORMAL);
            System.out.println("---------------");
            System.out.println("Masukkan ID restoran untuk menghapus");
            System.out.print("*(0 untuk kembali ke menu)\n> ");
            int idRestaurant = Input.getInteger(0, Data.getRestaurants().size());

            if (idRestaurant == 0) {
                menu();
                return;
            }

            // Mengonfirmasi hapus data
            System.out.printf(App.BOLD + "Hapus %s-%s\n" + App.NORMAL,
                    Data.getRestaurants().get(idRestaurant - 1).getName(),
                    Data.getRestaurants().get(idRestaurant - 1).getAddress());
            System.out.print("Masukkan 1 untuk hapus dan 0 untuk kembali ke menu\n> ");
            int confirm = Input.getInteger(0, 1);

            if (confirm == 0) {
                menu();
                return;
            } else {
                Data.removeRestaurant(idRestaurant - 1);
                return;
            }
        }
    }
}
