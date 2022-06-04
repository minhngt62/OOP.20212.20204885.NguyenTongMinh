package hust.soict.dsai.aims.utils;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class DVDUtils {
	public static boolean compareByCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		return dvd1.getCost() == dvd2.getCost();
	}
	public static boolean compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		return dvd1.getTitle().equals(dvd2.getTitle());
	}
	
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] dvdList) {
		for (int i=1; i<dvdList.length; i++) {
			DigitalVideoDisc key = dvdList[i];
			if (key == null) {
				continue;
			}
			int j = i - 1;
			while (j >= 0 && dvdList[j].getTitle().compareTo(key.getTitle()) > 0) {
				dvdList[j+1] = dvdList[j];
				j = j - 1;
			}
			dvdList[j+1] = key;
		}
		return dvdList;
	}
	
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] dvdList) {
		for (int i=1; i<dvdList.length; i++) {
			DigitalVideoDisc key = dvdList[i];
			if (key == null) {
				continue;
			}
			int j = i - 1;
			while (j >= 0 && dvdList[j].getCost() > key.getCost()) {
				dvdList[j+1] = dvdList[j];
				j = j - 1;
			}
			dvdList[j+1] = key;
		}
		return dvdList;
	}
	
	public static DigitalVideoDisc[] sortByTitleCostLength(DigitalVideoDisc[] dvdList) {
		for (int i=1; i<dvdList.length; i++) {
			DigitalVideoDisc key = dvdList[i];
			if (key == null) {
				continue;
			}
			int j = i - 1;
			while (j >= 0 && dvdList[j].getTitle().compareTo(key.getTitle()) >= 0) {
				if (compareByTitle(dvdList[j], key)) {
					if (compareByCost(dvdList[j], key)) {
						if (dvdList[j].getLength() < key.getLength()) {
							dvdList[j+1] = dvdList[j];
							j = j - 1;
						}
					} else if (dvdList[j].getCost() < key.getCost()) {
						dvdList[j+1] = dvdList[j];
						j = j - 1;
					}
				} else {
					dvdList[j+1] = dvdList[j];
					j = j - 1;
				}
				
			}
			dvdList[j+1] = key;
		}
		return dvdList;
	}
	
	public static DigitalVideoDisc[] sortByTitleCost(DigitalVideoDisc[] dvdList) {
		for (int i=1; i<dvdList.length; i++) {
			DigitalVideoDisc key = dvdList[i];
			if (key == null) {
				continue;
			}
			int j = i - 1;
			while (j >= 0 && dvdList[j].getTitle().compareTo(key.getTitle()) >= 0) {
				if (compareByTitle(dvdList[j], key)) {
					if (dvdList[j].getCost() < key.getCost()) {
						dvdList[j+1] = dvdList[j];
						j = j - 1;
					}
				} else {
					dvdList[j+1] = dvdList[j];
					j = j - 1;
				}
				
			}
			dvdList[j+1] = key;
		}
		return dvdList;
	}
	
	public static DigitalVideoDisc[] sortByCostTitle(DigitalVideoDisc[] dvdList) {
		for (int i=1; i<dvdList.length; i++) {
			DigitalVideoDisc key = dvdList[i];
			if (key == null) {
				continue;
			}
			int j = i - 1;
			while (j >= 0 && dvdList[j].getCost() <= key.getCost()) {
				if (compareByCost(dvdList[j], key)) {
					if (dvdList[j].getTitle().compareTo(key.getTitle()) > 0) {
						dvdList[j+1] = dvdList[j];
						j = j - 1;
					}
				} else {
					dvdList[j+1] = dvdList[j];
					j = j - 1;
				}
				
			}
			dvdList[j+1] = key;
		}
		return dvdList;
	}
	
}
