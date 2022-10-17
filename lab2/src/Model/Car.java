package Model;

public class Car implements Vehicle {
    private String color;

    public Car(String c){
        this.color = c;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Car c)){
            return false;
        }
        return c.color.equals(this.color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return "This car has color " + this.color;
    }
}
