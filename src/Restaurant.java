import java.util.ArrayList;

public class Restaurant {
    private String name;
    private String address;
    private ArrayList<ArrayList<String>> foods = new ArrayList<>();
    private ArrayList<ArrayList<String>> drinks = new ArrayList<>();

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Restaurant(Restaurant restaurant) {
        this.copy(restaurant);
    }

    public void copy(Restaurant restaurant) {
        this.name = restaurant.getName();
        this.address = restaurant.getAddress();
        this.foods = restaurant.getFoods();
        this.drinks = restaurant.getDrinks();
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

    public void addDrink(String name, String price) {
        ArrayList<String> drink = new ArrayList<String>();
        drink.add(name);
        drink.add(price);

        this.drinks.add(drink);
    }
}
