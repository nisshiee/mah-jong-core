package org.nisshiee.mahjong.core;

/**
 * 牌
 * 
 * @author nishioka
 * 
 */
public class Tile {
	/**
	 * 数牌であればtrue，字牌であればfalse
	 */
	private boolean simple;
	/**
	 * 数牌であれば萬子，筒子，索子を表すSuit，字牌であればnull
	 */
	private Suit suit;
	/**
	 * 数牌であればその数，字牌であれば0
	 */
	private int num;
	/**
	 * 数牌であればnull，字牌であればそれを表すHonour
	 */
	private Honour honour;

	/**
	 * 数牌インスタンスを生成
	 * 
	 * @param suit
	 *            萬子，筒子，索子
	 * @param num
	 *            数
	 */
	public Tile(Suit suit, int num) {
		if (suit == null) {
			throw new NullPointerException();
		}
		if (num < 1 || num > 9) {
			throw new IllegalArgumentException();
		}
		this.simple = true;
		this.suit = suit;
		this.num = num;
		this.honour = null;
	}

	/**
	 * 字牌インスタンスを生成
	 * 
	 * @param honour
	 *            字
	 */
	public Tile(Honour honour) {
		if (honour == null) {
			throw new NullPointerException();
		}
		this.simple = false;
		this.suit = null;
		this.num = 0;
		this.honour = honour;
	}

	/**
	 * 数牌であればtrue，字牌であればfalse
	 * 
	 * @return
	 */
	public boolean isSimple() {
		return simple;
	}

	/**
	 * 数牌であれば萬子，筒子，索子を表すSuit，字牌であればnull
	 * 
	 * @return
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * 数牌であればその数，字牌であれば0
	 * 
	 * @return
	 */
	public int getNum() {
		return num;
	}

	/**
	 * 数牌であればnull，字牌であればそれを表すHonour
	 * 
	 * @return
	 */
	public Honour getHonour() {
		return honour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((honour == null) ? 0 : honour.hashCode());
		result = prime * result + num;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + (simple ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Tile))
			return false;
		Tile other = (Tile) obj;
		if (honour != other.honour)
			return false;
		if (num != other.num)
			return false;
		if (suit != other.suit)
			return false;
		if (simple != other.simple)
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (simple) {
			return "" + num + suit.getCapital();
		} else {
			return honour.toString();
		}
	}
}
