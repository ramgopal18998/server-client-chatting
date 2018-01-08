import java.net.*;
import java.util.*;
import java.io.*;

class Chat extends Thread
{
    Socket s; 
    Chat(Socket s) 
    { this.s=s; }
    public void run() 
    {
        String str;Scanner sc=null;
        try 
        { 
            sc=new Scanner(s.getInputStream());
        }catch(IOException e){}        
        while(true) 
        {  
            str=sc.nextLine();  
            System.out.println(" "+str);  
        }
    }   
}
public class Server
{
    public static void main(String args[]) throws IOException 
    {
        ServerSocket ss=new ServerSocket(777);   
        System.out.println(); 
        System.out.println("Waiting For Client.");      
        Socket s=ss.accept();
        System.out.println("Client"+s.getInetAddress()+" Connected");  
        System.out.println("Start Chatting...");
        Chat c=new Chat(s); 
        c.start();  
        PrintStream ps=new PrintStream(s.getOutputStream());
        Scanner sc=new Scanner(System.in); 
        while(true) 
        ps.println(sc.nextLine());
    }
}