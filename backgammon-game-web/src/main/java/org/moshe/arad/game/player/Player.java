package org.moshe.arad.game.player;

import org.moshe.arad.game.instrument.BackgammonPawn;
import org.moshe.arad.game.instrument.BlackBackgammonPawn;
import org.moshe.arad.game.instrument.Color;
import org.moshe.arad.game.instrument.WhiteBackgammonPawn;
import org.moshe.arad.game.move.Move;
import org.moshe.arad.game.turn.BackgammonTurn;

public class Player implements Playerable{

	private String id;
	private String firstName;
	private String lastName;
	private int age;
	private BackgammonTurn turn;
	/**
	 * TODO remove color.
	 */
	private Color color;
	private boolean isWhite;



	public boolean isWhite() {
		return isWhite;
	}



	public Player(String id, String firstName, String lastName, int age, BackgammonTurn turn, int color) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.turn = turn;
		this.color = Color.getColorByInt(color);
	}



	@Override
	public String toString() {
		return "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
	public void setTurn(BackgammonTurn turn) {
		this.turn = turn;
	}

	public BackgammonTurn getTurn() {
		return turn;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}



	@Override
	public void makePlayed(Move move) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean isCanPlayWith(BackgammonPawn pawn) {
		return (isWhite && pawn instanceof WhiteBackgammonPawn) ||
				(!isWhite && pawn instanceof BlackBackgammonPawn);
	}
}
