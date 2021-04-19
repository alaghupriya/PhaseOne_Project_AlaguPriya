package LockedMe;

import java.util.*;


public class FileName {

	Scanner scan=new Scanner(System.in);
	private String filename;
	Queue<String> filelist=new LinkedList<String>();
	List<String> listoffiles = new ArrayList<String>();

	public FileName() {
		super();
		this.filename="";
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "FileName [filename=" + filename + "]";
	}


	Queue<String> addFileName(){
			
		scan.nextLine();	
		System.out.print("Enter File Name to be added : ");
		this.filename=scan.nextLine();	
		filelist.add(this.filename);
		System.out.println(filelist);
		return filelist;
			
		}
		
	public void sortFileNames(){
		
		if (filelist.isEmpty())
			System.out.println("No Files Added");
		else{		
		listoffiles.addAll(filelist);
		Collections.sort(listoffiles);		
		Iterator<String> iter = listoffiles.iterator();
		while (iter.hasNext()) 	
			System.out.println(iter.next());			
			}
		mainMenuOptions();
	}

	private void searchFileName() {
		scan.nextLine();
		System.out.println("Enter name of the file to be searched");
		this.filename=scan.nextLine();
		if(filelist.contains(this.filename)){
			System.out.println("File " + filename +" Found Successfully");
		}else {
			System.out.println("File could not be found ! Please refine your search keyword and Try Again !");
		};
		
		manageFileOptions();
	}

	public void deleteFileName() {
		scan.nextLine();
		System.out.println("Enter name of the file to be deleted");
		this.filename=scan.nextLine();
		filelist.remove(filename);
		System.out.println(filelist);	
	}
	
	private void closeApplication() {
		System.out.println("Application is Closed");
	}	

	
	public void mainMenuOptions(){
		System.out.println("Choose Any One Option from Below:");
		System.out.println("1.List of Files");
		System.out.println("2.Manage Files"); 
		System.out.println("3.Exit");
		
		try {
			int option=scan.nextInt();
			
			if (option==1)	
			sortFileNames();
			 else if(option==2)	
				manageFileOptions();
			 else if (option==3)	
				closeApplication();
			 else {
				System.out.println("Invalid Input");
				mainMenuOptions();
			}
		} catch (Exception e) {
			System.out.println("String not allowed");
			closeApplication();
		}
	}
	

	public void manageFileOptions(){
		System.out.println("Select an Action:");
		System.out.println("1.Add");
		System.out.println("2.Delete");
		System.out.println("3.Search");
		System.out.println("4.Back to Main Menu");
	
		try {
			int action=scan.nextInt();
			if (action==1){
				addFileName();
				System.out.println("File Added Successfully");
				manageFileOptions();
			} else if (action==2){
				deleteFileName();
				System.out.println("File Deleted Successfully");
				manageFileOptions();
			} else if (action==3){
				searchFileName();
			} else if (action==4){
				mainMenuOptions();
			} else{
				System.out.println("Invalid Input");
				manageFileOptions();
			}
		} catch (Exception e) {
			System.out.println("String not allowed");
			closeApplication();
		}
		
	}

	/*Queue<String> displayFileName(){
	
	listoffiles.addAll(filelist);
	System.out.println("List of Files : ");
	Iterator<String> iter = filelist.iterator();
	while (iter.hasNext()) {	
	System.out.println(iter.next());
	//listoffiles.add(iter.next());
	}
	
	return filelist;
	//System.out.println("File Name: " +this.getFilename());

 }*/
	
}
