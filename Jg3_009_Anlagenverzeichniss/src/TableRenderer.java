
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class TableRenderer implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int r, int c) {
       JLabel l = new JLabel("???");
       
       if(value instanceof Anlage){
           
           Anlage a = (Anlage) value;
           
           switch(c){
               case 0:l.setText(a.getBez()+"");break;
               case 1:l.setText(a.getaK()+"");break;
               case 2:l.setText(a.getiNahme()+"");break;
               case 3:l.setText(a.getnD()+"");break;
               case 4:l.setText(a.getBisND()+"");break;
               case 5:l.setText(a.getAfaBisher()+"");break;
               case 6:l.setText(a.getWVorAfa()+"");break;
               case 7:l.setText(a.getAfa()+"");break;
               case 8:l.setText(a.bW()+"");break;
           }
       }
       
       return l;
    }

}
