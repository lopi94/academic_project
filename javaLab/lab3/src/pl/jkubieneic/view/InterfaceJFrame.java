/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * package pl.jkubieniec.view cointain class responsible for program interface
 */
package pl.jkubieneic.view;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import pl.jkubieniec.model.Quiz;
import pl.jkubieniec.model.Results;

/**
 * Class responsible for interface
 * @author Julia Kubieniec
 * @version 1.0
 */
public class InterfaceJFrame extends javax.swing.JFrame {
    /**
    * variable holding the controller of the main class 
    */
    private Quiz controler; 
    
    /**
     * variable holds the current number of questions in quiz 1
     */
    private int questionNumberQuiz1 = 1;
    /**
     * variable holds the current number of questions in quiz 2
     */
    private int questionNumberQuiz2 = 1;
    /**
     * variable holds the current number of questions in quiz 3
     */
    private int questionNumberQuiz3 = 1;
    /**
     * variable holds user nick
     */
    private String nick;
    /**
     *  variable holds the numner of rows in result table
     */
    private int numberOfRows = 0;
    /**
     * variable to define if save result to file results.txt
     */
    private boolean saveResults = false;
    
    /**
     * Creates new form InterfaceJFrame
     * @param quiz object that holds quizzes
     * @param nick user nick
     */
    public InterfaceJFrame(Quiz quiz, String nick) {
        this.controler = getControler(quiz);
        this.nick = nick;
        initMyComponents();
    }
    
