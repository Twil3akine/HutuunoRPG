package rpg;

import rpg.character.AbstractCharacter;
import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;
import rpg.character.monster.MonsterParty;

import static rpg.Print.print;

public class BattleField {
    // Constructor
    public BattleField() {}

    // Methods
    /**
     * 勇者たちとモンスターたちが戦闘を行う
     *
     * @param heroes 勇者たち
     * @param monsters モンスターたち
     * @return 勇者が勝利した場合は"WIN"、敗北した場合は"LOSE"、逃げた場合は"ESCAPE"
     */
    public static String battle(HeroParty heroes,
                                MonsterParty monsters) {
        heroes.init();
        for (AbstractCharacter monster: monsters.getMembers()) print(monster.getName() + " ");
        print("が現れた！\n");

        while (true) {
            print("勇者のターン");
            heroes.printPartyStatus();
            String flg = heroes.turn(monsters);
            if (flg.equals("BEAT")) {
                return "WIN";
            } else if (flg.equals("ESCAPE")) {
                return "ESCAPE";
            }
            print("モンスターのターン");
            flg = monsters.turn(heroes);
            if (flg.equals("BEAT")) {
                return "LOSE";
            }
        }
    }

    /**
     * 勇者たちとモンスターが戦闘を行う
     *
     * @param heroes 勇者たち
     * @param monster モンスター
     * @return 勇者が勝利した場合は"WIN"、敗北した場合は"LOSE"、逃げた場合は"ESCAPE"
     */
    public static String battle(HeroParty heroes,
                                Monster monster) {
        heroes.init();
        print(monster.getName() + "が現れた！\n");

        MonsterParty monsters = new MonsterParty(new AbstractCharacter[]{monster});

        while (true) {
            print("勇者のターン");
            heroes.printPartyStatus();
            String flg = heroes.turn(monsters);
            if (flg.equals("BEAT")) {
                return "WIN";
            } else if (flg.equals("ESCAPE")) {
                return "ESCAPE";
            }
            print("モンスターのターン");
            flg = monsters.turn(heroes);
            if (flg.equals("BEAT")) {
                return "LOSE";
            } else if (flg.equals("ESCAPE")) {
                return "ESCAPE";
            }
        }
    }
}
