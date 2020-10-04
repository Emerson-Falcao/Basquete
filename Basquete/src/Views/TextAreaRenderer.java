/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

/**
 *
 * @author Emerson
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;


//este renderizador é utilizado para o header da tabela de resultados
public class TextAreaRenderer extends JTextArea
    implements TableCellRenderer {

  /*o método construtor informa que a celula renderizada se comportará como um JTextArea, 
    fazendo quebra automatica de linha, caso a linha tenha tamanho vertical suficiente*/
  public TextAreaRenderer() {
    setLineWrap(true);
    setWrapStyleWord(true);
    
  }
  //este método seta a cor de fundo e estilo da fonte das celulas
  public Component getTableCellRendererComponent(JTable jTable, Object obj, boolean isSelected, boolean hasFocus, int row,int column) {
    setBackground(new Color(84,37,141));
    setFont(new Font("Segoe UI", Font.PLAIN, 12));
    setForeground(Color.white);
    setText((String)obj);
    return this;
  }
}

