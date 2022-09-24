import java.io.Serializable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Guest implements Serializable{
    private SimpleStringProperty fullName,email,checkInDate,checkOutDate;
    private SimpleLongProperty contactNumber;

    private SimpleIntegerProperty roomNumber;

    public Guest() {
    }

    public Guest(String fullName, int contactNumber, String email, String checkInDate, String checkOutDate,
            int roomNumber) {
        this.fullName = new SimpleStringProperty(fullName);
        this.contactNumber = new SimpleLongProperty(contactNumber);
        this.email = new SimpleStringProperty(email);
        this.checkInDate = new SimpleStringProperty(checkInDate);
        this.checkOutDate = new SimpleStringProperty(checkOutDate);
        this.roomNumber = new SimpleIntegerProperty(roomNumber);
    }

    public String getFullName() {
        return fullName.get();
    }

    public void setFullName(SimpleStringProperty fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(SimpleStringProperty email) {
        this.email = email;
    }

    public String getCheckInDate() {
        return checkInDate.get();
    }

    public void setCheckInDate(SimpleStringProperty checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate.get();
    }

    public void setCheckOutDate(SimpleStringProperty checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Long getContactNumber() {
        return contactNumber.get();
    }

    public void setContactNumber(SimpleLongProperty contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getRoomNumber() {
        return roomNumber.get();
    }

    public void setRoomNumber(SimpleIntegerProperty roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString(){
        return ""+ this.getFullName()+this.getContactNumber()+this.getEmail()+getCheckInDate()+this.getCheckOutDate()+this.getRoomNumber();
    }

}
