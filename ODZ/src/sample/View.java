package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class View
{
    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private TextField surnameField;
    @FXML private TextField cardField;
    @FXML private TextField accountField;

    @FXML private TextField fromIntervalField;
    @FXML private TextField toIntervalField;

    @FXML private TextArea outputArea;

    public void addClick()
    {
        outputArea.setText("Add");
    }

    public void removeClick()
    {
        outputArea.setText("Remove");
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
}
