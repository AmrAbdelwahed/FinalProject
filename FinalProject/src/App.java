import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLHotelBooking.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLRegisterGuest.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLEditInfo.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Hotel Booking System");
        stage.show();

    }

}
