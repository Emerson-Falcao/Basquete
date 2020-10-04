/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;


//este renderizador é utilizado para a linha do resultado atual da tabela de resultados
public class ResulRenderer extends JTextArea
    implements TableCellRenderer {
  /*o método construtor informa que a celula renderizada se comportará como um JTextArea, 
    fazendo quebra automatica de linha, caso a linha tenha tamanho vertical suficiente*/
  public ResulRenderer() {
    setLineWrap(true);
    setWrapStyleWord(true);
    
  }
  //este método seta a cor de fundo e estilo da fonte das celulas
  public Component getTableCellRendererComponent(JTable jTable, Object obj, boolean isSelected, boolean hasFocus, int row,int column) {
    setFont(new Font("Segoe UI", Font.PLAIN, 12));
    setText((String)obj);
    return this;
  }
    
}
