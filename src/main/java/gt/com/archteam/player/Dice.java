package gt.com.archteam.player;

import java.util.Random;

public class Dice {
    private int sides;
    private Random random = new Random();

    public Dice(int sides) {
        this.sides = sides;
    }

    public int roll() {
        return this.random.nextInt(sides) + 1;
    }
}
