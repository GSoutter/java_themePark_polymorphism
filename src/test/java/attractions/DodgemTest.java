package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }



    @Test
    public void hasDefaultPrice() {
        assertEquals(4.5, dodgems.defaultPrice(), 0.01);
    }

    @Test
    public void hasPriceForOldl() {
        Visitor visitor = new Visitor(18, 210, 10);
        assertEquals(4.5, dodgems.priceFor(visitor), 0.01);
    }
    @Test
    public void hasPriceForYoung() {
        Visitor visitor = new Visitor(11, 180, 10);
        assertEquals(2.25, dodgems.priceFor(visitor), 0.01);
    }
}
