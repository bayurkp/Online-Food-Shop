public class Order {
    // Variabel kebutuhuan objek Order
    private String resaturantName;
    private String resaturantAddress;
    private String menuName;
    private double menuPrice;
    private boolean isFood;
    private int quantity;
    private double distance;

    // Cosntructor class Order
    public Order(String restaurantName, String resaturantAddress, String menuName, double menuPrice, boolean isFood,
            int quantity, double distance) {
        this.resaturantName = restaurantName;
        this.resaturantAddress = resaturantAddress;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.isFood = isFood;
        this.quantity = quantity;
        this.distance = distance;
    }

    // Getter nama restoran
    public String getResaturantName() {
        return resaturantName;
    }

    // Getter alamat restoran
    public String getResaturantAddress() {
        return resaturantAddress;
    }

    // Getter nama menu
    public String getMenuName() {
        return menuName;
    }

    // Getter harga menu
    public double getMenuPrice() {
        return menuPrice;
    }

    // Getter jarak antar
    public double getDistance() {
        return distance;
    }

    // Getter jumlah pesanan
    public int getQuantity() {
        return quantity;
    }

    // Getter harga total
    public double getTotalPrice() {
        if (distance < 5) {
            return menuPrice * quantity + 5000;
        } else {
            return menuPrice * quantity + 5000 + distance * 1000;
        }
    }

    // Getter kategori
    public boolean getCategory() {
        return isFood;
    }
}
