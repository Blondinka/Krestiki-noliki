package ClientPack;

import java.net.*;
import java.io.*;
import java.util.*;

public class KNClient {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		Socket socket=null;
		try{
			socket=new Socket(InetAddress.getLocalHost(),8033);
			PrintStream ps=new PrintStream(socket.getOutputStream());
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg=br.readLine();
			System.out.println('>'+msg);
			System.out.print('<');
			msg=scanner.nextLine();
			ps.println(msg);
			ps.flush();
			ps.close();
			socket.close();	
		}
		catch(IOException e){
				e.printStackTrace();
		}
	}
}