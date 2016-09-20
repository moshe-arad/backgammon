package org.moshe.arad.game.classic_board;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.moshe.arad.game.BasicGame;
import org.moshe.arad.game.instrument.Board;
import org.moshe.arad.game.player.BackgammonPlayer;
import org.moshe.arad.game.player.Player;
import org.moshe.arad.game.turn.TurnOrderable;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClassicBoardGame extends BasicGame {

	private final Logger logger = LogManager.getLogger("org.moshe.arad");
	@Autowired
	protected Board board;
	@Resource
	private Player firstPlayer;
	@Resource
	private Player secondPlayer;
	@Autowired
	private TurnOrderable turnOrderManager;
	
	private boolean isPlaying = true;

	@Override
	public void initGame() {
		logger.info("Initializing board...");
		board.initBoard();
		logger.info("Board initializing completed...");
	}
	
	@Override
	public void play(){
		logger.info("Game is about to begin...");
		try{
			while(isPlaying){
				Player playerWithTurn = turnOrderManager.howHasTurn();
				playGameTurn(playerWithTurn);
				if(!isHasWinner()) turnOrderManager.passTurn();
				else isPlaying = false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Game end with a winner...");
	}

	@Override
	public void doWinnerActions() {
		logger.info("we have a winner");
	}

	@Override
	public boolean isHasWinner() {
		try{
			BackgammonPlayer first = (BackgammonPlayer)turnOrderManager.howHasTurn();
			BackgammonPlayer second = (BackgammonPlayer)turnOrderManager.howIsNextInTurn();
			return board.isWinner(first) || board.isWinner(second);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	public abstract void playGameTurn(Player player);
	
	public Board getBoard() {
		return board;
	}
	public Player getFirstPlayer() {
		return firstPlayer;
	}
	public Player getSecondPlayer() {
		return secondPlayer;
	}
}
