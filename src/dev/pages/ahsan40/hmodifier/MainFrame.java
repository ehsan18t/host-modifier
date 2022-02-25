package dev.pages.ahsan40.hmodifier;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author Ahsan
 */
public class MainFrame extends JFrame {

    // Variables declaration
    //<editor-fold defaultstate="collapsed" desc=" Variable Declarations ">
    private JButton btnAbout;
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
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(Configs.icon))).getImage());
        setResizable(false);

        // change default theme to "Nimbus"
        theme();

        // set app window to center of screen
        this.setLocationRelativeTo(null);

        // action events method reference
        btnAdd.addActionListener(this::btnAddAction);
        btnRemove.addActionListener(this::btnRemoveAction);
        btnLoadFromFile.addActionListener(this::btnLoadFromFileAction);
        btnAbout.addActionListener(this::btnAboutAction);

        // On Select row Removed btn enable
        table.getSelectionModel().addListSelectionListener(event -> {
            btnRemove.setEnabled(true);
        });
    }

    private void initComponents() {
        // Main components
        hosts = new Host();

        // swing components initialization
        scrollPane = new JScrollPane();
        table = new JTable();

        lblTable = new JLabel("Blocked Site List");
        lblTable.setFont(new Font("Segoe UI", 0, 18)); // NOI18N

        btnAbout = new JButton();
        btnAbout.setBorder(null);
        btnAbout.setBorderPainted(false);
        btnAbout.setFocusPainted(false);
        btnAbout.setContentAreaFilled(false);
        btnAbout.setIcon(new ImageIcon("src/res/img/info.png")); // NOI18N

        btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Segoe UI", 0, 16)); // NOI18N

        btnRemove = new JButton("Remove");
        btnRemove.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        btnRemove.setEnabled(false);

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
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, Short.MAX_VALUE)
                                                .addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnLoadFromFile, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                                                .addGap(22, 22, 22))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(scrollPane, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 621, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblTable, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnAbout, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTable)
                                        .addComponent(btnAbout, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLoadFromFile, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
        );

        //</editor-fold>
        pack();
    }

    private void btnAboutAction(ActionEvent actionEvent) {
        new AboutFrame(this);
    }

    private void loadData() {
        ArrayList<String> data = hosts.getHosts();
        for (String line : data) {
            String[] d = line.trim().split(" ");
            model.addRow(d);
        }
    }

    private void btnLoadFromFileAction(ActionEvent actionEvent) {
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(Configs.exHost));
            String line;

            // read external hosts.txt
            while ((line = br.readLine()) != null) {
                list.add(Configs.redirectIP + line);
            }
            br.close();
        } catch (IOException e) {
            System.err.println(" - Host file read failed!");
            e.printStackTrace();
        }

        hosts.blockSiteFromFile(list, model);
        list.clear();
    }

    private void btnRemoveAction(ActionEvent actionEvent) {
        // counting total selected rows
        int size = table.getSelectedRowCount();

        // storing selected index in sorting them (ascending)
        int[] rows = table.getSelectedRows();
        Arrays.sort(rows);

        // reversing arrays (else removing elements from ArrayList & Table may cause exceptions)
        for (int i = 0; i < size / 2; i++) {
            int tmp = rows[i];
            rows[i] = rows[size - i - 1];
            rows[size - i - 1] = tmp;
        }

        // removing selected index
        hosts.removeHost(rows);
        for (int index : rows) {
            model.removeRow(index);
            System.out.println(" - Removing Model Index " + index);
        }
        btnRemove.setEnabled(false);
    }

    private void btnAddAction(ActionEvent actionEvent) {
        new NewItemFrame(hosts, model, this);
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
