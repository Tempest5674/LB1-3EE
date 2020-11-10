package classes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {
    @Id
    int id;

    public String carModel;
    public int seats;
    public int costPerDay;

    public Car(int id, String carModel, int seats, int costPerDay) {
        this.id = id;
        this.carModel = carModel;
        this.seats = seats;
        this.costPerDay = costPerDay;
    }

    public Car() {
        this.id = 0;
        this.carModel = "default";
        this.seats = 0;
        this.costPerDay = 0;
    }

    public static List<String> getColumnNames() {
        List<String> columnNames = new ArrayList<>();

        columnNames.add("Car Id");
        columnNames.add("Car model");
        columnNames.add("Seats");
        columnNames.add("Cost per day");

        return columnNames;
    }

    public static List<String> getPlaceHolderNames() {
        List<String> placeHolderNames = new ArrayList<>();

        placeHolderNames.add("CModel...");
        placeHolderNames.add("Seats...");
        placeHolderNames.add("CPD...");

        return placeHolderNames;
    }

    public int getId() {
        return id;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getSeats() {
        return seats;
    }

    public int getCostPerDay() {
        return costPerDay;
    }

    public static String getClassName() {
        return "Car";
    }

}
