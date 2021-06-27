import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Maliste extends JList {

    public Maliste(DefaultListModel<Object> model) {
        super(model) ;
    }

    public String getToolTipText(MouseEvent e) {
        int ind = this.locationToIndex(new Point(e.getX(),e.getY())) ;
        if (ind>=0) {
            Contact c = Tp4.data.get(ind) ;
            return c.nom+" "+c.prenom ;
    } else return "" ; }

}
