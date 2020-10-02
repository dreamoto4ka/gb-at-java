package web.ui.gb.at.java.participant;

public class Human implements Runner{
    protected String name;
    protected double maxRun;
    protected double maxJump;

    public Human(String name, double maxRun, double maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }


    public String getName() {
        return name;
    }

    public double getMaxLength() {
        return maxRun;
    }

    public double getMaxHeight() {
        return maxJump;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", maxRun=" + maxRun +
                ", maxJump=" + maxJump +
                '}';
    }
}