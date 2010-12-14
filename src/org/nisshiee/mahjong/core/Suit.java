package org.nisshiee.mahjong.core;

/**
 * 萬子，筒子，索子
 * 
 * @author nishioka
 * 
 */
public enum Suit {
	/**
	 * 萬子
	 */
	CHARACTER('m'),
	/**
	 * 筒子
	 */
	CIRCLE('p'),
	/**
	 * 索子
	 */
	BAMBOO('s');

	/**
	 * 略記用頭文字（m,p,s）
	 */
	private char capital;

	/**
	 * コンストラクタ
	 * 
	 * @param capital
	 *            略記用頭文字（m,p,s）
	 */
	private Suit(char capital) {
		this.capital = capital;
	}

	/**
	 * 略記用頭文字（m,p,s）を取得
	 * 
	 * @return
	 */
	public char getCapital() {
		return capital;
	}
}
