package dev.pages.ahsan40.hmodifier;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Ahsan
 */
public class AboutFrame extends JFrame {
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel author;
    private JLabel createdBy;
    private JLabel github;
    private JLabel source;
    private JLabel title;
    public AboutFrame(JFrame frame) {
        initComponents();
        theme();
        frame.setEnabled(false);

        // window settings
        setTitle("About Me");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setEnabled(true);
                e.getWindow().dispose();
            }
        });
        this.setLocationRelativeTo(null);
        setVisible(true);

        // Link Action
        github.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                linkClick(Configs.github);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                github.setForeground(new Color(0, 136, 167));
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                github.setForeground(new Color(0, 51, 204));

            }
        });
        source.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                linkClick(Configs.source);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                source.setForeground(new Color(0, 136, 167));
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                source.setForeground(new Color(0, 51, 204));

            }
        });
    }

    void linkClick(String link) {
        try {
            Desktop.getDesktop().browse(new URI(link));
        } catch (URISyntaxException | IOException ex) {
            System.err.println(" - Link open failed!");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        title = new JLabel();
        createdBy = new JLabel();
        author = new JLabel();
        github = new JLabel();
        source = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new Font("MS UI Gothic", 0, 42)); // NOI18N
        title.setText(Configs.title + " " + Configs.version);

        createdBy.setFont(new Font("Lucida Handwriting", 0, 24)); // NOI18N
        createdBy.setText("Created  By");

        author.setFont(new Font("Segoe Print", 1, 36)); // NOI18N
        author.setText(Configs.author);

        github.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        github.setForeground(new Color(0, 51, 204));
        github.setText("Github Profile");

        source.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        source.setForeground(new Color(0, 51, 204));
        source.setText("Source Code");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(author)
                                                .addContainerGap(102, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(github)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(source)
                                                .addGap(71, 71, 71))))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(createdBy, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                                .addGap(109, 109, 109))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(title)
                                                .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(title, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(createdBy)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(author)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(github)
                                        .addComponent(source))
                                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

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
    // End of variables declaration//GEN-END:variables
}
