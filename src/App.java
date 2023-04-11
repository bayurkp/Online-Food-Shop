// import java.util.*;

public class App {
    public static final String NORMAL = "\033[0;0m";
    public static final String BOLD = "\033[0;1m";
    
    // Method untuk membersihkan teks pada terminal
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Method untuk mengubah teks menjadi format capitalize each word
    public static String capitalizeWord(String text){  
        char[] chars = text.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '\'') {
                found = false;
            }
        }
        
        return String.valueOf(chars); 
}  

    // Method pengenalan aplikasi
    public static void intro() {
        clearScreen();
        System.out.println(BOLD + "\nOn-Food!" + NORMAL);
        System.out.println("---------------");
        System.out.println("Pilihan terbaik untuk perut Anda");
        System.out.print("*(Tekan enter untuk melanjutkan....)");
        Input.getAnyKey();
        login();
    }

    // Method login
    public static void login() {
        clearScreen();
        System.out.println(BOLD + "\nLogin" + NORMAL);
        System.out.println("---------------");
        System.out.print("Username\n> ");
        String username = Input.getString();
        System.out.print("Password\n> ");
        String password = Input.getPassword();

        if (username.equals(Admin.getAdminUsername()) && password.equals(Admin.getAdminPass())) {
            Admin.menu();
        } else if (username.equals(Customer.getCustUsername()) && password.equals(Customer.getCustPass())) {
            Customer.menu();
        } else {
            login();
        }
    }

    public static void main(String[] args) {
        intro();
        // Data.addRestaurant();
        // System.out.println(Data.getRestaurants().get(0).getName());
        // System.out.println(Data.getRestaurants().get(0).getAddress());
        // System.out.println(Data.getRestaurants().get(0).getFoods());
        // System.out.println(Data.getRestaurants().get(0).getDrinks());
    }
}
