
import static java.lang.System.exit;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        Dictionary dic = new Dictionary();
        ArrayList menu = new ArrayList();
        menu.add("Search word");
        menu.add("Add a new word");
        menu.add("Remove word");
        menu.add("Save file");
        menu.add("Show all word added");
        menu.add("Quit");
        int choice;
        dic.getData();
        do {
            choice = Dictionary.menu(menu);
            switch (choice) {
                case 1: {
                    dic.find();
                }
                break;
                case 2: {
                    dic.add();
                }
                break;
                case 3: {
                    try {
                        dic.delete();
                    } catch (Exception E) {
                        System.out.println("This word isn't exist in this list");
                    }
                }
                break;
                case 4: {
                    dic.save();
                }
                break;
                case 5: {
                    dic.outall();
                }
                break;
                case 6: {
                    String yn = Dictionary.getString("Do you want to save your data before exit? (Y/N)", "y", "n", "Y/N only");
                    if (yn.equalsIgnoreCase("y")) {
                        dic.save();
                    }
                    exit(0);
                }
            }
        } while (true);
    }
}
