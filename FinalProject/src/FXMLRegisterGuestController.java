import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
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


    @FXML Button btnClear;

    @FXML Button btnSave;

    @FXML TextField txtCheckIn;

    @FXML TextField txtCheckOut;

    @FXML TextField txtContact;

    @FXML TextField txtEmail;

    @FXML TextField txtFullName;

    @FXML TextField txtRoomNo;

    File file= new File("records5.dat"); //when we close of the program, the file should preserve all data bytes
    static FileOutputStream fo;
    static FileInputStream fi;
    static ObjectInputStream oi;
    static ObjectOutputStream os;

    //FXMLHotelBookingController c1 = new FXMLHotelBookingController();
    // FileOutputStream fo;
    // ObjectOutputStream os;
    //ObservableList <Guest> guestList = FXCollections.observableArrayList();

    //ArrayList <Guest> guestList = new ArrayList<>();
    ObservableList <Guest> guestNew;

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
    void handleActionSave(ActionEvent event)throws IOException, ClassNotFoundException {
        //debugging  

        try{
            Parent root = FXMLLoader.load(getClass().getResource("FXMLHotelBooking.fxml"));
            Stage stage = (Stage)btnSave.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Hotel Booking System");
            stage.show();
        }

        catch(Exception e){
            System.out.println("cannot load new window");
        }

        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }   
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }    
        System.out.println(guestNew.size());
        
        Guest g = new Guest();
        g.setFullName(((SimpleStringProperty)txtFullName.getText()));
        g.setRoomNumber(Integer.parseInt(txtRoomNo.getText()));
        g.setEmail((SimpleStringProperty)txtEmail.getText());
        g.setCheckInDate((SimpleStringProperty)txtCheckIn.getText());
        g.setCheckOutDate((SimpleStringProperty)txtCheckOut.getText());
        g.setContactNumber((SimpleLongProperty)Long.parseLong(txtContact.getText()));

        try {
            fi = new FileInputStream(file.getName()); //fi = new FileInputStream("records.dat");
            oi = new ObjectInputStream(fi);
            guestNew = (ObservableList)oi.readObject(); //now guestNew holds all the records stored in records.dat
            oi.close();
            fi.close();
            
        } catch (EOFException e) {
            System.out.println("Error opening the stream");
        }
        //Add guest object to guestNew 
        guestNew.add(g); //(Append to the current file 'g')

        fo = new FileOutputStream(file);
        os = new ObjectOutputStream(fo);
        os.writeObject(guestNew); //writing all records guestNew had read + 'g'
        os.close();
        fo.close();

        //check to see when application is closed the objects written to the file are preserved
        System.out.println(file.length()); //wrote the 5th object, the length of file is 285b, good result

        //debugging
        System.out.println(guestNew.size());

      //FXMLHotelBookingController.tblRecords.setItems(FXMLHotelBookingController.guestList);
        //add guest object to tableview

    }

}
