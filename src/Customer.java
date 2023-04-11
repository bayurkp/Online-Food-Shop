public class Customer {
    private static String custUsername = "customer";
    private static String custPass = "customer";

    public static String getCustUsername() {
        return custUsername;
    }

    public static String getCustPass() {
        return custPass;
    }

    // Method menu untuk customer
    public static void menu() {
        App.clearScreen();
        System.out.println(App.BOLD + "\nSelamat datang, Customer!" + App.NORMAL);
        System.out.println("---------------");
        System.out.println("1. Lihat restaurant");
        System.out.println("2. Buat pesanan");
        System.out.println("3. Lihat pesanan");
        System.out.println("0. Kembali ke menu Login");

        System.out.print("(Mohon masukkan kode angka untuk melanjutkan)\n> ");
        int select = Input.getInteger(0, 3);

        switch (select) {
            case 1:
                Data.showRestaurant();
                break;
            case 2:
                // addOrder();
                break;
            case 3:
                // showOrder();
                break;
            case 0:
                App.login();
                break;
        }
    }

    public static void addOrder() {
        int idRestaurant = Data.showRestaurant();
        if (idRestaurant == 0) {
            return;
        }

        System.out.println(App.BOLD + "\nTambahkan Pesanan" + App.NORMAL);
        System.out.println("---------------");
        System.out.println("Mohon masukkan ID menu.");
        System.out.print("*(Masukkan 0 untuk kembali)\n> ");

        String idMenu;
        int numberMenu;
        String categoryMenu;
        boolean isFood;
        while (true) {
            idMenu = Input.getString();
            if (idMenu.equals("0")) {
                menu();
                return;
            } else {
                if (idMenuValidation(idMenu)) {
                    idMenu = idMenu.replace("\\s", "");
                    numberMenu = Integer.parseInt(idMenu.split("-")[0]);
                    categoryMenu = idMenu.split("-")[1].toUpperCase();
                    if (categoryMenu.equals("F")) {
                        isFood = true;
                    } else {
                        isFood = false;
                    }
                    break;
                } else {
                    System.out.print("Input invalid. Mohon ulangi.\n> ");
                }
            }
        }

        System.out.println("Mohon masukkan jumlah pesanan.");
        System.out.print("*(Masukkan 0 untuk kembali)\n> ");
        int quantity = Input.getInteger(0, Integer.MAX_VALUE);
        if (quantity == 0) {
            menu();
            return;
        }

        System.out.println("Mohon masukkan jarak ke lokasi antar (dalam KM).");
        System.out.print("*(Masukkan 0 untuk kembali)\n> ");
        Double distance = Input.getDouble(0, Double.MAX_VALUE);
        if (distance == 0.0) {
            menu();
            return;
        }

        if (isFood) {
            Data.addOrder(new Order(
                    Data.getRestaurants().get(idRestaurant - 1).getName(),
                    Data.getRestaurants().get(idRestaurant - 1).getAddress(),
                    Data.getRestaurants().get(idRestaurant - 1).getFoods().get(numberMenu - 1).get(0),
                    Double.parseDouble(
                            Data.getRestaurants().get(idRestaurant - 1).getFoods().get(numberMenu - 1).get(1)),
                    isFood,
                    quantity,
                    distance));
        } else {
            Data.addOrder(new Order(
                    Data.getRestaurants().get(idRestaurant - 1).getName(),
                    Data.getRestaurants().get(idRestaurant - 1).getAddress(),
                    Data.getRestaurants().get(idRestaurant - 1).getDrinks().get(numberMenu - 1).get(0),
                    Double.parseDouble(
                            Data.getRestaurants().get(idRestaurant - 1).getDrinks().get(numberMenu - 1).get(1)),
                    isFood,
                    quantity,
                    distance));
        }
    }

    public static boolean idMenuValidation(String idMenu) {
        idMenu = idMenu.replaceAll("\\s", "");
        String[] parseIdMenu = idMenu.split("-");
        if (parseIdMenu.length == 2) {
            try {
                Integer.parseInt(parseIdMenu[0]);
                parseIdMenu[1] = parseIdMenu[1].toUpperCase();
                if (parseIdMenu[1].equals("D") || parseIdMenu[1].equals("F")) {
                    return true;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Restaurant a = new Restaurant("1", "1");
        // Restaurant b = new Restaurant("2", "2");
        // Restaurant c = new Restaurant("3", "3");
        Data.addRestaurants(a);
        Data.getRestaurants().get(0).addFood("tes1", "2000.01");
        Data.getRestaurants().get(0).addFood("tes2", "2000.02");
        Data.getRestaurants().get(0).addFood("tes3", "2000.03");
        // Data.addRestaurants(b);
        // Data.addRestaurants(c);
        addOrder();
        System.out.println(Data.getOrders().get(0).getMenuName());
        System.out.println(Data.getOrders().get(0).getMenuPrice());
        System.out.println(Data.getOrders().get(0).getTotalPrice());
    }
}
