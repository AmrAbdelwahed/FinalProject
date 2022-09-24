// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.io.ObjectOutputStream;
// import java.io.Serializable;
// import java.util.Optional;

// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.control.Alert;
// import javafx.scene.control.Button;
// import javafx.scene.control.ButtonType;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.scene.control.Alert.AlertType;
// import javafx.stage.Stage;

// public class FXMLEditInfoController extends FXMLHotelBookingController{

//     @FXML
//     private Button btnBack;

//     @FXML
//     private Button btnDelete;

//     @FXML
//     private Button btnEdit;

//     @FXML
//     private Button btnSave;

//     @FXML 
//     TextField txtInput;
//     @FXML  
//     Label lblStatus;
//     String titleTxt="Alert Dialog Example";
//     // FileOutputStream fo;
//     // ObjectOutputStream os;

//     @FXML
//     void handleActionBack(ActionEvent event) {

//     }

//     @FXML
//     public void handleActionDelete(ActionEvent event)throws IOException, ClassNotFoundException {
       
//         Alert alert = new Alert(AlertType.CONFIRMATION);
//         alert.setTitle(titleTxt);
//         String st = "Confirm to clear text in text field ! ";
//         alert.setContentText(st);

//         Optional<ButtonType> result = alert.showAndWait();

//         if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
//             for(int i=0; i<guestNew.size(); i++){
//                 //comparing the guest full name from the textfield with the one in the arraylist
//                String s = guestNew.get(i).getFullName();
//                 if(s.equals(txtFullName.getText()))
//                    guestNew.remove(i);
//             }
//             txtFullName.clear();
//             txtRoomNo.clear();
//             txtEmail.clear();
//             txtCheckIn.clear();
//             txtCheckOut.clear();
//             txtContact.clear();
    
//             oi.close();
//             fi.close();
            
//             fo = new FileOutputStream("record2.dat");
//             os = new ObjectOutputStream(fo);
//             os.writeObject(guestNew);
//             os.close();
//             fo.close();
//             txtInput.setText("");
//             lblStatus.setText("An example of Alert Dialogs. Enter some text and save.");
//             txtInput.requestFocus();
//         }
//         else{
//             lblStatus.setText("");
//         }
//     }

//     @FXML
//    public void handleActionEdit(ActionEvent event) {

//     }

//     @FXML
//     void handleActionSave(ActionEvent event) throws IOException{
//         //private FXMLHotelBookingController c1 = new FXMLHotelBookingController();
        
//         //debugging
//         // System.out.println(guestList.size());

//         // fo = new FileOutputStream("records.dat");
//         // os = new ObjectOutputStream(fo);
//         //added the whole array as an object into the file
//         //os.writeObject(guestList);

//         //when savebutton is clicked go back to tableview main page
//         // Stage stage = (Stage)btnSave.getScene().getWindow();
//         // stage.setScene(FXMLLoader.load(getClass().getResource("FXMLHotelBookingController.java")));
//     }



    


// }
