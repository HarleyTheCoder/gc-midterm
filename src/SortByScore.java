import java.util.Comparator;

//This sorts the high score table by most wins followed by least losses

public class SortByScore implements Comparator<Player> {

	@Override
	public int compare(Player a, Player b) {
		if (a.getWins() > b.getWins()) {
			return -1;
		} else if (a.getWins() < b.getWins()) {
			return 1;
		} else if (a.getWins() == b.getWins() && a.getLosses() < b.getLosses()) {
			return -1;
		} else if (a.getWins() == b.getWins() && a.getLosses() > b.getLosses()) {
			return 1;
		} else {
			return 0;
		}
	}

}
