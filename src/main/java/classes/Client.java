package classes;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.hibernate.annotations.NamedQuery;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "Select all clients",query = "from Client")
@Table(name = "client")
@Indexed
public class Client {
    @Id
    int id;

    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    public String firstName;

    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    public String secondName;

    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    public String phoneNumber;

    public Client(int id, String firstName, String secondName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
    }

    public Client() {
        this.id = 0;
        this.firstName = "default";
        this.secondName = "default";
        this.phoneNumber = "default";
    }

    public static List<String> getColumnNames() {
        List<String> columnNames = new ArrayList<>();

        columnNames.add("First name");
        columnNames.add("Second name");
        columnNames.add("Phone number");

        return columnNames;
    }

    public static String getFieldName(String columnName){
        switch (columnName){
            case "First name": return "firstName";
            case "Second name": return "secondName";
            case "Phone number": return "phoneNumber";
        }
        return "default";
    }

    public static List<String> getPlaceHolderNames() {
        List<String> placeHolderNames = new ArrayList<>();

        placeHolderNames.add("FName...");
        placeHolderNames.add("SName...");
        placeHolderNames.add("PNumb...");

        return placeHolderNames;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static String getClassName(){
        return "Client";
    }
}
