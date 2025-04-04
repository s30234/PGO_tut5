package musicLibrary;

import java.util.ArrayList;

public class MusicLibrary {
    private String name;
    private String user;
    private ArrayList<String> tracks;
    private ArrayList<Playlist> playlists;

    public MusicLibrary(String name, String user) {
        this.name = name;
        this.user = user;
        this.tracks = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    private Playlist findPlaylist(String name) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equalsIgnoreCase(name)) {
                return playlist;
            }
        }
        return null;
    }

    public void addTrack(String track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track is already in the playlist");
        }

    }

    public void displayTracks() {
        System.out.println("Playlist: " + name);
        if (tracks.isEmpty()) {
            System.out.println("-" + "No tracks found");
        } else {
            for (String track : tracks) {

                System.out.println("- " + track);
            }
        }
    }

    public void searchTracks(String phrase) {
        System.out.println("Tracks containing " + phrase + " :");
        boolean found = false;
        for (String track : tracks) {
            if (track.toLowerCase().contains(phrase.toLowerCase())) {
                System.out.println("-" + track);
            }
            if (!found) {
                System.out.println("No track found");
            }
        }
    }

    public void createPlaylist(String name) {
        if (findPlaylist(name) == null) {
            playlists.add(new Playlist(name));
        } else {
            System.out.println("Playlist already exists");
        }
    }

    public void addTrackToPlaylist(String name, String track) {
        Playlist playlist = findPlaylist(name);
        if (playlist != null) {
            if (tracks.contains(track)) {
                playlist.addTrack(track);
            } else {
                System.out.println("Track does not exist");
            }
        } else {
            System.out.println("Playlist does not exist");
        }
    }

    public void displayPlaylist(String name ) {
        Playlist playlist = findPlaylist(name);
        if (playlist != null) {
            playlist.display();
        } else {
            System.out.println("Playlist does not exist");
        }
    }


    public void displayAllPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("No playlists found");
        } else {
            System.out.println("All playlists: ");
            for (Playlist playlist : playlists) {
                System.out.println("- " + playlist.getName());
            }
        }
    }

    public void removeTrack(String track) {
        tracks.remove(track);
        for (Playlist playlist : playlists) {
            playlist.removeTrack(track);
        }
    }

    public int getTrackCount(){
        return tracks.size();
    }

    public int getPlaylistCount(){
        return playlists.size();
    }

}
