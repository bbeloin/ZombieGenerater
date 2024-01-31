package models;

public class Runner extends Zombie{

    public Runner(){
        super();
        setArms(random.nextInt(3));
        setLegs(random.nextInt(3));
        setBaseHP(random.nextInt(11) + 12);
        setSpeed(random.nextInt(16) + 10);
    }

    public Runner(int arms, int legs, int baseHP, int speed){
        super();
        setArms(arms);
        setLegs(legs);
        setBaseHP(baseHP);
        setSpeed(speed);
    }

    public int climbSpeed(){
        return getSpeed()/3;
    }

    @Override
    public void setBaseHP(int baseHP){
        try {
            this.baseHP = baseHP;
            if (baseHP < 10 || baseHP > 22 ){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException iao){
            System.out.println("The base HP is invalid. Setting to closest acceptable value.");
            if (baseHP  < 10){
                this.baseHP = 10;
            }
            else {
                this.baseHP = 22;
            }
        }
        this.baseHP = baseHP;

    }

    @Override
    public void setSpeed(int speed) {
        try {
            this.speed = speed;
            if (speed < 15 || speed > 25) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException iae) {
            System.out.println("The speed given is invalid. Setting to closest acceptable value.");
            if (speed < 15) {
                this.speed = 15;
            } else {
                this.speed = 25;
            }
        }
    }

    @Override
    public int attack(int attackRoll){
        int totalDamage = 0;

        if (attackRoll >= 8){
            totalDamage = roll(3, 6);
            if (attackRoll == 20){
                totalDamage *= 2;
            }
        }

        return totalDamage;
    }

    @Override
    public String attackType(int roll){
        String chance = "miss";

        if (roll == 19 || roll == 20){
            return "Critical Hit";
        } else if (roll >= 5) {
            return "hit";
        }else {
            return chance;
        }
    }

    @Override
    public String toString(){
        return super.toString() +
                ", Climb Speed=" + climbSpeed() + "}";
    }

}
