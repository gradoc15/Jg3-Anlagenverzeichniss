
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
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
public class TableRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int r, int c) {
        JLabel l = new JLabel("???");
        l.setOpaque(true);
        l.setHorizontalAlignment(JLabel.RIGHT);
        if (value instanceof Anlage) {

            Anlage a = (Anlage) value;
            switch (c) {
                case 0:
                    l.setText(a.getBez() + "");
                    break;
                case 1:
                    l.setText(String.format("%.2f", a.getaK()));
                    break;
                case 2:
                    l.setText(String.format("%.1f", a.getiNahme()));
                    break;
                case 3:
                    l.setText(String.format("%.2f", a.getnD()));
                    break;
                case 4:
                    l.setText(String.format("%.2f", a.getBisND()));
                    break;
                case 5:
                    l.setText(String.format("%.2f", a.getAfaBisher()));
                    break;
                case 6:
                    l.setText(String.format("%.2f", a.getWVorAfa()));
                    break;
                case 7:
                    l.setText(String.format("%.2f", a.getAfa()));
                    break;
                case 8:
                    l.setText(String.format("%.2f", a.getBW()));
                    break;
            }

            if (r == table.getRowCount() - 4) {
                double sum = a.getSum(c);
                if (sum == 0) {
                    l.setText("");
                } else {
                    l.setText(String.format("%.2f", sum));
                    l.setBorder(new MatteBorder(1, 0, 0, 0, Color.BLACK));
                    Font f = l.getFont();
                    l.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
                }

            } else if (r == table.getRowCount() - 3) {
                l.setText("");
            } else if (r == table.getRowCount() - 2) {
                l.setText("");
                if (c == 6) {
                    l.setText("BW 1.1");
                    Font f = l.getFont();
                    l.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
                } else if (c == 7) {
                    l.setText(String.format("%.2f", a.getSum(7)+a.getSum(6)));
                }

            } else if (r == table.getRowCount() - 1) {
                l.setText("");
                if (c == 6) {
                    l.setText("Zugänge "+a.getActYear());
                    Font f = l.getFont();
                    l.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
                } else if (c == 7) {
                    l.setText(String.format("%.2f", a.getZugang()));
                    
                }
            }

            try {
                double z1 = Double.parseDouble(l.getText().replace(",", "."));

                if (z1 == 0) {
                    l.setBackground(Color.red);
                }
            } catch (Exception b) {
            }

        }
        return l;
    }
}
