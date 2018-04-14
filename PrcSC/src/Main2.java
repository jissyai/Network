import java.io.*;
import java.net.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		Socket sock = new Socket("10.213.76.23",12345);
		OutputStream os = sock.getOutputStream();
		while(true){
			String input = new java.util.Scanner(System.in).nextLine();
			input += "\r\n";
			os.write(input.getBytes());
			if(input.equals("quit\r\n")){
				os.write(input.getBytes());
				break;
			}
		}
		os.flush();
		sock.close();
	}
}
