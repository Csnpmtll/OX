package Register;

import java.awt.image.BufferedImage;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import User.User;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Boss
 */
public class FormRegister extends javax.swing.JFrame {

    private static String s;
    User user;
    RegisterService register;

    /**
     * Creates new form Register
     */
    public FormRegister() {
        initComponents();
    }

    public void cleartext() {
        txtusername.setText("");
        txtname.setText("");
        txtpassword.setText("");
        txtconfirmpassword.setText("");
    }

    public static byte[] LoadImage(String filePath) throws Exception {
        File file = new File(filePath);
        int size = (int) file.length();
        byte[] buffer = new byte[size];
        FileInputStream in = new FileInputStream(file);
        in.read(buffer);
        in.close();
        return buffer;
    }

    public String getPath() {
        return s;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        insertButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        txtconfirmpassword = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        IMAGE = new javax.swing.JLabel();
        InsertImage = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(892, 672));
        setResizable(false);
        setSize(new java.awt.Dimension(892, 672));

        jPanel1.setLayout(null);

        insertButton.setText("REGISTER");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });
        jPanel1.add(insertButton);
        insertButton.setBounds(300, 490, 210, 70);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("USERNAME :");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(120, 180, 200, 60);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("PASSWORD :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(120, 250, 200, 60);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("CONFIRM-PASSWORD :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(120, 320, 200, 60);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("NAME :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(120, 390, 170, 50);
        jPanel1.add(txtusername);
        txtusername.setBounds(310, 180, 210, 50);
        jPanel1.add(txtname);
        txtname.setBounds(310, 390, 210, 50);
        jPanel1.add(txtpassword);
        txtpassword.setBounds(310, 250, 210, 50);
        jPanel1.add(txtconfirmpassword);
        txtconfirmpassword.setBounds(310, 320, 210, 50);

        jPanel2.setLayout(null);
        jPanel2.add(IMAGE);
        IMAGE.setBounds(0, 0, 250, 250);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(550, 180, 250, 250);

        InsertImage.setText("INSERT IMAGE");
        InsertImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertImageActionPerformed(evt);
            }
        });
        jPanel1.add(InsertImage);
        InsertImage.setBounds(610, 450, 140, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        jLabel5.setText("Register");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(280, 10, 380, 130);
        jPanel1.add(background);
        background.setBounds(0, 0, 820, 610);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InsertImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertImageActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = fileChooser.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                BufferedImage im = ImageIO.read(selectedFile);
                IMAGE.setIcon(new ImageIcon(im.getScaledInstance(IMAGE.getWidth(), IMAGE.getHeight(), WIDTH)));
                s = path;
            } catch (IOException ex) {
                Logger.getLogger(FormRegister.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("ไม่มีข้อมูล");
        }
    }//GEN-LAST:event_InsertImageActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        register = new RegisterService();
        user = new User(txtusername.getText(), txtpassword.getText(), txtconfirmpassword.getText(), txtname.getText(), 0, 0, 0, 0);
        register.putData(user);
        this.hide();
    }//GEN-LAST:event_insertButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IMAGE;
    private javax.swing.JButton InsertImage;
    private javax.swing.JLabel background;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtconfirmpassword;
    private javax.swing.JTextField txtname;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
