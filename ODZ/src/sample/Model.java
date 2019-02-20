package sample;

import java.util.ArrayList;

public class Model
{
    ArrayList<Buyer> buyers;

    public Model()
    {
        buyers = new ArrayList<Buyer>();
    }

    //==========================================================================
    //  interaction methods
    //==========================================================================
    public void addNewBuyer(int id, String name, String surname, int card, int account)
    {
        Buyer buyer = new Buyer(id, name, surname, card, account);
        buyers.add(buyer);
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

    public Buyer getBuyersByName(String name)
    {
        return null;
    }
}


