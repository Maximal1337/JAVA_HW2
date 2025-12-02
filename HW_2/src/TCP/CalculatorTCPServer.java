package TCP;

import java.io.*;
import java.net.*;

public class CalculatorTCPServer {
	public static void main(String[] args) throws IOException {
		try (ServerSocket serverSocket = new ServerSocket(9090)) {
			System.out.println("Server is listening on port 9090");
			while (true) {
				System.out.println("Waiting for client...");
				Socket clientSocket = serverSocket.accept();
				System.out.println("Client connected!");
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				
				String inputLine;
				double res = 0;
				while ((inputLine = in.readLine()) != null) {
					if (inputLine.equalsIgnoreCase("exit"))
						break;
					System.out.println("Received: " + inputLine);
					String[] calcArr = inputLine.split(" ");
					try {
						if (calcArr.length != 3)
							throw new IndexOutOfBoundsException();
						switch (calcArr[1]) {
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
						default:
							res = -1;
						}
						out.println(res);
					} catch (ArithmeticException e) {
						out.println("Error: Division by zero");
					} catch (IndexOutOfBoundsException e) {
						out.println("Error: Invalid expression");
					}
				}

				in.close();
				out.close();
				clientSocket.close();
			}
		}
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}