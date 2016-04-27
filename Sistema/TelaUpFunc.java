import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class TelaUpFunc extends javax.swing.JFrame {
   
    public TelaUpFunc() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackGround = new javax.swing.JLabel();
        Nome = new javax.swing.JLabel();
        Idade = new javax.swing.JLabel();
        Telefone = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JtfNome = new javax.swing.JTextField();
        TextfieldEndereco = new javax.swing.JTextField();
        JtfTel = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TextFieldCPF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();

        BackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/TelaLimpa.png"))); // NOI18N
        BackGround.setToolTipText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Usuario");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(705, 505));
        setResizable(false);
        getContentPane().setLayout(null);

        Nome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Nome.setText("Nome:");
        getContentPane().add(Nome);
        Nome.setBounds(30, 40, 60, 40);

        Idade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Idade.setText("Endereço:");
        getContentPane().add(Idade);
        Idade.setBounds(30, 70, 80, 40);

        Telefone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Telefone.setText("Telefone:");
        getContentPane().add(Telefone);
        Telefone.setBounds(30, 100, 70, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Senha:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 130, 60, 40);

        JtfNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JtfNome.setToolTipText("");
        JtfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JtfNomeKeyPressed(evt);
            }
        });
        getContentPane().add(JtfNome);
        JtfNome.setBounds(120, 50, 240, 20);

        TextfieldEndereco.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TextfieldEndereco.setToolTipText("");
        getContentPane().add(TextfieldEndereco);
        TextfieldEndereco.setBounds(120, 80, 240, 20);

        JtfTel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JtfTel.setToolTipText("");
        getContentPane().add(JtfTel);
        JtfTel.setBounds(120, 110, 240, 20);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(20, 200, 120, 50);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(230, 200, 130, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("CPF:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 10, 40, 40);

        TextFieldCPF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(TextFieldCPF);
        TextFieldCPF.setBounds(120, 20, 240, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Promove:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 170, 70, 20);

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(120, 140, 240, 20);

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(120, 170, 20, 21);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JtfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtfNomeKeyPressed
        // Evento tecla ESC apertada em cima do primeiro campo nome
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_JtfNomeKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Evento de click no botao salvar
        try{
            int x=0;
            if(TextFieldCPF.getText().length()>15||TextFieldCPF.getText().length()<8){
                JOptionPane.showMessageDialog(this, "Digite o CPF corretamente");
                x++;
            }
            String nome = JtfNome.getText();
            if(nome.length()>10||nome.length()<100){
                JOptionPane.showMessageDialog(this, "Digite o nome do usuario corretamente");
                x++;
            }
            String end=TextfieldEndereco.getText();
            if(end.length()>10||end.length()<400){
                JOptionPane.showMessageDialog(this, "Digite o endereço corretamente");
                x++;
            }
            String telefone = JtfTel.getText();
            if(telefone.length()<7||telefone.length()>15){
                JOptionPane.showMessageDialog(this, "Digite o telefone corretamente");
                x++;
            }
            String ano=jTextFieldData.getText();
            if(jTextFieldRG.getText().length()>4||jTextFieldRG.getText().length()<10){
                JOptionPane.showMessageDialog(this, "Digite O RG");
                x++;
            }
            String email = JtfEmail.getText();
            if(email.equals("")) email="0";
            
            
            String password=jPasswordField1.getPassword().toString();
            if(t==3&&password.equals("")){
                JOptionPane.showMessageDialog(this, "Digite a senha do funcionario");
                x++;
            }else password="0";
            
            if(x==0){
                long chavecpf=Long.valueOf(TextFieldCPF.getText());
                JOptionPane.showMessageDialog(this, "Cadastro Alterado com Sucesso");
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Cadastro Não Alterado! Faltam Dados");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(NumberFormatException e){
             JOptionPane.showMessageDialog(this, "Digite o RG e/ou CPF apenas com numeros");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Botao cancelar Clickado
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
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
            java.util.logging.Logger.getLogger(TelaUpFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaUpFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaUpFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaUpFunc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaUpFunc().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackGround;
    private javax.swing.JLabel Idade;
    private javax.swing.JTextField JtfNome;
    private javax.swing.JTextField JtfTel;
    private javax.swing.JLabel Nome;
    private javax.swing.JLabel Telefone;
    private javax.swing.JTextField TextFieldCPF;
    private javax.swing.JTextField TextfieldEndereco;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables

}
