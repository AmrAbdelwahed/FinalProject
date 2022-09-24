import javafx.collections.ObservableList;

public class Guest {
    private String fullName;
    protected long contactNumber;
    private String email;
    private String checkInDate;
    private String checkOutDate;
    private int roomNumber;
    public ObservableList<Guest> guests;
    
    public Guest() {
    }

    public Guest(String fullName, int contactNumber, String email, String checkInDate, String checkOutDate,
            int roomNumber) {
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomNumber = roomNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

}
