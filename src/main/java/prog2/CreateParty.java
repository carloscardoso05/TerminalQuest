package prog2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class CreateParty extends JFrame {
    private JComboBox<String> comboBox1;
    private JButton adicionarButton;
    private JTextField textField1;
    private JPanel panel1;

    public CreateParty() {
        comboBox1.addItemListener(itemEvent -> {
            if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                System.out.println(itemEvent.getItem());
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            final CreateParty frame = new CreateParty();
            frame.setContentPane(frame.panel1);
            frame.setTitle("FacompQuest");
            frame.setSize(800, 600);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        });
    }
}
