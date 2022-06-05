package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new 
			ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	
	public ArrayList<Track> getTracks() {
		return tracks;
	}

	public CompactDisc(String title) {
		super(title);
	}
	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public int addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("This track has already been in the track list");
			return 0;
		}
		System.out.println("Added the track");
		tracks.add(track);
		return 1;
	}
	
	public int removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Removed the track");
			return 1;
		} 
		System.out.println("This track is not in the track list");
		return 0;
	}
	
	public int getLength() {
		int lengthDisc = 0;
		for (Track t : tracks) {
			lengthDisc += t.getLength();
		}
		return lengthDisc;
	}
	
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
		
		for (Track t : tracks) {
			t.play();
		}
	}

}
