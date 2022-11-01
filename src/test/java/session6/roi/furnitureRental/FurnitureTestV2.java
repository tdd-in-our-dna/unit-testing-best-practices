package session6.roi.furnitureRental;

import org.junit.jupiter.api.Test;

import static session6.roi.furnitureRental.Furniture.Type.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FurnitureTestV2 {

    @Test
    public void getChargeForRegular() {
        assertEquals(200, new Furniture("", REGULAR).getCharge(1));
        assertEquals(200, new Furniture("", REGULAR).getCharge(2));
        assertEquals(350, new Furniture("", REGULAR).getCharge(3));
    }

    @Test
    public void getChargeForLuxury() {
        assertEquals(300, new Furniture("", LUXURY).getCharge(1));
        assertEquals(600, new Furniture("", LUXURY).getCharge(2));
        assertEquals(900, new Furniture("", LUXURY).getCharge(3));
    }

    @Test
    public void getChargeForChildrens() {
        assertEquals(150, new Furniture("", CHILDREN).getCharge(1));
        assertEquals(150, new Furniture("", CHILDREN).getCharge(2));
        assertEquals(150, new Furniture("", CHILDREN).getCharge(3));
    }

    /** .. Tests for getPoints()
     * getPointsForRegular()
     * getPointsForLuxury()
     * getPointsForChildrens()
     **/
}
