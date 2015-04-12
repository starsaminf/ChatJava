package chat_cliente;
//by starsaminf starsaminf@gmail.com
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cliente_chat {

    String IP;
    Socket conex;
    OutputStream out = null;
    DataOutputStream flujo;
    
    DataInputStream flujo1;
    InputStream aux2=null;
    int P;
    public void iniciar(String host, int port) {
        IP = host;
        P = port;
        try {
            conex = new Socket(IP, port);           
           
            out = conex.getOutputStream();
            flujo = new DataOutputStream(out);
            
            aux2= conex.getInputStream();
            flujo1= new DataInputStream(aux2); 
            
            
        } catch (IOException ex) {
            System.out.println("Paso algo cliente");
        }
    }

    public DataInputStream getConex() {
        return flujo1;
    }

    public void leer(String cade) {
        try {
            System.out.println("dato enviado -- >" + cade);
            flujo.writeUTF(cade);
        } catch (IOException ex) {
            System.err.println("error al enviar server");
        }
    }
}