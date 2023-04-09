// import java.util.*;

public class App {
    public static void login() {
        System.out.print("Username\n> ");
        String username = Input.getString();
        System.out.print("Password\n> ");
        String password = Input.getPassword();

        System.out.println(password);
        if (username.equals(Admin.getAdminUsername()) && password.equals(Admin.getAdminPass())) {
            Admin.menu();
        } else if (username.equals(Customer.getCustUsername()) && password.equals(Customer.getCustPass())) {
            Customer.menu();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            login();
        }
    }

    public static void main(String[] args) {
        // login();
        Data.addRestaurant();
        System.out.println(Data.getRestaurants().get(0).getFoods());
        // restaurants.get(0).getDrinks();
    }
}
