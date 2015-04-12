package chat_servidor;
//by starsaminf starsaminf@gmail.com
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server_chat {

    static Socket conex = null;
    static ServerSocket aux = null;
    static OutputStream out = null;
    DataOutputStream flujo;
    
    DataInputStream flujo1;
    InputStream aux2=null;

    public void iniciar() {
        try {
            aux = new ServerSocket(5000);
            conex = aux.accept();
            
            out = conex.getOutputStream();
            flujo = new DataOutputStream(out);
            
            aux2= conex.getInputStream();
            flujo1= new DataInputStream(aux2); 
        } catch (IOException ex) {
            System.err.println("error al inicar -- > server");

        }
    }

    public void leer(String cade) {
        try {
            flujo.writeUTF(cade);
            System.out.println("dato enviado -- >" + cade);
        } catch (IOException ex) {
            System.err.println("error al enviar server");
        }
    }
    public DataInputStream getConex() {
        return flujo1;
    }
}
