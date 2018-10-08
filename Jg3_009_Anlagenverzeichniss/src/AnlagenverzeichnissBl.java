
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    public void load (File f) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line = br.readLine();
        while((line = br.readLine()) != null){
            String splits[] = line.split(";");
            Anlage a =new Anlage(splits[0],Integer.parseInt(splits[1]),Double.parseDouble(splits[2]),Double.parseDouble(splits[3]));
            anlagen.add(a);
        }
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
