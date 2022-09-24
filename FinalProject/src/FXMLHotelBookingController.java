import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.LongProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FXMLHotelBookingController extends FXMLRegisterGuestController implements Serializable, Initializable{

    //configure the table

    @FXML private TableColumn<Guest, String> colName;

    @FXML private TableColumn<Guest, Long> colContact;

    @FXML private TableColumn<Guest, String> colEmail;

    @FXML  private TableColumn<Guest, String> colCheckIn;

    @FXML private TableColumn<Guest, String> colCheckOut;

    @FXML private TableColumn<Guest, Integer> colRoomNo;

    @FXML private static TableView<Guest> tblRecords;

    @FXML private TextField txtSearch;
    @FXML private Button btnRegister;
    @FXML private Button btnOpen;



    static int count = 0;
    static int ctr = 0;

    //write data to file 
    public ObservableList <Guest> guestNew;

    File file;
    FileOutputStream fo;
    FileInputStream fi;
    ObjectInputStream oi;
    ObjectOutputStream os;
    
    @FXML
    public void handleActionRegister(ActionEvent event){
        try{
            Stage stage = (Stage)btnRegister.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("FXMLRegisterGuest.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Hotel Booking System");
            stage.show();
        }

        catch(IOException e){
            System.out.println("cannot load new window");
        }
    }

    public void handleOpenFile(ActionEvent event)throws IOException, ClassNotFoundException{

        FileChooser filechooser = new FileChooser();
        file = filechooser.showOpenDialog(btnOpen.getScene().getWindow());
        fi = new FileInputStream(file.getName());
        oi = new ObjectInputStream(fi);
        
        guestNew = (ObservableList<Guest>)oi.readObject();
        
            tblRecords.setItems(guestNew);
            //tblRecords.setItems();
            //tblRecords.getItems().addAll(guestNew);
        //}
    }

        // public void handleActionDelete(ActionEvent event)throws IOException, ClassNotFoundException{
        //     String s;
        //     for(int i=0; i<guestNew.size(); i++){
        //         //comparing the guest full name from the textfield with the one in the arraylist
        //         s = guestNew.get(i).getFullName();
        //         if(s.equals(txtFullName.getText()))
        //             //we can write a confirmation pop up here
        //             guestNew.remove(i);
                
        //     }
        //     count--;
        //     txtFullName.clear();
        //     txtRoomNo.clear();
        //     txtEmail.clear();
        //     txtCheckIn.clear();
        //     txtCheckOut.clear();
        //     txtContact.clear();

        //     oi.close();
        //     fi.close();
            
        //     fo = new FileOutputStream("test2.dat");
        //     os = new ObjectOutputStream(fo);

        //     //writing updated arraylist. Overwriting existing arraylist in the file
        //     os.writeObject((ArrayList)guestNew);
        //     os.close();
        //     fo.close();
        // }    
        

        @Override
        public void initialize(URL URL,ResourceBundle rb){

            //setting up the columns
            colCheckIn.setCellValueFactory(new PropertyValueFactory<Guest, String>("checkInDate"));
            colCheckOut.setCellValueFactory(new PropertyValueFactory<Guest, String>("checkOutDate"));
            colContact.setCellValueFactory(new PropertyValueFactory<Guest, Long>("contactNumber"));
            colEmail.setCellValueFactory(new PropertyValueFactory<Guest, String>("email"));
            colName.setCellValueFactory(new PropertyValueFactory<Guest, String>("fullName"));
            colRoomNo.setCellValueFactory(new PropertyValueFactory<Guest, Integer>("roomNumber"));
            //tblRecords.setItems((ObservableList<Guest>) guestNew);
            //if(btnSave.isC
            // try {
            //     tblRecords.setItems(handleActionSave());
            // } catch (IOException e) {
            //     System.out.println("Item not added to table successfully" + e.getMessage());
            // }
            

        //     //anonymous inner class
        //     tblRecords.setOnMouseClicked(new javafx.event.EventHandler<MouseEvent>(){
        //         // Stage stage = (Stage)btnRegister.getScene().getWindow();
        //         // stage.setScene(FXMLLoader.load(getClass().getResource("FXMLRegisterGuestController.java")));    

        //         @Override
        //         public void handle(MouseEvent event){

        //             Stage stage = (Stage)btnRegister.getScene().getWindow();
        //             try{
        //                 stage.setScene(FXMLLoader.load(getClass().getResource("FXMLEditInfoController.java")));
        //             }
        //             catch(IOException e){
        //                 System.out.println("Could not load the edit view when clicked" + e.getMessage());
        //             }
        //             Object r = tblRecords.getSelectionModel().getSelectedItem();

        //             //ctr = tblRecords.getSelectionModel().getSelectedItem();
        //             //explivitly type casting from object into guest
        //             txtFullName.setText(((Guest)r).getFullName());
        //             txtEmail.setText(((Guest)r).getEmail());
        //             txtContact.setText(Integer.toString(((Guest)r).getContactNumber()));
        //             txtCheckIn.setText(((Guest)r).getCheckInDate());
        //             txtCheckOut.setText(((Guest)r).getCheckOutDate());
        //             txtRoomNo.setText(Integer.toString(((Guest)r).getRoomNumber()));
                    
        //         }
                
        //     });    
        }
}
