package sample.command;

import sample.Buyer;
import sample.Controller;
import sample.Model;

public class CommandRemove implements ICommand
{
    public void execute(Controller controller, Model model)
    {
        try {
            int id = controller.getIdByForm();

            Buyer buyer = model.getBuyerById(id);
            if(buyer == null){
                throw new Error("Removing: object with this id is not exist.");
            }
            model.removeBuyerById(id);

            controller.addTextOutputArea("Removed: " + buyer.getInfo());
        } catch (Throwable e) {
            controller.addTextOutputArea("Error: " + e.toString());
        }
    }
}
