package hust.soict.dsai.aims.media;
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
	public int compare(Media media1, Media media2) {
		try {
			float costDiff = media1.getCost() - media2.getCost();
			if (costDiff > 0) {
				return 1;
			} else if (costDiff < 0) {
				return -1;
			}
			int titleDiff = media1.getTitle().compareTo(media2.getTitle());
			return titleDiff;
		} catch (NullPointerException e) {
			return -1;
		}
	}

}
