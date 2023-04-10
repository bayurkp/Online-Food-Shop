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
    String words[] = text.split("\\s");  
    String capitalizeWord = "";
    for (String w:words){  
        String first = w.substring(0,1);  
        String afterfirst = w.substring(1);  
        capitalizeWord += first.toUpperCase() + afterfirst + " ";  
    }  
    return capitalizeWord.trim();  
}  

    // Method pengenalan aplikasi
    public static void intro() {
        clearScreen();
        System.out.println(BOLD + "\nOn-Food!" + NORMAL);
        System.out.println("---------------");
        System.out.println("Pilihan terbaik untuk perut Anda");
        System.out.print("\nTekan enter untuk melanjutkan....");
        Input.getString();
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
        // Data.addRestaurant();
        // System.out.println(Data.getRestaurants().get(0).getName());
        // System.out.println(Data.getRestaurants().get(0).getAddress());
        // System.out.println(Data.getRestaurants().get(0).getFoods());
        // System.out.println(Data.getRestaurants().get(0).getDrinks());
    }
}
