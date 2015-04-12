package chat_servidor;
//by starsaminf starsaminf@gmail.com
import java.io.DataInputStream;
import java.io.InputStream;
import javax.swing.JTextArea;

public class Hilo_servidor implements Runnable {
//eNCARGA DE ESCRIBIR EN EL TEXAREA
    InputStream aux = null;
    DataInputStream flujo;
    JTextArea texx;
    public Hilo_servidor(DataInputStream flujo, JTextArea tex) {
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
                texx.append("Servidor:   \n");
                texx.append(texto + "\n");
            }
        } catch (Exception e) {
            System.err.println("Error HILO_SERVIDOR msg vacio");
        }
    }
}