package GiftMachine;

import ToysList.Toy;

public class ToyGroup {
    public Toy Toy(){
        return toy;
    }
    private Toy toy;

    public int Weight(){
        return weight;
    }
    private int weight;

    public void SetWeight(int newWeight){
        weight = newWeight;
    }

    public int MyWeight(){
        return myWeight;
    }
    private int myWeight;

    public void UpdateWeight(int myWeight){
        this.myWeight = myWeight;
    }

    public int Count(){
        return count;
    }
    private int count;

    public void ChangeCount(int addCount){
        count += addCount;
    }

    public boolean RemoveToy(){
        count--;
        return count == 0;
    }

    public String GetInfo(){
        return "Toy: "+ toy.Name() + " (" + toy.ID() + "), Count: " + count + ", Weight: " + weight;
    }

    public ToyGroup(Toy toy){
        this.toy = toy;
        this.weight = 1;
        this.count = 5;
    }

    public ToyGroup(Toy toy, int count){
        this.toy = toy;
        this.weight = 1;
        this.count = count;
    }

    public ToyGroup(Toy toy, int count, int weight){
        this.toy = toy;
        this.weight = weight;
        this.count = count;
    }
}