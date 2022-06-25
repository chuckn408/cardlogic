package com.foss.llamas.poker.domain;

public class Card implements Comparable<Card> {
	private Color color;
	private Rank rank;
	private Suit suit;
	
	private boolean wild;
	private Card(Color color, Rank rank, Suit suit) {
		this.color = color;
		this.rank = rank;
		this.suit = suit;
	}
	private Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
		if (suit == Suit.CLUBS) {
			this.color = Color.BLACK;
		}
		else if (suit == Suit.SPADES) {
			this.color = Color.BLACK;
		}
		else if (suit == Suit.DIAMONDS) {
			this.color = Color.RED;
		}
		else if (suit == Suit.HEARTS) {
			this.color = Color.RED;
		}
		else if (suit == Suit.ANY) {
			this.color = Color.ANY;
		}
		else if (suit == Suit.JOKER) {
			this.color = Color.JOKER;
		}
		else {
			this.color = Color.OTHER;
		}
		
	}
	@Override
	public int compareTo(Card arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static Card build(Color color, Rank rank, Suit suit) {
		Card card = new Card(color, rank, suit);
		if ((color == Color.JOKER || color == Color.ANY) &&
			(rank == Rank.ANY || rank == Rank.JOKER) &&
			(suit == Suit.ANY || suit == Suit.JOKER)) {
			card.setWild(true);
		}
		return card;
	}

	public static Card build(Rank rank, Suit suit) {
		Card card = new Card(rank, suit);
		if ((rank == Rank.ANY || rank == Rank.JOKER) &&
			(suit == Suit.ANY || suit == Suit.JOKER)) {
			if (rank == Rank.JOKER || suit == Suit.JOKER) {
				card.color = Color.JOKER;				
			}
			else {
				card.color = Color.ANY;				
			}
			card.setWild(true);
		}
		return card;
	}
	public void setWild(boolean wild) {
		this.wild = wild;
	}
	public boolean isWild() {
		return wild;
	}
	public Color getColor() {
		return color;
	}
	public Rank getRank() {
		return rank;
	}
	public Suit getSuit() {
		return suit;
	}
}
