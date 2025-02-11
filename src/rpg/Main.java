package rpg;

import rpg.area.Area;
import rpg.area.Town;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
import rpg.character.hero.job.Priest;
import rpg.character.hero.job.Sorcerer;
import rpg.character.hero.job.Warrior;

public class Main {

    public static void main(String[] args) {
        // 勇者パーティ作成
        Hero[] heroes = {
                new Sorcerer("魔法に優れた人1"),
                new Sorcerer("魔法に優れた人2"),
                new Sorcerer("魔法に優れた人3"),
                new Warrior("脳まで筋肉1"),
                new Priest("魂を神にささげた人1"),
        };
        HeroParty party = new HeroParty(heroes);

        Area currentPosition = new Town();
        while (true) {
            currentPosition = currentPosition.access(party);
        }
    }
}
