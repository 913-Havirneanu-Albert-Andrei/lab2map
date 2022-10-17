package Model;

import java.util.Objects;

public class Bicycle implements Vehicle {
    private String color;

    public Bicycle(String c){
        this.color = c;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Bicycle b)) {
            return false;
        }
        return b.color.equals(this.color);
    }

    @Override
    public String toString(){
        return "This bicycle has color " + this.color;
    }

    @Override
    public String getColor(){
        return this.color;
    }
}