    /**
     * method responsible for passing control of the primary class
     * @param controler variable holding the controller of the main class
     * @return controler
     */
    private Quiz getControler(Quiz controler) {
        return controler;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initMyComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quiz");

        jToolBar1.setRollover(true);
        
        jButton1.setText("<  previous question  ");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setText("  next question  >");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setText("   End Quiz ");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText(controler.getText(0,0,"A"));
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
		
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText(controler.getText(0,0,"B"));
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText(controler.getText(0,0,"C"));
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
		
        jLabel1.setText("Android");

        jLabel2.setText(controler.getText(0,0,"Q"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addGap(14, 14, 14)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quiz #1", jPanel1);

        jToolBar2.setRollover(true);

        jButton4.setText("<  previous question  ");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton4);

        jButton5.setText("  next question  >");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton5);

        jButton6.setText("   End Quiz");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton6);

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText(controler.getText(1,0,"A"));
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText(controler.getText(1,0,"B"));
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText(controler.getText(1,0,"C"));
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });
        
        jLabel3.setText("Korposlang");

        jLabel4.setText(controler.getText(1,0,"Q"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(jRadioButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jRadioButton4)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton5)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton6)
                .addGap(18, 18, 18)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quiz #2", jPanel2);

        jToolBar3.setRollover(true);

        jButton7.setText("<  previous question  ");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton7);

        jButton8.setText("  next question  >");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton8);

        jButton9.setText("   End Quiz");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton9);

        buttonGroup3.add(jRadioButton7);
        jRadioButton7.setText(controler.getText(2,0,"A"));
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButton8);
        jRadioButton8.setText(controler.getText(2,0,"B"));
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });

        buttonGroup3.add(jRadioButton9);
        jRadioButton9.setText(controler.getText(2,0,"C"));
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });

        jLabel5.setText("Design patterns");

        jLabel6.setText(controler.getText(2,0,"Q"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(jRadioButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton7)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton8)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton9)
                .addGap(18, 18, 18)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quiz #3", jPanel3);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nick", "Quiz number", "Score"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        try {
            if(controler.getResultsFromFile()){
                List<Results<String,Integer>> tmp = controler.getResults();
                for(Results x : tmp) {
                    if(numberOfRows > 100) {
                        numberOfRows = 0;
                    }
                    jTable1.setValueAt(x.getNick(),numberOfRows,0);
                    jTable1.setValueAt(x.getWhichQuiz(),numberOfRows,1); 
                    jTable1.setValueAt(x.getScore(),numberOfRows,2);
                    numberOfRows++;
                }
                saveResults = true;
            }
        } catch ( IOException e) {
            JOptionPane.showMessageDialog(null,"Error: " +  e, "Error", JOptionPane.ERROR_MESSAGE);    
        }
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Results", jPanel4);
                
        jMenu1.setText("About");
        jMenuBar1.add(jMenu1);
        jMenuItem4.setText("About");
        jMenu1.add(jMenuItem4);
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuItem5.setText("Help");
        jMenu1.add(jMenuItem5);
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        
        jMenu2.setText("Look&Feel");
        jMenuBar1.add(jMenu2);
        jMenuItem1.setText("Motif");
        jMenu2.add(jMenuItem1);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jMenuItem1ActionPerformed(evt);
                } catch (Exception e) {
                   JOptionPane.showMessageDialog(null,"Error: " +  e, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        jMenuItem2.setText("Windows");
        jMenu2.add(jMenuItem2);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jMenuItem2ActionPerformed(evt);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Error: " +  e, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        jMenuItem3.setText("Nimbus");
        jMenu2.add(jMenuItem3);
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jMenuItem3ActionPerformed(evt);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Error: " +  e, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }

    ////////////////////////////////////////////////////////////////////////////
    /*Menu*/
    ////////////////////////////////////////////////////////////////////////////
    /**
     * Method responsile for set MotifLookAndFeel
     * @param evt ActionEvent
     * @throws Exception 
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);
        pack();
    }
    
    /**
     * Method responsile for set WindowsLookAndFeel
     * @param evt ActionEvent
     * @throws Exception 
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);
        pack();
    }
    
    /**
     * Method responsile for set NimbusLookAndFeel
     * @param evt ActionEvent
     * @throws Exception 
     */
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingUtilities.updateComponentTreeUI(this);
        pack();
    }
    
    /**
     * method responsiblle for show message about program
     * @param evt ActionEvent 
     */
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this,"Program written for Java lab");
    }
    
    /**
     * methodresponsible for show program help
     * @param evt ActionEvent
     */
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this,"Using the program is intuitive. You can solve several Quiz at once.");
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /* Results */
    ////////////////////////////////////////////////////////////////////////////
    /**
     * method responsible for set quiz results in table results
     * @param score number of points scored in the quiz
     * @param whichQuiz quiz ID
     * @param nick user nick
     */
    private void setResults(int score,String whichQuiz, String nick) {
        if(numberOfRows > 100) {
            numberOfRows = 0;
        }
        jTable1.setValueAt(nick,numberOfRows,0);
        jTable1.setValueAt(whichQuiz,numberOfRows,1); 
        jTable1.setValueAt(score,numberOfRows,2);
        numberOfRows++;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /*Quiz #1*/
    ////////////////////////////////////////////////////////////////////////////
    /**
     * method responsible for set user anwser A in Quiz 1
     * @param evt ActionEvent 
     */
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        controler.setAnswerUser(0,questionNumberQuiz1-1,"A");
    }

    /**
     * method responsible for set user anwser B in Quiz 1
     * @param evt ActionEvent 
     */
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        controler.setAnswerUser(0,questionNumberQuiz1-1,"B");
    }
    
    /**
     * method responsible for set user anwser C in Quiz 1
     * @param evt ActionEvent 
     */
    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        controler.setAnswerUser(0,questionNumberQuiz1-1,"C");
    }
     
    /**
     * method responsible for navigate backward in Quiz 1
     * @param evt ActionEvent 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(questionNumberQuiz1 > 1){
            questionNumberQuiz1--;
            jLabel2.setText(controler.getText(0,questionNumberQuiz1-1,"Q"));
            jRadioButton1.setText(controler.getText(0,questionNumberQuiz1-1,"A"));
            jRadioButton2.setText(controler.getText(0,questionNumberQuiz1-1,"B"));
            jRadioButton3.setText(controler.getText(0,questionNumberQuiz1-1,"C"));
            String tmp = controler.getText(0,questionNumberQuiz1-1,"U");
            switch(tmp) {
                case "A" : jRadioButton1.setSelected(true);
                    break;
                case "B" : jRadioButton2.setSelected(true);
                    break;
                case "C" : jRadioButton3.setSelected(true);
                    break;
                default :
                    buttonGroup1.clearSelection();
                    break;
            }
        }
    }  
    
    /**
     * method responsible for navigate forward in Quiz 1
     * @param evt ActionEvent 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(questionNumberQuiz1 < 5){
            questionNumberQuiz1++;
            jLabel2.setText(controler.getText(0,questionNumberQuiz1-1,"Q"));
            jRadioButton1.setText(controler.getText(0,questionNumberQuiz1-1,"A"));
            jRadioButton2.setText(controler.getText(0,questionNumberQuiz1-1,"B"));
            jRadioButton3.setText(controler.getText(0,questionNumberQuiz1-1,"C"));
            String tmp = controler.getText(0,questionNumberQuiz1-1,"U");
            switch(tmp) {
                case "A" : jRadioButton1.setSelected(true);
                    break;
                case "B" : jRadioButton2.setSelected(true);
                    break;
                case "C" : jRadioButton3.setSelected(true);
                    break;
                default :
                    buttonGroup1.clearSelection();
                    break;
            }
        }
    }
    
    /**
     * method responsible for end quiz and save results in Quiz 1
     * @param evt ActionEvent 
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        questionNumberQuiz1 = 1;
        jLabel2.setText(controler.getText(0,questionNumberQuiz1-1,"Q"));
        jRadioButton1.setText(controler.getText(0,questionNumberQuiz1-1,"A"));
        jRadioButton2.setText(controler.getText(0,questionNumberQuiz1-1,"B"));
        jRadioButton3.setText(controler.getText(0,questionNumberQuiz1-1,"C"));
        String tmp = controler.getText(0,questionNumberQuiz1-1,"U");
        controler.setResults(0,nick);
        JOptionPane.showMessageDialog(this,"Your score: " + Integer.toString(controler.getScore()));
        setResults(controler.getScore(), "Quiz #1",  nick);
        if(saveResults) { 
            try {
                controler.saveResultsToFile(nick, "Quiz #1", controler.getScore());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,"Error: " +  e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        buttonGroup1.clearSelection();
        for(int i = 0; i < 5; i++){
            controler.setAnswerUser(0, i, "");
        }
    }
	
    ////////////////////////////////////////////////////////////////////////////    
    /*Quiz #2*/
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * method responsible for set user anwser A in Quiz 2
     * @param evt ActionEvent 
     */
    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        controler.setAnswerUser(1,questionNumberQuiz2-1,"A");
    }                                             

    /**
     * method responsible for set user anwser B in Quiz 2
     * @param evt ActionEvent 
     */
    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        controler.setAnswerUser(1,questionNumberQuiz2-1,"B");
    }                                             
    
    /**
     * method responsible for set user anwser C in Quiz 2
     * @param evt ActionEvent 
     */
    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        controler.setAnswerUser(1,questionNumberQuiz2-1,"C");
    }
     
    /**
     * method responsible for navigate backward in Quiz 2
     * @param evt ActionEvent 
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(questionNumberQuiz2 > 1){
            questionNumberQuiz2--;
            jLabel4.setText(controler.getText(1,questionNumberQuiz2-1,"Q"));
            jRadioButton4.setText(controler.getText(1,questionNumberQuiz2-1,"A"));
            jRadioButton5.setText(controler.getText(1,questionNumberQuiz2-1,"B"));
            jRadioButton6.setText(controler.getText(1,questionNumberQuiz2-1,"C"));
            String tmp = controler.getText(1,questionNumberQuiz2-1,"U");
            switch(tmp) {
                case "A" : jRadioButton4.setSelected(true);
                    break;
                case "B" : jRadioButton5.setSelected(true);
                    break;
                case "C" : jRadioButton6.setSelected(true);
                    break;
                default :
                    buttonGroup2.clearSelection();
                    break;
            }
        }
    }  
    
    /**
     * method responsible for navigate forward in Quiz 2
     * @param evt ActionEvent 
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(questionNumberQuiz2 < 5){
            questionNumberQuiz2++;
            jLabel4.setText(controler.getText(1,questionNumberQuiz2-1,"Q"));
            jRadioButton4.setText(controler.getText(1,questionNumberQuiz2-1,"A"));
            jRadioButton5.setText(controler.getText(1,questionNumberQuiz2-1,"B"));
            jRadioButton6.setText(controler.getText(1,questionNumberQuiz2-1,"C"));
            String tmp = controler.getText(0,questionNumberQuiz2-1,"U");
            switch(tmp) {
                case "A" : jRadioButton4.setSelected(true);
                    break;
                case "B" : jRadioButton5.setSelected(true);
                    break;
                case "C" : jRadioButton6.setSelected(true);
                    break;
                default :
                    buttonGroup2.clearSelection();
                    break;
            }
        }
    }
    
    /**
     * method responsible for end quiz and save results in Quiz 2
     * @param evt ActionEvent 
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        questionNumberQuiz2 = 1;
        jLabel2.setText(controler.getText(0,questionNumberQuiz1-1,"Q"));
        jRadioButton1.setText(controler.getText(0,questionNumberQuiz1-1,"A"));
        jRadioButton2.setText(controler.getText(0,questionNumberQuiz1-1,"B"));
        jRadioButton3.setText(controler.getText(0,questionNumberQuiz1-1,"C"));
        String tmp = controler.getText(0,questionNumberQuiz1-1,"U");
        controler.setResults(1,nick);
        JOptionPane.showMessageDialog(this,"Your score: " + Integer.toString(controler.getScore()));
        setResults(controler.getScore(), "Quiz #2", nick);
        if(saveResults) { 
            try {
                controler.saveResultsToFile(nick, "Quiz #2", controler.getScore());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,"Error: " +  e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        buttonGroup2.clearSelection();
        for(int i = 0; i < 5; i++){
            controler.setAnswerUser(1, i, "");
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////
    /*Quiz #3*/
    ////////////////////////////////////////////////////////////////////////////

    /**
     * method responsible for set user anwser A in Quiz 3
     * @param evt ActionEvent 
     */
    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        controler.setAnswerUser(2,questionNumberQuiz3-1,"A");
    }                                             

    /**
     * method responsible for set user anwser B in Quiz 3
     * @param evt ActionEvent 
     */
    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        controler.setAnswerUser(2,questionNumberQuiz3-1,"B");
    }                                             
    
    /**
     * method responsible for set user anwser C in Quiz 3
     * @param evt ActionEvent 
     */
    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        controler.setAnswerUser(2,questionNumberQuiz3-1,"C");
    }
     
    /**
     * method responsible for navigate backward in Quiz 3
     * @param evt ActionEvent 
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(questionNumberQuiz3 > 1){
            questionNumberQuiz3--;
            jLabel6.setText(controler.getText(2,questionNumberQuiz3-1,"Q"));
            jRadioButton7.setText(controler.getText(2,questionNumberQuiz3-1,"A"));
            jRadioButton8.setText(controler.getText(2,questionNumberQuiz3-1,"B"));
            jRadioButton9.setText(controler.getText(2,questionNumberQuiz3-1,"C"));
            String tmp = controler.getText(2,questionNumberQuiz3-1,"U");
            switch(tmp) {
                case "A" : jRadioButton7.setSelected(true);
                    break;
                case "B" : jRadioButton8.setSelected(true);
                    break;
                case "C" : jRadioButton9.setSelected(true);
                    break;
                default :
                    buttonGroup3.clearSelection();
                    break;
            }
        }
    }  
    
    /**
     * method responsible for navigate forward in Quiz 1
     * @param evt ActionEvent 
     */
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(questionNumberQuiz3 < 5){
            questionNumberQuiz3++;
            jLabel6.setText(controler.getText(2,questionNumberQuiz3-1,"Q"));
            jRadioButton7.setText(controler.getText(2,questionNumberQuiz3-1,"A"));
            jRadioButton8.setText(controler.getText(2,questionNumberQuiz3-1,"B"));
            jRadioButton9.setText(controler.getText(2,questionNumberQuiz3-1,"C"));
            String tmp = controler.getText(2,questionNumberQuiz3-1,"U");
            switch(tmp) {
                case "A" : jRadioButton7.setSelected(true);
                    break;
                case "B" : jRadioButton8.setSelected(true);
                    break;
                case "C" : jRadioButton9.setSelected(true);
                    break;
                default :
                    buttonGroup3.clearSelection();
                    break;
            }
        }
    }
    
    /**
     * method responsible for end quiz and save results in Quiz 3
     * @param evt ActionEvent 
     */
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        questionNumberQuiz3 = 1;
        jLabel2.setText(controler.getText(0,questionNumberQuiz1-1,"Q"));
        jRadioButton1.setText(controler.getText(0,questionNumberQuiz1-1,"A"));
        jRadioButton2.setText(controler.getText(0,questionNumberQuiz1-1,"B"));
        jRadioButton3.setText(controler.getText(0,questionNumberQuiz1-1,"C"));
        String tmp = controler.getText(0,questionNumberQuiz1-1,"U");
        controler.setResults(2,nick);
        JOptionPane.showMessageDialog(this,"Your score: " + Integer.toString(controler.getScore()));
        setResults(controler.getScore(), "Quiz #3",  nick);
        if(saveResults) { 
            try {
                controler.saveResultsToFile(nick, "Quiz #3", controler.getScore());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,"Error: " +  e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        buttonGroup3.clearSelection();
        for(int i = 0; i < 5; i++){
            controler.setAnswerUser(2, i, "");
        }
    }
    
	// Variables declaration - do not modify                     
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    // End of variables declaration                   

}
