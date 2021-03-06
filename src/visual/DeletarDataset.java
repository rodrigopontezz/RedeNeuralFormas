/*	 Form que permite deletar um dataset criado.
 * 
 *	 @version 2.0
 * 	 GitHub: https://github.com/rodrigopontezz/RedeNeuralFiguras
 */

package visual;

import java.awt.event.WindowEvent;
import java.io.File;
import exception.WindowException;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class DeletarDataset extends javax.swing.JDialog {

    public DeletarDataset(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        /* Adicionando Ícone à janela */
        URL caminhoImagem = this.getClass().getClassLoader().getResource("favicon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
        setIconImage(iconeTitulo);
        
        /* Adicionando a cor de fundo*/
        this.getContentPane().setBackground(new java.awt.Color(255, 254, 240));
        
        adicionarDatasetsNaComboBox();
        
        this.setTitle("Excluir Dataset");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbBoxDataset = new javax.swing.JComboBox<>();
        lblSelecione = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbBoxDataset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblSelecione.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSelecione.setText("Selecione qual dataset deseja excluir:");

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbBoxDataset, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblSelecione)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblSelecione)
                .addGap(28, 28, 28)
                .addComponent(cmbBoxDataset, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        final File folder = new File(".\\src\\dataset");
        String delete = deletarDataset(folder, cmbBoxDataset.getSelectedItem().toString());
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        if (!delete.equals("")) {
            WarningWindow form = new WarningWindow(null, true, "O dataset \"" + delete + "\" foi excluído com sucesso!");
        } else {
            ExceptionWindow form = new ExceptionWindow(null, true, "Erro: Não foi possível excluir o dataset \"" + delete + "\".");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeletarDataset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeletarDataset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeletarDataset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeletarDataset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DeletarDataset dialog = new DeletarDataset(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    /*  Método que adiciona os datasets na combobox para listagem.
     */
    public void adicionarDatasetsNaComboBox() {
        File folder = new File(".\\src\\dataset");
        
        if (folder.listFiles().length <=  1) {
            throw new WindowException();
        } else {
            for (File fileEntry : folder.listFiles()) {
                if (fileEntry.isFile()) {
                    String nomeDataset = fileEntry.getName();

                    if (!nomeDataset.equals("dataset-padrao.txt")) {
                        cmbBoxDataset.addItem(nomeDataset);
                    }
                }
            }
        }
    }
    
    /*  Método que deleta o arquivo de um dataset.
     */
    public String deletarDataset(final File folder, String dataset) {
        for (final File fileEntry : folder.listFiles()) {
            if(fileEntry.isFile()) {
                if (dataset.equals(fileEntry.getName())) {
                    fileEntry.delete();
                    return fileEntry.getName();
                }
            }
        }
        return "";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JComboBox<String> cmbBoxDataset;
    private javax.swing.JLabel lblSelecione;
    // End of variables declaration//GEN-END:variables
}
