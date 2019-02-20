package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.command.CommandAdd;
import sample.command.CommandRemove;
import sample.command.ICommand;

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
        outputArea.setText("Edit");
    }

    public void showClick()
    {
        outputArea.setText("Show");
    }

    public void alphabeticSortClick()
    {
        outputArea.setText("Sort");
    }

    public void showListInIntervalClick()
    {
        outputArea.setText("List in interval");
    }

    private void sendCommand(ICommand cmd)
    {
        try{
            cmd.execute(this, model);
        }
        catch (Throwable e){
            addTextOutputArea("Error: " + e.toString());
        }
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

    public void setTextOutputArea(String text)
    {
        outputArea.setText(text + "\n");
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
