package wordcounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterGUI {
    
    private JFrame frame;
    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;
    
    // Constructor to set up the GUI
    public WordCounterGUI() {
        frame = new JFrame("Word Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        countButton = new JButton("Count Words");
    
        resultLabel = new JLabel("Number of words: 0");
        
        // Set up the layout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(countButton, BorderLayout.SOUTH);
        
        // Add components to the frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(resultLabel, BorderLayout.SOUTH);
        
        // Add button action listener
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = countWords(text);
                resultLabel.setText("Number of words: " + wordCount);
            }
        });
        
        frame.setVisible(true);
    }
    
    private int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        
        String[] words = text.split("\\s+");
        return words.length;
    }
}
