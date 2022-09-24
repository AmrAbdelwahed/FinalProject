import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLEditInfoController extends FXMLHotelBookingController implements Serializable{

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSave;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtEmail;

    @FXML
    void handleActionBack(ActionEvent event) {

    }

    @FXML
    public void handleActionDelete(ActionEvent event)throws IOException, ClassNotFoundException {
        String s;
            for(int i=0; i<guestNew.size(); i++){
                //comparing the guest full name from the textfield with the one in the arraylist
                s = guestNew.get(i).getFullName();
                if(s.equals(txtFullName.getText()))
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

    @FXML
    void handleActionEdit(ActionEvent event) {

    }

    @FXML
    void handleActionSave(ActionEvent event) throws IOException{
        //private FXMLHotelBookingController c1 = new FXMLHotelBookingController();
        
        //debugging
        System.out.println(guestList.size());

        fo = new FileOutputStream("records.dat");
        os = new ObjectOutputStream(fo);
        //added the whole array as an object into the file
        os.writeObject(guestList);

        //when savebutton is clicked go back to tableview main page
        // Stage stage = (Stage)btnSave.getScene().getWindow();
        // stage.setScene(FXMLLoader.load(getClass().getResource("FXMLHotelBookingController.java")));
    }

    @FXML
    void txtEmail(ActionEvent event) {

    }


}
