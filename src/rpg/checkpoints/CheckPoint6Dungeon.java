package rpg.checkpoints;

import rpg.area.*;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
import rpg.character.hero.job.*;

public class CheckPoint6Dungeon {

	public static void main(String[] args) {
		// 勇者パーティ作成
		Hero[] heroes = {
				new Sorcerer("a1"),
				new Sorcerer("a2"),
				new Warrior("a3")
		};
		HeroParty party = new HeroParty(heroes);

		// ダンジョン地下1階に行く
		// ドラゴンを倒したら終了
		Dungeon3rd dungeon = new Dungeon3rd();
		dungeon.access(party);
	}
}
