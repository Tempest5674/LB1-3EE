package classes;

import interfaces.CarSeatsConstraint;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "Select all cars",query = "from Car")
@Table(name = "car")
public class Car{
    @Id
    int id;

    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    public String carModel;

    @CarSeatsConstraint
    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    public int seats;

    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
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
