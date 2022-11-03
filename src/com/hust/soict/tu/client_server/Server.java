package src.com.hust.soict.tu.client_server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	public static void main(String[] args) throws IOException {
		System.out.println("The server is running");
		int clientNumber = 0;
		try (ServerSocket listioner = new ServerSocket(9898)){
			while (true) {
				new Sorter(listioner.accept(), ++clientNumber).start();
			}
		}
	}
}
