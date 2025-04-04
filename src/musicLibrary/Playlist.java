package musicLibrary;

import java.util.ArrayList;

public class Playlist {
    private String name;
    private ArrayList<String> tracks;

    public Playlist(String name) {
        this.name = name;
        tracks = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addTrack(String track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track is already in the playlist");
        }

    }

    public void removeTrack(String track) {
        boolean result = tracks.remove(track);
        if (!result) {
            System.out.println("Track is not in the playlist");
        }
    }

    public void display() {
        System.out.println("Playlist: " + name);
        if (tracks.isEmpty()) {
            System.out.println("-" + "No tracks found");
        } else {
            for (String track : tracks) {

                System.out.println("- " + track);
            }
        }
    }
    public void searchTrack(String phrase) {
        System.out.println("Tracks containing " + phrase + " :");
        boolean found = false;
        for (String track : tracks) {
            if(track.toLowerCase().contains(phrase.toLowerCase())) {
                System.out.println("-" + track);
            }
            if(!found) {
                System.out.println("No track found");
            }
        }
    }

//    public void setName(String name) {
//        this.name = name;
//    }


}
