import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import web.ui.gb.at.java.ChallengeService;
import web.ui.gb.at.java.obstacle.Wall;
import web.ui.gb.at.java.participant.Cat;
import web.ui.gb.at.java.participant.Human;
import web.ui.gb.at.java.participant.Robot;
import web.ui.gb.at.java.participant.Runner;

import java.util.ArrayList;
import java.util.stream.Stream;

public class JumpTest {
    ChallengeService challengeService = new ChallengeService();

    // @Test
/*    void testJump(){
        ArrayList<Cat> cats = getCats();
        ArrayList<Robot> robots = getRobots();
        ArrayList<Human> humans = getHumans();
        ArrayList<Wall> wall = getWalls();
        ArrayList<Boolean> expectedResult = getBooleans();
        ArrayList<Runner> runners = getRunners(cats, robots, humans);
        ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
        obstacles.addAll(wall);
        Assertions.assertEquals(expectedResult, challengeService.jumpOrRun(runners, obstacles));
    }*/

    @ParameterizedTest
    @MethodSource("data")
    public void testJump(Wall wall, Runner runner, boolean isSuccessful) {
        boolean check = wall.isCheck(runner);
        Assertions.assertEquals(isSuccessful, check);
    }

    private static Stream<Arguments> data() {
        Wall shortWall = new Wall(5);
        Wall longWall = new Wall(10);

        Cat barsik = new Cat("Barsik", 2, 2);
        Cat holly = new Cat("Holly", 2, 6);
        Cat molly = new Cat("Molly", 5, 1);
        Human pasha = new Human("Pasha", 7, 2);

        return Stream.of(Arguments.of(shortWall, barsik, false),
                Arguments.of(longWall, barsik, false),
                Arguments.of(shortWall, barsik, false),
                Arguments.of(longWall, holly, false),
                Arguments.of(shortWall, holly, true),
                Arguments.of(longWall, molly, false),
                Arguments.of(shortWall, molly, false),
                Arguments.of(longWall, pasha, false),
                Arguments.of(shortWall, pasha, false)
        );


    }


    private ArrayList<Wall> getWalls() {
        ArrayList<Wall> wall = new ArrayList<Wall>();
        wall.add(new Wall(5));
        wall.add(new Wall(10));
        return wall;
    }

    private ArrayList<Cat> getCats() {
        ArrayList<Cat> cats = new ArrayList<Cat>();
        cats.add(new Cat("Barsik", 2, 2));
        cats.add(new Cat("Holly", 2, 6));
        cats.add(new Cat("Molly", 5, 11));
        return cats;
    }

    private ArrayList<Human> getHumans() {
        ArrayList<Human> humans = new ArrayList<Human>();
        humans.add(new Human("Pasha", 7, 2));
        humans.add(new Human("Sveta", 7, 6));
        humans.add(new Human("Nina", 7, 11));
        return humans;
    }

    private ArrayList<Robot> getRobots() {
        ArrayList<Robot> robots = new ArrayList<Robot>();
        robots.add(new Robot("R2D2", 7, 2));
        robots.add(new Robot("R2D3", 7, 6));
        robots.add(new Robot("R2D4", 7, 11));
        return robots;
    }

    private ArrayList<Runner> getRunners(ArrayList<Cat> cats, ArrayList<Robot> robots, ArrayList<Human> humans) {
        ArrayList<Runner> runners = new ArrayList<Runner>();
        runners.addAll(cats);
        runners.addAll(robots);
        runners.addAll(humans);
        return runners;
    }

    private ArrayList<Boolean> getBooleans() {
        ArrayList<Boolean> expectedResult = new ArrayList<Boolean>();
        expectedResult.add(false);
        expectedResult.add(true);
        expectedResult.add(true);
        expectedResult.add(false);
        expectedResult.add(true);
        expectedResult.add(true);
        expectedResult.add(false);
        expectedResult.add(true);
        expectedResult.add(true);
        expectedResult.add(false);
        expectedResult.add(false);
        expectedResult.add(true);
        expectedResult.add(false);
        expectedResult.add(false);
        expectedResult.add(true);
        expectedResult.add(false);
        expectedResult.add(false);
        expectedResult.add(true);
        return expectedResult;
    }
}