package musicLibrary;

import java.util.ArrayList;

public class MusicLibrary {
    private String name;
    private String user;
    private ArrayList<String> tracks;
    private ArrayList<Playlist> playlists;
    public MusicLibrary(String name, String user, ArrayList<String> tracks, ArrayList<Playlist> playlists) {
        this.name = name;
        this.user = user;
        this.tracks = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    private Playlist findPlaylist(String name) {
        for(Playlist playlist : playlists) {
            if(playlist.getName().equals(name)) {
               return playlist;
            }
        }
        return null;
    }
    public void createPlaylist(String name) {
        if(findPlaylist(name) == null) {
            playlists.add(new Playlist(name));
        }else{
            System.out.println("Playlist already exists");
        }
    }

    public void addTrackToPlaylist(String name, String track) {
        Playlist playlist = findPlaylist(name);
        if(playlist != null) {
            if(tracks.contains(track)) {
                playlist.addTrack(track);
            }else{
                System.out.println("Track does not exist");
            }
        }else{
            System.out.println("Playlist does not exist");
        }
    }
    public void displayPlaylist() {
        Playlist playlist = findPlaylist(name);
        if(playlist != null) {
            playlist.display();
        }else{
            System.out.println("Playlist does not exist");
        }
    }


    public void displayAllPlaylists() {
        if(playlists.isEmpty()){
            System.out.println("No playlists found");
        }else{
            System.out.println("All playlists: ");
            for(Playlist playlist : playlists) {
                System.out.println("- " + playlist.getName());
            }
        }
    }


}
