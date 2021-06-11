/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Tuong
 */
public class SpinnerEditor extends AbstractCellEditor implements TableCellEditor {
  final JSpinner spinner = new JSpinner();

  public SpinnerEditor() {
    spinner.setModel(new SpinnerNumberModel(0, 0, 50, 1));
  }

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
      int row, int column) {
    //spinner.setValue(value);
    return spinner;
  }

  public boolean isCellEditable(EventObject evt) {
    if (evt instanceof MouseEvent) {
      return ((MouseEvent) evt).getClickCount() >= 1;
    }
    return true;
  }

  public Object getCellEditorValue() {
    return spinner.getValue();
  }
}

