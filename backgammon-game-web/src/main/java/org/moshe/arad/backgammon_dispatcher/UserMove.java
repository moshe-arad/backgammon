package org.moshe.arad.backgammon_dispatcher;

import org.moshe.arad.game.move.Move;
import org.moshe.arad.repositories.entities.BasicUser;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Component
@JsonDeserialize(using = UserMoveJsonDeserializer.class)
public class UserMove {

	private Move move;
	private BasicUser user;
	
	public UserMove() {

	}

	public UserMove(Move move, BasicUser user) {
		this.move = move;
		this.user = user;
	}

	public Move getMove() {
		return move;
	}
	@JsonSetter("move")
	public void setMove(Move move) {
		this.move = move;
	}
	public BasicUser getUser() {
		return user;
	}
	
	@JsonSetter("user")
	public void setUser(BasicUser user) {
		this.user = user;
	}
	
	
}
