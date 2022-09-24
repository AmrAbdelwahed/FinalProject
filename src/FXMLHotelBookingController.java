import java.beans.EventHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FXMLHotelBookingController extends FXMLRegisterGuestController implements Serializable{
    // public FXMLHotelBookingController(){
    //     super();
    // }

    @FXML 
    private TableColumn<Guest, String> colCheckIn;

    @FXML private TableColumn<Guest, String> colCheckOut;

    @FXML private TableColumn<Guest, Integer> colContact;

    @FXML private TableColumn<Guest, String> colEmail;

    @FXML private TableColumn<Guest, String> colName;

    @FXML private TableColumn<Guest, Integer> colRoomNo;

    @FXML static TableView<Guest> tblRecords;

    @FXML private TextField txtSearch;
    @FXML private Button btnRegister;
    @FXML private Button btnOpen;


    static int count = 0;
    static int ctr = 0;

    //write data to file 
    public static ObservableList <Guest> guestList = FXCollections.observableArrayList();
    //read data from file using filechooser
    public static ObservableList<Guest> guestNew = FXCollections.observableArrayList();

    static File file;
    static FileOutputStream fo;
    static FileInputStream fi;
    static ObjectInputStream oi;
    static ObjectOutputStream os;
    
    @FXML
    public void handleActionRegister(ActionEvent event) throws IOException{
    
        Stage stage = (Stage)btnRegister.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLHotelBooking.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Hotel Booking System");
        stage.show();
        
        
    }

    public void handleOpenFile(ActionEvent event)throws IOException, ClassNotFoundException{

        FileChooser filechooser = new FileChooser();
        file = filechooser.showOpenDialog(btnOpen.getScene().getWindow());
        fi = new FileInputStream(file.getName());
        oi = new ObjectInputStream(fi);

        guestNew = (ObservableList<Guest>)oi.readObject();
        if(!guestNew.isEmpty()){
            //debugging
            System.out.println(guestNew.size());

            Guest g = guestNew.get(0);
            colName.setText(g.getFullName());
            colRoomNo.setText(Integer.toString(g.getRoomNumber()));
            colEmail.setText(g.getEmail());
            colCheckIn.setText(g.getCheckInDate());
            colCheckOut.setText(g.getCheckOutDate());
            colContact.setText(Long.toString(g.getContactNumber()));

            //need to create a for loop to iterate through all elements
            for(int i=1;i<guestNew.size();i++){
                Guest g1 = guestNew.get(i);
                txtFullName.setText(g1.getFullName());
                txtRoomNo.setText(Integer.toString(g1.getRoomNumber()));
                txtEmail.setText(g1.getEmail());
                txtCheckIn.setText(g1.getCheckInDate());
                txtCheckOut.setText(g1.getCheckOutDate());
                txtContact.setText(Long.toString(g1.getContactNumber()));
            }

            //add all records read from the input stream to the table
            tblRecords.setItems(guestNew);
            //tblRecords.getItems().addAll(guestNew);
        }

            //here you can store the complete arraylist into the listview
    }

        public void handleActionDelete(ActionEvent event)throws IOException, ClassNotFoundException{
            String s;
            for(int i=0; i<guestNew.size(); i++){
                //comparing the guest full name from the textfield with the one in the arraylist
                s = guestNew.get(i).getFullName();
                if(s.equals(txtFullName.getText()))
                    //we can write a confirmation pop up here
                    guestNew.remove(i);
                
            }
            count--;
            txtFullName.clear();
            txtRoomNo.clear();
            txtEmail.clear();
            txtCheckIn.clear();
            txtCheckOut.clear();
            txtContact.clear();

            oi.close();
            fi.close();
            
            fo = new FileOutputStream("test2.dat");
            os = new ObjectOutputStream(fo);

            //writing updated arraylist. Overwriting existing arraylist in the file
            os.writeObject(guestNew);
            os.close();
            fo.close();
        }    
        

}
