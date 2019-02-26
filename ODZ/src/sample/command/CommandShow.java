package sample.command;

import sample.Buyer;
import sample.Controller;
import sample.Model;

import java.util.ArrayList;

public class CommandShow implements ICommand
{
    public void execute(Controller controller, Model model)
    {
        try {
            int id = controller.getIdByForm();
            showById(controller, model, id);
        }
        catch (Throwable e1) {
            try {
                String name = controller.getNameByForm();
                showByName(controller, model, name);
            }
            catch (Throwable e2) {
                try {
                    String surname = controller.getSurnameByForm();
                    showBySurname(controller, model, surname);
                }
                catch (Throwable e3) {
                    try {
                        int card = controller.getCardByForm();
                        showByCard(controller, model, card);
                    }
                    catch (Throwable e4) {
                        try {
                            int account = controller.getAccountByForm();
                            showByAccount(controller, model, account);
                        }
                        catch (Throwable e5){
                            showAll(controller, model);
                        }
                    }
                }
            }
        }
    }

    private void showById(Controller controller, Model model, int id)
    {
        Buyer buyer = model.getBuyerById(id);
        if(buyer == null){
            controller.addTextOutputArea("Buyer with such Id didn't find.");
        }
        controller.addTextOutputArea(buyer.getInfo());
    }

    private void showByName(Controller controller, Model model, String name)
    {
        ArrayList<Buyer> buyers = model.getBuyersByName(name);
        if(buyers.size() == 0){
            controller.addTextOutputArea("We don't have any buyer records whit such name.");
        }

        for(int i = 0; i < buyers.size(); i++){
            controller.addTextOutputArea(buyers.get(i).getInfo());
        }
    }

    private void showBySurname(Controller controller, Model model, String surname)
    {
        ArrayList<Buyer> buyers = model.getBuyersBySurname(surname);
        if(buyers.size() == 0){
            controller.addTextOutputArea("We don't have any buyer records with such surname.");
        }

        for(int i = 0; i < buyers.size(); i++){
            controller.addTextOutputArea(buyers.get(i).getInfo());
        }
    }

    private void showByCard(Controller controller, Model model, int card)
    {
        ArrayList<Buyer> buyers = model.getBuyersByCard(card);
        if(buyers.size() == 0){
            controller.addTextOutputArea("We don't have any buyer records with such card number.");
        }

        for(int i = 0; i < buyers.size(); i++){
            controller.addTextOutputArea(buyers.get(i).getInfo());
        }
    }

    private void showByAccount(Controller controller, Model model, int account)
    {
        ArrayList<Buyer> buyers = model.getBuyersByAccount(account);
        if(buyers.size() == 0){
            controller.addTextOutputArea("We don't have any buyer records with such account number.");
        }

        for(int i = 0; i < buyers.size(); i++){
            controller.addTextOutputArea(buyers.get(i).getInfo());
        }
    }

    private void showAll(Controller controller, Model model)
    {
        ArrayList<Buyer> buyers = model.getBuyers();
        if(buyers.size() == 0){
            controller.addTextOutputArea("We don't have any buyer records.");
        }

        for(int i = 0; i < buyers.size(); i++){
            controller.addTextOutputArea(buyers.get(i).getInfo());
        }
    }
}
