import java.util.Comparator;

//This sorts the stats table

public class SortByStats implements Comparator<Player> {

	@Override
	public int compare(Player a, Player b) {
		if (a.getWinPercent() > b.getWinPercent()) {
			return -1;
		} else if (a.getWinPercent() < b.getWinPercent()) {
			return 1;
		} else if (a.getWinPercent() == b.getWinPercent() &&
				a.getAvgGuesses() < b.getAvgGuesses()) {
			return -1;
		} else if (a.getWinPercent() == b.getWinPercent() &&
				a.getAvgGuesses() > b.getAvgGuesses()) {
			return 1;
		} else if (a.getWinPercent() == b.getWinPercent() &&
				a.getAvgGuesses() == b.getAvgGuesses() &&
				a.getAvgLength() > b.getAvgLength()) {
			return -1;
		} else if (a.getWinPercent() == b.getWinPercent() &&
				a.getAvgGuesses() == b.getAvgGuesses() &&
				a.getAvgLength() < b.getAvgLength()) {
			return 1;
		} else {
			return 0;
		}
			
	}

}
