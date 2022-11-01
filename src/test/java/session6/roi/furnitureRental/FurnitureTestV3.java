package session6.roi.furnitureRental;

import org.junit.jupiter.api.Test;

import static session6.roi.furnitureRental.Furniture.Type.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FurnitureTestV3 {

    @Test
    public void getChargeForRegular1Day() {
        Furniture regularFurniture = new Furniture("", REGULAR);

        double chargeRegular1Day = regularFurniture.getCharge(1);

        assertEquals(200, chargeRegular1Day);
    }

    @Test
    public void getChargeForRegular2Days() {
        Furniture regularFurniture = new Furniture("", REGULAR);

        double chargeRegular2Days = regularFurniture.getCharge(2);

        assertEquals(200, chargeRegular2Days);
    }

    @Test
    public void getChargeForRegular3Days() {
        Furniture regularFurniture = new Furniture("", REGULAR);

        double chargeRegular3Days = regularFurniture.getCharge(3);

        assertEquals(350, chargeRegular3Days);
    }

    @Test
    public void getChargeForLuxury1Day() {
        Furniture luxuryFurniture = new Furniture("", LUXURY);

        double chargeLuxury1Day = luxuryFurniture.getCharge(1);

        assertEquals(300, chargeLuxury1Day);
    }

    @Test
    public void getChargeForLuxury2Days() {
        Furniture luxuryFurniture = new Furniture("", LUXURY);

        double chargeLuxury2Days = luxuryFurniture.getCharge(2);

        assertEquals(600, chargeLuxury2Days);
    }

    @Test
    public void getChargeForLuxury3Days() {
        Furniture luxuryFurniture = new Furniture("", LUXURY);

        double chargeLuxury3Days = luxuryFurniture.getCharge(3);

        assertEquals(900, chargeLuxury3Days);
    }

    @Test
    public void getChargeForChildrens1Day() {
        Furniture childrensFurniture = new Furniture("", CHILDREN);

        double charge1Day = childrensFurniture.getCharge(1);

        assertEquals(150, charge1Day);
    }

    @Test
    public void getChargeForChildrens2Days() {
        Furniture childrensFurniture = new Furniture("", CHILDREN);

        double charge2Days = childrensFurniture.getCharge(2);

        assertEquals(150, charge2Days);
    }

    @Test
    public void getChargeForChildrens3Days() {
        Furniture childrensFurniture = new Furniture("", CHILDREN);

        double charge3Days = childrensFurniture.getCharge(3);

        assertEquals(150, charge3Days);
    }

    @Test
    public void getChargeForChildrens4Days() {
        Furniture childrensFurniture = new Furniture("", CHILDREN);

        double charge4Days = childrensFurniture.getCharge(4);

        assertEquals(300, charge4Days);
    }

    // .. Tests for getPoints()
}


