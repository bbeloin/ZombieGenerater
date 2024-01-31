package models;

public class Tank extends Zombie{

    public Tank(){
        super();
        setArms(random.nextInt(3));
        setLegs(random.nextInt(3));
        setBaseHP(random.nextInt(26) + 45);
        setSpeed(random.nextInt(5) + 4);
    }

    public Tank(int arms, int legs, int baseHP, int speed){
        super();
        setArms(arms);
        setLegs(legs);
        setBaseHP(baseHP);
        setSpeed(speed);
    }

    @Override
    public void setBaseHP(int baseHP){
        try {
            this.baseHP =baseHP;
            if (baseHP < 45 || baseHP > 70 ){
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException iao){
            System.out.println("The base HP is invalid. Setting to closest acceptable value.");
            if (baseHP  < 45){
                this.baseHP = 45;
            }
            else {
                this.baseHP = 70;
            }
        }
        this.baseHP = baseHP;

    }

    @Override
    public void setSpeed(int speed) {
        try {
            this.speed = speed;
            if (speed < 4 || speed > 8) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException iae) {
            System.out.println("The speed given is invalid. Setting to closest acceptable value.");
            if (speed < 4) {
                this.speed = 4;
            } else {
                this.speed = 8;
            }
        }
    }

    public int damageModifier(){
        return 10 + random.nextInt(11);
    }

    @Override
    public int attack(int attackRoll){
        int totalDamage = 0;

        if (attackRoll >= 8){
            totalDamage = roll(3, 6) + damageModifier();
            if (attackRoll == 20){
                totalDamage *= 3;
            }
        }

        return totalDamage;
    }

    @Override
    public String attackType(int roll){
        String chance = "miss";

        if (roll == 20){
            return "Critical Hit";
        } else if (roll >= 10) {
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
