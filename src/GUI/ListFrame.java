package GUI;

import javax.swing.*;
import java.awt.*;

public class ListFrame extends JFrame {
    private JPanel panelNorthWest = new JPanel();
    private JPanel panelNorthCenter = new JPanel();
    private JPanel panelNorthEast = new JPanel();
    private JPanel panelNorth = new JPanel();
    private JPanel panelSouth = new JPanel();

    private JList playersList;
    private JLabel addLbl = new JLabel("Added Players");
    private JButton addPlayerBtn = new JButton("Add Player");
    private JButton importBtn = new JButton("Import Teams");
    private JButton startBtn = new JButton("Start Tournament");
    private JScrollPane scrollPane;

    private JButton goBtn = new JButton("OK");

    private JTable teamsTable;
    private JLabel teamsLbl = new JLabel("Teams");
    private String[] header = {"Teams" , "P1", "P2", "P3"};

    private JTextArea textArea = new JTextArea();
    private JTextArea textArea2 = new JTextArea();


    private String [] pizzas = {"Kalle", "Japp" , "Bulle" , "Kanske"};

    public ListFrame(){
        super("Easy Tournament");
        setSize(new Dimension(1600,1000));
        setVisible(true);
        setupNorth();
        setupSouth();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setupNorth(){
        add(panelNorth,BorderLayout.NORTH);
        panelNorth.add(panelNorthWest,BorderLayout.WEST);
        panelNorth.add(panelNorthCenter,BorderLayout.CENTER);
        panelNorth.add(panelNorthEast,BorderLayout.EAST);
        panelNorth.setPreferredSize(new Dimension(1550,490));
        panelNorthWest.setPreferredSize(new Dimension(650,480));
        panelNorthCenter.setPreferredSize(new Dimension(300,480));
        panelNorthEast.setPreferredSize(new Dimension(450,480));

        panelNorthWest.add(addLbl);
        addLbl.setPreferredSize(new Dimension(550,20));
//        playersList = new JList(pizzas);
//        playersList.setPreferredSize(new Dimension(550,400));
//        playersList.setVisibleRowCount(5);
//        scrollPane = new JScrollPane(playersList);
//        panelNorthWest.add(scrollPane);
        panelNorthWest.add(textArea);
        textArea.setPreferredSize(new Dimension(550,400));

        panelNorthCenter.add(addPlayerBtn);
        panelNorthCenter.add(importBtn);
        panelNorthCenter.add(startBtn);
        addPlayerBtn.setPreferredSize(new Dimension(160,40));
        importBtn.setPreferredSize(new Dimension(160,40));
        startBtn.setPreferredSize(new Dimension(160,40));

        panelNorthEast.add(goBtn);
        goBtn.setPreferredSize(new Dimension(90,40));




    }

    public void setupSouth(){
        add(panelSouth,BorderLayout.SOUTH);
        panelSouth.setPreferredSize(new Dimension(1400,500));

        panelSouth.add(teamsLbl);
        teamsLbl.setPreferredSize(new Dimension(1350,20));
        panelSouth.add(textArea2);
        textArea2.setPreferredSize(new Dimension(1350,450));
//
//        panelSouth.add(teamsTable);
//        teamsTable = new JTable(null, header);
//        panelSouth.add(new JScrollPane(teamsTable));

    }

    public static void main(String[] args) {
        ListFrame listFrame = new ListFrame();
//        listFrame.setupNorth();
//        listFrame.setupSouth();
    }

}

