package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class PlaygroundTest {
    Playground playground;
    Visitor visitorYoung;
    Visitor visitorOld;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
        visitorYoung = new Visitor(12, 180, 10);
        visitorOld = new Visitor(20, 180, 10);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void hasAgeLimitRightAge() {
        assertEquals(true, playground.isAllowedTo(visitorYoung));
    }
    @Test
    public void hasAgeLimitTooOld() {
        assertEquals(false, playground.isAllowedTo(visitorOld));
    }
}
