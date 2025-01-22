package rpg;

import rpg.character.AbstractCharacter;
import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;
import rpg.character.monster.MonsterParty;

public class BattleField {
    // Constructor
    public BattleField() {}

    // Methods
    public static String battle(HeroParty heroes,
                                MonsterParty monsters) {
        heroes.init();
        for (AbstractCharacter monster: monsters.getMembers()) System.out.println(monster.getName() + " ");
        System.out.println("が現れた！\n");

        while (true) {
            System.out.println("勇者のターン");
            heroes.printPartyStatus();
            String flg = heroes.turn(monsters);
            if (flg.equals("BEAT")) {
                return "WIN";
            } else if (flg.equals("ESCAPE")) {
                return "ESCAPE";
            }
            System.out.println("モンスターのターン");
            flg = monsters.turn(heroes);
            if (flg.equals("BEAT")) {
                return "LOSE";
            }
        }
    }
}
