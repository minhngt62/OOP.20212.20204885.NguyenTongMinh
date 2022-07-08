package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public interface Playable {
	public StringBuffer play() throws PlayerException;
}
