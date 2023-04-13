public class Admin {
    // Variabel username untuk admin
    private static String username = "admin";
    // Variabel password untuk admin
    private static String password = "admin";

    // Getter username
    public static String getUsername() {
        return username;
    }

    // Getter password
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

        // Input pilihan
        System.out.print("*(Mohon masukkan kode angka untuk melanjutkan)\n> ");
        int select = Input.getInteger(0, 3);

        // Jalankan menu yang dipilih
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

        // Kembali ke menu
        menu();
    }

    // Method untuk menambahkan data restoran
    public static void addRestaurant() {
        App.clearScreen();
        System.out.println(App.BOLD + "\nTambah Restoran" + App.NORMAL);
        System.out.println("---------------");

        // Input nama restoran
        System.out.println("Masukkan nama restoran.");
        System.out.print("*(Masukkan 0 untuk kembali)\n> ");
        String restaurantName = Input.getString();
        if (restaurantName.equals("0")) {
            menu();
            return;
        }

        // Mengubah format nama restoran yang diinput menjadi Capitalize Each Word
        restaurantName = App.capitalizeWord(restaurantName);

        // Input alamat restoran
        System.out.println("Masukkan alamat restoran.");
        System.out.print("*(Masukkan 0 untuk kembali)\n> ");
        String restaurantAddress = Input.getString();
        if (restaurantAddress.equals("0")) {
            menu();
            return;
        }

        // Mengubah format alamat restoran yang diinput menjadi Capitalize Each Word
        restaurantAddress = App.capitalizeWord(restaurantAddress);
        App.clearScreen();

        // Instansiasi objek restaurant
        Restaurant restaurant = new Restaurant(restaurantName, restaurantAddress);

        // Looping untuk input menu makanan dan minuman di restoran
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

        // Menambahkan data objek restoran ke ArrayList pada class Data
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

            // Mengonfirmasi penghapusan data restoran
            System.out.printf(App.BOLD + "Hapus %s-%s\n" + App.NORMAL,
                    Data.getRestaurants().get(idRestaurant - 1).getName(),
                    Data.getRestaurants().get(idRestaurant - 1).getAddress());
            System.out.print("Masukkan 1 untuk hapus dan 0 untuk kembali ke menu\n> ");
            int confirm = Input.getInteger(0, 1);

            if (confirm == 0) {
                menu();
                return;
            } else {
                // Hapus data restoran
                Data.removeRestaurant(idRestaurant - 1);
                return;
            }
        }
    }
}
