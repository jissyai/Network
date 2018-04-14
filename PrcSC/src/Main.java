import java.io.*;
import java.net.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Socket sock = new Socket("10.213.76.23",12345);
		OutputStream os = sock.getOutputStream();
		os.write("Kawajiri Ryo\r\n".getBytes());
		os.write("quit\r\n".getBytes());
		os.flush();
		sock.close();
	}
}
