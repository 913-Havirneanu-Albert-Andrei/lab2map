package Controller;
import Model.Bicycle;
import Model.Car;
import Model.Motorcycle;
import Model.Vehicle;
import Repository.RepositoryException;
import Repository.RepositoryInterface;

public class Controller {
    private final RepositoryInterface repository;
    public Controller(RepositoryInterface repo){
        this.repository = repo;
    }

    public void addVehicle(String type , String color) throws RepositoryException {
        switch (type) {
            case "car" -> {
                Car c = new Car(color);
                this.repository.addVehicle(c);
            }
            case "motorcycle" -> {
                Motorcycle m = new Motorcycle(color);
                this.repository.addVehicle(m);
            }
            case "bicycle" -> {
                Bicycle b = new Bicycle(color);
                this.repository.addVehicle(b);
            }
        }
    }

    public int getSize(){
        return this.repository.getSize();
    }

    public int getPositionOfVehicle(String type , String color){
        switch (type) {
            case "car" -> {
                Car c = new Car(color);
                return this.repository.getPositionOfVehicle(c);
            }
            case "motorcycle" -> {
                Motorcycle m = new Motorcycle(color);
                return this.repository.getPositionOfVehicle(m);
            }
            case "bicycle" -> {
                Bicycle b = new Bicycle(color);
                return this.repository.getPositionOfVehicle(b);
            }
        }
        return -1;
    }

    public void deleteVehicleFromPosition(int pos) throws RepositoryException {
        this.repository.deleteVehicleFromPosition(pos);
    }

    public Vehicle[] filterByColor(String color){
        int size = 0;
        Vehicle[] result = new Vehicle[this.repository.getSize()];
        for(int i = 0; i < this.repository.getSize(); i++){
            if(this.repository.getVehicles()[i].getColor().equals(color)){
                result[size++] = this.repository.getVehicles()[i];
            }
        }
        return result;
    }

    public Vehicle[] getVehicles() {
        return this.repository.getVehicles();
    }
}
