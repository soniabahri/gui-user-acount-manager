import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Validation extends JFrame {

    JLabel lb ;
    JPasswordField entrer ;
    JButton btn ;
    Validation() {
        this.setVisible(true);
        lb = new JLabel(" Password ") ;
        entrer = new JPasswordField(10) ;
        btn = new JButton("Entrer XD ") ;
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(entrer.getText().equals("issatso")) {

                new Project() ;
                Validation.this.setVisible(false);
            } else {JOptionPane.showMessageDialog(getContentPane()," vous n'avez pas le droit !! ");  }
        }});

        this.setLayout( new FlowLayout());
        this.add(lb) ;
        this.add(entrer) ;
        this.add(btn) ;
        this.setLocationRelativeTo(null);
        this.setSize(300,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


}

    public static void main(String[] args) {
        new Validation() ;

    }
}
