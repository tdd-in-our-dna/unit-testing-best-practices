package session6.roi.furnitureRental.price;

public class ChildrensPrice extends Price {
    @Override
    public double getCharge(int daysRented) {
        double amount = 150;
        int minThreshold = 3;
        if (daysRented > minThreshold)
            amount += (daysRented - minThreshold) * 150;
        return amount;
    }
}
