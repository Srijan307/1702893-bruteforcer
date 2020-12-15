import java.io.IOException;
import java.net.*;
import java.io.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.lang.Object;

public class Main {
	public static int isAccessable(String url,int[] arr) {
	    //url = url.replaceFirst("http", "https"); // Otherwise an exception may
	                                                // be thrown on invalid SSL
	                                                // certificates.
	    try {
	        HttpURLConnection connection = (HttpURLConnection) new URL(url)
	                .openConnection();
	        int responseCode = connection.getResponseCode();
	         //System.out.println(responseCode);
		for(int i=0;i<arr.length;i++){
	         	if(responseCode == arr[i])
				System.out.println(url +"[Status Code: " + responseCode + " ]");
	        }
	    } catch (IOException exception) {
	        System.out.print("IOError");
	    }
	    return 0;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter URL: ");
		String url=sc.nextLine();
		System.out.println("Enter path of file: ");
		String path=sc.nextLine();
		System.out.println("Enter success codes: ");
		String codes=sc.nextLine();
		String[] code=codes.split(" ");
		int n=code.length;
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
		arr[i]=Integer.parseInt(code[i]);
		}
		try {
      			File myObj = new File(path);
      			Scanner myReader = new Scanner(myObj);
	
		        while (myReader.hasNextLine()) {
        		String data = myReader.nextLine();
			String newurl=url+"/"+data;
        		Main.isAccessable(newurl, arr);
			}
      			myReader.close();
		
      		} catch (FileNotFoundException e) {
      			System.out.println("An error occurred.");
      			e.printStackTrace();
    		}
		//System.out.println(System.nanoTime());
	}
}