package police.civilian;

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

public class Civilian {
    
	public void civilianPage(String pathOfDatabase){
		Scanner sc = new Scanner(System.in);
		String nameOfCivilian = "";
		String allowLocation = "0";
		while(true){
			System.out.println("----------------------------------------------------------------------");
			System.out.println("Please Enter your name");
			nameOfCivilian = sc.nextLine();
			if(nameOfCivilian.equals("")){
				System.out.println("\nI request you to please enter your name");
			}
			else{
				break;
			}
		}
		while(true){
			System.out.println("----------------------------------------------------------------------");
			System.out.println("Please Allow us to acces your Location "+nameOfCivilian+"\n");
			System.out.println("----------------------------------------------------------------------");
			System.out.println("           0. Exit Application");
			System.out.println("           1. Allow Location Access");
			System.out.println("           2. Denay Location Access");
			System.out.println();
			allowLocation = sc.next();
            sc.nextLine();
			if(allowLocation.equals("2")){
				System.out.println("----------------------------------------------------------------------");
				System.out.println("We respect your privacy "+nameOfCivilian+" but by accession you location we can serve you several more functionalitions on this application");
				System.out.println("If you want to ask for immidiate police help \n OR \n you want to get location and information of your nearlby police station \n then you have to allow us to acces your location");
				while(true){
					System.out.println("----------------------------------------------------------------------");
					System.out.println("           0. Exit Application");
					System.out.println("           1. Go back to Location Access Tab");
					System.out.println("           2. Send Message to Police Station");
					String locationDenideTabResponse = sc.nextLine();
					if(locationDenideTabResponse.equals("0")){
						return;
					}
					else if(locationDenideTabResponse.equals("1")){
						break;
					}
					else if(locationDenideTabResponse.equals("2")){
						System.out.println("----------------------------------------------------------------------");
						System.out.println("Please write your message and send it\n");
						String SendMessageToPolice = sc.nextLine();
						try {
							this.addCivilianMessage(nameOfCivilian,SendMessageToPolice,pathOfDatabase);
						} catch (Exception e) {
							//TODO: handle exception
							System.out.println("Their is an error while conecting to databse, Please try after sometime");
							System.out.println(e.getMessage());
						}
						System.out.println("\nYour message has successfully send to out prolice department, \n soon we will take necessary action on it");
					}
					else{
						System.out.println("\nI request you to please enter valid respnse");
					}
				}
			}
			else if(allowLocation.equals("1")){
				System.out.println("----------------------------------------------------------------------");
				System.out.println("Thankyou For your corporation "+nameOfCivilian);
				while(true){
					System.out.println("----------------------------------------------------------------------");
					System.out.println("           0. Exit Application");
					System.out.println("           1. Send Message to Police Station");
					System.out.println("           2. Get Location of Police Station");
					System.out.println("           3. Get Detail of Police Officers of Neraby Police Station");
					System.out.println("           4. Ask for immidiate Police support");
					String locationAcceptTabResponse = sc.nextLine();
					if(locationAcceptTabResponse.equals("0")){
						return;
					}
					else if(locationAcceptTabResponse.equals("1")){
						System.out.println("----------------------------------------------------------------------");
						System.out.println("Please write your message and send it\n");
						String SendMessageToPolice = sc.nextLine();
						try {
							this.addCivilianMessage(nameOfCivilian,SendMessageToPolice,pathOfDatabase);
						} catch (Exception e) {
							//TODO: handle exception
							System.out.println("Their is an error while conecting to databse, Please try after sometime");
							System.out.println(e.getMessage());
						}
						System.out.println("\nYour message has successfully send to out prolice department, \n soon we will take necessary action on it");
					}
					else if(locationAcceptTabResponse.equals("2")){
						System.out.println("----------------------------------------------------------------------");
						System.out.println("Location of Your Neraest Police Station");
						System.out.println("Lovely Police Station, Uni Road, Division of student relationship, LPU, phagwara");
					}
					else if(locationAcceptTabResponse.equals("3")){
						System.out.println("----------------------------------------------------------------------");
						System.out.println("Details of Your Neraest Police Station officers");
						System.out.println("Thakur Mritunjay deepak, 9283746501");
						System.out.println("Manish Das, 9283746501");
						System.out.println("Jatin Sharma, 9283746501");
					}
					else if(locationAcceptTabResponse.equals("4")){
						System.out.println("Try to Protect yourself, Police team has be send to your location");
					}
					else{
						System.out.println("\nI request you to please enter valid response");
					}
				}
			}
			else if(allowLocation.equals("0")){
				System.out.println("----------------------------------------------------------------------");
				System.out.println("Thankyou For Using this Application");
				System.out.println("----------------------------------------------------------------------");
				return;
			}
			else{
				System.out.println("\nI request you to please enter valid response");
			}
		}
	}

	void addCivilianMessage(String nameOfCivilian,String SendMessageToPolice,String pathOfDatabase) throws IOException{
		FileWriter civilianMessageWrite = new FileWriter(pathOfDatabase+"\\civilianMessage.txt",true);
		civilianMessageWrite.write(nameOfCivilian+","+SendMessageToPolice+"\n");
		civilianMessageWrite.flush();
		civilianMessageWrite.close();
	}
    public static void main(String[] args) {
        String pathOfDatabase = "G:\\JAVA Training\\project\\police\\database";
        Civilian c = new Civilian();
        c.civilianPage(pathOfDatabase);
        
    }
}
