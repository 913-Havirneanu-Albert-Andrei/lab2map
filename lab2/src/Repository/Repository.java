package Repository;
import Model.Vehicle;

public class Repository implements RepositoryInterface {
    private final Vehicle[] vehicles;
    private int size;

    public Repository(int capacity) {
        this.vehicles = new Vehicle[capacity];
        this.size = 0;
    }

    @Override
    public int getSize(){
        return this.size;
    }

    @Override
    public int getPositionOfVehicle(Vehicle v){
        for (int i = 0; i < this.size; i++) {
            if(this.vehicles[i].equals(v))
                return i;
        }
        return -1;
    }

    @Override
    public void deleteVehicleFromPosition(int pos) throws RepositoryException {
        if(pos == -1)
            throw new RepositoryException("No vehicle");
        for (int i = pos; i < this.vehicles.length - 1; i++) {
            this.vehicles[i] = this.vehicles[i + 1];
        }
        this.vehicles[this.size - 1] = null;
        this.size--;
    }

    @Override
    public void addVehicle(Vehicle v) throws RepositoryException{
        if(this.size == this.vehicles.length)
            throw new RepositoryException("Array is full!");
        this.vehicles[this.size++] = v;
    }

    @Override
    public Vehicle[] getVehicles() {
        return this.vehicles;
    }
}
