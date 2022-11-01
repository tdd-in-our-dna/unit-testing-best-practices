package session6.roi.furnitureRental.price;

public class LuxuryPrice extends Price {
    @Override
    public double getCharge(int daysRented) {
        return daysRented * 300;
    }

    @Override
    public int getPoints(int daysRented) {
        if (daysRented > 1)
            return 20;
        return 10;
    }
}