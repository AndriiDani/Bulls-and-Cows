package view;

import controller.Face;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainMenu extends JFrame {
    private final ScreenLocation size = new ScreenLocation();
    private final JButton exit = new JButton();
    private final JButton againstcomp = new JButton();
    private final JButton withcomp = new JButton();
    private final JButton settings = new JButton();
    private final JLabel label = new JLabel();

    public MainMenu() {
        initComponents();
        size.setWindowLocation(50,45);
        startFrame();
    }

    public void initComponents() {
        label.setIcon(new ImageIcon("src/resources/mainPicture.png"));
        exit.setText("Вихід");
        exit.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        againstcomp.setText("Відгадати число");
        withcomp.setText("Загадати число");
        settings.setText("Налаштування");
        againstcomp.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                againstcompActionPerformed(evt);
            }
        });
        settings.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });
        withcomp.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                withcompActionPerformed(evt);
            }
        });
    }


    private void exitActionPerformed(java.awt.event.ActionEvent e) {
        System.exit(0);

    }

    private void againstcompActionPerformed(java.awt.event.ActionEvent e) {
        dispose();
        Face.startAgainst();
    }

    private void settingsActionPerformed(java.awt.event.ActionEvent e) {
        Face.startSettings();
    }

    private void withcompActionPerformed(java.awt.event.ActionEvent e) {
        dispose();
        Face.startWith();
    }


    private void startFrame() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(208, 208, 208)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(withcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                // .addComponent(players, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(againstcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        // .addComponent(players, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(againstcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(withcomp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(settings, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
        );
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Бики та корови");
        setResizable(false);
        setVisible(true);
        try {
            setIconImage(ImageIO.read(new File("src/resources/icon.png")));
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        setBounds(size.getLocationX(),size.getLocationY(),size.getWidth(),size.getHeight());
        pack();
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}