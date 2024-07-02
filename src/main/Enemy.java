package main;

import static java.lang.Math.max;

abstract public class Enemy implements Mortal {
    private int health;
    private int attackForce;

    public Enemy(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackForce() {
        return this.attackForce;
    }

    public void setAttackForce(int attackForce) {
        this.attackForce = attackForce;
    }

    public void takeDamage(int damage) {
        this.health = max(0, this.health - damage);
    }

    abstract void attackHero(Hero h);

    abstract String getEnemyType();

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}

interface Mortal {
    boolean isAlive();
}

class Zombie extends Enemy {
    public static final int constMortality = 1000;
    public final int defaultAttackForce = 15;
    private int cntResurrect = 3;
    public Zombie(int health) {
        super(health);
        setAttackForce(defaultAttackForce);
    }

    @Override
    void attackHero(Hero h) {
        System.out.println("Zombie is attacking " + h.getHeroType() + " " + h.getName());
        h.takeDamage(getAttackForce());
        System.out.println(getEnemyType() + " health: " + getHealth());
        System.out.println(h.getHeroType() + " health: " + h.getHealth());
    }

    @Override
    String getEnemyType() {
        return "Zombie";
    }

    public void resurrect(int health) {
        this.cntResurrect++;
        this.setHealth(health / this.cntResurrect);
        if (health > 0) {
            System.out.println("Zombie resurrected health: " + getHealth());
        }
    }

    public void switchOffResurrection() {
        this.cntResurrect = this.constMortality;
        System.out.println("Zombie became mortal");
    }

    public int getCntResurrect() {
        return this.cntResurrect;
    }
}

class Witch extends Enemy {
    public static final int defaultAttackForce = 10;
    private int conjureForce = 3;

    public Witch(int health) {
        super(health);
        setAttackForce(defaultAttackForce);
    }

    @Override
    void attackHero(Hero h) {
        System.out.println("Witch is attacking " + h.getHeroType() + " " + h.getName());
        h.takeDamage(getAttackForce());
        System.out.println(getEnemyType() + " health: " + getHealth());
        System.out.println(h.getHeroType() + " health: " + h.getHealth());
    }

    @Override
    String getEnemyType() {
        return "Witch";
    }

    public void conjure(Hero h) {
        h.conjured(conjureForce);
        if (conjureForce > 0) {
            System.out.println("Witch conjured " + h.getHeroType() + " " + h.getName() + ", by " + conjureForce);
        }
    }

    public void takeSpell() {
        conjureForce = 0;
    }

    public int getConjureForce() {
        return this.conjureForce;
    }
}
