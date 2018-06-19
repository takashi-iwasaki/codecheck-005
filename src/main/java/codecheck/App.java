package codecheck;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {

	public static void main(String[] args) {

		//とりあえず組み合わせ格納

		//引数2個未満はエラー
		if (args.length <= 2) {
			System.out.println("Error01!");
			return;
		}

		//引数処理

		int allCards = Integer.parseInt(args[0]);
		int allCost = Integer.parseInt(args[1]);

		//連番で格納
		Map<Integer, Summon> keyMap = new HashMap<>();
		Map<Integer, Map<Double, Summon>> keyMapList = new HashMap<>();

		//総火力キー
		Map<Integer, SummonList> AllKeyMap = new HashMap<>();
		SummonList finalSummonList = new SummonList();

		for (int y = 1; y <= allCards; y++) {
			Summon tmpSummon = new Summon();
			tmpSummon.setPower(Integer.parseInt(args[y * 2]));
			tmpSummon.setCost(Integer.parseInt(args[y * 2 + 1]));
			keyMap.put(y, tmpSummon);
		}

		while (true) {
			// キーでソート
			Object[] mapkey = keyMap.keySet().toArray();
			Arrays.sort(mapkey);

			int addKey = 0;

			int tmpCost = finalSummonList.getAllCost();

			for (int nKey : keyMap.keySet()) {
				if (addKey == 0) {
					if (finalSummonList.getAllCost() + keyMap.get(addKey).getCost() == tmpCost) {
						addKey = nKey;
					}
				} else if (keyMap.get(nKey).getPaformance() > keyMap.get(addKey).getPaformance()) {
					if (finalSummonList.getAllCost() + keyMap.get(addKey).getCost() == tmpCost) {
						addKey = nKey;
					}

				}
			}
			finalSummonList.setSummon(keyMap.get(addKey));
			keyMap.remove(addKey);
			if (finalSummonList.getAllCost() == tmpCost) {
				break;
			}

		}

		System.out.println(finalSummonList.getAllPower());

	}

}
