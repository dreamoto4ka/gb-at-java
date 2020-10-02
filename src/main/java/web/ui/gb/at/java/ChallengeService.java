package web.ui.gb.at.java;

import web.ui.gb.at.java.obstacle.Obstacle;
import web.ui.gb.at.java.participant.Runner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ChallengeService {

    public List<Runner> jumpOrRun(Collection<Runner> runners, Collection<Obstacle> obstacles) {
        List<Runner> actualResult = new ArrayList<Runner>(runners);

        for (Obstacle obstacle : obstacles) {
            Iterator<Runner> iterator = actualResult.iterator();
            while (iterator.hasNext()) {
                Runner runner = iterator.next();
                boolean isPassed = obstacle.isCheck(runner);
                if (!isPassed) {
                    iterator.remove();
                }
            }
        }

        return actualResult;
    }

}