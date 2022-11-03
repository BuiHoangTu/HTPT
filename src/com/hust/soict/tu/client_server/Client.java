package src.com.hust.soict.tu.client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1",9898);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Please check your server (listener)");
		}

		BufferedReader in = null;
		try {
			assert socket != null;
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		PrintWriter out = null;
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			assert in != null;
			System.out.println(in.readLine());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Scanner scanner = new Scanner(System.in);
		String message;
		do {
			message = scanner.nextLine();
			assert out != null;
			out.println(message);
		}
		while(!message.equals(""));

		
		/*try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		scanner.close();

		//wait for server's responds
		try {
			System.out.println(in.readLine());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
