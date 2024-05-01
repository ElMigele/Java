package ToysList;

import java.util.Scanner;

public class View {
    Scanner intScan;
    Scanner strScan;

    public View(){
        intScan = new Scanner(System.in);
        strScan = new Scanner(System.in);
        strScan.useDelimiter("\\n");
    }

    public void ShowCommands(){
        System.out.println("");
        System.out.println("Commands:");
        System.out.println("1. Show All Toys in List");
        System.out.println("2. Add Toy in List");
        System.out.println("3. Edit Toy in List (by id)");
        System.out.println("4. Delete Toy in List (by id)");
        System.out.println("5. Return");
        System.out.println("");
    }

    public int GetCommand(){
        System.out.print("Enter command ID: ");
        return intScan.nextInt();
    }

    public String GetName(){
        System.out.print("Enter Toy Name: ");
        String s = strScan.next();
        s = s.replaceAll("[\n\r]", "");
        return s;
    }

    public String GetName(String oldName){
        System.out.print("Enter Toy Name [old: " + oldName + "]: ");
        return strScan.next();
    }

    public int GetID(){
        System.out.print("Enter Toy ID: ");
        String s = intScan.next();
        try {
            return Integer.parseInt(s);            
        } catch (Exception e) {
            return -1;
        }
        //return intScan.nextInt();
    }

    public void PrintToy(Toy toy){
        System.out.println(toy.GetInfo());
    }

    public void Log(String string) {
        System.out.println(string);
    }
}