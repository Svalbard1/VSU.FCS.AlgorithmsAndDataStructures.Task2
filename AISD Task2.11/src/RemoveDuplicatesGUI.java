import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesGUI extends JFrame {
    private JTextField inputField;
    private JTextArea outputArea;

    public RemoveDuplicatesGUI() {
        super("Remove Duplicates");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Enter a list of elements, separated by commas:");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);

        inputField = new JTextField(20);
        inputField.setMaximumSize(new Dimension(Integer.MAX_VALUE, inputField.getPreferredSize().height));
        panel.add(inputField);

        JButton button = new JButton("Remove Duplicates");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(button);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        panel.add(scrollPane);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String[] elements = input.split(",");
                Set<String> uniqueElements = new HashSet<>(Arrays.asList(elements));
                StringBuilder sb = new StringBuilder();
                for (String element : uniqueElements) {
                    sb.append(element.trim()).append("\n");
                }
                outputArea.setText(sb.toString());
            }
        });

        setContentPane(panel);
        setVisible(true);
    }
}
