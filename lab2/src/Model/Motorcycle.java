package Model;

public class Motorcycle implements Vehicle {
    private String color;

    public Motorcycle(String c){
        this.color = c;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Motorcycle m)){
            return false;
        }
        return m.color.equals(this.color);
    }


    @Override
    public String getColor(){
        return this.color;
    }

    @Override
    public String toString(){
        return "This motorcycle has color " + this.color;
    }
}
