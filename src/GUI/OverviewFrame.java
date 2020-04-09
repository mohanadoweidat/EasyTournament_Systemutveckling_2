package GUI;

/*import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class OverviewFrame extends JFrame {
    private JLabel lblOverview = new JLabel("Overview");
    private JTextArea txtSummary = new JTextArea();
    private JButton btnSettings = new JButton("Change Settings");
    private JButton btnPlay = new JButton("Lets play!");
    private JPanel pnlWest = new JPanel();
    private JPanel pnlEast = new JPanel();
    private JPanel empty = new JPanel();
    private JLabel emptylbl = new JLabel("");
    private JComboBox goBack = new JComboBox();

    public OverviewFrame(){
        setUpFrame();
    }

    public void setUpFrame(){
        setSize(new Dimension(800,500));
        add(pnlWest, BorderLayout.WEST);
        add(pnlEast, BorderLayout.EAST);
        pnlWest.setPreferredSize(new Dimension(390, 490));
        pnlEast.setPreferredSize(new Dimension(390, 490));


        lblOverview.setFont(new Font("Serif", Font.BOLD, 18));
        lblOverview.setPreferredSize(new Dimension(200,50));
        txtSummary.setPreferredSize(new Dimension(250, 300));
        txtSummary.setEditable(false);
        btnPlay.setPreferredSize(new Dimension(120,50));
        btnSettings.setPreferredSize(new Dimension(120, 50));
        empty.setPreferredSize(new Dimension(400, 160));
        emptylbl.setPreferredSize(new Dimension(380, 70));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        txtSummary.setBorder(border);

        pnlWest.add(goBack);
        pnlWest.add(lblOverview);
        pnlWest.add(txtSummary);

        pnlEast.add(emptylbl);
        pnlEast.add(btnSettings, BorderLayout.NORTH);
        pnlEast.add(empty);
        pnlEast.add(btnPlay, BorderLayout.SOUTH);





        setVisible(true);
    }

    public static void main(String[] args) {
        new OverviewFrame();
    }
}
*/