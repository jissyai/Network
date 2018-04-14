import java.net.*;
import java.io.*;
import java.util.*;

class MyServer {  

  public static void main(String args[]) throws Exception{
  	ServerSocket ss = null;
  	Socket s;
  	// 
         //int port  = Integer.parseInt(args[0]);  
         int port = 8080;
        //
	  ss = new ServerSocket(port);

	  System.out.println("Waiting Client");
  	  while ( true) {
  	    s = ss.accept();
	    System.out.println("Accepted Client");
            Runnable clientProc = new ClientProc(s);
	    Thread clientThread = new Thread(clientProc);
	    clientThread.start();
 	  }  
   }
 }

class ClientProc implements Runnable{

	Socket socket;

	ClientProc(Socket s){
	   socket = s;
	}

	public void run(){
	  try{
	    InetAddress address = socket.getInetAddress();
	    System.out.println("Client: " + address.getHostName() );
       
            //  (A)
	    	//入出力変数の準備
	    	BufferedReader sockBr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    	PrintWriter sockPw = new PrintWriter(socket.getOutputStream(),true);
	    	//HTTPリクエストを読み込み、表示する。
	    	String s = sockBr.readLine();
	    	String[] S = s.split(" ");
	    	System.out.println(s);
	    	while(!s.equals("")){
	    		s = sockBr.readLine();
	    		System.out.println(s);
	    	}
	    	
	    	if(S[0].equals("GET")){
	    		String s1 = S[1].trim();
	    		String uri = "." + s1;
	    		FileInputStream fis = new FileInputStream(uri);
	    		OutputStream os = socket.getOutputStream();
	    		int i = fis.read();
	    		while(i != 1){
	    			os.write((byte)i);
	    			i = fis.read();
	    		}
	    		fis.close();
	    		os.flush();
	    	}	
	    	else{
	    		while(!s.equals("")){
		    		s = sockBr.readLine();
		    		System.out.println(s);
		    	}
	    		//HTMLファイルを送信する。
	    		sockPw.println("<HTML>");
	    		sockPw.println("<HEAD><TITLE>My Page</TITLE></HEAD>");
	    		sockPw.println("<BODY><H1>My Web Page</H1>");
	    		sockPw.println("My Name is Imizu muzu muzu.<P>");
	    		sockPw.println("</BODY>");
	    		sockPw.println("</HTML>");
	    	}

            socket.close( );
	   }catch(Exception e){ 
		System.err.println("Exception Error");
	   };

	} 
}

