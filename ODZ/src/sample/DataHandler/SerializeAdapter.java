package sample.DataHandler;

import sample.Buyer;

import java.io.*;
import java.util.ArrayList;

public class SerializeAdapter implements IDataAccessor
{
    private String fileName;

    public SerializeAdapter(String fileName)
    {
        this.fileName = fileName;
    }

    public ArrayList<Buyer> readBuyersFromDB()
    {
        ArrayList<Buyer> list = new ArrayList<Buyer>();
        try {
            FileInputStream fileInput = new FileInputStream(fileName);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);

            while (true){           //как нормально проверять?
                Buyer buyer = (Buyer)objectInput.readObject();
                if(buyer == null){
                    break;
                }
                list.add(buyer);
            }
            objectInput.close();
            return list;
        } catch (IOException io){
            System.out.println("io exception: " + io.getMessage());
        } catch (ClassNotFoundException e){
            System.out.println("not fount exception: " + e.getMessage());
        }
        return list;
    }

    public  void writeBuyersToDB(ArrayList<Buyer> list)
    {
        try {
            FileOutputStream fileOutput = new FileOutputStream(fileName, false);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);

            for(int i = 0; i < list.size(); i++){
                Buyer buyer = list.get(i);
                objectOutput.writeObject(buyer);
            }
            objectOutput.flush();
            objectOutput.close();
        }catch (IOException io){
            System.out.println("io exception: " + io.getMessage());
        }
    }
}
