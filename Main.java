package police;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


import police.policeOfficer.*;
import police.commissioner.*;
import police.civilian.*;

public class Main {
    private static String pathOfDatabase = "G:\\JAVA Training\\project\\police\\database";

    public static boolean verifyLogin(int userid,String Password, String Filepath) throws IOException {
        BufferedReader dataReader = new BufferedReader(new FileReader(Filepath));
        String line = dataReader.readLine();
        boolean found = false;
        while((line = dataReader.readLine()) != null){
            if(userid == Integer.parseInt(line.split(",")[0]) && Password.equals(line.split(",")[1])){
                found = true;
            }
        }
		dataReader.close();
        return found;
	}


    public static void main(String[] args) {

        
        Police policeObj = new Police();
        Commissioner commissionerObj = new Commissioner();
		Civilian civilianObj = new Civilian();
		

		Scanner sc = new Scanner(System.in);
		boolean menu=true;
label:
		while(menu) {
		System.out.println("----------------------------------------------------------------------");
		System.out.println("                   POLICE MANAGEMENT SYSTEM                           ");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("                   WELCOME USER PLEASE SELECT                         ");
		System.out.println();
		System.out.println("----------------------------------------------------------------------");
		System.out.println("           1. CIVILIAN");
		System.out.println("           2. POLICE OFFICIAL");
		int choice=sc.nextInt();
		if(choice==1){
			//module 4:
			civilianObj.civilianPage(pathOfDatabase);
			menu = false;
		}
		else if(choice==2) 
		{
			System.out.println("Please select your Rank:");
			System.out.println("1. commissioner:");
			System.out.println("2. Police Officer:");
			
			int choice2= sc.nextInt();
			if(choice2==1) {
				System.out.println("Please Enter Your Police Official Id And Password");
				int UId=sc.nextInt();
				String Pword=sc.next();
                String PathC=pathOfDatabase+"\\commissionerProtected.txt";
                boolean c = false;
                try {
                    c=verifyLogin(UId, Pword, PathC);
                } catch (Exception e) {
                    //TODO: handle exception
                    System.out.println("Error in fetching data from database "+e.getMessage());
                }
				if(c) {
					System.out.println("----------------------------------------------------------------------");
					System.out.println("                     WELCOME COMMISIONER                              ");
					System.out.println("----------------------------------------------------------------------");
					// System.out.println("PLEASE CHOOSE");
					//mODULE 3:
                    try {
                        commissionerObj.commissioner(pathOfDatabase);
                    } catch (Exception e) {
                        //TODO: handle exception
                        e.fillInStackTrace();
                    }
					menu = false;
				}
				else {
					System.out.println("error");
					continue label;
					
				}
			}
			else if(choice2==2) {
        
            System.out.println("Please Enter Your Police Official Id And Password");
            int UId=sc.nextInt();
            String Pword=sc.next();
            String PathC=pathOfDatabase+"\\policeProtected.txt";
            boolean op = false;
            try {
                op=verifyLogin(UId, Pword, PathC);
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Error in fetching data from database "+e.getMessage());
            }
			if(op){
				System.out.println("----------------------------------------------------------------------");
				System.out.println("                       WELCOME POLICE OFFICER                                ");
				System.out.println("----------------------------------------------------------------------");
				// System.out.println("PLEASE CHOOSE");
				// MODULE 2:
                policeObj.police(pathOfDatabase, UId, "Police");
				menu = false;
				
			}
			else {
				System.out.println("Error");
				continue label;
			}
			}
			else {
				System.out.println("Wrong input detected terminating program");
				continue label;
			}
			
			
			
		}
		else {
			System.out.println("*******************Invalid input*******************");
			continue label;
			
		}
		
		sc.close();
	}
	}

    
}
