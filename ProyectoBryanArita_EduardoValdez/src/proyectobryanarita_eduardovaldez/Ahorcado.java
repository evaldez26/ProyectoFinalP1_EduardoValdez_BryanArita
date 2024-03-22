/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectobryanarita_eduardovaldez;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author BJAL
 */
public class Ahorcado extends javax.swing.JFrame {

    static Random rndm = new Random();
    public ImageIcon imagenes[];
    public JButton botones[];
    public String mensajes[];
    public int rango;
    public int fallo;
    JLabel labelIMG;
    public String reinicio[];

    public Ahorcado() {
        initComponents();
        setDefaultCloseOperation(Ahorcado.EXIT_ON_CLOSE);
        JButton BotontoMenu = new JButton();
        BotontoMenu=BotonRegresar;
        
        BotontoMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu BackMenu = new Menu();
                BackMenu.setVisible(true);
            }
        });
        
        imagenes = new ImageIcon[7];
        botones = new JButton[26];
        mensajes = new String[15];

        imagenes[0] = new ImageIcon(getClass().getResource("/imagenes/ahorcadoPT1.jpg"));
        imagenes[1] = new ImageIcon(getClass().getResource("/imagenes/ahorcadoPT2.jpg"));
        imagenes[2] = new ImageIcon(getClass().getResource("/imagenes/ahorcadoPT3.jpg"));
        imagenes[3] = new ImageIcon(getClass().getResource("/imagenes/ahorcadoPT4.jpg"));
        imagenes[4] = new ImageIcon(getClass().getResource("/imagenes/ahorcadoPT5.jpg"));
        imagenes[5] = new ImageIcon(getClass().getResource("/imagenes/ahorcadoPT6.jpg"));
        imagenes[6] = new ImageIcon(getClass().getResource("/imagenes/ahorcadoPT7.jpg"));
        labelIMG = new JLabel();
        labelIMG = ImgAhorcado;

        botones[0] = A;
        botones[1] = B;
        botones[2] = C;
        botones[3] = D;
        botones[4] = E;
        botones[5] = F;
        botones[6] = G;
        botones[7] = H;
        botones[8] = I;
        botones[9] = J;
        botones[10] = K;
        botones[11] = L;
        botones[12] = M;
        botones[13] = N;
        botones[14] = O;
        botones[15] = P;
        botones[16] = Q;
        botones[17] = R;
        botones[18] = S;
        botones[19] = T;
        botones[20] = U;
        botones[21] = V;
        botones[22] = W;
        botones[23] = X;
        botones[24] = Y;
        botones[25] = Z;

        mensajes[0] = "Honduras".toUpperCase();
        mensajes[1] = "Guante".toUpperCase();
        mensajes[2] = "curita".toUpperCase();
        mensajes[3] = "vampiros".toUpperCase();
        mensajes[4] = "polaris".toUpperCase();
        mensajes[5] = "fruto".toUpperCase();
        mensajes[6] = "complejo".toUpperCase();
        mensajes[7] = "exotica".toUpperCase();
        mensajes[8] = "conmigo".toUpperCase();
        mensajes[9] = "Cangrinaje".toUpperCase();
        mensajes[10] = "volando".toUpperCase();
        mensajes[11] = "Arrancarmelo".toUpperCase();
        mensajes[12] = "diamantes".toUpperCase();
        mensajes[13] = "psicopata".toUpperCase();
        mensajes[14] = "mercedes".toUpperCase();

        for (int i = 0; i < 26; i++) {
            botones[i].setEnabled(false);
            botones[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent v) {
                    CheckErrores(v);
                }
            });
        }

        JuegoIniciar();
    }

    public void JuegoIniciar() {
        labelIMG.setIcon(imagenes[0]);
        fallo = 0;
        for (int i = 0; i < 26; i++) {
            botones[i].setEnabled(true);
        }
        jTextPane1.setText("");

        rango = rndm.nextInt(15);
        String palabra[] = mensajes[rango].split(" ");
        reinicio = new String[mensajes[rango].length()];
        int guiones = 0;
        for (String pal : palabra) {
            for (int i = 0; i < pal.length(); i++) {
                jTextPane1.setText(jTextPane1.getText() + "_ ");
                reinicio[guiones++] = "_";
            }
            jTextPane1.setText(jTextPane1.getText() + " ");
        }
    }

    public void CheckErrores(ActionEvent x) {
        JButton boton = (JButton) x.getSource();
        char[] c;
        for (int i = 0; i < 26; i++) {
            if (boton == botones[i]) {
                c = Character.toChars(65 + i);
                boolean existe = false;
                for (int j = 0; j < mensajes[rango].length(); j++) {
                    if (c[0] == mensajes[rango].charAt(j)) {
                        reinicio[j] = c[0] + "";
                        existe = true;
                    }
                }
                if (existe) {
                    jTextPane1.setText("");
                    for (String st : reinicio) {
                        if (" ".equals(st)) {
                            jTextPane1.setText(jTextPane1.getText() + "_ ");
                        } else {
                            jTextPane1.setText(jTextPane1.getText() + st + " ");
                        }
                    }
                    boolean win = true;
                    for (String st : reinicio) {
                        if (st.equals("_")) {
                            win = false;
                            break;
                        }
                    }
                    if (win) {
                        JOptionPane.showMessageDialog(null, "HAS GANADO");
                        JuegoIniciar();
                        return;
                    }
                } else {
                    fallo++;
                    if (fallo < imagenes.length) {
                        labelIMG.setIcon(imagenes[fallo]);
                    }
                    if (fallo == imagenes.length - 1) {
                        JOptionPane.showMessageDialog(null, "HAS PERDIDO \n\nLa palabra era: " + mensajes[rango]);
                        JuegoIniciar();
                        return;
                    }
                }
                boton.setEnabled(false);
                break;
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        O = new javax.swing.JButton();
        S = new javax.swing.JButton();
        A = new javax.swing.JButton();
        F = new javax.swing.JButton();
        G = new javax.swing.JButton();
        H = new javax.swing.JButton();
        J = new javax.swing.JButton();
        P = new javax.swing.JButton();
        X = new javax.swing.JButton();
        K = new javax.swing.JButton();
        L = new javax.swing.JButton();
        C = new javax.swing.JButton();
        R = new javax.swing.JButton();
        V = new javax.swing.JButton();
        Q = new javax.swing.JButton();
        B = new javax.swing.JButton();
        W = new javax.swing.JButton();
        M = new javax.swing.JButton();
        T = new javax.swing.JButton();
        Y = new javax.swing.JButton();
        Z = new javax.swing.JButton();
        U = new javax.swing.JButton();
        N = new javax.swing.JButton();
        E = new javax.swing.JButton();
        D = new javax.swing.JButton();
        I = new javax.swing.JButton();
        Titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        ImgAhorcado = new javax.swing.JLabel();
        BotonRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        O.setBackground(new java.awt.Color(0, 0, 0));
        O.setForeground(new java.awt.Color(255, 255, 255));
        O.setText("O");

        S.setBackground(new java.awt.Color(0, 0, 0));
        S.setForeground(new java.awt.Color(255, 255, 255));
        S.setText("S");

        A.setBackground(new java.awt.Color(0, 0, 0));
        A.setForeground(new java.awt.Color(255, 255, 255));
        A.setText("A");

        F.setBackground(new java.awt.Color(0, 0, 0));
        F.setForeground(new java.awt.Color(255, 255, 255));
        F.setText("F");

        G.setBackground(new java.awt.Color(0, 0, 0));
        G.setForeground(new java.awt.Color(255, 255, 255));
        G.setText("G");

        H.setBackground(new java.awt.Color(0, 0, 0));
        H.setForeground(new java.awt.Color(255, 255, 255));
        H.setText("H");

        J.setBackground(new java.awt.Color(0, 0, 0));
        J.setForeground(new java.awt.Color(255, 255, 255));
        J.setText("J");

        P.setBackground(new java.awt.Color(0, 0, 0));
        P.setForeground(new java.awt.Color(255, 255, 255));
        P.setText("P");

        X.setBackground(new java.awt.Color(0, 0, 0));
        X.setForeground(new java.awt.Color(255, 255, 255));
        X.setText("X");

        K.setBackground(new java.awt.Color(0, 0, 0));
        K.setForeground(new java.awt.Color(255, 255, 255));
        K.setText("K");

        L.setBackground(new java.awt.Color(0, 0, 0));
        L.setForeground(new java.awt.Color(255, 255, 255));
        L.setText("L");

        C.setBackground(new java.awt.Color(0, 0, 0));
        C.setForeground(new java.awt.Color(255, 255, 255));
        C.setText("C");

        R.setBackground(new java.awt.Color(0, 0, 0));
        R.setForeground(new java.awt.Color(255, 255, 255));
        R.setText("R");

        V.setBackground(new java.awt.Color(0, 0, 0));
        V.setForeground(new java.awt.Color(255, 255, 255));
        V.setText("V");

        Q.setBackground(new java.awt.Color(0, 0, 0));
        Q.setForeground(new java.awt.Color(255, 255, 255));
        Q.setText("Q");

        B.setBackground(new java.awt.Color(0, 0, 0));
        B.setForeground(new java.awt.Color(255, 255, 255));
        B.setText("B");

        W.setBackground(new java.awt.Color(0, 0, 0));
        W.setForeground(new java.awt.Color(255, 255, 255));
        W.setText("W");

        M.setBackground(new java.awt.Color(0, 0, 0));
        M.setForeground(new java.awt.Color(255, 255, 255));
        M.setText("M");

        T.setBackground(new java.awt.Color(0, 0, 0));
        T.setForeground(new java.awt.Color(255, 255, 255));
        T.setText("T");

        Y.setBackground(new java.awt.Color(0, 0, 0));
        Y.setForeground(new java.awt.Color(255, 255, 255));
        Y.setText("Y");

        Z.setBackground(new java.awt.Color(0, 0, 0));
        Z.setForeground(new java.awt.Color(255, 255, 255));
        Z.setText("Z");

        U.setBackground(new java.awt.Color(0, 0, 0));
        U.setForeground(new java.awt.Color(255, 255, 255));
        U.setText("U");

        N.setBackground(new java.awt.Color(0, 0, 0));
        N.setForeground(new java.awt.Color(255, 255, 255));
        N.setText("N");

        E.setBackground(new java.awt.Color(0, 0, 0));
        E.setForeground(new java.awt.Color(255, 255, 255));
        E.setText("E");

        D.setBackground(new java.awt.Color(0, 0, 0));
        D.setForeground(new java.awt.Color(255, 255, 255));
        D.setText("D");

        I.setBackground(new java.awt.Color(0, 0, 0));
        I.setForeground(new java.awt.Color(255, 255, 255));
        I.setText("I");

        Titulo.setBackground(new java.awt.Color(0, 0, 0));
        Titulo.setFont(new java.awt.Font("Showcard Gothic", 0, 48)); // NOI18N
        Titulo.setForeground(new java.awt.Color(0, 0, 0));
        Titulo.setText("AHORCADO");

        jScrollPane1.setViewportView(jTextPane1);

        BotonRegresar.setBackground(new java.awt.Color(204, 0, 51));
        BotonRegresar.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        BotonRegresar.setForeground(new java.awt.Color(0, 0, 0));
        BotonRegresar.setText("REGRESAR AL MENU");
        BotonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(257, 257, 257)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(ImgAhorcado, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(38, 38, 38))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Titulo)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(Q, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(W, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(E, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(R, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(T, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Y, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(U, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(I, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(O, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(P, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BotonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(108, 108, 108)
                                    .addComponent(Z, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(X, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(C, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(V, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(B, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(N, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(M, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap()))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(A, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(S, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(D, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(F, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(G, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(H, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(J, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(K, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(L, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BotonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ImgAhorcado, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(W, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Q, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(R, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(T, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Y, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(U, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(I, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(O, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(S, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(G, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(H, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(J, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(K, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(X, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(V, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Z, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(M, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(N, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BotonRegresar.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ahorcado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ahorcado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton A;
    private javax.swing.JButton B;
    private javax.swing.JButton BotonRegresar;
    private javax.swing.JButton C;
    private javax.swing.JButton D;
    private javax.swing.JButton E;
    private javax.swing.JButton F;
    private javax.swing.JButton G;
    private javax.swing.JButton H;
    private javax.swing.JButton I;
    private javax.swing.JLabel ImgAhorcado;
    private javax.swing.JButton J;
    private javax.swing.JButton K;
    private javax.swing.JButton L;
    private javax.swing.JButton M;
    private javax.swing.JButton N;
    private javax.swing.JButton O;
    private javax.swing.JButton P;
    private javax.swing.JButton Q;
    private javax.swing.JButton R;
    private javax.swing.JButton S;
    private javax.swing.JButton T;
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton U;
    private javax.swing.JButton V;
    private javax.swing.JButton W;
    private javax.swing.JButton X;
    private javax.swing.JButton Y;
    private javax.swing.JButton Z;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
