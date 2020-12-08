package soundsystem;

import org.springframework.stereotype.Component;

import java.util.List;

public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;

    public BlankDisc() {
    }

    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public BlankDisc(String title, String artist, List<String> tracks) {
        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    public void play() {
        System.out.println("Odtwarzam utwór " + title + " autorstwa " + artist);
        for (String track : tracks) {
            System.out.println("-Utwór: " + track);
        }
    }

    public void playTrack(int trackNr) {
        try {
            System.out.println("Odtwarzam utwór " + trackNr + " o tytule: " + tracks.get(trackNr));
        } catch (IndexOutOfBoundsException e){
            System.out.println("Nie ma utworu o numerze " + trackNr);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }
}
