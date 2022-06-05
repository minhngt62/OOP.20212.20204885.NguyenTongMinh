package hust.soict.dsai.aims.utils;
import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;

public class MediaUtils {
	public static boolean compareByCost(Media dvd1, Media dvd2) {
		return dvd1.getCost() == dvd2.getCost();
	}
	public static boolean compareByTitle(Media dvd1, Media dvd2) {
		return dvd1.getTitle().equals(dvd2.getTitle());
	}
	
	public static ArrayList<Media> sortByTitle(ArrayList<Media> mediaList) {
		for (int i=1; i<mediaList.size(); i++) {
			Media key = mediaList.get(i);
			if (key == null) {
				continue;
			}
			int j = i - 1;
			while (j >= 0 && mediaList.get(j).getTitle().compareTo(key.getTitle()) > 0) {
				mediaList.set(j+1, mediaList.get(j));
				j = j - 1;
			}
			mediaList.set(j+1, key);
		}
		return mediaList;
	}
	
	public static ArrayList<Media> sortByCost(ArrayList<Media> mediaList) {
		for (int i=1; i < mediaList.size(); i++) {
			Media key = mediaList.get(i);
			if (key == null) {
				continue;
			}
			int j = i - 1;
			while (j >= 0 && mediaList.get(j).getCost() > key.getCost()) {
				mediaList.set(j+1, mediaList.get(j));
				j = j - 1;
			}
			mediaList.set(j+1, key);
		}
		return mediaList;
	}
	
	public static ArrayList<Media> sortByTitleCost(ArrayList<Media> mediaList) {
		for (int i=1; i<mediaList.size(); i++) {
			Media key = mediaList.get(i);
			if (key == null) {
				continue;
			}
			int j = i - 1;
			while (j >= 0 && mediaList.get(j).getTitle().compareTo(key.getTitle()) >= 0) {
				if (compareByTitle(mediaList.get(j), key)) {
					if (mediaList.get(j).getCost() < key.getCost()) {
						mediaList.set(j+1, mediaList.get(j));
						j = j - 1;
					}
				} else {
					mediaList.set(j+1, mediaList.get(j));
					j = j - 1;
				}
				
			}
			mediaList.set(j+1, key);
		}
		return mediaList;
	}
	
	public static ArrayList<Media> sortByCostTitle(ArrayList<Media> mediaList) {
		for (int i=1; i<mediaList.size(); i++) {
			Media key = mediaList.get(i);
			if (key == null) {
				continue;
			}
			int j = i - 1;
			while (j >= 0 && mediaList.get(j).getCost() <= key.getCost()) {
				if (compareByCost(mediaList.get(j), key)) {
					if (mediaList.get(j).getTitle().compareTo(key.getTitle()) > 0) {
						mediaList.set(j+1, mediaList.get(j));
						j = j - 1;
					}
				} else {
					mediaList.set(j+1, mediaList.get(j));
					j = j - 1;
				}
				
			}
			mediaList.set(j+1, key);
		}
		return mediaList;
	}
	
}
