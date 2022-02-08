package police.policeOfficer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Police{
    private int id;
    private String rank;
    private String name;
    private String mission;

    private int criminalId;
    private String criminalName;
    private String criminalCrime;
    private String criminalCategory;
    private Boolean criminalUnderCustody;

    private static String pathOfDatabase;

// decoration 
    public void partition(){
        System.out.println("\n===============================================================================================================================\n");
    }

    public void terminatePragram(){
        this.partition();
        System.out.println("Thankyou for using this Application");
        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");

    }

    public void inputPartition(){
        System.out.print("\nYou can Enter your input here ==> ");
    }

    public void welcomePoliceMessage(int id,String name,String mission){
        System.out.println("Welcome Police Officer "+name);
        System.out.println("\nYour details : ");
        System.out.println("Police Id : "+id+"\t\t Name : "+name);
    }
// decoration //

// checking
    public Boolean policeDataCheck(int id,String name,String mission){
        if(id != -1 && name != null && mission != null){
            return true;
        }
        else{
            return false;
        }
    } 
// checking //

// login and fetching data of police officer 
    public void login(int loginId,String loginRank) throws IOException{
        this.id = loginId;
        this.rank = loginRank;
        if(this.policeValidation(rank)){
            this.fetchPoliceDetails();
        }
    }

    Boolean policeValidation(String Rank){
        if(rank.equals("Police")){
            return true;
        }
        else{
            return false;
        }
    }

    void fetchPoliceDetails() throws IOException{
        BufferedReader policeDetailRead = new BufferedReader(new FileReader(pathOfDatabase+"\\police.txt"));
        String line = policeDetailRead.readLine();
        while((line = policeDetailRead.readLine()) != null){
            if(Integer.parseInt(line.split(",")[0]) == id){
                this.name = line.split(",")[1];
                this.mission = line.split(",")[2];
            }
        }
        policeDetailRead.close();
    }

    int getPoliceId(){
        return id;
    }
    
    String getPoliceName(){
        return name;
    }
    
    String getPoliceMission(){
        return mission;
    }
// login and fetching data of police officer  //

// showing first menu option to police
    int policeMainMenu(){
        Scanner sc = new Scanner(System.in); 
        while(true){
            this.partition();
            System.out.println("\n MAIN MENU \n");
            System.out.println("Press 0 close the Application");
            System.out.println("Press 1 to go in Your Current Mission Section");
            System.out.println("Press 2 to go in Criminal Section");
            System.out.println("Press 3 to ask for Bakeup in the HeadQuarter");
            System.out.println("Press 4 to see the messages of civilians");
            this.inputPartition();
            int mainMenuResponse = -1;
            try {
                mainMenuResponse = sc.nextInt();
            } catch (Exception e) {
                this.partition();
                System.out.println("\nWARNING : Your response is invalid\n");
                return -1;
            }

            if(mainMenuResponse == 0 || mainMenuResponse == 1 || mainMenuResponse == 2 || mainMenuResponse == 4){
                return mainMenuResponse;
            }
            else{
                this.partition();
                System.out.println("\nWARNING : I Request you to please enter valid response\n");
            }
        }
    }
// showing first menu option to police//

// current mission detail 
    int currentMissionDetails(){
        this.partition();
        System.out.println("Current mission details : ");
        System.out.println("\n"+mission);
        Scanner sc = new Scanner(System.in); 
        while(true){
            this.partition();
            System.out.println("\n CURRENT MISSION MENU BAR \n");
            System.out.println("Press 0 close the Application");
            System.out.println("Press 1 to go back to Main Menu");
            this.inputPartition();
            int currentMissionResponse = -1;
            try {
                currentMissionResponse = sc.nextInt();
            } catch (Exception e) {
                this.partition();
                System.out.println("\nWARNING : Your response is invalid\n");
                return -1;
            }

            if(currentMissionResponse == 0 || currentMissionResponse == 1){
                return currentMissionResponse;
            }
            else{
                this.partition();
                System.out.println("\nWARNING : I Request you to please enter valid response\n");
            }
        }
    }
// current mission detail //

// police bakeup 
    int getPoliceBakeup(){
        Scanner sc = new Scanner(System.in); 
        while(true){
            this.partition();
            System.out.println("\n BAKEUP MENU \n");
            System.out.println("Press 0 to go back to Main Menu");
            System.out.println("Press 1 to get bakeup of Constables");
            System.out.println("Press 2 to get bakeup of Armed Police Force");
            System.out.println("Press 3 to get bakeup of Commandos");
            this.inputPartition();
            int policeBakeupResponse = -1;
            try {
                policeBakeupResponse = sc.nextInt();
            } catch (Exception e) {
                this.partition();
                System.out.println("\nWARNING : Your response is invalid\n");
                return -1;
            }

            if(policeBakeupResponse == 0){
                return policeBakeupResponse;
            }
            else if(policeBakeupResponse == 1){
                this.partition();
                System.out.println("Your Request has been Submitted !");
                System.out.println("\n Bakeup Squad of Constable will be send soon, Hold Your Position");
                return policeBakeupResponse;
            }
            else if(policeBakeupResponse == 2){
                this.partition();
                System.out.println("Your Request has been Submitted !");
                System.out.println("\n Bakeup Squad of Armed Police Force will be send soon, Hold Your Position if Possible");
                return policeBakeupResponse;
            }
            else if(policeBakeupResponse == 3){
                this.partition();
                System.out.println("Your Request has been Submitted !");
                System.out.println("\n Bakeup Squad of Constable will be send soon, Retret and protect yourself");
                return policeBakeupResponse;
            }
            else{
                this.partition();
                System.out.println("\nWARNING : I Request you to please enter valid response\n");
            }
        }
    }
// police bakeup //

// criminal main menu
    int getCriminalMainMenu(){
        Scanner sc = new Scanner(System.in); 
        while(true){
            this.partition();
            System.out.println("\n CRIMINAL MAIN MENU \n");
            System.out.println("Press 0 close the Application");
            System.out.println("Press 1 to go back to Main Menu");
            System.out.println("Press 2 to go Edit Criminal Section");
            System.out.println("Press 3 to go to Criminal Record Section");
            System.out.println("Press 4 to go Add Criminal Section");
            System.out.println("Press 5 to go Delete Criminal Section");

            this.inputPartition();
            int criminalMainMenuResponse = -1;
            try {
                criminalMainMenuResponse = sc.nextInt();
            } catch (Exception e) {
                this.partition();
                System.out.println("\nWARNING : Your response is invalid\n");
                return -1;
            }

            if(criminalMainMenuResponse == 0 || criminalMainMenuResponse == 1 || criminalMainMenuResponse == 2 || criminalMainMenuResponse == 3 || criminalMainMenuResponse == 4 || criminalMainMenuResponse == 5){
                return criminalMainMenuResponse;
            }
            else{
                this.partition();
                System.out.println("\nWARNING : I Request you to please enter valid response\n");
            }
        }
    }
// criminal main menu //

//criminal record menu
    int getCriminalRecordMenu(){
        Scanner sc = new Scanner(System.in); 
        while(true){
            this.partition();
            System.out.println("\n CRIMINAL RECORD MENU \n");
            System.out.println("Press 0 close the Application");
            System.out.println("Press 1 to go back to Criminal Main Menu");
            System.out.println("Press 2 to see list of Dangerous A ranked Criminals");
            System.out.println("Press 3 to see list of Average B ranked Criminals");
            System.out.println("Press 4 to see list of simple C ranked Criminals");
            System.out.println("Press 5 to see list of Cought Criminals");
            System.out.println("Press 6 to see list of Free Criminals");
            System.out.println("Press 7 to see list of All Criminals");
            this.inputPartition();
            int criminalRecordMenuResponse = -1;
            try {
                criminalRecordMenuResponse = sc.nextInt();
            } catch (Exception e) {
                this.partition();
                System.out.println("\nWARNING : Your response is invalid\n");
                return -1;
            }

            if(criminalRecordMenuResponse == 0 || criminalRecordMenuResponse == 1 || criminalRecordMenuResponse == 2 || criminalRecordMenuResponse == 3 || criminalRecordMenuResponse == 4 || criminalRecordMenuResponse == 5 || criminalRecordMenuResponse == 6 || criminalRecordMenuResponse == 7){
                return criminalRecordMenuResponse;
            }
            else{
                this.partition();
                System.out.println("\nWARNING : I Request you to please enter valid response\n");
            }
        }
    }
//criminal record menu //

// criminal list
    int getCriminalList(int typeOfCriminal){
        System.out.println("Criminals List : ");
        System.out.println("\n");
        try {
            this.partition();
            getCriminalDetailinList(typeOfCriminal);
        } catch (Exception e) {
            System.out.println("\n***Their is an error while fetching data from dtabase***\n"+e.getMessage());
        }
        Scanner sc = new Scanner(System.in); 
        while(true){
            this.partition();
            System.out.println("\n CRIMINAL LIST MENU BAR \n");
            System.out.println("Press 0 close the Application");
            System.out.println("Press 1 to go back to  Criminal Record Menu");
            this.inputPartition();
            int criminalListResponse = -1;
            try {
                criminalListResponse = sc.nextInt();
            } catch (Exception e) {
                this.partition();
                System.out.println("\nWARNING : Your response is invalid\n");
                return -1;
            }

            if(criminalListResponse == 0 || criminalListResponse == 1){
                return criminalListResponse;
            }
            else{
                this.partition();
                System.out.println("\nWARNING : I Request you to please enter valid response\n");
            }
        }
    }

    void getCriminalDetailinList(int typeOfCriminal) throws IOException{
        System.out.println("\nList Of Crimininals\n");
        ArrayList<Police> criminals = new ArrayList<Police>();
        BufferedReader criminalDetailRead = new BufferedReader(new FileReader(pathOfDatabase+"\\criminal.txt"));
        String line = criminalDetailRead.readLine();
            
        while((line = criminalDetailRead.readLine()) != null){
            Police p = new Police();
            p.criminalId = Integer.parseInt(line.split(",")[0]);
            p.criminalName = line.split(",")[1];
            p.criminalCrime = line.split(",")[2];
            p.criminalCategory = line.split(",")[3];
            p.criminalUnderCustody = Boolean.parseBoolean(line.split(",")[4]);
            criminals.add(p);
        }
        for(int i = 0 ; i < criminals.size() ;i++){
            if(typeOfCriminal == 2 && criminals.get(i).criminalCategory.equals("A")){
                System.out.println();
                System.out.print("Id : "+criminals.get(i).criminalId+" ,");
                System.out.print("\tCriminal Name : "+criminals.get(i).criminalName+" ,");
                System.out.print("\t Criminal Crime : "+criminals.get(i).criminalCrime+" ,");
                System.out.print("\tCriminal Category: "+criminals.get(i).criminalCategory+" ,");
                System.out.print("\tCriminal Under Custody : "+criminals.get(i).criminalUnderCustody+" ,");
                System.out.println();
            }
            else if(typeOfCriminal == 3 && criminals.get(i).criminalCategory.equals("B")){
                System.out.println();
                System.out.print("Id : "+criminals.get(i).criminalId+" .");
                System.out.print("\tCriminal Name : "+criminals.get(i).criminalName+" ,");
                System.out.print("\t Criminal Crime : "+criminals.get(i).criminalCrime+" ,");
                System.out.print("\tCriminal Category: "+criminals.get(i).criminalCategory+" ,");
                System.out.print("\tCriminal Under Custody : "+criminals.get(i).criminalUnderCustody+" ,");
                System.out.println();
            }
            else if(typeOfCriminal == 4 && criminals.get(i).criminalCategory.equals("C")){
                System.out.println();
                System.out.print("Id : "+criminals.get(i).criminalId+" ,");
                System.out.print("\tCriminal Name : "+criminals.get(i).criminalName+" ,");
                System.out.print("\t Criminal Crime : "+criminals.get(i).criminalCrime+" ,");
                System.out.print("\tCriminal Category: "+criminals.get(i).criminalCategory+" ,");
                System.out.print("\tCriminal Under Custody : "+criminals.get(i).criminalUnderCustody+" ,");
                System.out.println();
            }
            else if(typeOfCriminal == 5 && criminals.get(i).criminalUnderCustody == true){
                System.out.println();
                System.out.print("Id : "+criminals.get(i).criminalId+" ,");
                System.out.print("\tCriminal Name : "+criminals.get(i).criminalName+" ,");
                System.out.print("\t Criminal Crime : "+criminals.get(i).criminalCrime+" ,");
                System.out.print("\tCriminal Category: "+criminals.get(i).criminalCategory+" ,");
                System.out.print("\tCriminal Under Custody : "+criminals.get(i).criminalUnderCustody+" ,");
                System.out.println();
            }
            else if(typeOfCriminal == 6 && criminals.get(i).criminalUnderCustody == false){
                System.out.println();
                System.out.print("Id : "+criminals.get(i).criminalId+" ,");
                System.out.print("\tCriminal Name : "+criminals.get(i).criminalName+" ,");
                System.out.print("\t Criminal Crime : "+criminals.get(i).criminalCrime+" ,");
                System.out.print("\tCriminal Category: "+criminals.get(i).criminalCategory+" ,");
                System.out.print("\tCriminal Under Custody : "+criminals.get(i).criminalUnderCustody+" ,");
                System.out.println();
            }
            else if(typeOfCriminal == 7 ){
                System.out.println();
                System.out.print("Id : "+criminals.get(i).criminalId+" ,");
                System.out.print("\tCriminal Name : "+criminals.get(i).criminalName+" ,");
                System.out.print("\tCriminal Crime : "+criminals.get(i).criminalCrime+" ,");
                System.out.print("\tCriminal Category: "+criminals.get(i).criminalCategory+" ,");
                System.out.print("\tCriminal Under Custody : "+criminals.get(i).criminalUnderCustody+" ,");
                System.out.println();
            }
        }
        criminalDetailRead.close();
    }

// criminal list//

// add criminal
    int addCriminal(){
        Scanner sc = new Scanner(System.in);
        while(true){
            int addCriminalResponse = -1;
            String addCriminalName = "";
            String addCriminalCrime = "";
            String addCriminalCategory = null;
            String addCriminalUnderCustody = null;
            try {
                this.partition();
                System.out.println("\nADD CRIMINAL \n");
                System.out.println("Kindly fill the details of criminal carefully");
                System.out.println("\nPlease Enter Name of Criminal");
                this.inputPartition();
                addCriminalName = sc.nextLine();
                System.out.println("\nPlease Enter Crime of Criminal");
                this.inputPartition();
                addCriminalCrime = sc.nextLine();
                System.out.println("\nPlease Enter Category of Criminal ('A' / 'B' / 'C')");
                this.inputPartition();
                addCriminalCategory = sc.nextLine().toUpperCase();
                System.out.println("\nPlease Enter is Criminal under Custody? (true / false) ");
                this.inputPartition();
                addCriminalUnderCustody = sc.next();
            } catch (Exception e) {
                this.partition();
                System.out.println("\nWARNING : Your response is invalid\n");
                return -1;
            }
            
            if(addCriminalCategory.equals("A") || addCriminalCategory.equals("B") || addCriminalCategory.equals("C")){
                if(addCriminalUnderCustody.equals("true") || addCriminalUnderCustody.equals("false")){
                    if(!addCriminalName.equals("") && !addCriminalCrime.equals("")){
                        try {
                            addCriminalInDataBase(addCriminalName,addCriminalCrime,addCriminalCategory,addCriminalUnderCustody);
                        } catch (Exception e) {
                            System.out.println("\n***Their is an error while adding data to dtabase***\n"+e.getMessage());
                        }
                        addCriminalResponse = 1;
                        return addCriminalResponse;
                    }
                    else{
                        sc.nextLine();
                        this.partition();
                        System.out.println("\nWARNING : I Request you to please enter Name of Criminal and crime of Criminal\n");
                    }
                }
                else{
                    sc.nextLine();
                    this.partition();
                    System.out.println("\nWARNING : I Request you to please enter only 'true' or 'false' to declear that Criminal is under custody or not\n");
                }
            }
            else{
                sc.nextLine();
                this.partition();
                System.out.println("\nWARNING : I Request you to please enter only 'A' or 'B' or 'C' to declear Category of Criminal\n");
                System.out.println("\nCategory A : Most Dangerous Criminal ");
                System.out.println("Category B : Average Criminal ");
                System.out.println("Category C : Easy Criminal \n");
            }
        }
        

    }

    void addCriminalInDataBase(String addCriminalName,String addCriminalCrime,String addCriminalCategory,String addCriminalUnderCustody) throws IOException{
        
        ArrayList<Police> criminals = new ArrayList<Police>();
        BufferedReader criminalDetailRead = new BufferedReader(new FileReader(pathOfDatabase+"\\criminal.txt"));
        String line = criminalDetailRead.readLine();
        int addCriminalId = 0;
            
        while((line = criminalDetailRead.readLine()) != null){
            Police p = new Police();
            p.criminalId = Integer.parseInt(line.split(",")[0]);
            addCriminalId = p.criminalId;
            p.criminalName = line.split(",")[1];
            p.criminalCrime = line.split(",")[2];
            p.criminalCategory = line.split(",")[3];
            p.criminalUnderCustody = Boolean.parseBoolean(line.split(",")[4]);
            criminals.add(p);
        }

        criminalDetailRead.close();

        Police p = new Police();
        p.criminalId = addCriminalId + 1;
        p.criminalName = addCriminalName;
        p.criminalCrime = addCriminalCrime;
        p.criminalCategory = addCriminalCategory;
        p.criminalUnderCustody = Boolean.parseBoolean(addCriminalUnderCustody);
        criminals.add(p);

        FileWriter criminalDetailWrite = new FileWriter(pathOfDatabase+"\\criminal.txt");
        criminalDetailWrite.write("id,name,crime,category,custody");

        for(int i = 0 ; i < criminals.size(); i++){
            criminalDetailWrite.write("\n"+Integer.toString(criminals.get(i).criminalId)+","+criminals.get(i).criminalName+","+criminals.get(i).criminalCrime+","+criminals.get(i).criminalCategory+","+Boolean.toString(criminals.get(i).criminalUnderCustody));
        }
        criminalDetailWrite.flush();
        criminalDetailWrite.close();

        this.partition();

        System.out.println("Criminal has Succesfulay Added in Criminal List");
        System.out.println();
        System.out.print(""+criminals.get((criminals.size())-1).criminalId+" ");
        System.out.print("\t\t"+criminals.get((criminals.size())-1).criminalName+" ");
        System.out.print("\t\t"+criminals.get((criminals.size())-1).criminalCrime+" ");
        System.out.print("\t\t"+criminals.get((criminals.size())-1).criminalCategory+" ");
        System.out.print("\t\t"+criminals.get((criminals.size())-1).criminalUnderCustody+" ");
        System.out.println();

    }
// add criminal //


// delete criminal
    void deleteCriminal(){
        Scanner sc = new Scanner(System.in);
        this.partition();
        System.out.println("\nDelete CRIMINAL \n");
        System.out.println("Kindly fill the ID of criminal carefully");
        System.out.println("Please Enter Id of Criminal");
        this.inputPartition();
        String deleteCriminalId = sc.nextLine();
        try {
            if(this.deleteCriminalValidation(deleteCriminalId)){
                try {
                    this.deleteCriminalDatabase(deleteCriminalId);
                } catch (Exception e) {
                    System.out.println("\n***Their is an error while fetching data from dtabase***\n"+e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("\n***Their is an error while fetching data from dtabase***\n"+e.getMessage());
        }

    }

    boolean deleteCriminalValidation(String deleteCriminalId) throws IOException{
        BufferedReader criminalDetailRead = new BufferedReader(new FileReader(pathOfDatabase+"\\criminal.txt"));
        String line = criminalDetailRead.readLine();
        while((line = criminalDetailRead.readLine()) != null){
            if((line.split(",")[0]).equals(deleteCriminalId)){
                this.partition();
                System.out.println("Are you sure to want to delete the perticular Criminal from Database\n");
                System.out.println("Id : "+line.split(",")[0]+"\t\t Name : "+line.split(",")[1]+"\t\t Crime : "+line.split(",")[2]+"\t\t Category : "+line.split(",")[3]+"\t\t Under Custody : "+line.split(",")[4]);
                while(true){
                    int deleteCriminalFinalValidationResponse = this.deleteCriminalFinalValidation();
                    if(deleteCriminalFinalValidationResponse == 1){
                        return true;
                    }
                    else if(deleteCriminalFinalValidationResponse == 0){
                        this.partition();
                        System.out.println("Deletion of Criminal of id "+deleteCriminalId+" is cancled\n");
                        return false;
                    }
                }
            }
        }
        criminalDetailRead.close();
        this.partition();
        System.out.println("Their is no such criminal of Id : "+deleteCriminalId);
        return false;
    }

    int deleteCriminalFinalValidation(){
        Scanner sc = new Scanner(System.in);
        while(true){
            this.partition();
            System.out.println("\n ARE YOU SURE TO DELETE THE CRIMINAL DETAILS \n");
            System.out.println("Press 0 to Cancel Delete and go back to Criminal Main Menu");
            System.out.println("Press 1 to delete the perticular criminal");
    
            this.inputPartition();
            int deleteCriminalFinalValidationResponse = -1;
            try {
                deleteCriminalFinalValidationResponse = sc.nextInt();
            } catch (Exception e) {
                this.partition();
                System.out.println("\nWARNING : Your response is invalid\n");
                return -1;
            }

            if(deleteCriminalFinalValidationResponse == 0 || deleteCriminalFinalValidationResponse == 1){
                return deleteCriminalFinalValidationResponse;
            }
            else{
                this.partition();
                System.out.println("\nWARNING : I Request you to please enter valid response\n");
            }
        }
    }

    void deleteCriminalDatabase(String deleteCriminalId) throws IOException{
        ArrayList<Police> criminals = new ArrayList<Police>();
        BufferedReader criminalDetailRead = new BufferedReader(new FileReader(pathOfDatabase+"\\criminal.txt"));
        String line = criminalDetailRead.readLine();

        int decrementId = 0;

        ArrayList<String> deleteCriminalDetail = new ArrayList<String>();
            
        while((line = criminalDetailRead.readLine()) != null){
            if(!line.split(",")[0].equals(deleteCriminalId)){
                Police p = new Police();
                p.criminalId = Integer.parseInt(line.split(",")[0]) - decrementId;
                p.criminalName = line.split(",")[1];
                p.criminalCrime = line.split(",")[2];
                p.criminalCategory = line.split(",")[3];
                p.criminalUnderCustody = Boolean.parseBoolean(line.split(",")[4]);
                criminals.add(p);
            }
            else{
                decrementId = 1;
                deleteCriminalDetail.add(line.split(",")[0]);
                deleteCriminalDetail.add(line.split(",")[1]);
                deleteCriminalDetail.add(line.split(",")[2]);
                deleteCriminalDetail.add(line.split(",")[3]);
                deleteCriminalDetail.add(line.split(",")[4]);
            }
        }

        criminalDetailRead.close();

        FileWriter criminalDetailWrite = new FileWriter(pathOfDatabase+"\\criminal.txt");
        criminalDetailWrite.write("id,name,crime,category,custody");

        for(int i = 0 ; i < criminals.size(); i++){
            criminalDetailWrite.write("\n"+Integer.toString(criminals.get(i).criminalId)+","+criminals.get(i).criminalName+","+criminals.get(i).criminalCrime+","+criminals.get(i).criminalCategory+","+Boolean.toString(criminals.get(i).criminalUnderCustody));
        }
        criminalDetailWrite.flush();
        criminalDetailWrite.close();

        this.partition();

        System.out.println("Criminal has Succesfulay Deleted from Criminal List");
        System.out.println("\nDeleted Criminal details :\n");
        System.out.println("Id : "+deleteCriminalDetail.get(0)+"\t\t Name : "+deleteCriminalDetail.get(1)+"\t\t Crime : "+deleteCriminalDetail.get(2)+"\t\t Category : "+deleteCriminalDetail.get(3)+"\t\t Under Custody : "+deleteCriminalDetail.get(4));
    }
// delete criminal //

// edit criminal 
    void editCriminal(){
        Scanner sc = new Scanner(System.in);
        this.partition();
        System.out.println("\n Edit CRIMINAL \n");
        System.out.println("Kindly fill the ID of criminal carefully");
        System.out.println("Please Enter Id of Criminal");
        this.inputPartition();
        String editCriminalId = sc.nextLine();
        try {
            this.editCriminalValidation(editCriminalId);
        } catch (Exception e) {
            System.out.println("\n***Their is an error while fetching data from dtabase***\n"+e.getMessage());
        }
    }

    
    void editCriminalValidation(String editCriminalId) throws IOException{
        BufferedReader criminalDetailRead = new BufferedReader(new FileReader(pathOfDatabase+"\\criminal.txt"));
        String line = criminalDetailRead.readLine();
        while((line = criminalDetailRead.readLine()) != null){
            if((line.split(",")[0]).equals(editCriminalId)){
                this.partition();
                System.out.println("Pre Saved Details of Criminal of Entered id "+editCriminalId+"\n");
                System.out.println("Id : "+line.split(",")[0]+"\t\t Name : "+line.split(",")[1]+"\t\t Crime : "+line.split(",")[2]+"\t\t Category : "+line.split(",")[3]+"\t\t Under Custody : "+line.split(",")[4]);
                while(true){
                    int editCriminalDatabaseResponse = this.editCriminalDatabase(editCriminalId);
                    if(editCriminalDatabaseResponse == 1){
                        return;
                    }
                    else if(editCriminalDatabaseResponse == 0){
                        this.partition();
                        System.out.println("Editing of Criminal of id "+editCriminalId+" is cancled");
                        return;
                    }
                }
            }
        }
        criminalDetailRead.close();
        this.partition();
        System.out.println("Their is no such criminal of Id : "+editCriminalId);
    }

    int editCriminalDatabase(String editCriminalId){
        Scanner sc = new Scanner(System.in);
        while(true){
            String editCriminalName = "";
            String editCriminalCrime = "";
            String editCriminalCategory = "";
            String editCriminalUnderCustody = "";
            try {
                this.partition();
                System.out.println("\nEdit CRIMINAL \n");
                System.out.println("Kindly Edit the details of criminal carefully");
                System.out.println("\nPlease Enter New Name of Criminal");
                System.out.println("Please Press Enter and Leave it Empty If you dont want to Change Name of Criminal");
                System.out.println("Please Press '0' if you want to cancel the Editing of Criminal Data");
                this.inputPartition();
                editCriminalName = sc.nextLine();
                if(editCriminalName.equals("0")){
                    return 0;
                }
                System.out.println("\nPlease Enter Updated Crime of Criminal");
                System.out.println("Please Press Enter and Leave it Empty If you dont want to Change Name of Criminal");
                System.out.println("Please Press '0' if you want to cancel the Editing of Criminal Data");
                this.inputPartition();
                editCriminalCrime = sc.nextLine();
                if(editCriminalCrime.equals("0")){
                    return 0;
                }
                System.out.println("\nPlease Enter New Category of Criminal ('A' / 'B' / 'C')");
                System.out.println("Please Press Enter and Leave it Empty If you dont want to Change Name of Criminal");
                System.out.println("Please Press '0' if you want to cancel the Editing of Criminal Data");
                this.inputPartition();
                editCriminalCategory = sc.nextLine();
                if(editCriminalCategory.equals("0")){
                    return 0;
                }
                else{
                    editCriminalCategory = editCriminalCategory.toUpperCase();
                }
                System.out.println("\nPlease Enter is Criminal under Custody? (true / false) ");
                System.out.println("Please Press Enter and Leave it Empty If you dont want to Change Name of Criminal");
                System.out.println("Please Press '0' if you want to cancel the Editing of Criminal Data");
                this.inputPartition();
                editCriminalUnderCustody = sc.nextLine();
                if(editCriminalUnderCustody.equals("0")){
                    return 0;
                }
            } catch (Exception e) {
                this.partition();
                System.out.println("\nWARNING : Your response is invalid\n");
                return -1;
            }
            
            if(editCriminalCategory.equals("A") || editCriminalCategory.equals("B") || editCriminalCategory.equals("C") || editCriminalCategory.equals("") ){
                if(editCriminalUnderCustody.equals("true") || editCriminalUnderCustody.equals("false") || editCriminalUnderCustody.equals("")){
                    try {
                        editCriminalDataBaseFinal(editCriminalId,editCriminalName,editCriminalCrime,editCriminalCategory,editCriminalUnderCustody);
                    } catch (Exception e) {
                        System.out.println("\n***Their is an error while adding data to dtabase***\n"+e.getMessage());
                    }
                    return 1;
                }
                else{
                    sc.nextLine();
                    this.partition();
                    System.out.println("\nWARNING : I Request you to please enter only 'true' or 'false' to declear that Criminal is under custody or not \nOR\n just leave it blank if you do not want to Edit it\n");
                }
            }
            else{
                sc.nextLine();
                this.partition();
                System.out.println("\nWARNING : I Request you to please enter only 'A' or 'B' or 'C' to declear Category of Criminal \nOR\n just leave it blank if you do not want to Edit it\n");
                System.out.println("\nCategory A : Most Dangerous Criminal ");
                System.out.println("Category B : Average Criminal ");
                System.out.println("Category C : Easy Criminal \n");
            }
        }
    }

    
    void editCriminalDataBaseFinal(String editCriminalId,String editCriminalName,String editCriminalCrime,String editCriminalCategory,String editCriminalUnderCustody) throws IOException{
        
        ArrayList<Police> criminals = new ArrayList<Police>();
        BufferedReader criminalDetailRead = new BufferedReader(new FileReader(pathOfDatabase+"\\criminal.txt"));
        String line = criminalDetailRead.readLine();
        int index = -1;
            
        while((line = criminalDetailRead.readLine()) != null){
            Police p = new Police();
            p.criminalId = Integer.parseInt(line.split(",")[0]);
            if(line.split(",")[0].equals(editCriminalId)){

                index = p.criminalId;

                if(editCriminalName.equals("")){
                    p.criminalName = line.split(",")[1];
                }
                else{
                    p.criminalName = editCriminalName;
                }
                
                if(editCriminalCrime.equals("")){
                    p.criminalCrime = line.split(",")[2];
                }
                else{
                    p.criminalCrime = editCriminalCrime;
                }
                
                if(editCriminalCategory.equals("")){
                    p.criminalCategory = line.split(",")[3];
                }
                else{
                    p.criminalCategory = editCriminalCategory;
                }
                
                if(editCriminalUnderCustody.equals("")){
                    p.criminalUnderCustody = Boolean.parseBoolean(line.split(",")[4]);
                }
                else{
                    p.criminalUnderCustody = Boolean.parseBoolean(editCriminalUnderCustody);
                }

            }
            else{
                p.criminalName = line.split(",")[1];
                p.criminalCrime = line.split(",")[2];
                p.criminalCategory = line.split(",")[3];
                p.criminalUnderCustody = Boolean.parseBoolean(line.split(",")[4]);
            }
            criminals.add(p);
        }

        criminalDetailRead.close();

        FileWriter criminalDetailWrite = new FileWriter(pathOfDatabase+"\\criminal.txt");
        criminalDetailWrite.write("id,name,crime,category,custody");

        for(int i = 0 ; i < criminals.size(); i++){
            criminalDetailWrite.write("\n"+Integer.toString(criminals.get(i).criminalId)+","+criminals.get(i).criminalName+","+criminals.get(i).criminalCrime+","+criminals.get(i).criminalCategory+","+Boolean.toString(criminals.get(i).criminalUnderCustody));
        }
        criminalDetailWrite.flush();
        criminalDetailWrite.close();

        this.partition();

        System.out.println("Criminal Detail has Succesfulay Edited in Criminal List");
        System.out.println();
        System.out.print(""+criminals.get(index-1).criminalId+" ");
        System.out.print("\t\t"+criminals.get(index-1).criminalName+" ");
        System.out.print("\t\t"+criminals.get(index-1).criminalCrime+" ");
        System.out.print("\t\t"+criminals.get(index-1).criminalCategory+" ");
        System.out.print("\t\t"+criminals.get(index-1).criminalUnderCustody+" ");
        System.out.println();

    }


// edit criminal //

// read civilian message 
    void readCivilianMessage() throws IOException{
        BufferedReader civilianMessageRead = new BufferedReader(new FileReader(pathOfDatabase+"\\civilianMessage.txt"));
        String line = civilianMessageRead.readLine();
            
        this.partition();
        while((line = civilianMessageRead.readLine()) != null){
            System.out.println("Name : "+line.split(",")[0]+" , Message : "+line.split(",")[1]);
        }
        
    }
// read civilian message //

public void police(String pathOfDatabase,int loginId,String loginRank){
    this.pathOfDatabase = pathOfDatabase;
    
    Police p = new Police();

    int id = -1;
    String name = null;
    String mission = null;

    p.partition();

    try {
        p.login(loginId,loginRank);
        id = p.getPoliceId();
        name = p.getPoliceName();
        mission = p.getPoliceMission();
    } catch (Exception e) {
        System.out.println("***Their is an error while fetching data from dtabase***  "+e.getMessage());
    }

    if(p.policeDataCheck(id,name,mission)){

        p.welcomePoliceMessage(id,name,mission);


        int mainMenuResponse = -1;
        while(true){
            mainMenuResponse = p.policeMainMenu();
            if(mainMenuResponse == 0){ // terminate
                p.terminatePragram();
                return;
            }
            else if(mainMenuResponse == 1){ //current mission
                while(true){
                    int currentMissionResponse = p.currentMissionDetails();
                    if(currentMissionResponse == 0){// terminate
                        p.terminatePragram();
                        return;
                    }
                    else if(currentMissionResponse == 1){ // back
                        p.partition();
                        break;
                    }
                }
            }
            else if(mainMenuResponse == 2){ // criminal section
                while(true){
                    int criminalMainMenuResponse = p.getCriminalMainMenu();
                    if(criminalMainMenuResponse == 0){// terminate
                        p.terminatePragram();
                        return;
                    }
                    else if(criminalMainMenuResponse == 1){ // back
                        p.partition();
                        break;
                    }
                    else if(criminalMainMenuResponse == 2){ // edit criminal
                        p.editCriminal();
                    }
                    else if(criminalMainMenuResponse == 3){ // criminal list
                        while(true){
                            int criminalRecordMenuResponse = p.getCriminalRecordMenu();
                            if(criminalRecordMenuResponse == 0){// terminate
                                p.terminatePragram();
                                return;
                            }
                            else if(criminalRecordMenuResponse == 1){ // back
                                // p.partition();
                                break;
                            }
                            else if(criminalRecordMenuResponse == 2 || criminalRecordMenuResponse == 3 || criminalRecordMenuResponse == 4 || criminalRecordMenuResponse == 5 || criminalRecordMenuResponse == 6 || criminalRecordMenuResponse == 7){//typeof criminal in list
                                while(true){
                                    int criminalListResponse = p.getCriminalList(criminalRecordMenuResponse);
                                    if(criminalListResponse == 0){// terminate
                                        p.terminatePragram();
                                        return;
                                    }
                                    else if(criminalListResponse == 1){ // back
                                        // p.partition();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    else if(criminalMainMenuResponse == 4){ // add criminal
                        while(true){
                            int addCriminalResponse = p.addCriminal();
                            if(addCriminalResponse == 1){
                                break;
                            }
                        }
                    }
                    else if(criminalMainMenuResponse == 5){ //delete criminal
                        p.deleteCriminal();
                    }
                }
            }
            else if(mainMenuResponse == 3){ // bakeup in headquarter
                while(true){
                    int policeBakeupResponse = p.getPoliceBakeup();
                    if(policeBakeupResponse == 0 || policeBakeupResponse == 1 || policeBakeupResponse == 2 || policeBakeupResponse == 3){// bakeup type
                        p.partition();
                        break;
                    }
                }
            }
            else if(mainMenuResponse == 4){ // meaaagse of civilians
                try {
                    p.readCivilianMessage();
                } catch (Exception e) {
                    //TODO: handle exception
                    System.out.println("Their is an error in fetching data from databse");
                }
            }
        }
    }

}


    public static void main(String[] args){
        String pathOfDatabase = "G:\\JAVA Training\\project\\police\\database";
        Police p = new Police();
        p.police(pathOfDatabase,11203,"Police");

        
    }
}