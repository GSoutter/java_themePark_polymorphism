package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitorYoung;
    Visitor visitorOld;


    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitorYoung = new Visitor(11, 180, 10);
        visitorOld = new Visitor(20, 180, 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void hasAgeLimitRightAge() {
        assertEquals(true, rollerCoaster.isAllowedTo(visitorOld));
    }
    @Test
    public void hasAgeLimitTooYoung() {
        assertEquals(false, rollerCoaster.isAllowedTo(visitorYoung));
    }

    @Test
    public void hasHeightLimitRightHeight() {
        Visitor visitor = new Visitor(18, 180, 10);
        assertEquals(true, rollerCoaster.isAllowedTo(visitor));
    }
    @Test
    public void hasHeightLimitTooShort() {
        Visitor visitor = new Visitor(18, 140, 10);

        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }


    @Test
    public void hasDefaultPrice() {
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.01);
    }

    @Test
    public void hasPriceForTall() {
        Visitor visitor = new Visitor(18, 210, 10);
        assertEquals(16.80, rollerCoaster.priceFor(visitor), 0.01);
    }
    @Test
    public void hasPriceForSmall() {
        Visitor visitor = new Visitor(18, 180, 10);
        assertEquals(8.40, rollerCoaster.priceFor(visitor), 0.01);
    }

}
