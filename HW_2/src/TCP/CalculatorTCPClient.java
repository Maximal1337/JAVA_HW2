package TCP;

import java.io.*;
import java.net.*;

public class CalculatorTCPClient
{
 public static void main(String[] args) throws IOException
{
	 InetAddress addr = InetAddress.getByName("localhost");
	 Socket socket = new Socket(addr, 9090);
	 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	 BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	
	 String userInput;
	 System.out.print("Enter expression (num op num) or exit: ");
	 while ((userInput = stdIn.readLine()) != null){ 
		 if(userInput.equalsIgnoreCase("EXIT")) {
			 System.out.println("Shutting down the programm...");
			 break;
		 }
		 out.println(userInput);
		 System.out.println("Server returned: " + userInput + " = " + in.readLine());
		 System.out.print("Enter num op num or exit: ");
 }
 out.close(); in.close(); socket.close();
}}