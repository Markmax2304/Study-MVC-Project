package sample;

import java.util.ArrayList;

public class Model
{
    ArrayList<Buyer> buyers;

    public Model()
    {
        buyers = new ArrayList<>();
    }
}

class Buyer
{
    private int id;
    private String name;
    private String surname;
    private int cardNumber;
    private int accountNumber;

    public Buyer(int id, String name, String surname, int cardNumber, int accountNumber)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
    }

    public String getInfo()
    {
        StringBuilder info = new StringBuilder();
        return info.append(name).append(" ").append(surname).append(": Card number = ").append(cardNumber).
                append(", Account number = ").append(accountNumber).append("\n").toString();
    }

    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getSurname()
    {
        return surname;
    }
    public int getCard()
    {
        return cardNumber;
    }
    public int getAccount()
    {
        return accountNumber;
    }

    public void setName(String value)
    {
        name = value;
    }
    public void setSurname(String value)
    {
        surname = value;
    }
    public void setCard(int value)
    {
        cardNumber = value;
    }
    public void setAccount(int value)
    {
        accountNumber = value;
    }
}
