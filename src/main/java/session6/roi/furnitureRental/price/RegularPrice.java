package session6.roi.furnitureRental.price;

public class RegularPrice extends Price {
    @Override
    public double getCharge(int daysRented) {
        double amount = 200;
        if (daysRented > 2)
            amount += (daysRented - 2) * 150;
        return amount;
    }
}