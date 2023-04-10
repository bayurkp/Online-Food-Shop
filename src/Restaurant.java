import java.util.ArrayList;

public class Restaurant {
    private static String name;
    private static String address;
    private static ArrayList<ArrayList<String>> foods = new ArrayList<ArrayList<String>>();
    private static ArrayList<ArrayList<String>> drinks = new ArrayList<ArrayList<String>>();

    public Restaurant(String nameArg, String addressArg) {
        name = nameArg;
        address = addressArg;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<ArrayList<String>> getFoods() {
        return foods;
    }

    public ArrayList<ArrayList<String>> getDrinks() {
        return drinks;
    }

    public void addFood(String name, String price) {
        ArrayList<String> food = new ArrayList<String>();
        food.add(name);
        food.add(price);

        foods.add(food);
    }

    public void addDrinks(String name, String price) {
        ArrayList<String> drink = new ArrayList<String>();
        drink.add(name);
        drink.add(price);

        drinks.add(drink);
    }
}
