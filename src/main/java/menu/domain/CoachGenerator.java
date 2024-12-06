package menu.domain;

import java.util.List;

public class CoachGenerator {
    public Coaches generateCoaches(List<String> coachNames) {
        Coaches coaches = new Coaches();
        for (String coachName : coachNames) {
            Coach coach = new Coach(coachName);
            coaches.addCoach(coach);
        }
        return coaches;
    }
}
