package view;

import logics.Condition;
import logics.Controll;
import logics.ErrorType;
import logics.GenerateNumb;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class AgainstComp extends JFrame {
    final private GenerateNumb gen = new GenerateNumb();
    final private ErrorType er = new ErrorType();
    final private Condition cond = new Condition();
    final private JButton input = new JButton();
    final private JButton backMenu = new JButton();
    final private JButton capitulate = new JButton();
    final private JButton newGame = new JButton();
    final private JLabel numbCountLabel = new JLabel();
    final private JLabel timerLabel = new JLabel();
    final private JLabel settingsLabel = new JLabel();
    final private JScrollPane jScrollPane1 = new JScrollPane();
    final private Font font = new Font("Tahoma", 0, 14);
    private DefaultTableModel model;
    private JTextField jTextField1 = new JTextField();

    public AgainstComp() {
        initComponents();
        table();
        screen();
        startFrame();

    }

    private void screen() {
        final int sizeWidth;
        final int sizeHeight;
        final int locationX;
        final int locationY;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Загадати число");
        setResizable(false);
        setVisible(true);
        try {
            setIconImage(ImageIO.read(new File("res/bicho1.png")));
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        sizeWidth = 450;
        sizeHeight = 359;
        locationX = (screenSize.width - sizeWidth) / 2;
        locationY = (screenSize.height - sizeHeight) / 2;
        setBounds(locationX, locationY, sizeWidth, sizeHeight);
    }

    private void table() {
        String headers[] = {"Cпроба", "Число", "", ""};
        final Object rows[][] = {};
        model = new DefaultTableModel(rows, headers) {
            public boolean isCellEditable(int row, int headers) {
                return false;
            }
        };
        JTable jTable1 = new JTable(model);
        jScrollPane1.setViewportView(jTable1);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for(int i = 0;i<4;i++){
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}
        Icon cowIcon = new ImageIcon("res/korovka.png");
        Icon bullIcon = new ImageIcon("res/bichochok.png");
        Border headerBorder = UIManager.getBorder("TableHeader.cellBorder");
        JLabel cowLabel = new JLabel(headers[3], cowIcon, JLabel.CENTER);
        cowLabel.setBorder(headerBorder);
        JLabel bullLabel = new JLabel(headers[2], bullIcon, JLabel.CENTER);
        bullLabel.setBorder(headerBorder);
        TableCellRenderer renderer = new JComponentTableCellRenderer();
        TableColumnModel columnModel = jTable1.getColumnModel();
        TableColumn column3 = columnModel.getColumn(3);
        TableColumn column2 = columnModel.getColumn(2);
        column3.setHeaderRenderer(renderer);
        column3.setHeaderValue(cowLabel);
        column2.setHeaderRenderer(renderer);
        column2.setHeaderValue(bullLabel);
    }

    private void initComponents() {
        backMenu.setText("Повернутись до меню");
        timerLabel.setFont(font);
        numbCountLabel.setFont(font);
        timerLabel.setFont(font);
        settingsLabel.setFont(font);
        input.setFont(font);
        newGame.setFont(font);
        capitulate.setFont(font);
        numbCountLabel.setText("Кількість цифр у числі");
        timerLabel.setText("Таймер");
        settingsLabel.setText("Налаштування");


        jTextField1.setFont(new Font("Tahoma", 0, 14));
        input.setText("Ввід");
        input.setToolTipText("Якщо впевнені");
        KeyListener listener = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        };
        jTextField1.addKeyListener(listener);


        input.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });
        capitulate.setText("Здаюсь");
        capitulate.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                capitulateActionPerformed(evt);
            }
        });
        newGame.setText("Нова гра");
        newGame.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        backMenu.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backMenuActionPerformed(evt);
            }
        });
        backMenu.setPreferredSize(new Dimension(180, 30));
        jScrollPane1.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }

    private void endGame() {
        cond.setGuesses(0);
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        gen.getNumber(cond);
    }

    private void startFrame() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backMenu, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(input, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(capitulate)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(newGame)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(64, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                                .addGap(120, 120, 120))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(input)
                                        .addComponent(capitulate)
                                        .addComponent(newGame)
                                        .addComponent(backMenu))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
        endGame();
    }

    private void inputActionPerformed(ActionEvent e) {
        if (jTextField1.getText().isEmpty()) {
            er.Error1();
        } else {
            if (cond.getExceptedNumb().contains(Integer.parseInt(jTextField1.getText()))) {
                er.Error2();
            } else {
                cond.setGuessStr(jTextField1.getText());
            }
        }

        if (Integer.valueOf(cond.getGuessStr().length()) != cond.getSize()) {
            er.Error(cond);
        } else {
            if (cond.getExceptedNumb().contains(Integer.parseInt(cond.getGuessStr()))) {
                ;
            } else {
                cond.cond(gen);

                model.insertRow(model.getRowCount(), new Object[]{cond.getGuesses(), cond.getGuessStr(), cond.getBullcount(), cond.getCowcount()});
                cond.setCowcount(0);
                cond.setBullcount(0);

                jTextField1.setText(null);
            }
        }
        if(cond.isGuessed()){
            input.setEnabled(false);
            jTextField1.setEnabled(false);
            capitulate.setEnabled(false);}
    }

    private void newGameActionPerformed(ActionEvent e) {
        jTextField1.setText(null);
        jTextField1.setEnabled(true);
        input.setEnabled(true);
        cond.getExceptedNumb().clear();
        endGame();
    }

    private void capitulateActionPerformed(ActionEvent e) {
        er.GiveUp(gen);
        endGame();
    }

    private void backMenuActionPerformed(ActionEvent e) {
        cond.getExceptedNumb().clear();
        setVisible(false);
        Controll.menu();
    }

}