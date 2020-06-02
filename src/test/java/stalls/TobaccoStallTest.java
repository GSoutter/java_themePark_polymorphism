package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor visitorYoung;
    Visitor visitorOld;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 2);
        visitorYoung = new Visitor(12, 180, 10);
        visitorOld = new Visitor(20, 180, 10);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }


    @Test
    public void hasAgeLimitRightAge() {
        assertEquals(true, tobaccoStall.isAllowedTo(visitorOld));
    }
    @Test
    public void hasAgeLimitTooYoung() {
        assertEquals(false, tobaccoStall.isAllowedTo(visitorYoung));
    }

    @Test
    public void canGetRating() {
        assertEquals(2, tobaccoStall.getRating());
    }
}
