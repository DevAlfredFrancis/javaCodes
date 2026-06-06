import java.util.Scanner;

public class Playlist {

    public static void main(String[] args) {

        String[] songs = {"Pasko na Sinta ko", "Ang Pasko ay sumapit", "Give love on Christmas Day", "Malamig ang pasko ni Ravi", "Kay Ravi ang Pasko"};

        System.out.println("Total number of songs: " + songs.length); //print the total of songs

        for (int i = 0; i < songs.length; i++) { //display all the songs inside the playlist
            System.out.println(i + 1 + ". " + songs[i]);
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Search: ");
        String searchSong = sc.nextLine();

        String searchRes = "";

        for (String j : songs) { // search songs
            if (searchSong.equalsIgnoreCase(j)) {
                System.out.println(j);
                searchRes = j;
                break;
            }
        }
        
    }
}