package q01_basic.question07;

import java.util.ArrayList;
import java.util.List;

/**
 * 整数リストを制御するクラス
 * 
 */
class NumberList {

	/**
	 * 整数のList
	 * 
	 */
	private List<Integer> numbers = new ArrayList<>();

	/**
	 * 1から引数までの整数をListに代入する
	 * 
	 * @param limit（Listの最終要素）
	 */
	public void addFromOneTo(Integer limit) {
		//TODO ここから実装する
		for (int i = 1; i <= limit; i++) {
			numbers.add(i);
		}

	}

	/**
	 * Listの各要素整数を合計する
	 * 
	 * @return Listの要素の合計値
	 */
	public Integer calcSumOfList(Integer limit) {
		Integer sum = 0;
		//TODO ここから実装する
		for (int i = 0; i < limit; i++) {
			numbers.get(i);
			sum += i;
		}
		return sum;
	}

	/**
	 * Listの各要素を2倍にする
	 * 
	 */
	public void doubleListEachValue(Integer limit) {

		//TODO ここから実装する
		for (int i = 0; i < limit; i++) {
			numbers.set(i, i * 2);

		}
	}

	/**
	 * Listの要素の前半部分を削除する
	 * 要素数が奇数の場合、中央値は残す
	 */
	public void removeIndexOfFirstHalf(Integer limit) {

		//TODO ここから実装する
		if (numbers.size() % 2 == 0) {
			for (int i = 0; i <= numbers.size() / 2; i++) {
				numbers.remove(i);

			}
		} else {
			for (int j = 0; j < (numbers.size() + 1) / 2; j++) {
				numbers.remove(j);

			}

		}

	}

	/**
	 * @return numbers
	 */
	public List<Integer> getNumbers() {
		return numbers;
	}

	/**
	 * @param numbers セットする numbers
	 */
	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}

}
