package main;

import static java.lang.Math.max;

abstract public class Hero implements Mortal {
    private String name;
    private int health;
    private int attackForce;

    public Hero(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public String getName() {
        return this.name;
    }

    public void takeDamage(int damage) {
        this.health = max(0, this.health - damage);
    }

    public int getAttackForce() {
        return this.attackForce;
    }

    public void setAttackForce(int attackForce) {
        this.attackForce = attackForce;
    }

    public void conjured(int force) {
        this.attackForce = max(0, this.attackForce - force);
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    abstract public void attackEnemy(Enemy e);
    abstract public String getHeroType();
}

class Warrior extends Hero {
    public static final int defaultAttackForce = 30;

    public Warrior(String name, int health) {
        super(name, health);
        setAttackForce(defaultAttackForce);
    }

    @Override
    public void attackEnemy(Enemy e) {
        System.out.println("Warrior " + super.getName() + " is attacking " + e.getEnemyType() + " enemy");
        e.takeDamage(getAttackForce());
        System.out.println(e.getEnemyType() + " health: " + e.getHealth());
        System.out.println(getHeroType() + " health: " + getHealth());
    }

    @Override
    public String getHeroType() {
        return "Warrior";
    }
}

class Mage extends Hero {
    public static final int defaultAttackForce = 15;

    public Mage(String name, int health) {
        super(name, health);
        setAttackForce(defaultAttackForce);
    }

    @Override
    public void attackEnemy(Enemy e) {
        System.out.println("Mage " + super.getName() + " is attacking " + e.getEnemyType() + " enemy");
        e.takeDamage(getAttackForce());
        System.out.println(e.getEnemyType() + " health: " + e.getHealth());
        System.out.println(getHeroType() + " health: " + getHealth());
    }

    @Override
    public String getHeroType() {
        return "Mage";
    }

    public void tellSpell(Witch e) {
        if (e.getConjureForce() == 0) return;
        e.takeSpell();
        System.out.println(getHeroType() + " " + getName() + " told spell against Witch, and destroyed ability to conjure of Witch");
    }
}

class Archer extends Hero {
    public static final int defaultAttackForce = 20;

    public Archer(String name, int health) {
        super(name, health);
        setAttackForce(defaultAttackForce);
    }

    @Override
    public void attackEnemy(Enemy e) {
        System.out.println("Archer " + super.getName() + " is attacking " + e.getEnemyType() + " enemy");
        e.takeDamage(getAttackForce());
        System.out.println(e.getEnemyType() + " health: " + e.getHealth());
        System.out.println(getHeroType() + " health: " + getHealth());
    }

    @Override
    public String getHeroType() {
        return "Archer";
    }

    public void destroyImmortality(Zombie zombie) {
        if (zombie.getCntResurrect() >= zombie.constMortality) return;
        zombie.switchOffResurrection();
        System.out.println("Archer destroyed immortality of Zombie");
    }
}

