package grafica_cliente;
//by starsaminf starsaminf@gmail.com
import chat_cliente.cliente_chat;
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

public class gui_chat_1_1 extends JFrame implements ActionListener {

    JLabel etiqueta = new JLabel("CLiente");
    JTextField tecle = new JTextField("Hola soy el cliente", 30);
    JButton enviar = new JButton("Enviar");
    JTextArea tex = new JTextArea(8, 10);
    cliente_chat aux;

    public gui_chat_1_1() {
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(tecle.getText());
        
        aux.leer(tecle.getText());
        tex.append("Yo \n"+tecle.getText()+"\n");
    }

    public void envia(cliente_chat se) {
        aux = se;
    }

    public JTextArea gettex() {
        return tex;
    }
}