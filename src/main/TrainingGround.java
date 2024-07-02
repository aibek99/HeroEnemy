package main;

import java.util.ArrayList;

public class TrainingGround {
    public static final int defaultHealth = 100;
    public static final String defaultName = "Aibek";

    public static void main(String[] args) {
        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(new Warrior(defaultName, defaultHealth));
        heroes.add(new Mage(defaultName, defaultHealth));
        heroes.add(new Archer(defaultName, defaultHealth));
        Enemy z = new Zombie(defaultHealth);

        for (Hero hero : heroes) {
            System.out.println(hero.getName());
            hero.attackEnemy(z);
            System.out.println();
        }
    }
}


