import attractions.Attraction;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ThemePark {


    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;


    public ThemePark(){
        this.attractions = new ArrayList<Attraction>();
        this.stalls = new ArrayList<Stall>();
    }


    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public ArrayList<Stall> getStalls() {
        return stalls;
    }

    public void addAttraction(Attraction attraction) {
        this.attractions.add(attraction);
    }
    public void addStall(Stall stall) {
        this.stalls.add(stall);
    }

    public ArrayList<IReviewed> getAllReviewed() {
        ArrayList<IReviewed> reviewed = new ArrayList<>();
        reviewed.addAll(this.attractions);
        reviewed.addAll(this.stalls);
        return reviewed;
    }

    public void visitAttraction(Visitor visitor, Attraction attraction) {
        visitor.visitAttraction(attraction);
        attraction.addVisit();
    }

    public HashMap<String, Integer> getReviewHash() {
        HashMap<String, Integer> reviews = new HashMap<String, Integer>();
        for (IReviewed item : getAllReviewed()){
            reviews.put(item.getName(), item.getRating());
        }
        return reviews;
    }

    public ArrayList<IReviewed> getAllAllowed(Visitor visitor) {
        ArrayList<IReviewed> allowed = new ArrayList<>();
        for (IReviewed item : getAllReviewed()){
            if (item instanceof ISecurity){
                if (((ISecurity) item).isAllowedTo(visitor)){
                    allowed.add(item);
                }
            } else{
                allowed.add(item);
            }
        }
        return allowed;

    }
}
