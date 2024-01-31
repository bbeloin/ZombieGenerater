package models;

import java.util.Random;

public abstract class Zombie {
    protected Random random = new Random();

    protected int arms;
    protected int legs;
    protected int baseHP;
    protected int speed;

    public int roll(int numDice, int diceSides) {
        int totalRoll = 0;

        for (int i = 0; i < numDice; i++) {
            totalRoll += random.nextInt(diceSides) + 1;
        }
        return totalRoll;
    }

    public abstract int attack(int attackRoll);

    public abstract String attackType(int roll);

    public int getArms() {
        return arms;
    }

    public void setArms(int arms) {
        this.arms = arms;

    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;

    }

    public int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return new StringBuilder(this.getClass().getSimpleName()).append("{")
                .append("arms=").append(getArms())
                .append(", legs=").append(getLegs())
                .append(", baseHP=").append(getBaseHP())
                .append(", speed=").append(getSpeed()).toString();
    }

}
