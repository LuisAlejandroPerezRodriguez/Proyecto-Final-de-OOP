
package proyectofinal;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UdpClient extends Thread {
    
    public void run(){
        try{
            //for (int i=0;;i++){
     Leaderboard lb1 = new Leaderboard();
    DatagramSocket ds =new DatagramSocket();
    InetAddress ia = InetAddress.getLocalHost();
     ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Leaderboard"));
     ;
     ByteArrayOutputStream bStream = new ByteArrayOutputStream();
    ObjectOutput oo = new ObjectOutputStream(bStream); 
    oo.writeObject(obj.readObject());
    System.out.println("Se envio el objeto por udp");
    oo.close();
byte[] serializedMessage = bStream.toByteArray();
    //byte 
     DatagramPacket dp = new DatagramPacket(serializedMessage,serializedMessage.length,ia,9999);   
     ds.send(dp);
     System.out.println("Se envio el objeto por udp");
     //sleep(6000);
          //  }       
  }
        catch(Exception e){
            System.out.println(e.getMessage());;
        
        }
    
    }
    
}
