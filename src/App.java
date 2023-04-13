import java.util.Random;

public class App {
    // String untuk format bold pada text
    public static final String NORMAL = "\033[0;0m";
    // String untuk format default pada text
    public static final String BOLD = "\033[0;1m";

    // method untuk membersihkan teks pada terminal
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Method untuk mengubah teks menjadi format capitalize each word
    public static String capitalizeWord(String text) {
        // Menginisialisasi array character baru dengan nilai lowercase dari argumen
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

    // Method generator string acak
    public static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            char randomChar = chars.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
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

        // Input username
        System.out.print("Username\n> ");
        String username = Input.getString();

        // Input password
        System.out.print("Password\n> ");
        String password = Input.getPassword();

        // Pengecekan kredensial
        if (username.equals(Admin.getUsername()) && password.equals(Admin.getPassword())) {
            Admin.menu();
            return;
        } else if (username.equals(Customer.getUsername()) && password.equals(Customer.getPassword())) {
            Customer.menu();
            return;
        } else {
            login();
            return;
        }
    }

    // Method main
    public static void main(String[] args) {
        intro();
    }
}
