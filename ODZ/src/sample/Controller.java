package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.command.*;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Controller
{
    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private TextField surnameField;
    @FXML private TextField cardField;
    @FXML private TextField accountField;

    @FXML private TextField fromIntervalField;
    @FXML private TextField toIntervalField;

    @FXML private TextArea outputArea;

    private Model model = new Model();

    //==========================================================================
    //  button events
    //==========================================================================
    public void addClick()
    {
        sendCommand(new CommandAdd());
    }

    public void removeClick()
    {
        sendCommand(new CommandRemove());
    }

    public void editClick()
    {
        sendCommand(new CommandEdit());
    }

    public void showClick()
    {
        sendCommand(new CommandShow());
    }

    public void alphabeticSortClick()
    {
        outputArea.setText("Sort");
    }

    public void showListInIntervalClick()
    {
        outputArea.setText("List in interval");
    }

    public void clearOutputClick()
    {
        outputArea.clear();
    }

    public void selectTextField(MouseEvent e)
    {
        TextField field = (TextField)e.getSource();
        field.selectAll();          //select on each click - bug
    }

    public void saveModelData()
    {
        model.saveData();
    }

    private void sendCommand(ICommand cmd)
    {
        cmd.execute(this, model);
    }

    //==========================================================================
    //  interaction methods
    //==========================================================================
    public int getIdByForm()
    {
        if(idField.getText() == null || idField.getText().trim().isEmpty()){
            throw new Error("Id field is empty.");
        }
        return Integer.parseInt(idField.getText());
    }

    public String getNameByForm()
    {
        if(nameField.getText() == null || nameField.getText().trim().isEmpty()){
            throw new Error("Name field is empty.");
        }
        return nameField.getText();
    }

    public String getSurnameByForm()
    {
        if(surnameField.getText() == null || surnameField.getText().trim().isEmpty()){
            throw new Error("Surname field is empty.");
        }
        return surnameField.getText();
    }

    public int getCardByForm()
    {
        if(cardField.getText() == null || cardField.getText().trim().isEmpty()){
            throw new Error("Card field is empty.");
        }
        return Integer.parseInt(cardField.getText());
    }

    public int getAccountByForm()
    {
        if(accountField.getText() == null || accountField.getText().trim().isEmpty()){
            throw new Error("Account field is empty.");
        }
        return Integer.parseInt(accountField.getText());
    }

    public int getFromIntervalByForm()
    {
        if(fromIntervalField.getText() == null || fromIntervalField.getText().trim().isEmpty()){
            throw new Error("FromInterval field is empty.");
        }
        return Integer.parseInt(fromIntervalField.getText());
    }

    public int getToIntervalByForm()
    {
        if(toIntervalField.getText() == null || toIntervalField.getText().trim().isEmpty()){
            throw new Error("ToInterval field is empty.");
        }
        return Integer.parseInt(toIntervalField.getText());
    }

    public void addTextOutputArea(String text)
    {
        String textArea = outputArea.getText();
        outputArea.setText(textArea + text + "\n");
    }

    public void clearInputForm()
    {
        idField.clear();
        nameField.clear();
        surnameField.clear();
        cardField.clear();
        accountField.clear();
    }

    public void clearIntervalForm()
    {
        fromIntervalField.clear();
        toIntervalField.clear();
    }
}
