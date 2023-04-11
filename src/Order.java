public class Order {
    private String resaturantName;
    private String resaturantAddress;
    private String menuName;
    private double menuPrice;
    private boolean isFood;
    private int quantity;
    private double distance;

    public Order(String restaurantName, String resaturantAddress, String menuName, double menuPrice, boolean isFood, int quantity, double distance) {
        this.resaturantName = restaurantName;
        this.resaturantAddress = resaturantAddress;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.isFood = isFood;
        this.quantity = quantity;
        this.distance = distance;
    }

    public String getResaturantName() {
        return resaturantName;
    }

    public String getResaturantAddress() {
        return resaturantAddress;
    }

    public String getMenuName() {
        return menuName;
    }

    public double getMenuPrice() {
        return menuPrice;
    }

    public double getDistance() {
        return distance;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        if (distance < 5) {
            return menuPrice * quantity + 5000;
        } else {
            return menuPrice * quantity + 5000 + distance * 1000;
        }
    }

    public boolean getCategory() {
        return isFood;
    }
    
}
