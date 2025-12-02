import java.net.DatagramPacket;
import java.util.Random;
import java.net.DatagramSocket;

public class QuoteUDPServer {
	static Random rand = new Random();
	public static void main(String[] args) {
		String[] quotesArr = {"one", "two", "three", "four", "five"};
		DatagramSocket socket = null;
		try {
			socket = new DatagramSocket(8080);
			byte[] receiveData = new byte[1024];
			System.out.println("Server is running...");
	
			while (true)
			{
				
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				socket.receive(receivePacket);
		
				String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
				String sendMessage;
				int rnd = 0;
				if(message.toUpperCase().equalsIgnoreCase("EXIT")) break;
				if(message.toUpperCase().equals("GET")) {
					try {
						rnd = rand.nextInt(0,quotesArr.length);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					sendMessage = quotesArr[rnd];
				}
				else sendMessage = "Error";
				System.out.println("Received from client: " + message);
				byte[] sendData = sendMessage.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
				socket.send(sendPacket);
			}
		}
		catch (Exception e) {e.printStackTrace();}
		finally
		{
			if (socket != null && !socket.isClosed())
			socket.close();
		}
		}
}
