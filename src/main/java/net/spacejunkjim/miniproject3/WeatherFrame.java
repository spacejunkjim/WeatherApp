package net.spacejunkjim.miniproject3;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * The GUI Frame for Part 2 of the XML Assignment
 * @author James Ashford, Dorian Dressler
 */
public class WeatherFrame extends javax.swing.JFrame {

    String defaultFrameInputText = "Enter BBC Weather Observations RSS URL...";
    /**
     * Constructor new form WeatherFrame
     */
    public WeatherFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        appTitle = new JLabel();
        appURLLabel = new JLabel();
        appURLField = new JTextField();
        appForecastButton = new JButton();
        appOutputTextArea = new JScrollPane();
        jTextArea1 = new JTextArea();
        appWeatherIcon = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("BBC Weather Observations");
        setResizable(false);

        appTitle.setFont(new Font("Lucida Grande", 0, 18)); // NOI18N
        appTitle.setText("BBC Weather Observations");

        appURLLabel.setText("URL: ");

        appURLField.setText("Enter BBC Weather Observations RSS URL...");
        appURLField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                appURLFieldActionPerformed(evt);
            }
        });

        appForecastButton.setText("Forecast");
        appForecastButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                appForecastButtonMouseClicked(evt);
            }
        });
        appForecastButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                appForecastButtonActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        appOutputTextArea.setViewportView(jTextArea1);

        appWeatherIcon.setHorizontalAlignment(SwingConstants.CENTER);
        appWeatherIcon.setIcon(new ImageIcon(getClass().getResource("/simple_weather_icon_01.png"))); // NOI18N
        appWeatherIcon.setBorder(BorderFactory.createEtchedBorder());

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(appURLLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(appURLField)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(appForecastButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(appTitle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(appOutputTextArea, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(appWeatherIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(appURLLabel)
                    .addComponent(appURLField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(appForecastButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(appWeatherIcon)
                        .addContainerGap())
                    .addComponent(appOutputTextArea)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void appURLFieldActionPerformed(ActionEvent evt) {//GEN-FIRST:event_appURLFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appURLFieldActionPerformed

    private void appForecastButtonMouseClicked(MouseEvent evt) {//GEN-FIRST:event_appForecastButtonMouseClicked
        // Clear the output
        jTextArea1.removeAll();
        jTextArea1.setText("");
        // Get the URL
        String url = appURLField.getText();
        
        if(url.equals("") || url.equals(defaultFrameInputText)){
            jTextArea1.setText("Please enter an RSS URL");
        } else {
            // Get a WeatherParser with URL
            WeatherParser parser = new WeatherParser(url);
        
            // Add output to display
            // Now the error has been resolved.
            jTextArea1.append(parser.getOutput());
            String weatherInfoString = parser.getOutput(); // Dorian is working in here
            
            //************************************************
            // i will put this into a separate method
            // i right now this is only here for test purposes
            //************************************************
            
            if (weatherInfoString.contains("null")) {
                appWeatherIcon.setIcon(new ImageIcon(getClass().getResource("/simple_weather_icon_02.png")));
            } else {
                
            }
            //System.out.println("Test String: " + test);
            
        
            // Clear URL field
            appURLField.setText("");
        }
    }//GEN-LAST:event_appForecastButtonMouseClicked

    private void appForecastButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_appForecastButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appForecastButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WeatherFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton appForecastButton;
    private JScrollPane appOutputTextArea;
    private JLabel appTitle;
    private JTextField appURLField;
    private JLabel appURLLabel;
    private JLabel appWeatherIcon;
    private JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
