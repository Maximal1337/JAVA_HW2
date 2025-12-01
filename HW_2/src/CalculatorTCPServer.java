import java.io.*;
import java.net.*;

public class CalculatorTCPServer
{
 public static void main(String[] args) throws IOException
 {
 ServerSocket serverSocket = new ServerSocket(9090);
 System.out.println("Server is listening on port 9090");
 Socket clientSocket = serverSocket.accept();
 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

 String inputLine;
 double res = 0;
 while ((inputLine = in.readLine()) != null){ 
	 if(inputLine.equalsIgnoreCase("exit")) break;
	 System.out.println("Received: " + inputLine);
	 String[] calcArr = inputLine.split(" ");
	 try {
		 switch(calcArr[1]) {
		 	case "+":
		 		res = Integer.parseInt(calcArr[0]) + Integer.parseInt(calcArr[2]);
		 		break;
		 	case "-":
		 		res = Integer.parseInt(calcArr[0]) - Integer.parseInt(calcArr[2]);
		 		break;
		 	case "*":
		 		res = Integer.parseInt(calcArr[0]) * Integer.parseInt(calcArr[2]);
		 		break;
		 	case "/":
		 		res = Integer.parseInt(calcArr[0]) / Integer.parseInt(calcArr[2]);
		 		break;
		 }
		 out.println(inputLine + " = " + res); 
	 }
	 catch(Exception e) {
		 out.println("Error: " + e.getMessage());
	 }
	 }

 in.close(); out.close(); clientSocket.close(); serverSocket.close();
 }}