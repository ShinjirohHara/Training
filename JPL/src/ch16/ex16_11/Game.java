package ch16.ex16_11;

import java.util.Iterator;
import java.util.List;

public class Game {
	
	public static void main(String[] args) {
		String name;
		Game game = new Game();
		while ((name = getNextPlayer()) != null) {
			try {
				PlayerLoader loader = new PlayerLoader();
				Class<? extends Player> classOf =
						loader.loadClass(name).asSubclass(Player.class);
				Player player = classOf.newInstance();
				game.addPlayer(player);
			} catch (Exception e) {
				reportException(name ,e);
				return;
			}
		}
		game.start();
		game.reportScore(name);
	}
	
	private Player[][] board = new Player[3][3];
	private List<Player> members;
	private int count = 0;
	
	private void start() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = null;
			}
		}
		
		while (true) {
			for (Iterator<Player> ite = members.iterator(); ite.hasNext(); ) {
				Player player = ite.next();
				player.play(this);
				if (count == 9)
					return;
			}
		}
	}

	public Player getPlayer(int x, int y){
		return board[x][y];
	}
	
	public boolean place(int x, int y, Player player) {
		if (board[x][y] == null) {
			board[x][y] = player;
			count++;
			return true;
		} else {
			return false;
		}
	}


	private void addPlayer(Player player) {
		members.add(player);
	}

	private static void reportException(String name, Exception e) {
		
	}

	private void reportScore(String name) {
		
	}

	private static String getNextPlayer() {
		return null;
	}

}
