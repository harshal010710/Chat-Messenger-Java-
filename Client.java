import java.io.*;
import java.net.*;

class Client
{

    public static void main(String[] args) throws Exception
    {
        System.out.println("Client of Marvellous chat Messanger is running.....\n");
        
        Socket sobj = new Socket("localhost", 2100);
        
        System.out.println("Client is Waiting for Server to Accept the Request..\n");

        PrintStream ps = new PrintStream(sobj.getOutputStream());

        BufferedReader br1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
        
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));


        String str1, str2;

        while(!(str1 = br2.readLine()).equals("end"))
        {
            ps.println(str1);
            System.out.println("Enter the massege for server...");
            str2 = br1.readLine();
            
            System.out.println("Server says : "+str2);
        }

        System.out.println("Thanks for using chat massenger....");

        sobj.close();
        ps.close();
        br1.close();
        br2.close();

    }
}