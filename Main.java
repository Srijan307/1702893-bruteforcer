import java.io.IOException;
import java.net.*;
import java.io.*;
import java.util.Scanner; // Import the Scanner class to read text files


public class Main {
	public static int ifworking(String url,int[] arr) {
	    //url = url.replaceFirst("http", "https"); // Otherwise an exception may
	                                             // be thrown on invalid SSL
	                                             // certificates.
	    try {
	        HttpURLConnection connection = (HttpURLConnection) new URL(url)
	                .openConnection();
	        int responseCode = connection.getResponseCode();
	
		for(int i=0;i<arr.length;i++){
	         	if(responseCode == arr[i])
				System.out.println(url +" [Status Code " + responseCode + " ]");
	        }//The output that we require
	    } catch (IOException exception) {
	        System.out.print("IOError");
	    }
	    return 0;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter URL ");//User Input no. 1 Ex. http://www.github.com
		String url=sc.nextLine();
		System.out.println("Enter path of file ");//User input no. 2 Ex. Filename.txt
		String path=sc.nextLine();
		System.out.println("Enter success codes ");//User input no. 3 Ex. 200 302
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
		        while (myReader.hasNextLine()) {//reading the file "filename"
        		String data = myReader.nextLine();
			String newurl=url+"/"+data;
        		Main.ifworking(newurl, arr);//calling method "ifworking"
			}
      			myReader.close();
		
      		} catch (FileNotFoundException e) {
      			System.out.println("An error occurred.");
      			e.printStackTrace();
    		}
	}
}
