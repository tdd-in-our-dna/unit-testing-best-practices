package session6.roi.furnitureRental;

import session6.roi.furnitureRental.price.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static session6.roi.furnitureRental.Furniture.Type.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FurnitureTestV1 {

    private Furniture regularFurniture;
    private Furniture luxuryFurniture;
    private Furniture childrenFurniture;

    @BeforeEach
    void setUp() {
        regularFurniture = new Furniture("", REGULAR);
        luxuryFurniture = new Furniture("", LUXURY);
        childrenFurniture = new Furniture("", CHILDREN);
    }

    @Test
    public void getCharge() {
        int[] regularCharges = new int[]{200, 200, 350};
        int[] luxuryCharges = new int[]{300, 600, 900};
        int[] childrenCharges = new int[]{150, 150, 150};

        for (int i = 0; i < 3; i++) {
            assertEquals(regularCharges[i], regularFurniture.getCharge(i + 1));
            assertEquals(luxuryCharges[i], luxuryFurniture.getCharge(i + 1));
            assertEquals(childrenCharges[i], childrenFurniture.getCharge(i + 1));
        }
    }

    @Test
    public void getPoints() {
        int[] regularPoints = new int[]{10, 10, 10};
        int[] luxuryPoints = new int[]{10, 20, 20};
        int[] childrenPoints = new int[]{10, 10, 10};

        for (int i = 0; i < 3; i++) {
            assertEquals(regularPoints[i], regularFurniture.getPoints(i + 1));
            assertEquals(luxuryPoints[i], luxuryFurniture.getPoints(i + 1));
            assertEquals(childrenPoints[i], childrenFurniture.getPoints(i + 1));
        }
    }

    @Test
    void callsPriceGetCharge() {
        Price price = mock(Price.class);
        when(price.getCharge(1)).thenReturn(Double.valueOf(100));
        Furniture furniture = new Furniture(price);

        furniture.getCharge(1);

        verify(price).getCharge(1);
    }

    @Test
    void callsPriceGetPoints() {
        Price price = mock(Price.class);
        when(price.getPoints(1)).thenReturn(20);
        Furniture furniture = new Furniture(price);

        furniture.getPoints(1);

        verify(price).getPoints(1);
    }
}
