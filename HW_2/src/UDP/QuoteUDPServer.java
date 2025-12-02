package UDP;

import java.net.DatagramPacket;
import java.util.Random;
import java.net.DatagramSocket;

public class QuoteUDPServer {
	static Random rand = new Random();

	public static void main(String[] args) {
		String[] quotesArr = { "The only way to do great work is to love what you do. – Steve Jobs",
				"Success is not final, failure is not fatal: it is the courage to continue that counts. – Winston Churchill",
				"Believe you can and you're halfway there. – Theodore Roosevelt",
				"The future belongs to those who believe in the beauty of their dreams. – Eleanor Roosevelt",
				"It does not matter how slowly you go as long as you do not stop. – Confucius" };
		try (DatagramSocket socket = new DatagramSocket(8080)) {
			byte[] receiveData = new byte[1024];
			System.out.println("Server is running...");
			while (true) {
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				socket.receive(receivePacket);
				System.out.println("Received data from client");
				String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
				String sendMessage;
				int rnd = 0;
				if (message.equalsIgnoreCase("EXIT"))
					System.out.println("Client interrupted connection");
				else {
					if (message.equalsIgnoreCase("GET")) {
						try {
							rnd = rand.nextInt(0, quotesArr.length);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
						sendMessage = quotesArr[rnd];
					} else
						sendMessage = "Error: Invalid command. Use 'get' to receive a quote or 'exit' to quit.";
					System.out.println("Received from client: " + message);
					byte[] sendData = sendMessage.getBytes();
					DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
							receivePacket.getAddress(), receivePacket.getPort());
					socket.send(sendPacket);
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
