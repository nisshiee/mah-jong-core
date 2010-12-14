package org.nisshiee.mahjong.core;

/**
 * 字牌
 * 
 * @author nishioka
 * 
 */
public enum Honour {
	/**
	 * 東
	 */
	EAST("東"),
	/**
	 * 南
	 */
	SOUTH("南"),
	/**
	 * 西
	 */
	WEST("西"),
	/**
	 * 北
	 */
	NORTH("北"),
	/**
	 * 白
	 */
	WHITE("白"),
	/**
	 * 發
	 */
	GREEN("發"),
	/**
	 * 中
	 */
	RED("中");

	/**
	 * 字
	 */
	private String name;

	/**
	 * コンストラクタ
	 * 
	 * @param name
	 *            字
	 */
	private Honour(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
