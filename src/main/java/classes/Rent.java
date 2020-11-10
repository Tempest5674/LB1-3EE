package classes;

import org.hibernate.search.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rent")
@Indexed
public class Rent {
    @Id
    int carId;

    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    public int clientId;
    public int rentCost;
    public int rentLength;
    public int rentTotal;

    public Rent(int carId, int clientId, int rentCost, int rentLength, int rentTotal) {
        this.carId = carId;
        this.clientId = clientId;
        this.rentCost = rentCost;
        this.rentLength = rentLength;
        this.rentTotal = rentTotal;
    }

    public Rent() {
        carId=0;
        clientId =0;
        rentCost=0;
        rentLength=0;
        rentTotal = 0;
    }

    public int getCarId() {
        return carId;
    }

    public int getClientId() {
        return clientId;
    }

    public int getRentCost() {
        return rentCost;
    }

    public int getRentLength() {
        return rentLength;
    }

    public int getRentTotal() {
        return rentTotal;
    }

    public static List<String> getColumnNames() {
        List<String> columnNames = new ArrayList<>();

        columnNames.add("Car id");
        columnNames.add("Cost");
        columnNames.add("Length");
        columnNames.add("Total");

        return columnNames;
    }

    public static List<String> getPlaceHolderNames() {
        List<String> placeHolderNames = new ArrayList<>();

        placeHolderNames.add("CarId...");
        placeHolderNames.add("ClientId...");
        placeHolderNames.add("RCost...");
        placeHolderNames.add("RLen...");
        placeHolderNames.add("RTotal...");

        return placeHolderNames;
    }

}
