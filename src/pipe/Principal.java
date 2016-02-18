package pipe;

import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Principal extends javax.swing.JFrame {

    private javax.swing.JFileChooser jFileChooser;
    PipeTo to = new PipeTo();
    PipeToNum pipe = new PipeToNum();

    public Principal() {
        initComponents();
        /*int a = 0;
        while (a < 100) {
            textArea.append(a + "\n");
            a++;
        }
         */
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        buttonAbrirArquivo = new javax.swing.JButton();
        buttonConverter = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        buttonLimpar = new javax.swing.JButton();
        caminhoTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        titulo.setText("My Pipe");

        buttonAbrirArquivo.setText("Abrir Arquivo");
        buttonAbrirArquivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAbrirArquivoMouseClicked(evt);
            }
        });

        buttonConverter.setText("Converter");
        buttonConverter.setEnabled(false);
        buttonConverter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonConverterMouseClicked(evt);
            }
        });

        buttonSair.setText("Sair");
        buttonSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSairMouseClicked(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        buttonLimpar.setText("Limpar");
        buttonLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLimparMouseClicked(evt);
            }
        });

        caminhoTextField.setEditable(false);
        caminhoTextField.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(titulo)
                .addGap(224, 224, 224))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonConverter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonAbrirArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(caminhoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonSair)
                                .addGap(15, 15, 15)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(titulo)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAbrirArquivo)
                    .addComponent(caminhoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonConverter)
                    .addComponent(buttonSair)
                    .addComponent(buttonLimpar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAbrirArquivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAbrirArquivoMouseClicked
        buscar();
        if (this.caminhoTextField != null) {
            this.buttonConverter.setEnabled(true);
        }

    }//GEN-LAST:event_buttonAbrirArquivoMouseClicked

    private void buttonSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSairMouseClicked
        dispose();
    }//GEN-LAST:event_buttonSairMouseClicked

    private void buttonLimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLimparMouseClicked
        textArea.setText("");
    }//GEN-LAST:event_buttonLimparMouseClicked

    private void buttonConverterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonConverterMouseClicked
        try {
            pipe.contarLinha(to.getCaminhoArquivo());
            pipe.converterMatrizPipe();
            pipe.converterPipeToNum();
            setNumero(pipe.getNumero());
        } catch (Exception e) {
            System.out.println("Erro ao executar comandos !");
        }

    }//GEN-LAST:event_buttonConverterMouseClicked

    private void buscar() {
        try {
            jFileChooser = new JFileChooser();
            jFileChooser.setFileFilter(new FileNameExtensionFilter("Arquivo de Texto (*.txt)", "txt"));
            jFileChooser.setApproveButtonText("Selecionar Texto");
            jFileChooser.setDialogTitle("Buscar Texto");
            jFileChooser.setAcceptAllFileFilterUsed(false);
            int returnVal = jFileChooser.showOpenDialog(this);
            if (!(returnVal == JFileChooser.APPROVE_OPTION)) {
                return;
            }
            this.to.setCaminhoArquivo(jFileChooser.getSelectedFile().toString());
            this.caminhoTextField.setText(to.getCaminhoArquivo());

        } catch (Exception e) {
            System.out.println("Não Encontrou o Caminho !");
        }
    }

    public void setNumero(ArrayList lista) {
        int a = 0, b=0;
        try {
            ArrayList list = lista;
            while (b < list.size()) {
                this.textArea.append(list.get(a) + "\n");
                b++;
            }
        } catch (Exception e) {
            System.out.println("Erro ao preencher o textArea !");
        }
    }

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
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAbrirArquivo;
    private javax.swing.JButton buttonConverter;
    private javax.swing.JButton buttonLimpar;
    private javax.swing.JButton buttonSair;
    private javax.swing.JTextField caminhoTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
