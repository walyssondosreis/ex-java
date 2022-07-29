package calculadora;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.UIManager;

public class JFrameCalc extends javax.swing.JFrame {
    //////////////////////////////////////////////////////////////////////////// FONTE PERSONALIZADA APLICACAO
    private static Font fonteBarca;
    private static Font fonteReal;

    private static Font loadFont(String resourceName) {
        InputStream is;
        Font font = null;
        try {
            is = JFrameCalc.class.getResourceAsStream(resourceName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            is.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (FontFormatException ex) {
            ex.printStackTrace();
        }
        return font;
    }

    static {
        fonteBarca = loadFont("/midia/BARCELONA_2012.ttf");
        fonteReal = loadFont("/midia/REAL_MADRID_2014.ttf");
    }
////////////////////////////////////////////////////////////////////////////////
    CalcMotor motorCalc = new CalcMotor();

    public JFrameCalc() {
        initComponents();

        //TROCA O ICONE DA JANELA 
        URL url = this.getClass().getResource("/midia/calc_ico.png");
        Image imagemTituloJanela = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTituloJanela); //TROCA ICONE DO JFRAME

        //LOOK AND FELL
        try {
            //  UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonBKS = new javax.swing.JButton();
        jButtonCE = new javax.swing.JButton();
        jButtonC = new javax.swing.JButton();
        jButtonMaisOuMenos = new javax.swing.JButton();
        jButtonNum7 = new javax.swing.JButton();
        jButtonNum8 = new javax.swing.JButton();
        jButtonNum9 = new javax.swing.JButton();
        jButtonNum4 = new javax.swing.JButton();
        jButtonNum5 = new javax.swing.JButton();
        jButtonNum6 = new javax.swing.JButton();
        jButtonNum1 = new javax.swing.JButton();
        jButtonNum2 = new javax.swing.JButton();
        jButtonNum3 = new javax.swing.JButton();
        jButtonNum0 = new javax.swing.JButton();
        jButtonVirgula = new javax.swing.JButton();
        jButtonDivisao = new javax.swing.JButton();
        jButtonMultiplicacao = new javax.swing.JButton();
        jButtonSubtracao = new javax.swing.JButton();
        jButtonSoma = new javax.swing.JButton();
        jButtonRaizQuadrada = new javax.swing.JButton();
        jButtonPorcentagem = new javax.swing.JButton();
        jButtonInverso = new javax.swing.JButton();
        jButtonIgualdade = new javax.swing.JButton();
        jPanelFundoVisor = new javax.swing.JPanel();
        jTextFieldVisor1 = new javax.swing.JTextField();
        jTextFieldVisor2 = new javax.swing.JTextField();
        jLabelLog1 = new javax.swing.JLabel();
        jLabelLog2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonBKS.setBackground(new java.awt.Color(255, 255, 255));
        jButtonBKS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonBKS.setText("<-");
        jButtonBKS.setFocusPainted(false);
        jButtonBKS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonBKS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonBKS, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 50, 36));

        jButtonCE.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCE.setFont(fonteBarca.deriveFont(18f));
        jButtonCE.setText("CE");
        jButtonCE.setFocusPainted(false);
        jButtonCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonCE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonCE, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 50, 36));

        jButtonC.setBackground(new java.awt.Color(255, 255, 255));
        jButtonC.setFont(fonteBarca.deriveFont(24f));
        jButtonC.setText("C");
        jButtonC.setFocusPainted(false);
        jButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 50, 36));

        jButtonMaisOuMenos.setBackground(new java.awt.Color(255, 255, 255));
        jButtonMaisOuMenos.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jButtonMaisOuMenos.setText("+|-");
        jButtonMaisOuMenos.setFocusPainted(false);
        jButtonMaisOuMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonMaisOuMenos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonMaisOuMenos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 50, 36));

        jButtonNum7.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum7.setFont(fonteBarca.deriveFont(24f));
        jButtonNum7.setText("7");
        jButtonNum7.setFocusPainted(false);
        jButtonNum7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonNum7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonNum7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 50, 36));

        jButtonNum8.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum8.setFont(fonteBarca.deriveFont(24f));
        jButtonNum8.setText("8");
        jButtonNum8.setFocusPainted(false);
        jButtonNum8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonNum8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonNum8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 50, 36));

        jButtonNum9.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum9.setFont(fonteBarca.deriveFont(24f));
        jButtonNum9.setText("9");
        jButtonNum9.setFocusPainted(false);
        jButtonNum9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonNum9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonNum9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 50, 36));

        jButtonNum4.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum4.setFont(fonteBarca.deriveFont(24f));
        jButtonNum4.setText("4");
        jButtonNum4.setFocusPainted(false);
        jButtonNum4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonNum4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonNum4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 50, 36));

        jButtonNum5.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum5.setFont(fonteBarca.deriveFont(24f));
        jButtonNum5.setText("5");
        jButtonNum5.setFocusPainted(false);
        jButtonNum5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonNum5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonNum5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 50, 36));

        jButtonNum6.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum6.setFont(fonteBarca.deriveFont(24f));
        jButtonNum6.setText("6");
        jButtonNum6.setFocusPainted(false);
        jButtonNum6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonNum6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonNum6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 50, 36));

        jButtonNum1.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum1.setFont(fonteBarca.deriveFont(24f));
        jButtonNum1.setText("1");
        jButtonNum1.setFocusPainted(false);
        jButtonNum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonNum1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonNum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 50, 36));

        jButtonNum2.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum2.setFont(fonteBarca.deriveFont(24f));
        jButtonNum2.setText("2");
        jButtonNum2.setFocusPainted(false);
        jButtonNum2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonNum2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonNum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 50, 36));

        jButtonNum3.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum3.setFont(fonteBarca.deriveFont(24f));
        jButtonNum3.setText("3");
        jButtonNum3.setFocusPainted(false);
        jButtonNum3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonNum3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonNum3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 50, 36));

        jButtonNum0.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum0.setFont(fonteBarca.deriveFont(24f));
        jButtonNum0.setText("0");
        jButtonNum0.setFocusPainted(false);
        jButtonNum0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonNum0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonNum0, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 110, 40));

        jButtonVirgula.setBackground(new java.awt.Color(255, 255, 255));
        jButtonVirgula.setFont(fonteReal.deriveFont(24f));
        jButtonVirgula.setText(",");
        jButtonVirgula.setFocusPainted(false);
        jButtonVirgula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonVirgula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonVirgula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 50, 40));

        jButtonDivisao.setBackground(new java.awt.Color(255, 255, 255));
        jButtonDivisao.setFont(fonteReal.deriveFont(24f));
        jButtonDivisao.setText("/");
        jButtonDivisao.setFocusPainted(false);
        jButtonDivisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonDivisao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonDivisao, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 50, 40));

        jButtonMultiplicacao.setBackground(new java.awt.Color(255, 255, 255));
        jButtonMultiplicacao.setFont(fonteReal.deriveFont(24f));
        jButtonMultiplicacao.setText("x");
        jButtonMultiplicacao.setFocusPainted(false);
        jButtonMultiplicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonMultiplicacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonMultiplicacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 50, 36));

        jButtonSubtracao.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSubtracao.setFont(fonteReal.deriveFont(24f));
        jButtonSubtracao.setText("-");
        jButtonSubtracao.setFocusPainted(false);
        jButtonSubtracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonSubtracao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonSubtracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 50, 40));

        jButtonSoma.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSoma.setFont(fonteReal.deriveFont(24f));
        jButtonSoma.setText("+");
        jButtonSoma.setFocusPainted(false);
        jButtonSoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonSoma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonSoma, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 50, 40));

        jButtonRaizQuadrada.setBackground(new java.awt.Color(255, 255, 255));
        jButtonRaizQuadrada.setFont(fonteReal.deriveFont(24f));
        jButtonRaizQuadrada.setText("√");
        jButtonRaizQuadrada.setFocusPainted(false);
        jButtonRaizQuadrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonRaizQuadrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonRaizQuadrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 50, 36));

        jButtonPorcentagem.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPorcentagem.setFont(fonteReal.deriveFont(12f));
        jButtonPorcentagem.setText("%");
        jButtonPorcentagem.setFocusPainted(false);
        jButtonPorcentagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonPorcentagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonPorcentagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 50, 36));

        jButtonInverso.setBackground(new java.awt.Color(255, 255, 255));
        jButtonInverso.setFont(fonteReal.deriveFont(14f));
        jButtonInverso.setText("1/x");
        jButtonInverso.setFocusPainted(false);
        jButtonInverso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonInverso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonInverso, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, 36));

        jButtonIgualdade.setBackground(new java.awt.Color(255, 255, 255));
        jButtonIgualdade.setFont(fonteReal.deriveFont(24f));
        jButtonIgualdade.setText("=");
        jButtonIgualdade.setFocusPainted(false);
        jButtonIgualdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcaoClicar(evt);
            }
        });
        jButtonIgualdade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanel1.add(jButtonIgualdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 50, 90));

        jPanelFundoVisor.setBackground(new java.awt.Color(0, 0, 0));
        jPanelFundoVisor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        jPanelFundoVisor.setEnabled(false);
        jPanelFundoVisor.setLayout(null);

        jTextFieldVisor1.setEditable(false);
        jTextFieldVisor1.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldVisor1.setFont(fonteBarca.deriveFont(48f));
        jTextFieldVisor1.setForeground(new java.awt.Color(255, 255, 0));
        jTextFieldVisor1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldVisor1.setText("_WALLE CALC   ");
        jTextFieldVisor1.setToolTipText("");
        jTextFieldVisor1.setBorder(null);
        jTextFieldVisor1.setDisabledTextColor(new java.awt.Color(255, 255, 0));
        jTextFieldVisor1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonAcaoTeclar(evt);
            }
        });
        jPanelFundoVisor.add(jTextFieldVisor1);
        jTextFieldVisor1.setBounds(10, 60, 290, 40);

        jTextFieldVisor2.setEditable(false);
        jTextFieldVisor2.setBackground(new java.awt.Color(0, 0, 0));
        jTextFieldVisor2.setFont(fonteReal.deriveFont(36f));
        jTextFieldVisor2.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldVisor2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldVisor2.setText("BeM ViNdO!        ");
        jTextFieldVisor2.setBorder(null);
        jTextFieldVisor2.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        jTextFieldVisor2.setEnabled(false);
        jPanelFundoVisor.add(jTextFieldVisor2);
        jTextFieldVisor2.setBounds(10, 10, 290, 50);

        jPanel1.add(jPanelFundoVisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 310, 110));

        jLabelLog1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLog1.setFont(fonteBarca.deriveFont(18f));
        jLabelLog1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.add(jLabelLog1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 40));

        jLabelLog2.setFont(fonteReal.deriveFont(14f));
        jLabelLog2.setForeground(new java.awt.Color(204, 204, 204));
        jLabelLog2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(jLabelLog2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 160, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 410));

        setSize(new java.awt.Dimension(316, 447));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonAcaoClicar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcaoClicar

        JButton botao = (JButton) evt.getSource();
        if (botao.getText().equals("x")) {
            motorCalc.operarConformeEstado("*");
        } else if (botao.getText().equals("+|-")) {
            motorCalc.operarConformeEstado("u");
        } else if (botao.getText().equals("1/x")) {
            motorCalc.operarConformeEstado("i");
        } else if (botao.getText().equals("/")) {
            motorCalc.operarConformeEstado("÷");
        } else {
            motorCalc.operarConformeEstado(botao.getText());
        }


    }//GEN-LAST:event_jButtonAcaoClicar

    private void jButtonAcaoTeclar(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonAcaoTeclar
        if ((evt.getKeyCode() == KeyEvent.VK_0)
                || (evt.getKeyCode() == KeyEvent.VK_1)
                || (evt.getKeyCode() == KeyEvent.VK_2)
                || (evt.getKeyCode() == KeyEvent.VK_3)
                || (evt.getKeyCode() == KeyEvent.VK_4)
                || (evt.getKeyCode() == KeyEvent.VK_5)
                || (evt.getKeyCode() == KeyEvent.VK_6)
                || (evt.getKeyCode() == KeyEvent.VK_7)
                || (evt.getKeyCode() == KeyEvent.VK_8)
                || (evt.getKeyCode() == KeyEvent.VK_9)
                || (evt.getKeyCode() == KeyEvent.VK_NUMPAD0)
                || (evt.getKeyCode() == KeyEvent.VK_NUMPAD1)
                || (evt.getKeyCode() == KeyEvent.VK_NUMPAD2)
                || (evt.getKeyCode() == KeyEvent.VK_NUMPAD3)
                || (evt.getKeyCode() == KeyEvent.VK_NUMPAD4)
                || (evt.getKeyCode() == KeyEvent.VK_NUMPAD5)
                || (evt.getKeyCode() == KeyEvent.VK_NUMPAD6)
                || (evt.getKeyCode() == KeyEvent.VK_NUMPAD7)
                || (evt.getKeyCode() == KeyEvent.VK_NUMPAD8)
                || (evt.getKeyCode() == KeyEvent.VK_NUMPAD9)
                || (evt.getKeyCode() == KeyEvent.VK_ADD)
                || (evt.getKeyCode() == KeyEvent.VK_SUBTRACT)
                || (evt.getKeyCode() == KeyEvent.VK_MULTIPLY)
                || (evt.getKeyCode() == KeyEvent.VK_EQUALS)) {

            motorCalc.operarConformeEstado("" + evt.getKeyChar());

        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            motorCalc.operarConformeEstado("C");
        } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            motorCalc.operarConformeEstado("<-");
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            motorCalc.operarConformeEstado("=");
        } else if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            motorCalc.operarConformeEstado("CE");
        } else if (evt.getKeyChar() == '/' || evt.getKeyCode() == KeyEvent.VK_DIVIDE) {
            motorCalc.operarConformeEstado("÷");
        } else if (evt.getKeyChar() == ',' || evt.getKeyChar() == '.') {
            motorCalc.operarConformeEstado(".");
        }
    }//GEN-LAST:event_jButtonAcaoTeclar

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        jTextFieldVisor1.requestFocus();

    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameCalc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBKS;
    private javax.swing.JButton jButtonC;
    private javax.swing.JButton jButtonCE;
    private javax.swing.JButton jButtonDivisao;
    private javax.swing.JButton jButtonIgualdade;
    private javax.swing.JButton jButtonInverso;
    private javax.swing.JButton jButtonMaisOuMenos;
    private javax.swing.JButton jButtonMultiplicacao;
    private javax.swing.JButton jButtonNum0;
    private javax.swing.JButton jButtonNum1;
    private javax.swing.JButton jButtonNum2;
    private javax.swing.JButton jButtonNum3;
    private javax.swing.JButton jButtonNum4;
    private javax.swing.JButton jButtonNum5;
    private javax.swing.JButton jButtonNum6;
    private javax.swing.JButton jButtonNum7;
    private javax.swing.JButton jButtonNum8;
    private javax.swing.JButton jButtonNum9;
    private javax.swing.JButton jButtonPorcentagem;
    private javax.swing.JButton jButtonRaizQuadrada;
    private javax.swing.JButton jButtonSoma;
    private javax.swing.JButton jButtonSubtracao;
    private javax.swing.JButton jButtonVirgula;
    static javax.swing.JLabel jLabelLog1;
    static javax.swing.JLabel jLabelLog2;
    static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelFundoVisor;
    static javax.swing.JTextField jTextFieldVisor1;
    static javax.swing.JTextField jTextFieldVisor2;
    // End of variables declaration//GEN-END:variables
}

/*

 FONTE: https://www.youtube.com/watch?v=xyChCncaHgI&t=761s
 FONTE: http://partilho.com.br/java-netbeans/projetos-java-netbeans/calculadora-com-interface-java-netbeans-v1-0/

 */
