import java.util.ArrayList;

public class Restaurant {
    private String name;
    private String address;
    private ArrayList<ArrayList<String>> foods = new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<String>> drinks = new ArrayList<ArrayList<String>>();

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public ArrayList<ArrayList<String>> getFoods() {
        return this.foods;
    }

    public ArrayList<ArrayList<String>> getDrinks() {
        return this.drinks;
    }

    public void addFood(String name, String price) {
        ArrayList<String> food = new ArrayList<String>();
        food.add(name);
        food.add(price);

        this.foods.add(food);
    }

    public void addDrinks(String name, String price) {
        ArrayList<String> drink = new ArrayList<String>();
        drink.add(name);
        drink.add(price);

        this.drinks.add(drink);
    }
}
