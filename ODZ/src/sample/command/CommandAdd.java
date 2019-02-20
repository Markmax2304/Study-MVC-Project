package sample.command;

import sample.Buyer;
import sample.Controller;
import sample.Model;

public class CommandAdd implements ICommand
{
    public void execute(Controller controller, Model model)
    {
        int id = controller.getIdByForm();
        String name = controller.getNameByForm();
        String surname = controller.getSurnameByForm();
        int card = controller.getCardByForm();
        int account = controller.getAccountByForm();

        if(model.existBuyerId(id)){
            throw new Error("Adding: this id is already exist.");
        }

        model.addNewBuyer(id, name, surname, card, account);
        Buyer buyer = model.getBuyerById(id);
        if(buyer == null){                                                  //excess
            throw new Error("Adding: new object didn't create.");
        }

        controller.addTextOutputArea("Added: " + buyer.getInfo());
        controller.clearInputForm();
    }
}
