package police.commissioner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Collector;

public class Commissioner {
    int id;
    String name;
    String d1;
    String d2;
    String UnderCustody;
    int id1;
    String name1;
    String cm;

    private static String pathOfDatabase;

    public Commissioner() {
    }

    public Commissioner(int id, String name, String d1, String d2, String UnderCustody) {
        this.id = id;
        this.name = name;
        this.d1 = d1;
        this.d2 = d2;
        this.UnderCustody = UnderCustody;
    }

    public Commissioner(int id1, String name1, String cm) {
        this.id1 = id1;
        this.name1 = name1;
        this.cm = cm;
    }

    public void commissioner(String pathOfDatabase) throws IOException {
        Scanner sc = new Scanner(System.in);
        String k[] = { "Comissionor ID :", "NAME :", "PHONE NO. :", "Gmail :" };
        int len = k.length;

        int n;
        String UserId;
        String password;
        // FileReader fd1 = new FileReader(pathOfDatabase+"\\ComCred.txt");
        // BufferedReader br1 = new BufferedReader(fd1);
        // ArrayList ar = new ArrayList();
        // String line;
        // while((line=br1.readLine())!=null){
        // ar.add(line);
        // }

        // System.out.println("Enter the USER ID and PASSWORD to access :");
        // System.out.println("---------------------------------------------------------------
        // :");
        // UserId = sc.next();
        // password = sc.next();
        // if(UserId.equals(ar.get(0)) && password.equals(ar.get(1)) )
        // if (true) {
            System.out.println("----------------------------------------------------------- :");
            System.out.println("Comissionar Details :");
            System.out.println("----------------------------------------------------------- :");
            FileReader fd2 = new FileReader(pathOfDatabase + "\\commissioner.txt");
            BufferedReader br2 = new BufferedReader(fd2);
            ArrayList ar2 = new ArrayList();
            String line1 = "";
            while ((line1 = br2.readLine()) != null) {
                ar2.add(line1);
            }
            int l = ar2.size();
            for (int i = 0; i < l; i++) {
                System.out.println(k[i] + " " + ar2.get(i));
            }
            System.out.println("----------------------------------------------------------- :");
            do {
                System.out.println("PRESS 1 :To Access Criminals Files");
                System.out.println("PRESS 2 :To Acess Police Officers Files");
                System.out.println("PRESS 3 :To Exit");
                System.out.println("------------------------------------------------------- :");
                n = sc.nextInt();

                // To Access Criminals Files
                switch (n) {
                    case 1:
                        FileReader fr = new FileReader(pathOfDatabase + "\\criminal.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String s = "";
                        ArrayList<Commissioner> list = new ArrayList<Commissioner>();
                        String arr[];
                        int id = 0;
                        String name = "";
                        String d1 = "";
                        String d2 = "";
                        String UnderCustody = "";
                        br.readLine();
                        while ((s = br.readLine()) != null) {
                            arr = s.split(",");
                            id = (Integer.parseInt(arr[0]));
                            name = (arr[1]);
                            d1 = (arr[2]);
                            d2 = (arr[3]);
                            UnderCustody = (arr[4]);
                            list.add(new Commissioner(id, name, d1, d2, UnderCustody));
                        }
                        int m;
                        do {
                            System.out.println("--------------------------------------------------- :");
                            System.out.println("PRESS 1 :To view Criminal Details");
                            System.out.println("PRESS 2 :To update crime type of criminal");
                            System.out.println("PRESS 3 :To update status of criminal");
                            System.out.println("PRESS 4 :To update undercustody details");
                            System.out.println("PRESS 5 :To add criminal details");
                            System.out.println("PRESS 6 :To Exit");
                            System.out.println("--------------------------------------------------- :");
                            m = sc.nextInt();
                            switch (m) {

                                // To view Criminal Details
                                case 1:
                                    for (int i = 0; i < list.size(); i++) {
                                        System.out.println("CRIMINAL ID : " + list.get(i).id);
                                        System.out.println("NAME : " + list.get(i).name);
                                        System.out.println("CRIME : " + list.get(i).d1);
                                        System.out.println("CATEGORY : " + list.get(i).d2);
                                        System.out.println("UNDER_CUSTODY : " + list.get(i).UnderCustody);
                                        System.out.println();
                                    }
                                    break;

                                // To update crime type of criminal
                                case 2:
                                    System.out.println("--------------------------------------------------- :");
                                    FileWriter fw = new FileWriter(pathOfDatabase + "\\criminal.txt");
                                    fw.write("id,name,crime,category,custody\n");
                                    System.out.println("Update crime category by entering new crime name :");
                                    sc.nextLine();
                                    String crime1 = sc.nextLine();
                                    System.out.println("Enter the ID to be modified");
                                    int k1 = sc.nextInt();
                                    System.out.println("--------------------------------------------------- :");
                                    for (int i = 0; i < list.size(); i++) {
                                        if (list.get(i).id == k1) {
                                            list.get(i).d1 = crime1;
                                        }
                                        fw.write(Integer.toString(list.get(i).id) + "," + list.get(i).name + ","
                                                + list.get(i).d1 + "," + list.get(i).d2 + "," + list.get(i).UnderCustody
                                                + "\n");
                                    }
                                    System.out.println("UPDATED SUCCESSFULLY :");
                                    fw.flush();
                                    fw.close();
                                    break;

                                // To update category of criminal
                                case 3:
                                    System.out.println("--------------------------------------------------- :");
                                    FileWriter fw2 = new FileWriter(pathOfDatabase + "\\criminal.txt");
                                    fw2.write("id,name,crime,category,custody\n");
                                    System.out.println("Update Category :");
                                    String category = sc.next();
                                    System.out.println("Enter the ID to be modified");
                                    int k2 = sc.nextInt();
                                    System.out.println("--------------------------------------------------- :");
                                    for (int i = 0; i < list.size(); i++) {
                                        if (list.get(i).id == k2) {
                                            list.get(i).d2 = category;
                                        }
                                        fw2.write(Integer.toString(list.get(i).id) + "," + list.get(i).name + ","
                                                + list.get(i).d1 + "," + list.get(i).d2 + "," + list.get(i).UnderCustody
                                                + "\n");
                                    }
                                    System.out.println("UPDATED SUCCESSFULLY :");
                                    fw2.flush();
                                    fw2.close();
                                    break;

                                // To update undercustody details
                                case 4:
                                    System.out.println("--------------------------------------------------- :");
                                    FileWriter fw3 = new FileWriter(pathOfDatabase + "\\criminal.txt");
                                    fw3.write("id,name,crime,category,custody\n");
                                    System.out.println("Update status of  Under-custody :");
                                    String UnderCustody1 = sc.next();
                                    System.out.println("Enter the ID to be modified");
                                    int k3 = sc.nextInt();
                                    System.out.println("--------------------------------------------------- :");
                                    for (int i = 0; i < list.size(); i++) {
                                        if (list.get(i).id == k3) {
                                            list.get(i).UnderCustody = UnderCustody1;
                                        }
                                        fw3.write(Integer.toString(list.get(i).id) + "," + list.get(i).name + ","
                                                + list.get(i).d1 + "," + list.get(i).d2 + "," + list.get(i).UnderCustody
                                                + "\n");
                                    }
                                    System.out.println("UPDATED SUCCESSFULLY :");
                                    fw3.flush();
                                    fw3.close();
                                    break;

                                // To add criminal details
                                case 5:
                                    System.out.println("--------------------------------------------------- :");
                                    FileWriter fw1 = new FileWriter(pathOfDatabase + "\\criminal.txt", true);
                                    System.out.println("Enter the ID of the criminal :");
                                    int ID = sc.nextInt();
                                    System.out.println("Enter the name of the criminal :");
                                    String name1 = sc.next();
                                    System.out.println("Enter the crime of the criminal :");
                                    String crime2 = sc.next();
                                    System.out.println("Enter the status of the criminal :");
                                    String category1 = sc.next();
                                    System.out.println("Enter the Under Custody of the criminal :");
                                    String UnderCustody2 = sc.next();
                                    System.out.print("\n");

                                    fw1.write(ID + ",");
                                    fw1.write(name1 + ",");
                                    fw1.write(crime2 + ",");
                                    fw1.write(category1 + ",");
                                    fw1.write(UnderCustody2);
                                    System.out.println("--------------------------------------------------- :");
                                    System.out.println("Details added successfulyy");
                                    fw1.flush();
                                    fw1.close();
                                    break;
                            }
                        } while (m < 6);
                        br.close();
                        fr.close();
                        break;

                    // To Acess Police Officers Files
                    case 2:
                        FileReader fr2 = new FileReader(pathOfDatabase + "\\Police.txt");
                        BufferedReader br3 = new BufferedReader(fr2);
                        String s1 = "";
                        ArrayList<Commissioner> list1 = new ArrayList<Commissioner>();
                        String arr1[];
                        int id1 = 0;
                        String name1 = "";
                        String cm = "";

                        br3.readLine();
                        while ((s1 = br3.readLine()) != null) {
                            arr1 = s1.split(",");
                            id1 = (Integer.parseInt(arr1[0]));
                            name1 = (arr1[1]);
                            cm = (arr1[2]);
                            list1.add(new Commissioner(id1, name1, cm));
                        }
                        int m1;
                        do {
                            System.out.println("--------------------------------------------------- :");
                            System.out.println("PRESS 1 :To view Police Details");
                            System.out.println("PRESS 2 :To update mission");
                            // System.out.println("PRESS 3 :To add police details");
                            System.out.println("PRESS 3 :To Exit");
                            System.out.println("--------------------------------------------------- :");
                            m1 = sc.nextInt();
                            switch (m1) {

                                // To view Police Details
                                case 1:
                                    for (int i = 0; i < list1.size(); i++) {
                                        System.out.println("POLICE ID : " + list1.get(i).id1);
                                        System.out.println("NAME : " + list1.get(i).name1);
                                        System.out.println("MISSION : " + list1.get(i).cm);
                                        System.out.println();
                                    }
                                    break;

                                // To update mission
                                case 2:
                                    System.out.println("--------------------------------------------------- :");
                                    FileWriter fw3 = new FileWriter(pathOfDatabase + "\\Police.txt");
                                    fw3.write("id,name,task\n");
                                    System.out.println("Update mission:");
                                    String mission = sc.next();
                                    System.out.println("Enter the ID to be modified");
                                    int k9 = sc.nextInt();
                                    System.out.println("--------------------------------------------------- :");
                                    for (int i = 0; i < list1.size(); i++) {
                                        if (list1.get(i).id1 == k9) {
                                            list1.get(i).cm = mission;
                                        }
                                        fw3.write(Integer.toString(list1.get(i).id1) + "," + list1.get(i).name1 + ","
                                                + list1.get(i).cm + "\n");
                                    }
                                    System.out.println("UPDATED SUCCESSFULLY :");
                                    fw3.flush();
                                    fw3.close();
                                    break;

                                // To add police details
                                // case 3:
                                //     System.out.println("--------------------------------------------------- :");
                                //     FileWriter fw1 = new FileWriter(pathOfDatabase + "\\Police.txt", true);
                                //     System.out.println("Enter the ID of the police :");
                                //     int ID = sc.nextInt();
                                //     System.out.println("Enter the name of the police :");
                                //     String name2 = sc.next();
                                //     System.out.println("Enter the mission enrolled :");
                                //     String miss = sc.next();
                                //     System.out.print("\n");

                                //     fw1.write(ID + ",");
                                //     fw1.write(name1 + ",");
                                //     fw1.write(miss);
                                //     System.out.println("--------------------------------------------------- :");
                                //     System.out.println("Details added successfulyy");
                                //     fw1.flush();
                                //     fw1.close();
                                //     break;
                            }
                        } while (m1 < 4);
                        br3.close();
                        fr2.close();

                        break;
                }
            } while (n < 3);
        // } else {
        //     System.out.println("Invalid Credentials : Check your password or userId");
        // }

    }

    public static void main(String[] args) throws IOException {
        String pathOfDatabase = "G:\\JAVA Training\\project\\police\\database";

        Commissioner c = new Commissioner();
        c.commissioner(pathOfDatabase);
    }
}
