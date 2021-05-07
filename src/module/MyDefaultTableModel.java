/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tuong
 */
public class MyDefaultTableModel extends DefaultTableModel{
    private boolean[][] editable_cells; // 2d array to represent rows and columns

    public MyDefaultTableModel(int rows, int cols) { // constructor
        super(0,cols);//0 hàng 3 cột trong bảng Khoảng cách
        this.editable_cells = new boolean[rows][cols];
    }

    @Override
    public boolean isCellEditable(int row, int column) { // custom isCellEditable function
        return this.editable_cells[row][column];
    }

    public void setCellEditable(int row, int col, boolean value) {
        this.editable_cells[row][col] = value; // set cell true/false
        this.fireTableCellUpdated(row, col);
    }
}
