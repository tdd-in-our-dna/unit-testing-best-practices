package session6.roi.furnitureRental.price;

import session6.roi.furnitureRental.Furniture;

public class PriceFactory {

    public Price getPrice(Furniture.Type priceCode) {
        switch (priceCode) {
            case CHILDREN:
                return new ChildrensPrice();
            case LUXURY:
                return new LuxuryPrice();
            default:
                return new RegularPrice();
        }
    }
}
