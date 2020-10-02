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

/**
 *
 * @author Emerson
 */
public class ResulRenderer extends JTextArea
    implements TableCellRenderer {

  public ResulRenderer() {
    setLineWrap(true);
    setWrapStyleWord(true);
    
  }

  public Component getTableCellRendererComponent(JTable jTable, Object obj, boolean isSelected, boolean hasFocus, int row,int column) {
    setFont(new Font("Segoe UI", Font.PLAIN, 12));
    setText((String)obj);
    return this;
  }
    
}
