package codecademy;

import java.util.ArrayList;
import java.util.Random;

class Playlist {

    public static ArrayList<String> shuffle(ArrayList<String> playlist) {
        Random rand = new Random();
        int songA = rand.nextInt(playlist.size());
        int songB = rand.nextInt(playlist.size());
        swap(playlist, songA, songB);
        return playlist;
    }

    public static void swap(ArrayList<String> playlist, int songA, int songB) {
        String tmp = playlist.get(songA);
        playlist.set(songA, playlist.get(songB));
        playlist.set(songB, tmp);
    }

    public static ArrayList<String> reverse(ArrayList<String> playlist) {
        ArrayList<String> reversed = new ArrayList<String>();
        int i = 0;
        int length = playlist.size();
        while (i < length) {
            reversed.add(playlist.get(length - 1 - i));
            i++;
        }
        return reversed;
    }

    public static void main(String[] args) {
        ArrayList<String> myPlaylist = new ArrayList<String>();
        // System.out.println(myPlaylist);
        myPlaylist.add("An die Freude");
        myPlaylist.add("All You need is love");
        myPlaylist.add("Mr Postman");
        myPlaylist.add("Wish you were here");
        myPlaylist.add("We are the champions");
        myPlaylist.add("Under pressure");
        myPlaylist.add("Circle of Life");
        System.out.println("codecademy.Playlist: " + myPlaylist);
        System.out.println("Size of the playlist: " + myPlaylist.size());
        myPlaylist.remove("Circle of Life");
        myPlaylist.remove(0);
        System.out.println("codecademy.Playlist after removing some songs: " + myPlaylist);
        System.out.println("Actual size of the playlist: " + myPlaylist.size());

        int idx_1 = myPlaylist.indexOf("Mr Postman");
        int idx_2 = myPlaylist.indexOf("We are the champions");
        String tmp = myPlaylist.get(idx_1);
        myPlaylist.set(idx_1, myPlaylist.get(idx_2));
        myPlaylist.set(idx_2, tmp);
        System.out.println("Actual playlist: " + myPlaylist);
        System.out.println("Actual size of the playlist: " + myPlaylist.size());

        System.out.println("Reversed: " + reverse(myPlaylist));

        int i = 0;
        while (i < myPlaylist.size() * 2) {
            shuffle(myPlaylist);
            i++;
        }

        System.out.println("Shuffled: " + myPlaylist);

    }

}