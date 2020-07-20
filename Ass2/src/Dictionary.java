
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS
 */
public class Dictionary {

    TreeEnglish listEnglish = new TreeEnglish();
    TreeVietnam listVietnam = new TreeVietnam();

    public static String getString(String sgt, String acpt1, String acpt2, String err) {
        Scanner sc = new Scanner(System.in);
        String out;
        System.out.println(sgt);
        while (true) {
            out = sc.nextLine();
            if (out.equalsIgnoreCase(acpt1) || out.equalsIgnoreCase(acpt2)) {
                return out;
            } else {
                System.out.println(err);
            }
        }
    }

    public static String getString(String sgt, String err) {
        Scanner sc = new Scanner(System.in);
        String out;
        System.out.println(sgt);
        while (true) {
            out = sc.nextLine();
            if (out == null) {
                System.out.println(err);
            } else {
                return out.trim();
            }
        }
    }

    public static int getNum(String sgt, String err1, String err2, String err3) {
        Scanner sc = new Scanner(System.in);
        String out;
        int num;
        System.out.println(sgt);
        while (true) {
            try {
                out = sc.nextLine();
                num = Integer.parseInt(out);
                if (out == null) {
                    System.out.println(err2);
                }
                if (num < 0) {
                    System.out.println(err3);
                } else {
                    return num;
                }
            } catch (Exception E) {
                System.out.println(err1);
            }
        }
    }

    public static int menu(ArrayList menu) {
        int choice;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).toString());
        }
        while (true) {
            choice = getNum("Choice one: ", "This format must be the number!", "This value can't null", "the input must be greatter than 0");
            if (((choice) > 0) && (choice < menu.size() + 1)) {
                return choice;
            } else {
                System.out.println("1~" + menu.size() + " Please!");
            }
        }
    }

    public void getData() {
        String line;
        try {
            File file = new File("wordlist.txt");
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            while ((line = bf.readLine().toString()) != null) {
                listEnglish.InsertNodeE(line);
                listVietnam.InsertNodeV(line);
            }
            fr.close();
            bf.close();
        } catch (Exception E) {
            System.out.println("File Readed!");
        }
    }

    public void add() {
        String english, viet, exEng, exVni, yn;
        Scanner sc = new Scanner(System.in);
        do {
            StringBuffer string = new StringBuffer();
            english = getString("Enter the English word: ", "Can't null enter the value please!");
            string.append(english).append("; ");
            viet = getString("Enter the Vietnamese meanning: ", "Can't null enter the value please!");
            string.append(viet).append("; ");
            exEng = getString("Enter the English example: ", "Can't null enter the value please!");
            string.append(exEng).append("; ");
            exVni = getString("Enter the Vietnamese example: ", "Can't null enter the value please!");
            string.append(exVni);
            listEnglish.InsertNodeE(string.toString());
            listVietnam.InsertNodeV(string.toString());
            System.out.println("**************Data Inserted!***************");
            yn = getString("Do you want to insert more?(choose y/n)", "y", "n", "Y/N please!");
        } while (yn.equalsIgnoreCase("y"));
    }

    public void find() {
        String findE, findV;
        ArrayList menu = new ArrayList();
        menu.add("Find by english");
        menu.add("Find by Vietnam");
        int choice = menu(menu);
        switch (choice) {
            case 1: {
                findE = getString("Enter the English word to find: ", "This value can't null");
                listEnglish.SearchNodeE(findE);
            }
            break;
            case 2: {
                findV = getString("Enter the Vietnamese meanning of finding word: ", "This value can't null");
                listVietnam.SearchNodeV(findV);
            }
            break;
        }
    }

    public void delete() {
        String DeleteE, DeleteV, yn1, yn2;
        ArrayList menu = new ArrayList();
        menu.add("Delete by english");
        menu.add("Delete by Vietnam");
        int choice = menu(menu);
        switch (choice) {
            case 1: {
                DeleteE = getString("Enter the English word to delete: ", "This value can't empty");
                String temp = listEnglish.SearchNodeE(listEnglish.root, DeleteE);
                StringTokenizer str = new StringTokenizer(temp, ";");
                String temp1 = str.nextToken();
                String vni = str.nextToken();
                listEnglish.SearchNodeE(DeleteE);
                yn1 = getString("Are you sure to delete that?(Y/N)", "y", "n", "Y/N only");
                if (yn1.equalsIgnoreCase("y")) {
                    listEnglish.deleteNodeE(DeleteE);
                    listVietnam.deleteNodeV(vni.trim());
                }
            }
            break;
            case 2: {
                DeleteV = getString("Enter the Vietnamease meanning of deleting word: ", "Thí value can't be null");
                String temp = listVietnam.SearchNodeV(listVietnam.root, DeleteV);
                StringTokenizer str = new StringTokenizer(temp, ";");
                String temp1 = str.nextToken();
                String eng = str.nextToken();
                listVietnam.SearchNodeV(DeleteV);
                yn2 = getString("Are you sure to delete that?(Y/N)", "y", "n", "Y/N only");
                if (yn2.equalsIgnoreCase("y")) {
                    listVietnam.deleteNodeV(DeleteV);
                    listEnglish.deleteNodeE(eng);
                }
            }
        }
    }

    public void save() {
        File file = new File("wordlist.txt");
        listEnglish.BreadthOrder(listEnglish.root, file);
    }

    public void outall() {
        listEnglish.BreadthOrder(listEnglish.root);
    }
}
