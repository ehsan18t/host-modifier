/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dev.pages.ahsan400.hmodifier;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 *
 * @author Ahsan
 */
public class MainFrame extends JFrame {

    // Variables declaration
    //<editor-fold defaultstate="collapsed" desc=" Variable Declarations ">
    private JButton btnAdd;
    private JButton btnRemove;
    private JButton btnLoadFromFile;
    private JLabel lblTable;
    private JScrollPane scrollPane;
    private JTable table;
    private Host hosts;
    private DefaultTableModel model;
    // End of variables declaration
    //</editor-fold>

    public MainFrame() {
        // init
        initComponents();
        loadData();
        
        // window settings
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(Configs.title + " " + Configs.version);
//        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(Config.icon))).getImage());
        setResizable(false);

        // change default theme to "Nimbus"
        theme();

        // set app window to center of screen
        this.setLocationRelativeTo(null);

        // action events method reference
        btnAdd.addActionListener(this::btnAddAction);
        btnRemove.addActionListener(this::btnRemoveAction);
        btnLoadFromFile.addActionListener(this::btnLoadFromFileAction);
    }

    private void loadData() {
        ArrayList<String> data = hosts.getHosts();
        for (String line: data) {
            if (!line.startsWith("#") && !line.trim().isEmpty()) {
                String[] d = line.trim().split(" ");
                model.addRow(d);
            }
        }
    }

    private void btnLoadFromFileAction(ActionEvent actionEvent) {
    }

    private void btnRemoveAction(ActionEvent actionEvent) {
    }

    private void btnAddAction(ActionEvent actionEvent) {
    }

    private void initComponents() {
        // Main components
        hosts = new Host();

        // swing components initialization
        scrollPane = new JScrollPane();
        table = new JTable();

        lblTable = new JLabel("Blocked Site List");
        lblTable.setFont(new Font("Segoe UI", 0, 18)); // NOI18N

        btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Segoe UI", 0, 16)); // NOI18N

        btnRemove = new JButton("Remove");
        btnRemove.setFont(new Font("Segoe UI", 0, 16)); // NOI18N

        btnLoadFromFile = new JButton("Load From File");
        btnLoadFromFile.setFont(new Font("Segoe UI", 0, 16)); // NOI18N

        // table init
        table = new JTable() {
            // making table non-editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        scrollPane = new JScrollPane();
        model = new DefaultTableModel();
        model.addColumn("Redirected IP");
        model.addColumn("Site");

        table.setFont(new java.awt.Font("sanserif", Font.PLAIN, 18));
        table.setModel(model);
        table.setRowHeight(35);
        table.getTableHeader().setPreferredSize(new Dimension(table.getWidth(), 35));

        table.getColumnModel().getColumn(0).setPreferredWidth(170);
        table.getColumnModel().getColumn(0).setMaxWidth(170);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        scrollPane.setViewportView(table);

        // Layout Settings
        // Done with NetBeans
        //<editor-fold defaultstate="collapsed" desc=" initialization Codes ">
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTable, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLoadFromFile, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 621, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTable)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadFromFile, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        //</editor-fold>
        pack();
    }

    private void theme() {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (UnsupportedLookAndFeelException exc) {
            System.err.println("Nimbus: Unsupported Look and feel!");
        }
        //</editor-fold>
    }
}
