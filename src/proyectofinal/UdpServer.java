
package proyectofinal;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;


public class UdpServer extends Thread {
    
    
     public void run(){
         try{
             System.out.println("Se obtuvo el objeto");
    ServerSocket serverSocket = new ServerSocket(9999);
    
    Socket socket = serverSocket.accept();// mantiene el programa corriendo
    ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
    ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
    
    Leaderboard recvPacket = (Leaderboard)inStream.readObject();
    System.out.println("ya se tiene el objeto");
   
    
             
     }
         catch(Exception e){
         
         
         
         }
     
     
     }
}
