package sample;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;

public class Login {

    public Button btnExit,btnLogin;
    public TextField txtUsername, txtPass;
    public WebView webView;

    public void initialize(){
        txtUsername.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!(txtUsername.getText().isEmpty())){
                    txtPass.setDisable(false);
                }
            }
        });

        txtPass.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!(txtPass.getText().isEmpty())){
                    btnLogin.setDisable(false);
                }
            }
        });

        txtUsername.requestFocus();

        //webView = new WebView();

        WebEngine engine = webView.getEngine();
        engine.load("https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fe-11-156fcd3fa501b4a1aa50ee8ba6543fbd-ce65ac9fde0b9239ecbe088a5bce66fcefca39c8&flowName=GlifWebSignIn&flowEntry=SignUp");
    }

    public void btnLoginPressed(ActionEvent event) {

        Login test =  new Login();
        Login test2 =  new Login();
        String email =  txtUsername.getText();
        String pwd =  txtPass.getText();
        boolean isValid =  test.validateEmail(email);
        test.printStatus(email,isValid);
        if (isValid) {
            changeScreen(isValid, email,pwd);
        }
        else
        {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Unable to log you in");
            a.setContentText("Please check your username and password and try again");
            a.showAndWait();
            txtPass.clear();
        }


    }

    private void changeScreen(boolean isValid, String email,String pwd) {

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Welcome "+ email);
        a.setContentText("Logging you in");
        a.showAndWait();

        try {
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("email.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage newStage = new Stage();
            newStage.initStyle(StageStyle.TRANSPARENT);
            newStage.setTitle("Email");
            newStage.setScene(new Scene(root1));
            newStage.show();


            Application app =  fxmlLoader.getController();
            app.initialize(email,pwd);
        } catch (IOException e) {
          //  e.printStackTrace();
        }

    }



    private boolean validateEmail(String email) {
        boolean isValid = false;
        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
            isValid = true;
        } catch (AddressException e) {
            System.out.println("You are in catch block -- Exception Occurred for: " + email);
        }
        return isValid;

    }
    public void btnExitPressed(ActionEvent event) {
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.close();
    }

        private void printStatus(String email, boolean valid) {
        System.out.println(email + " is " + (valid ? "a" : "not a") +
                " valid email address");

    }

}
