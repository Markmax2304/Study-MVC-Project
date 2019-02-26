package sample.command;

import sample.Buyer;
import sample.Controller;
import sample.Model;

public class CommandEdit implements ICommand
{
    public void execute(Controller controller, Model model)
    {
        try {
            int id = controller.getIdByForm();
            String name = controller.getNameByForm();
            String surname = controller.getSurnameByForm();
            int card = controller.getCardByForm();
            int account = controller.getAccountByForm();

            Buyer buyer = model.getBuyerById(id);
            String oldInfo = buyer.getInfo();
            if(buyer == null){
                throw new Error("Editing: object with this id is not exist.");
            }

            buyer.setName(name);
            buyer.setSurname(surname);
            buyer.setCard(card);
            buyer.setAccount(account);

            controller.addTextOutputArea("Edited: " + oldInfo + "  =>  " + buyer.getInfo());
        } catch (Throwable e) {
            controller.addTextOutputArea("Error: " + e.toString());
        }
    }
}
