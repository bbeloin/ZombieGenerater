package models;

public class Walker extends Zombie{

    public Walker(){
        super();
        setArms(random.nextInt(3));
        setLegs(random.nextInt(3));
        setBaseHP(random.nextInt(16) + 15);
        setSpeed(random.nextInt(5) + 6);
    }

    public Walker(int arms, int legs, int baseHP, int speed){
        super();
        setArms(arms);
        setLegs(legs);
        setBaseHP(baseHP);
        setSpeed(speed);
    }

    @Override
    public void setBaseHP(int baseHP){
        try {
            this.baseHP = baseHP;
            if (baseHP < 15 || baseHP > 30 ){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException iao){
            System.out.println("The base HP is invalid. Setting to closest acceptable value.");
            if (baseHP < 15){
                this.baseHP = 15;
            }
            else {
                this.baseHP = 30;
            }
        }

        this.baseHP = baseHP;

    }

    @Override
    public void setSpeed(int speed) {
        try {
            this.speed = speed;
            if (speed < 6 || speed > 10) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException iae) {
            System.out.println("The speed given is invalid. Setting to closest acceptable value.");
            if (speed < 6) {
                this.speed = 6;
            } else {
                this.speed = 10;
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

        if (roll == 20){
            return "Critical Hit";
        } else if (roll >= 8) {
            return "hit";
        }else {
            return chance;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "}";
    }

}
