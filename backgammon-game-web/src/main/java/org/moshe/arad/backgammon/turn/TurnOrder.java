package org.moshe.arad.backgammon.turn;

import java.util.LinkedList;
import org.moshe.arad.backgammon.player.Player;

public abstract class TurnOrder implements TurnOrderable {

	protected LinkedList<Player> order = new LinkedList<Player>();

	public TurnOrder() {
	}

	public TurnOrder(LinkedList<Player> order) {
		this.order = order;
	}
}
