package vista.tablas;

import javax.swing.table.AbstractTableModel;

public class ModeloTablaFloyd extends AbstractTableModel {
    private Double distancias[][];

    public ModeloTablaFloyd(Double distancias[][]) {
        this.distancias = distancias;
    }

    @Override
    public int getRowCount() {
        return distancias.length;
    }

    @Override
    public int getColumnCount() {
        return distancias[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return distancias[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return "V" + (column + 1);
    }
}
