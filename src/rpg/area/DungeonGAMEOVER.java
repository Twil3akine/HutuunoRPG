package rpg.area;

import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;

import static rpg.Print.print;

public class DungeonGAMEOVER extends Area {

    @Override
    public Area access(HeroParty party) {
        try {
            Thread.sleep(1000);
            print("おお、勇者よ…");
            Thread.sleep(1000);
            print("死んでしまうとは情けない...");
            Thread.sleep(1000);

            System.exit(0);
            return null;
        } catch (InterruptedException e) {
            throw new Error();
        }
    }
}
