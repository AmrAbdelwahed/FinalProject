import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLRegisterGuestController implements Serializable {

    public FXMLRegisterGuestController(){
    }
    @FXML Button btnClear;

    @FXML Button btnSave;

    @FXML TextField txtCheckIn;

    @FXML TextField txtCheckOut;

    @FXML TextField txtContact;

    @FXML TextField txtEmail;

    @FXML TextField txtFullName;

    @FXML TextField txtRoomNo;

    //FXMLHotelBookingController c1 = new FXMLHotelBookingController();
    FileOutputStream fo;
    ObjectOutputStream os;
    //ObservableList <Guest> guestList = FXCollections.observableArrayList();
    ArrayList <Guest> guestList = new ArrayList<>();

    @FXML
    void handleActionClear(ActionEvent event) {

        txtFullName.clear();
        txtRoomNo.clear();
        txtEmail.clear();
        txtCheckIn.clear();
        txtCheckOut.clear();
        txtContact.clear();
    }

    @FXML
    void handleActionSave(ActionEvent event)throws IOException {
        //debugging
        System.out.println(FXMLHotelBookingController.guestList.size());

        
        Guest g = new Guest();
        g.setFullName(txtFullName.getText());
        g.setRoomNumber(Integer.parseInt(txtRoomNo.getText()));
        g.setEmail(txtEmail.getText());
        g.setCheckInDate(txtCheckIn.getText());
        g.setCheckOutDate(txtCheckOut.getText());
        g.setContactNumber(Long.parseLong(txtContact.getText()));

        //add guest object to tableview
        //FXMLHotelBookingController.tblRecords.getItems().add(g);

        //Add guest object to arraylist
        FXMLHotelBookingController.guestList.add(g);
        //debugging
        System.out.println(FXMLHotelBookingController.guestList.size());

        fo = new FileOutputStream("records.txt");
        os = new ObjectOutputStream(fo);

        //added the whole array as an object into the file
        os.writeObject(guestList);

        //when savebutton is clicked go back to tableview main page

        // Stage stage = (Stage)btnSave.getScene().getWindow();
        // stage.setScene(FXMLLoader.load(getClass().getResource("FXMLHotelBookingController.java")));
        
        // Stage stage = (Stage)btnSave.getScene().getWindow();
        // Parent root = FXMLLoader.load(getClass().getResource("FXMLHotelBooking.fxml"));
        // stage.setScene(new Scene(root));
        // stage.setTitle("Hotel Booking System");
        // stage.show();
    }

}
