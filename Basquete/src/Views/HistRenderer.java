/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

//este renderizador é utilizado para a tabela de histórico de resultados
public class HistRenderer extends DefaultTableCellRenderer{
    
    //este método faz com que as linhas tenham cores intercaladas
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setBackground(row % 2 == 0 ? new Color(230,230,230) : new Color(247,247,247));
        return c;
    }
}
