package org.nisshiee.mahjong.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 1セットの牌の組
 * 
 * @author nishioka
 * 
 */
public class TileSet {
	/**
	 * 牌の数
	 */
	private static final int SIZE = 136;
	/**
	 * 牌の集合
	 */
	private Collection<Tile> tiles;

	/**
	 * コンストラクタ
	 */
	public TileSet() {
		this.tiles = new ArrayList<Tile>(SIZE);
		for (Suit suit : Suit.values()) {
			for (int num = 1; num <= 9; num++) {
				for (int i = 0; i < 4; i++) {
					tiles.add(new Tile(suit, num));
				}
			}
		}
		for (Honour honour : Honour.values()) {
			for (int i = 0; i < 4; i++) {
				tiles.add(new Tile(honour));
			}
		}
	}

	/**
	 * シャッフルされた山を生成
	 * 
	 * @param rnd
	 *            Random
	 * @return
	 */
	public List<Tile> createShuffledWall(Random rnd) {
		List<Tile> making = new ArrayList<Tile>(tiles);
		Collections.shuffle(making, rnd);
		return making;
	}

	/**
	 * シャッフルされた山を生成
	 * 
	 * @param seed
	 *            乱数シード
	 * @return
	 */
	public List<Tile> createShuffledWall(long seed) {
		return createShuffledWall(new Random(seed));
	}

	/**
	 * シャッフルされた山を生成
	 * 
	 * @return
	 */
	public List<Tile> createShuffledWall() {
		return createShuffledWall(new Random());
	}

	/**
	 * 牌の数を取得
	 * 
	 * @return
	 */
	public int getSize() {
		return SIZE;
	}
}
