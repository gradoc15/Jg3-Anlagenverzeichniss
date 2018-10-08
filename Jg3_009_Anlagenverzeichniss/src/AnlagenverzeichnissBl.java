
import java.io.File;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class AnlagenverzeichnissBl extends AbstractTableModel {

    private ArrayList<Anlage> anlagen = new ArrayList<>();
    private String COLNAMES[] = {"Bezeichnung", "AK", "Inbetriebnahme", "ND", "bish. ND", "AfA bisher", "Wert vor AfA", "AfA d.J.", "BW 31.12"};

    public void calc(int year) {

    }

    public void load (File f){
        
    }
    @Override
    public int getRowCount() {
        return anlagen.size();
    }

    @Override
    public int getColumnCount() {
        return COLNAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLNAMES[column]; //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return anlagen.get(columnIndex);
    }

}
