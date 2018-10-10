
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
        Anlage.setActYear(year);
        for (Anlage a : anlagen) {
            a.setZero();
        }
        for (Anlage a : anlagen) {

            a.updateValues();
        }
    }

    public void add(Anlage a) {
        anlagen.add(a);
        a.updateValues();
        fireTableRowsInserted(anlagen.size() - 1, anlagen.size() - 1);
    }

    public void save(File f) throws FileNotFoundException, IOException {
        /*
           while ((line = br.readLine()) != null) {
            String splits[] = line.split(";");

            String bez = splits[0];
            int aK = Integer.parseInt(splits[1].replace(".", ""));
            double iNahme = Double.parseDouble(splits[2].replace(",", "."));
            double ND = Double.parseDouble(splits[3].replace(",", "."));

            Anlage a = new Anlage(bez, aK, iNahme, ND);
         */
        BufferedWriter br = new BufferedWriter(new FileWriter(f));

        String line = "";
        for (Anlage a : anlagen) {
            line = String.format("%s;%.0f;%f;%f", a.getBez(), a.getaK(), a.getiNahme(), a.getnD());
            br.write(line);
            br.newLine();
        }

        br.close();
    }

    public void load(File f) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line = br.readLine();
        while ((line = br.readLine()) != null) {

            String splits[] = line.split(";");

            String bez = splits[0];
            int aK = Integer.parseInt(splits[1].replace(".", ""));
            double iNahme = Double.parseDouble(splits[2].replace(",", "."));
            double ND = Double.parseDouble(splits[3].replace(",", "."));
            System.out.println(bez);
            Anlage a = new Anlage(bez, aK, iNahme, ND);
            anlagen.add(a);
        }
    }

    @Override
    public int getRowCount() {
        return anlagen.size() + 4;
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
        try {
            return anlagen.get(rowIndex);
        } catch (Exception e) {
            return new Anlage();
        }
    }

}
