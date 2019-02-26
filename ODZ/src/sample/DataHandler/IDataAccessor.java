package sample.DataHandler;

import sample.Buyer;

import java.io.IOException;
import java.util.ArrayList;

public interface IDataAccessor
{
    public ArrayList<Buyer> readBuyersFromDB();
    public  void writeBuyersToDB(ArrayList<Buyer> list);
}
