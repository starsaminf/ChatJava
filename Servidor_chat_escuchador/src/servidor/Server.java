package servidor;
//by starsaminf starsaminf@gmail.com
import chat_servidor.Hilo_servidor;
import chat_servidor.server_chat;
import grafica_servidor.gui_chat_1_1_servidor;

class Server {

    public static void main(String[] arg) {
        System.out.println("SERVIDOR");
        gui_chat_1_1_servidor gui_ser = new gui_chat_1_1_servidor();
        gui_ser.setVisible(true);
        
        server_chat se = new server_chat();
        se.iniciar();
        gui_ser.envia(se);
        
        Hilo_servidor Hs = new Hilo_servidor(se.getConex(), gui_ser.gettex());

    }
}
