package Repository;
import Model.Vehicle;

public interface RepositoryInterface {
    void addVehicle(Vehicle v) throws RepositoryException;
    int getPositionOfVehicle(Vehicle v) ;

    void deleteVehicleFromPosition(int position) throws RepositoryException;

    int getSize();
    Vehicle[] getVehicles();
}
