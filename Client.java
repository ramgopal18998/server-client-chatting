
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
public class Client 
{   
    public static void main(String args[]) throws Exception
    {
        Socket s=new Socket("localhost",777); 
        System.out.println(); 
        System.out.println("Connected to Server.");
        System.out.println("Start Chatting...");  
        Chat c=new Chat(s); 
        c.start();  
        PrintStream ps=new PrintStream(s.getOutputStream());           
        Scanner s2=new Scanner(System.in); 
        while(true) 
        ps.println(s2.nextLine());           
    }
}
