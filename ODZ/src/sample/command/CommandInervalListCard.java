package sample.command;

import sample.Buyer;
import sample.Controller;
import sample.Model;

import java.util.List;

public class CommandInervalListCard implements ICommand
{
    public void execute(Controller controller, Model model)
    {
        try{
            int cardFrom = controller.getFromIntervalByForm();
            int cardTo = controller.getToIntervalByForm();

            List<Buyer> buyers = model.getBuyers();
            for(int i = 0; i < buyers.size(); i++){
                if(cardFrom <= buyers.get(i).getCard() && cardTo >= buyers.get(i).getCard()){
                    controller.addTextOutputArea(buyers.get(i).getInfo());
                }
            }
        }
        catch (Throwable e){
            controller.addTextOutputArea("Error: " + e.toString());
        }
    }
}
