package servidor;

import java.net.*; 
import java.io.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Servidor {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        ServerSocket socket;
        
          
        socket = new ServerSocket(4000);  
        Socket socket_cli = socket.accept();  
        
        DataInputStream in =
        new DataInputStream(socket_cli.getInputStream()); 
        
        DataOutputStream out =
        new DataOutputStream(socket_cli.getOutputStream());  

        String mencli1="";
        String mencli2="";
            
            String Final = null;
            
            while(!mencli1.equals("Fin")){  
                
                System.out.println("Chat Servidor: ");
                
                mencli1=in.readUTF(); 
                
                System.out.println("Mensaje Recibido de Cliente: "+mencli1);  
                
                mencli2=br.readLine();  
                out.writeUTF(mencli2);  
                out.flush();  
                
                
                
                if(Final == null){
                    
                    Final = "Mensaje cliente: "+mencli1+"\n"+"Mensaje Servidor: "+mencli2+"\n";
                    
                }else{
                    
                    Final = Final +"Mensaje cliente: "+mencli1+"\n"+"Mensaje Servidor: "+mencli2+"\n";
                  
                }
            }
        
        in.close();  
        socket.close();  
        socket_cli.close();
        int i = 1;
        String ruta = "C:/Users/ASUS/Desktop/Clases 2020 V ciclo/Desarrollo de Aplicaciones Distribuidas/Distribuidas-Examen4/src/Chat"+ i +".txt";
        File file = new File(ruta); 
        
        
        if (!file.exists()) {
            file.createNewFile();
        }
        
        do{
            ++i;
            ruta = "C:/Users/ASUS/Desktop/Clases 2020 V ciclo/Desarrollo de Aplicaciones Distribuidas/Distribuidas-Examen4/src/Chat"+ i +".txt";
            file = new File(ruta);
        }while (file.exists());

        
        PrintWriter writer = new PrintWriter("C:/Users/ASUS/Desktop/Clases 2020 V ciclo/Desarrollo de Aplicaciones Distribuidas/Distribuidas-Examen4/src/Chat"+ i +".txt", "UTF-8");
        writer.println(Final);
        writer.close();  
             

            
       
    }
    
}
