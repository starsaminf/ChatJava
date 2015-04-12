package cliente;
//by starsaminf starsaminf@gmail.com
import chat_cliente.Hilo_cliente;
import chat_cliente.cliente_chat;
import grafica_cliente.gui_chat_1_1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] arg) {
        String ip = null;
        int p = 0;
        try {
            Scanner sc=new Scanner(new File("config.ini"));
            ip=sc.nextLine();
            p=Integer.parseInt(sc.nextLine());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println("CLIENTE");

        cliente_chat cli = new cliente_chat();
        cli.iniciar(ip, p);

        gui_chat_1_1 np = new gui_chat_1_1();
        np.envia(cli);
        
        Hilo_cliente hcl = new Hilo_cliente(cli.getConex(), np.gettex());
        System.out.println("Contacto");
        
        np.setVisible(true);
    }
}
