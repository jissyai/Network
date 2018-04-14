import java.io.*;
import java.net.*;

public class Main3 {
	public static void main(String[] args) throws IOException {
		Socket sock = new Socket("10.200.0.161",39648);
		OutputStream os = sock.getOutputStream();
		InputStream is = sock.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		while(true){
			String input = new java.util.Scanner(System.in).nextLine();
			input += "\r\n";
			os.write(input.getBytes());
			os.flush();
			if(input.equals("quit\r\n")){
				os.write(input.getBytes());
				break;
			}
			BufferedReader br = new BufferedReader(isr);
			String s = br.readLine();
			System.out.println(s);
		}
		sock.close();
	}
}
