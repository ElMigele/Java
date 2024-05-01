package ToysList;
public class Toy{
    public String Name(){
        return name;
    }
    private String name;

    public void Rename(String newName){
        name = newName;
    }

    public String GetInfo(){
        return "#" + id + ", Name: " + name;
    }

    public int ID(){
        return id;
    }
    private int id;

    public Toy(String name, int id){
        this.name = name;
        this.id = id;
    }
    
    public Toy(String info){
        String[] blocks = info.split(";");

        this.name = blocks[1];
        this.id = Integer.valueOf(blocks[0]);
    }
}