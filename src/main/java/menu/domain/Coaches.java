package menu.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Coaches implements Iterable<Coach> {
    private List<Coach> coaches = new ArrayList<>();

    public List<Coach> addCoach(Coach coach) {
        coaches.add(coach);
        return coaches;
    }

    public void pickOneRandomMenuForAll(Menus menus) {
        for (Coach coach : coaches) {
            coach.pickOneRandomMenu(menus);
        }
    }

    public int getNumberOfCoaches() {
        return coaches.size();
    }

    @Override
    public Iterator<Coach> iterator() {
        return coaches.iterator();
    }
}
