package General;
import java.util.Scanner;

public class View {
    Scanner scan;
    public View(){
        scan = new Scanner(System.in);
    }

    public void ShowCommands(){
        System.out.println("");
        System.out.println("Commands:");
        System.out.println("1. Go to Toys List");
        System.out.println("2. Go to Gift Machine");
        System.out.println("3. Exit programm");
        System.out.println("");
    }

    public int GetCommand(){
        System.out.print("Enter Command: ");
        return scan.nextInt();
    }

    public void ShutDown(){
        System.out.print("Shut down...");
    }
}