package sample.command;

import sample.Buyer;
import sample.Controller;
import sample.Model;

import java.util.List;

public class CommandAlphanumericSort implements ICommand
{
    public void execute(Controller controller, Model model)
    {
        try{
            List<Buyer> buyers = (List<Buyer>) model.getBuyers().clone();
            buyers.sort((a, b) -> a.getName().compareTo(b.getName()));
            for(int i = 0; i < buyers.size(); i++){
                controller.addTextOutputArea(i + ") " + buyers.get(i).getInfo());
            }
        }
        catch (Throwable e){
            controller.addTextOutputArea("Error: " + e.toString());
        }
    }
}
