import attractions.Dodgems;
import attractions.Park;
import attractions.Playground;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {


    Park park;
    Dodgems dodgems;
    RollerCoaster rollerCoaster;
    Playground playground;
    Visitor visitor;
    CandyflossStall candyflossStall;
    TobaccoStall tobaccoStall;
    IceCreamStall iceCreamStall;
    ThemePark themePark;






    @Before
    public void setUp() throws Exception {

        park = new Park("Leafy Meadows", 9);
        dodgems = new Dodgems("Bumper Cars", 5);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        playground = new Playground("Fun Zone", 7);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 2);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 2);
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4,2);

        visitor = new Visitor(14, 1.2, 40.0);

        themePark = new ThemePark();

        themePark.addStall(candyflossStall);
        themePark.addStall(tobaccoStall);
        themePark.addStall(iceCreamStall);
        themePark.addAttraction(park);
        themePark.addAttraction(dodgems);
        themePark.addAttraction(rollerCoaster);
        themePark.addAttraction(playground);
    }


    @Test
    public void canGetStalls() {
        assertEquals(3, themePark.getStalls().size());
    }
    @Test
    public void canGetAttractions() {
        assertEquals(4, themePark.getAttractions().size());
    }

    @Test
    public void canGetAllReviewed() {
        assertEquals(7, themePark.getAllReviewed().size());
    }

    @Test
    public void canHaveVisitorsVisitAttractions() {
        themePark.visitAttraction(visitor, rollerCoaster);
        assertEquals(1, visitor.getVisitedAttractions().size());
        assertEquals(1, rollerCoaster.getVisitCount());
    }
}
