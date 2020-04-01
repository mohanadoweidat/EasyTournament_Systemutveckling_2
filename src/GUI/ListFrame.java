package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListFrame extends JFrame {
    private JPanel panelNorthWest = new JPanel();
    private JPanel panelNorthCenter = new JPanel();
    private JPanel panelNorthEast = new JPanel();
    private JPanel panelNorth = new JPanel();
    private JPanel panelSouth = new JPanel();

    private JList playersList;
    private JTable playersTable;
    private JLabel addLbl = new JLabel("Added Players");
    private JButton addPlayerBtn = new JButton("Add Player");
    private JButton importBtn = new JButton("Import Teams");
    private JButton startBtn = new JButton("Start Tournament");
    private JScrollPane scrollPane;
    private JLabel empty = new JLabel("");

    private Color color = Color.decode("#763838");
    private Font font = new Font("SanSerif", Font.BOLD, 15);
    private Border border = BorderFactory.createLineBorder(Color.black);
//    private JButton goBtn = new JButton("OK");

    private JTable table;
    private DefaultTableModel model;
    private JLabel teamsLbl = new JLabel("Teams");
    private String[] header = {"Teams" , "P1", "P2", "P3","P4", "P5"};
    private String[] listHead = {"Added Players"};

    ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/ET.png").getImage().getScaledInstance(200, 250, Image.SCALE_DEFAULT));
    private JLabel imageLbl = new JLabel(imageIcon);

    public ListFrame(){
        super("Easy Tournament");
//        setSize(new Dimension(1600,1000));
        setSize(new Dimension(1200,850));
        setBackground(color);
        setupNorth();
        setupSouth();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setupNorth(){
        add(panelNorth,BorderLayout.NORTH);
        panelNorth.add(panelNorthWest,BorderLayout.WEST);
        panelNorth.add(panelNorthCenter, BorderLayout.CENTER);
        panelNorth.add(panelNorthEast,BorderLayout.EAST);
        panelNorth.setBackground(color);
        panelNorthEast.setBackground(color);
        panelNorthWest.setBackground(color);
        panelNorthCenter.setBackground(color);

        panelNorth.setPreferredSize(new Dimension(1190,400));
        panelNorthWest.setPreferredSize(new Dimension(470,400));
        panelNorthCenter.setPreferredSize(new Dimension(150,400));
        panelNorthEast.setPreferredSize(new Dimension(350,400));

//        panelNorthWest.add(addLbl);
//        addLbl.setPreferredSize(new Dimension(450,20));
//        playersList = new JList(listHead);
//        playersList.setFixedCellWidth(430);
        playersTable = new JTable(new DefaultTableModel(listHead,0));
//        playersList.setFixedCellHeight(250);
//        playersList.setPreferredSize(new Dimension(430,330));
//        playersList.setVisibleRowCount(14);
        playersTable.setPreferredSize(new Dimension(430,300));
//        playersTable.setVisibleRowCount(14);
        scrollPane = new JScrollPane(playersTable);
        panelNorthWest.add(scrollPane);
        addLbl.setFont(font);

        panelNorthCenter.add(empty);
        panelNorthCenter.add(addPlayerBtn);
        panelNorthCenter.add(importBtn);
        panelNorthCenter.add(startBtn);
        empty.setPreferredSize(new Dimension(120,60));
        addPlayerBtn.setPreferredSize(new Dimension(120,50));
        importBtn.setPreferredSize(new Dimension(120,50));
        startBtn.setPreferredSize(new Dimension(120,50));

//        panelNorthEast.add(goBtn);
//        goBtn.setPreferredSize(new Dimension(90,30));
        panelNorthEast.add(imageLbl);



    }

    public void setupSouth(){
        add(panelSouth,BorderLayout.SOUTH);
        panelSouth.setPreferredSize(new Dimension(1190,428));
        panelSouth.setBackground(color);

//        panelSouth.add(teamsLbl);
//        teamsLbl.setPreferredSize(new Dimension(1350,20));
//        panelSouth.add(textArea2);
//        textArea2.setPreferredSize(new Dimension(1350,450));


        table = new JTable(new DefaultTableModel(header,0));
        model = (DefaultTableModel) table.getModel();

        JScrollPane scroll = new JScrollPane(table);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panelSouth.add(scroll,BorderLayout.SOUTH);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 300));
        table.setFillsViewportHeight(true);
    }



    public static void main(String[] args) {
        ListFrame listFrame = new ListFrame();
    }

}

