package session6.roi.furnitureRental;

import session6.roi.furnitureRental.price.Price;
import session6.roi.furnitureRental.price.PriceFactory;

public class Furniture {
    public enum Type {
        REGULAR, LUXURY, CHILDREN;
    }

    private String title;
    Price price;

    public Furniture(
            String title, Furniture.Type priceCode) {
        this.title = title;
        this.price = new PriceFactory().getPrice(priceCode);
    }

    public Furniture(Price price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public int getPoints(int daysRented) {
        return price.getPoints(daysRented);
    }

}