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

        Restaurant restaurant = new Restaurant(Data.getRestaurants().get(idRestaurant - 1).getName(), Data.getRestaurants().get(idRestaurant - 1).getAddress());

        System.out.println(App.BOLD + "Tambahkan Pesanan" + App.NORMAL);
        System.out.println("---------------");
        System.out.println("Mohon masukkan ID menu.");
        System.out.print("*(Masukkan 0 untuk kembali)\n> ");

        String idMenu = Input.getString();
        if (idMenu.equals("0")) {
            menu();
            return;
        } else {
            System.out.println(idMenuValidation(idMenu));
        }
    }

    public static boolean idMenuValidation(String idMenu) {
        String[] parseIdMenu = idMenu.split("-");
        if (parseIdMenu.length == 2) {
            try {  
                Integer.parseInt(parseIdMenu[0]);
                if (parseIdMenu[1].equals("d") || parseIdMenu[1].equals("f") || parseIdMenu[1].equals("D") || parseIdMenu[1].equals("F")) {
                    return true;
                }
            } catch(NumberFormatException e) {  
                return false;
            } 
        } 
        
        return false;
    }

    public static void main(String[] args) {
        Restaurant a = new Restaurant("1", "1");
        Restaurant b = new Restaurant("2", "2");
        Restaurant c = new Restaurant("3", "3");
        Data.addRestaurants(a);
        Data.addRestaurants(b);
        Data.addRestaurants(c);
        addOrder();
    }
}
