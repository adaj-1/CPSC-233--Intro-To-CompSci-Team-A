package model;

public class BlankPlayer extends Player {

	public BlankPlayer() {
		this.name = "  ";
		player = new String[101];
		for (int i = 0; i < 101; i++) {
			player[i] = "  ";
		}
	}

	public void MovePlayer() {
	}

	public void MovePlayerGUI() {
	}
}
