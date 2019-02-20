package sample.command;

import sample.Controller;
import sample.Model;

public interface ICommand
{
    public void execute(Controller controller, Model model);
}
