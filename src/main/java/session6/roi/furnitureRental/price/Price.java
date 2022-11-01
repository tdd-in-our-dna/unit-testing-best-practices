package session6.roi.furnitureRental.price;

public abstract class Price {
    public abstract double getCharge(int daysRented);
    public int getPoints(int daysRented) {
        return 10;
    }
}