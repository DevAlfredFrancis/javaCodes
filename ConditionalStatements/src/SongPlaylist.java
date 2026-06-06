import java.util.Scanner;

public class SongPlaylist {

    public static void main(String[] args) {

        String[] songs = {"Give love on Christmas Day", "Baby Come Back", "Don't look back", "Hey, Jude", "Dont know what to do"};

        for(int i=0; i<songs.length; i++) {
            System.out.println(i + 1 + ". " + songs[i]);
        }

        System.out.println("Total number of Songs: " + songs.length);

        String songRes = "";

        for(String i : songs) {
            System.out.println(i);
            songRes = i ;
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your song: ");
        String searchSong = sc.nextLine();

        if(searchSong.equalsIgnoreCase(songRes)) {
            System.out.print(searchSong);
        }else {
            System.out.print("Not Found!");
        }
    }
}
