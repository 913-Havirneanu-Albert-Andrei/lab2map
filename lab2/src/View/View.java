package View;

import Controller.Controller;
import Model.Vehicle;
import Repository.Repository;
import Repository.RepositoryInterface;
import Repository.RepositoryException;
import java.util.Scanner;

public class View {
    private final RepositoryInterface repository;
    private final Controller controller;

    View() {
        this.repository = new Repository(100);
        this.controller = new Controller(repository);
    }

    public void showFilteredVehicles(){
        String color;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter color");
        color = s.nextLine().toLowerCase();
        Vehicle[] res = this.controller.filterByColor(color);
        if(res.length == 0){
            System.out.println("No cars");
            return ;
        }
        for(Vehicle v: res){
            if(v == null){
                return;
            }
            System.out.println(v);
        }
    }

    public void showVehicles(){
        Vehicle[] vehicles = this.controller.getVehicles();
        if (this.repository.getSize()== 0) {
            System.out.println("There are no vehicles");
            return;
        }
        for (int i = 0; i < this.repository.getSize(); i++) {
            System.out.println(vehicles[i]);
        }
    }

    public void removeVehicle(){
        System.out.println("Enter the type of vehicle(car , motorcycle , bicycle)");
        Scanner s = new Scanner(System.in);
        String type = s.nextLine().toLowerCase();
        System.out.println("Enter the color of vehicle");
        String color = s.nextLine().toLowerCase();
        int position = this.controller.getPositionOfVehicle(type , color);
        try {
            this.controller.deleteVehicleFromPosition(position);
        }catch (RepositoryException e){
            System.out.println(e.getMessage());
        }
    }

    public void addVehicle(){
        System.out.println("Enter the type of vehicle(car , motorcycle , bicycle)");
        Scanner s = new Scanner(System.in);
        String type = s.nextLine().toLowerCase();
        System.out.println("Enter the color of vehicle");
        String color = s.nextLine().toLowerCase();
        try {
            this.controller.addVehicle(type, color);
        } catch (RepositoryException e){
            System.out.println(e.getMessage());
        }
    }

    public void printMenu(){
        System.out.println("1 for adding a vehicle");
        System.out.println("2 for deleting a vehicle");
        System.out.println("3 for filtering by color");
        System.out.println("4 for printing all vehicles");
        System.out.println("0 to exit the program");
    }

    public void start(){
        Scanner s = new Scanner(System.in);
        this.printMenu();
        int option = s.nextInt();
        while (true){
            if(option == 1)
                this.addVehicle();
            else if(option == 2)
                this.removeVehicle();
            else if(option == 3)
                this.showFilteredVehicles();
            else if(option == 4)
                this.showVehicles();
            else if(option == 0)
                return;
            else
                System.out.println("Invalid command. Try again =)");
            this.printMenu();
            option = s.nextInt();
        }
    }

    public static void main(String[] args) {
        View v = new View();
        v.start();

    }
}
