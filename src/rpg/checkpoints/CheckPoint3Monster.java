package rpg.checkpoints;

import rpg.character.AbstractCharacter;
import rpg.character.hero.*;
// import rpg.character.hero.job.Warrior;
import rpg.character.monster.*;
 import rpg.character.monster.monster.*;

public class CheckPoint3Monster {

	public static void main(String[] args) {
		// ベビードラゴン生成
		Monster babyDragon = new BabyDragon(0);

		// ベビードラゴンのデータを表示
		System.out.println("name: " + babyDragon.getName());
		System.out.println("hp: " + babyDragon.getHp());
		System.out.println("power: " + babyDragon.getAttack());

		// モンスターパーティ作成
		Monster ms1[] = {
				new BabyDragon(1),
				new BabyDragon(2),
				new BabyDragon(3)
		};
		Monster ms2[] = {
				new BabyDragon(4),
				new BabyDragon(5),
				new BabyDragon(6)
		};
		MonsterParty mpty1 = new MonsterParty(ms1);
		MonsterParty mpty2 = new MonsterParty(ms2);

		// モンスター同士で喧嘩
		while(!mpty1.isAllDead() && !mpty2.isAllDead()) {
			System.out.println("モンスターパーティー1のターン");
			mpty1.turn(mpty2);
			System.out.println("モンスターパーティー2のターン");
			mpty2.turn(mpty1);
			if (mpty1.isAllDead()) {
				System.out.println("モンスターパーティー2の勝ち");
			}
			if (mpty2.isAllDead()) {
				System.out.println("モンスターパーティー1の勝ち");
			}
		}
	}

}
