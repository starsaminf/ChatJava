package grafica_servidor;
//by starsaminf starsaminf@gmail.com
import chat_servidor.server_chat;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class gui_chat_1_1_servidor extends JFrame implements ActionListener {

    JLabel etiqueta = new JLabel("Servidor");
    JTextField tecle = new JTextField("Hola soy el servidor", 30);
    JButton enviar = new JButton("Enviar");
    JTextArea tex = new JTextArea(8, 10);
    server_chat aux;

    public gui_chat_1_1_servidor() {
        super("Chat de prueba");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout bor = new BorderLayout();
        setLayout(bor);
        enviar.addActionListener(this);
        JPanel panel = new JPanel();
        panel.add(etiqueta);
        panel.add(tecle);
        panel.add(enviar);
        add(panel, BorderLayout.NORTH);
        tex.setLineWrap(true);
        JScrollPane panelTexto = new JScrollPane(tex);
        add(panelTexto, BorderLayout.CENTER);
        //setVisible(true);
        //
    }

    public JTextArea gettex() {
        return tex;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        aux.leer(tecle.getText());
        tex.append("Yo \n" + tecle.getText() + "\n");
    }

    public void envia(server_chat se) {
        aux = se;
    }
}