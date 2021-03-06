/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.OperacoesBanco;
import Models.Jogo;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Emerson
 */
public class Resultados extends javax.swing.JPanel {

    private OperacoesBanco ope = new OperacoesBanco();
    
    public Resultados() {
        
        initComponents();
        initTable(header, new TextAreaRenderer(),new Color(84,37,141),40);
        initResulAtual();
        initTable(resulAtual,new ResulRenderer(), new Color(255,255,255),50);
        initHist();
        
    }
    //este método estiliza as tabelas para terem um GUI mais agradável que o padrão do Java
    public void initTable(JTable table,JTextArea renderer, Color cor, int rowHeight){
        
        table.getTableHeader().setUI(null);
        table.setBackground(cor);
        table.setDefaultRenderer(Object.class, (TableCellRenderer)renderer);
        table.setRowHeight(rowHeight);
        table.setShowGrid(false);
        
    }
    //este método busca a última linha do banco de dados e preenche a linha principal da tabela
    public void initResulAtual(){
        Jogo ultimoJogo = null;
        try {
            ultimoJogo = ope.getUltimoJogo();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
        }
            resulAtual.setValueAt(" "+ultimoJogo.getNum(), 0, 0);
            resulAtual.setValueAt(" "+ultimoJogo.getPlacar(), 0, 1);
            resulAtual.setValueAt(" "+ultimoJogo.getRecordeMin(), 0, 2);
            resulAtual.setValueAt(" "+ultimoJogo.getRecordeMax(), 0, 3);
            resulAtual.setValueAt(" "+ultimoJogo.getQuebraMin(), 0, 4);
            resulAtual.setValueAt(" "+ultimoJogo.getQuebraMax(), 0, 5);
        
    }
    public void initHist(){
        //aqui é chamado o método que busca todos os jogos salvos no banco
        jPanel2.setVisible(false);
        DefaultTableModel model = (DefaultTableModel) resulAnte.getModel();
            ArrayList<Jogo> jogos = null;
        try {
            jogos = ope.getTodosJogos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Resultados.class.getName()).log(Level.SEVERE, null, ex);
        }
        //aqui os jogos são adicionados linha a linha na tabela
            Jogo jogo;
            for(int i = 1; i < jogos.size();i++){
                jogo = jogos.get(i);
                model.addRow(new Object[]{jogo.getNum(),jogo.getPlacar(),jogo.getRecordeMin(),jogo.getRecordeMax(),jogo.getQuebraMin(),jogo.getQuebraMax()});
            }
            resulAnte.setModel(model);
        
        resulAnte.getTableHeader().setUI(null);
        resulAnte.setRowHeight(30);
        resulAnte.setShowGrid(false);
        resulAnte.setDefaultRenderer(Object.class, new HistRenderer());//esta tabela possui um renderer diferente, que não utiliza JTextArea para renderizar as celulas
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JTable();
        resulAtual = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        histButton = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resulAnte = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        header.setBackground(new java.awt.Color(84, 37, 141));
        header.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        header.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"    Jogo", "Placar", "Mínimo da Temporada", "Máximo da Temporada", "Quebra Recorde Mínimo", "Quebra Recorde Máximo"}
            },
            new String [] {
                "Jogo", "    Placar ", "Mínimo da Temporada", "Máximo da Temporada", "Quebra Recordo Mínimo", "Quebra Recorde Máximo"
            }
        ));
        add(header);
        header.setBounds(30, 19, 542, 40);

        resulAtual.setBackground(new java.awt.Color(247, 247, 247));
        resulAtual.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        resulAtual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"    4", "    24", "    10", "    24", "    1", "    1"}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Título 5", "Título 6"
            }
        ));
        add(resulAtual);
        resulAtual.setBounds(30, 60, 540, 40);

        jPanel1.setBackground(new java.awt.Color(84, 37, 141));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 5));
        jPanel1.setPreferredSize(new java.awt.Dimension(540, 5));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        add(jPanel1);
        jPanel1.setBounds(30, 100, 540, 5);

        histButton.setBackground(new java.awt.Color(255, 255, 255));
        histButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                histButtonMouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                histButtonMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                histButtonMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(84, 37, 141));
        jLabel4.setText("Histórico");

        javax.swing.GroupLayout histButtonLayout = new javax.swing.GroupLayout(histButton);
        histButton.setLayout(histButtonLayout);
        histButtonLayout.setHorizontalGroup(
            histButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        histButtonLayout.setVerticalGroup(
            histButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        add(histButton);
        histButton.setBounds(30, 110, 133, 31);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        resulAnte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Título 5", "Título 6"
            }
        ));
        resulAnte.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(resulAnte);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );

        add(jPanel2);
        jPanel2.setBounds(30, 150, 540, 170);
    }// </editor-fold>//GEN-END:initComponents

    private void histButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_histButtonMouseClicked
        // este evento deixa vísivel ou invisivel o histórico de jogos
        
        if(jPanel2.isVisible()){
            jPanel2.setVisible(false);
        }else{
            jPanel2.setVisible(true);
        }
    }//GEN-LAST:event_histButtonMouseClicked

    private void histButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_histButtonMouseEntered
        // TODO add your handling code here:
        histButton.setBackground(new Color(202,188,217));
    }//GEN-LAST:event_histButtonMouseEntered

    private void histButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_histButtonMouseExited
        // TODO add your handling code here:
        histButton.setBackground(Color.white);
    }//GEN-LAST:event_histButtonMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable header;
    private javax.swing.JPanel histButton;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable resulAnte;
    private javax.swing.JTable resulAtual;
    // End of variables declaration//GEN-END:variables
}
