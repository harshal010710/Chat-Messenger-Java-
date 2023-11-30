import java.io.*;
import java.net.*;

class Server
{

    public static void main(String[] args) throws Exception
    {
        System.out.println("Server of Marvellous chat Messanger is running....\n");
        
        ServerSocket ssobj = new ServerSocket(2100);

        System.out.println("Server is in the listining mode at port number  : 2100\n");

        Socket sobj = ssobj.accept();

        System.out.println("Client and Server Connection is Succesfull....");

        PrintStream ps = new PrintStream(sobj.getOutputStream());

        BufferedReader br1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
        
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Marvellous chat Massenger Started...");

        String str1, str2;

        while ((str1 = br1.readLine()) != null)
        {
            System.out.println("Client Says : "+str1);

            System.out.println("Enter message for Client : ");

            str2 = br2.readLine();

            ps.println(str2);
        }

        System.out.println("Thanks for using chat messanger..");

        ssobj.close();
        sobj.close();
        ps.close();
        br1.close();
        br2.close();

    }   
}