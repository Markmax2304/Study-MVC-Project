package sample;

import sample.DataHandler.IDataAccessor;
import sample.DataHandler.SerializeAdapter;

import java.util.ArrayList;

public class Model
{
    ArrayList<Buyer> buyers;
    IDataAccessor dataAccessor;

    public Model()
    {
        dataAccessor = new SerializeAdapter("D:\\My_documents\\Java_projects\\Study-MVC-Project\\ODZ\\DB.dat");
        buyers = dataAccessor.readBuyersFromDB();
    }

    public void saveData()
    {
        dataAccessor.writeBuyersToDB(buyers);
    }

    //==========================================================================
    //  interaction methods
    //==========================================================================
    public void addNewBuyer(int id, String name, String surname, int card, int account)
    {
        Buyer buyer = new Buyer(id, name, surname, card, account);
        buyers.add(buyer);
    }

    public void removeBuyerById(int id)
    {
        for(int i = 0; i < buyers.size(); i++){
            if(buyers.get(i).getId() == id){
                buyers.remove(i);
                return;
            }
        }
    }

    public boolean existBuyerId(int id)
    {
        for(int i = 0; i < buyers.size(); i++){
            if(buyers.get(i).getId() == id){
                return true;
            }
        }
        return false;
    }

    public Buyer getBuyerById(int id)
    {
        for(int i = 0; i < buyers.size(); i++){
            if(buyers.get(i).getId() == id){
                return  buyers.get(i);
            }
        }
        return null;
    }

    public ArrayList<Buyer> getBuyersByName(String name)
    {
        ArrayList<Buyer> buyersByNameList = new ArrayList<Buyer>();
        for(int i = 0; i < buyers.size(); i++){
            Buyer buyer = buyers.get(i);
            if(name.equals(buyer.getName())){
                buyersByNameList.add(buyer);
            }
        }
        return  buyersByNameList;
    }

    public ArrayList<Buyer> getBuyersBySurname(String surname)
    {
        ArrayList<Buyer> buyersBySurnameList = new ArrayList<Buyer>();
        for(int i = 0; i < buyers.size(); i++){
            Buyer buyer = buyers.get(i);
            if(surname.equals(buyer.getSurname())){
                buyersBySurnameList.add(buyer);
            }
        }
        return  buyersBySurnameList;
    }

    public ArrayList<Buyer> getBuyersByCard(int card)
    {
        ArrayList<Buyer> buyersByCardList = new ArrayList<Buyer>();
        for(int i = 0; i < buyers.size(); i++){
            Buyer buyer = buyers.get(i);
            if(buyer.getCard() == card){
                buyersByCardList.add(buyer);
            }
        }
        return  buyersByCardList;
    }

    public ArrayList<Buyer> getBuyersByAccount(int account)
    {
        ArrayList<Buyer> buyersByAccountList = new ArrayList<Buyer>();
        for(int i = 0; i < buyers.size(); i++){
            Buyer buyer = buyers.get(i);
            if(buyer.getAccount() == account){
                buyersByAccountList.add(buyer);
            }
        }
        return  buyersByAccountList;
    }

    public ArrayList<Buyer> getBuyers()
    {
        return buyers;
    }
}


