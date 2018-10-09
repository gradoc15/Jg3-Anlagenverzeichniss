
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
               case 1:l.setText(String.format("%.2f",a.getaK()));break;
               case 2:l.setText(String.format("%.1f",a.getiNahme()));break;
               case 3:l.setText(String.format("%.2f",a.getnD()));break;
               case 4:l.setText(String.format("%.2f",a.getBisND()));break;
               case 5:l.setText(String.format("%.2f",a.getAfaBisher()));break;
               case 6:l.setText(String.format("%.2f",a.getWVorAfa()));break;
               case 7:l.setText(String.format("%.2f",a.getAfa()));break;
               case 8:l.setText(String.format("%.2f",a.bW()));break;
           }
           
           if(!(l.getText() instanceof String)){
               System.out.println("");
           }
       }
       
       return l;
    }

}
