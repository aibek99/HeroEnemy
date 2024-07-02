package main;

import java.util.ArrayList;

public class BattleGround {
    public static final int defaultHealth = 100;
    public static final String heroName = "Aibek";

    public static void main(String[] args) {
        System.out.println();
        System.out.println("----------------------------------------------------------");
        Warrior warrior = new Warrior(heroName, defaultHealth);
        Zombie zombie = new Zombie(defaultHealth);
        while (warrior.isAlive() && zombie.isAlive()) {
            warrior.attackEnemy(zombie);
            zombie.attackHero(warrior);
            if (!zombie.isAlive()) {
                zombie.resurrect(defaultHealth);
            }
        }
        determineWinner(warrior, zombie);

        warrior = new Warrior(heroName, defaultHealth);
        Witch witch = new Witch(defaultHealth);
        while (warrior.isAlive() && witch.isAlive()) {
            warrior.attackEnemy(witch);
            witch.attackHero(warrior);
            witch.conjure(warrior);
        }
        determineWinner(warrior, witch);

        Mage mage = new Mage(heroName, defaultHealth);
        zombie = new Zombie(defaultHealth);
        while (mage.isAlive() && zombie.isAlive()) {
            mage.attackEnemy(zombie);
            zombie.attackHero(mage);
            if (!zombie.isAlive()) {
                zombie.resurrect(defaultHealth);
            }
        }
        determineWinner(mage, zombie);

        mage = new Mage(heroName, defaultHealth);
        witch = new Witch(defaultHealth);
        while (mage.isAlive() && witch.isAlive()) {
            mage.attackEnemy(witch);
            witch.attackHero(mage);
            mage.tellSpell(witch);
            witch.conjure(mage);
        }
        determineWinner(mage, witch);

        Archer archer = new Archer(heroName, defaultHealth);
        zombie = new Zombie(defaultHealth);
        while (archer.isAlive() && zombie.isAlive()) {
            archer.attackEnemy(zombie);
            zombie.attackHero(archer);
            archer.destroyImmortality(zombie);
            if (!zombie.isAlive()) {
                zombie.resurrect(defaultHealth);
            }
        }
        determineWinner(archer, zombie);

        archer = new Archer(heroName, defaultHealth);
        witch = new Witch(defaultHealth);
        while (archer.isAlive() && witch.isAlive()) {
            archer.attackEnemy(witch);
            witch.attackHero(archer);
            witch.conjure(archer);
        }
        determineWinner(archer, witch);
    }

    public static void determineWinner(Hero hero, Enemy enemy) {
        if (hero.isAlive()) {
            System.out.println("Hero " + hero.getHeroType() + " won the battle, against " + enemy.getEnemyType());
        } else {
            System.out.println("Enemy " + enemy.getEnemyType() + " won the battle, against " + hero.getHeroType());
        }
        System.out.println("----------------------------------------------------------");
        System.out.println();
    }
}
