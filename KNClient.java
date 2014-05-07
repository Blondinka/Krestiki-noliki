package ClientPack;

import java.net.*;
import java.io.*;
import java.util.*;

public class KNClient {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		Socket socket=null;
		int x,y;
		boolean game=true;
		try{
			Pole pole=new Pole();
			socket=new Socket(InetAddress.getLocalHost(),8031);
			while(game==true){
				PrintStream ps=new PrintStream(socket.getOutputStream());
				BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String s=new String();
				while(pole.isKrestikiWin()==false && pole.isNolikikiWin()==false){
					System.out.println("Wait while your opponent is moving");
					s=br.readLine();
					x=Integer.valueOf(s);
					s=br.readLine();
					y=Integer.valueOf(s);
					pole.setKrestik(x, y);
					pole.display();
					if(pole.isKrestikiWin()==false){
						pole.move();
						x=pole.getLastX();
						y=pole.getLastY();
						pole.display();
						s=String.valueOf(x);
						ps.println(s);
						s=String.valueOf(y);
						ps.println(s);
						ps.flush();
					}
				}
				if(pole.isKrestikiWin()==true)
					System.out.println("You are loose");
				if(pole.isNolikikiWin()==true)
					System.out.println("You are win");
				if(pole.isFull()==true)
					System.out.println("Draw!");
				ps.close();
			}
			socket.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
