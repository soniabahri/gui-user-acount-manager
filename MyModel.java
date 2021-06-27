import javax.crypto.Cipher;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MyModel extends AbstractTableModel {
    ArrayList<Contact> d;
    MyModel( ArrayList<Contact> data) {
        d = data;
    }

    @Override
    public int getRowCount() {
        return d.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return d.get(rowIndex).getNom();
        }
        if (columnIndex == 1) {
        return d.get(rowIndex).getPrenom();
        }
        if (columnIndex == 2) {
            return d.get(rowIndex).getPseudo();
        }return "" ;
    }
}
