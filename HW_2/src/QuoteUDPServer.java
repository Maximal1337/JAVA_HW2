import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class QuoteUDPServer {
	public static void main(String[] args) {
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
				if(message.equalsIgnoreCase("exit")) break;
				System.out.println("Received from client: " + message);
		
				byte[] sendData = message.getBytes();
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
