package GiftMachine;

import java.util.Scanner;

public class View {
    Scanner scan;
    
    public View(){
        scan = new Scanner(System.in);
    }

    public void ShowCommand(){
        System.out.println("");
        System.out.println("Commands:");
        System.out.println("1. Show Toys in Machine");
        System.out.println("2. Show Toys in List");
        System.out.println("3. Load Toy (id, count)");
        System.out.println("4. Unload Toy (id, count)");
        System.out.println("5. Set Weight for Toy");
        System.out.println("6. Claim Toy");
        System.out.println("7. Return");
        System.out.println("");
    }

    public int GetCommand(){
        System.out.print("Enter command ID: ");
        return scan.nextInt();
    }

    public int SetWeight(String toyName){
        String s = "Set Toy " + toyName + " Weight: ";
        System.out.print(s);
        int res = scan.nextInt();
        if (res <= 0){
            System.out.print(s);
            res = scan.nextInt();
        }
        return res;
    }

    public int GetCount(){
        System.out.print("Set count: ");
        int res = scan.nextInt();
        while (res <= 0){
            System.out.print("Set count: ");
            res = scan.nextInt();
        }
        return res;
    }
    
    public int GetID(String s){
        System.out.print("Enter " + s + " ID: ");
        return scan.nextInt();
    }

    public void Log(String s){
        System.out.println(s);
    }
}