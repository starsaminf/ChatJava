package chat_cliente;
//by starsaminf starsaminf@gmail.com
import java.io.DataInputStream;
import java.io.InputStream;
import javax.swing.JTextArea;

public class Hilo_cliente implements Runnable {
    InputStream aux = null;
    DataInputStream flujo;
    JTextArea texx;

    public Hilo_cliente(DataInputStream flujo, JTextArea tex) {
        try {
            this.flujo = flujo;
            texx = tex;
            Thread hilo = new Thread(this);
            hilo.start();
        } catch (Exception e) {
        }

    }

    public void run() {
        try {
            while (true) {
                String texto = flujo.readUTF();
                texx.append("CLiente:   \n");
                texx.append(texto + "\n");
            }
        } catch (Exception e) {
            System.err.println("Error HILO_CLIENTE msg vacio");
        }
    }
}