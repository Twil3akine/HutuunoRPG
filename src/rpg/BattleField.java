package rpg;

import static rpg.Print.print;
import rpg.character.AbstractCharacter;
import rpg.character.hero.HeroParty;
import rpg.character.monster.MonsterParty;

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
}
