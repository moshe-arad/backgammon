package org.moshe.arad.backgammon;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.moshe.arad.game.classic_board.backgammon.Backgammon;
import org.moshe.arad.game.instrument.Board;
import org.moshe.arad.game.instrument.Pawn;
import org.moshe.arad.game.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:backgammon-context-test.xml")
public class BackgammonTest {

	@Autowired
	Backgammon backgammon;
	@Autowired
	Board board;
	@Resource
	Pawn blackPawn;
	@Resource
	Pawn whitePawn;
	@Resource
	Player whitePawnPlayer;
	@Resource
	Player blackPawnPlayer;
	
	@Before
	public void setup(){
		board.clearBoard();
		assertNotNull("Board object is null. can't run tests.", board);
		assertNotNull("Pawn object is null. can't run tests.", blackPawn);
	}
	
	@Test
	public void isHasWinnerOnlyBlackOnBoardWhiteIsWinnerTest(){
		boolean pawnSet = board.setPawn(blackPawn, 0);
		assertTrue("Pawn set failed. is has winner with only black pawns failed." ,pawnSet);
		boolean actual = backgammon.isHasWinner();
		assertTrue("Is Has Winner Only Black On Board White Is Winner test is failed.", actual);
	}
	
	@Test
	public void isHasWinnerOnlyWhiteOnBoardBlackIsWinnerTest(){
		boolean pawnSet = board.setPawn(whitePawn, 0);
		assertTrue("Pawn set failed. is has winner with only white pawns failed." ,pawnSet);
		boolean actual = backgammon.isHasWinner();
		assertTrue("Is Has Winner Only White On Board Black Is Winner test is failed.", actual);
	}
	
	@Test
	public void isHasWinnerDoesNotHaveWinnerBothColorsTest(){
		boolean pawnSet = board.setPawn(whitePawn, 0);
		assertTrue("Pawn set failed. is has winner Does Not Have Winner Both Colors failed first." ,pawnSet);
		pawnSet = board.setPawn(blackPawn, 1);
		assertTrue("Pawn set failed. is has winner Does Not Have Winner Both Colors failed second." ,pawnSet);
		boolean actual = backgammon.isHasWinner();
		assertFalse("is has winner Does Not Have Winner Both Colors failed. actual test.", actual);
	}
	
	@Test
	public void isHasWinnerEmptyBoardTest(){
		boolean actual = backgammon.isHasWinner();
		assertFalse("is has winner empty board failed.", actual);
	}
	
	@Test
	public void isWinnerWhitePawnBlackIsWinnerTest(){
		boolean pawnSet = board.setPawn(whitePawn, 0);
		assertTrue("Is winner test, black is winner, white pawn set failed." ,pawnSet);
		boolean actual = backgammon.isWinner(blackPawnPlayer, board);
		assertTrue("Is winner test, black is winner failed.", actual);
	}
	
	@Test
	public void isWinnerWhitePawnWhiteIsNotWinnerTest(){
		boolean pawnSet = board.setPawn(whitePawn, 0);
		assertTrue("Is winner test, white pawn, white is not winner, white pawn set failed." ,pawnSet);
		boolean actual = backgammon.isWinner(whitePawnPlayer, board);
		assertFalse("Is winner test, white pawn, white is not winner failed.", actual);
	}
	
	@Test
	public void isWinnerBlackPawnWhiteIsWinnerTest(){
		boolean pawnSet = board.setPawn(blackPawn, 0);
		assertTrue("Is winner test, black pawn, black is winner, black pawn set failed." ,pawnSet);
		boolean actual = backgammon.isWinner(whitePawnPlayer, board);
		assertTrue("Is winner test, black pawn, white is winner failed.", actual);
	}
	
	@Test
	public void isWinnerBlackPawnBlackIsNotWinnerTest(){
		boolean pawnSet = board.setPawn(blackPawn, 0);
		assertTrue("Is winner test, black pawn, black is not winner, black pawn set failed." ,pawnSet);
		boolean actual = backgammon.isWinner(blackPawnPlayer, board);
		assertFalse("Is winner test, black pawn, black is not winner failed.", actual);
	}
	
	@Test
	public void isWinnerEmptyBoardBlackPawn(){
		boolean actual = backgammon.isWinner(blackPawnPlayer, board);
		assertFalse("Is winner test, empty board check black pawn winner failed.", actual);
	}
	
	@Test
	public void isWinnerEmptyBoardWhitePawn(){
		boolean actual = backgammon.isWinner(whitePawnPlayer, board);
		assertFalse("Is winner test, empty board check white pawn winner failed.", actual);
	}
	
	@Test
	public void isWinnerBlackPawnDoesNotHaveWinnerBothColorsTest(){
		boolean pawnSet = board.setPawn(whitePawn, 0);
		assertTrue("Pawn set failed. is Winner Black Pawn Does Not Have Winner Both Colors Test." ,pawnSet);
		pawnSet = board.setPawn(blackPawn, 1);
		assertTrue("Pawn set failed. is Winner Black Pawn Does Not Have Winner Both Colors Test." ,pawnSet);
		boolean actual = backgammon.isWinner(blackPawnPlayer, board);
		assertFalse("is Winner Black Pawn Does Not Have Winner Both Colors Test.", actual);
	}
	
	@Test
	public void isWinnerWhitePawnDoesNotHaveWinnerBothColorsTest(){
		boolean pawnSet = board.setPawn(whitePawn, 0);
		assertTrue("Pawn set failed. is Winner White Pawn Does Not Have Winner Both Colors Test." ,pawnSet);
		pawnSet = board.setPawn(blackPawn, 1);
		assertTrue("Pawn set failed. is Winner White Pawn Does Not Have Winner Both Colors Test." ,pawnSet);
		boolean actual = backgammon.isWinner(whitePawnPlayer, board);
		assertFalse("is Winner White Pawn Does Not Have Winner Both Colors Test.", actual);
	}
}
