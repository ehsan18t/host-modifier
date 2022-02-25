package dev.pages.ahsan40.hmodifier;

import javax.swing.*;
import java.awt.Font;

/**
 *
 * @author Ahsan
 */
public class AboutFrame extends JPanel {
    public AboutFrame(JFrame frame) {
        initComponents();


    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        title = new JLabel();
        createdBy = new JLabel();
        author = new JLabel();
        github = new JLabel();
        source = new JLabel();

        title.setFont(new Font("MS UI Gothic", 0, 48)); // NOI18N
        title.setText("Host Modifier v1.0");

        createdBy.setFont(new Font("Lucida Handwriting", 0, 24)); // NOI18N
        createdBy.setText("Created  By");

        author.setFont(new Font("Segoe Print", 1, 36)); // NOI18N
        author.setText("Ahsan Khan");

        github.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        github.setForeground(new java.awt.Color(0, 51, 204));
        github.setText("Github Profile");

        source.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        source.setForeground(new java.awt.Color(0, 51, 204));
        source.setText("Source Code");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(title)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(createdBy, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(author)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(github)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(source)
                                                .addGap(71, 71, 71))))
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
    }// </editor-fold>


    // Variables declaration - do not modify
    private JLabel author;
    private JLabel createdBy;
    private JLabel github;
    private JLabel source;
    private JLabel title;
    // End of variables declaration
}
