package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FirstFrame extends JFrame {
    private JLabel lblLogo = new JLabel("Welcome to Easy Tournament");

    private JLabel lblChoose = new JLabel("Choose between teams or players");
    private JLabel lblTeams = new JLabel("Teams");
    private JLabel lblPlayer = new JLabel("Players");
    private JRadioButton btnTeam = new JRadioButton();
    private JRadioButton btnPlayer = new JRadioButton();
    private JButton btnOK = new JButton("Ok");

    private JTextArea textArea = new JTextArea();
    private JLabel lblAmount = new JLabel("Amount");
    private JLabel lblNames = new JLabel("Name");
    private JComboBox amountBox = new JComboBox();
    private JTextField textField = new JTextField();

    private JPanel north = new JPanel();
    private JPanel center = new JPanel();
    private JPanel southWest = new JPanel();
    private JPanel southEast = new JPanel();
    private JPanel east = new JPanel();

    ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/ET.png").getImage().getScaledInstance(200, 250, Image.SCALE_DEFAULT));
    private JLabel imageLbl = new JLabel(imageIcon);

    public FirstFrame(){

    }

    public void setupFrame(){
        setSize(new Dimension(1600,1000));
        add(north, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(southWest, BorderLayout.SOUTH);
        add(east, BorderLayout.EAST);
        north.setBackground(Color.WHITE);
        center.setBackground(Color.WHITE);
        east.setBackground(Color.WHITE);
        southEast.setBackground(Color.WHITE);
        southWest.setBackground(Color.WHITE);
//        add(southEast, BorderLayout.SOUTH);


        Border border = BorderFactory.createLineBorder(Color.BLACK);
        center.setBorder(border);


        north.setPreferredSize(new Dimension(1200,130));
        center.setPreferredSize(new Dimension(750,100));
        southWest.setPreferredSize(new Dimension(720,430));
        southEast.setPreferredSize(new Dimension(730,430));
        east.setPreferredSize(new Dimension(700,100));

        north.add(lblLogo);
        lblLogo.setPreferredSize(new Dimension(650,80));
        lblLogo.setFont(new Font("Serif", Font.BOLD, 50));
        lblLogo.setForeground(Color.black);

        center.add(lblChoose);
        center.add(lblPlayer);
        center.add(btnPlayer);
        center.add(lblTeams);
        center.add(btnTeam);
        center.add(btnOK);
        lblChoose.setPreferredSize(new Dimension(730, 30));
        lblPlayer.setPreferredSize(new Dimension(200, 20));
        btnPlayer.setPreferredSize(new Dimension(500, 20));
        lblTeams.setPreferredSize(new Dimension(200, 20));
        btnTeam.setPreferredSize(new Dimension(500, 20));
        btnOK.setPreferredSize(new Dimension(130, 20));
        lblChoose.setFont(new Font("", Font.TRUETYPE_FONT, 15));

        east.add(imageLbl);
        imageLbl.setPreferredSize(new Dimension(600,240));


        southWest.add(southEast);
        southWest.add(lblAmount);
        southWest.add(amountBox);
        southWest.add(lblNames);
        southWest.add(textField);

        lblAmount.setPreferredSize(new Dimension(700,20));
        amountBox.setPreferredSize(new Dimension(700,20));
        lblNames.setPreferredSize(new Dimension(700,20));
        textField.setPreferredSize(new Dimension(700,20));


        southEast.add(textArea);

        textArea.setPreferredSize(new Dimension(700,300));

        setVisible(true);
    }

    public static void main(String[] args) {
        FirstFrame firstFrame = new FirstFrame();
        firstFrame.setupFrame();
    }

}
