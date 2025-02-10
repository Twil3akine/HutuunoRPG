package rpg.area;

import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;

import static rpg.Print.print;

public class DungeonCLEAR extends Area {
    public DungeonCLEAR() {
    }

    public Area access(HeroParty party) {
        try {
            Thread.sleep(1000);
            print("ゲームクリア！！");
            Thread.sleep(1000);
            print("Cast");
            for (int i = 0; i < party.getMembers().length; i++) {
                Thread.sleep(1000);
                print("ヒーロー" + (i + 1) + "：" + party.getMembers()[i].getName() + "(" + ((Hero) party.getMembers()[i]).getJob() + ")");
            }

            print("お  ");
            Thread.sleep(1000);
            print("わ  ");
            Thread.sleep(1000);
            print("り  ");
            System.exit(0);
            return null;
        } catch (InterruptedException e) {
            throw new Error();
        }
    }
}
