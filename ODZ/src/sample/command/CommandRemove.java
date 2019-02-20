package sample.command;

import sample.Controller;
import sample.Model;

public class CommandRemove implements ICommand
{
    public void execute(Controller controller, Model model)
    {
        int id = controller.getIdByForm();
        String name = controller.getNameByForm();
        String surname = controller.getSurnameByForm();
        int card = controller.getCardByForm();
        int account = controller.getAccountByForm();
    }
}
