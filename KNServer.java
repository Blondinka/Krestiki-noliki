package ServerPack;
import java.net.*;
import java.io.*;
import java.util.*;

public class KNServer {
	public static void main(String[] args)throws IOException{
		Socket socket=null;
		try{
			Scanner scanner=new Scanner(System.in);
			ServerSocket server=new ServerSocket(8033);
			System.out.println("server is started");
			Pole pole=new Pole();
			pole.move();
			pole.display();
			socket=server.accept();
			PrintStream ps=new PrintStream(socket.getOutputStream());
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg="привет";
			ps.println(msg);
			ps.flush();
			msg=br.readLine();
			System.out.println(msg);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			if(socket!=null)
				socket.close();
		}	
	}
}
