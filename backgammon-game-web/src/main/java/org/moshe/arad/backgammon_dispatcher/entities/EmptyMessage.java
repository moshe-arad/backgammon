package org.moshe.arad.backgammon_dispatcher.entities;

public class EmptyMessage extends BasicDetails {

	private boolean isEmpty = true;
	
	public EmptyMessage() {
	}
	
	public EmptyMessage(int messageToken) {
		super(messageToken, "", false);
		this.isEmpty = isEmpty;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	
	
}
