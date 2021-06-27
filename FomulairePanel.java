import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FomulairePanel extends JPanel {
    private TitledBorder b;
    private  JCheckBox box1, box2,box3,box4,box5,box6;

    private  JCheckBox cbox1,cbox2,cbox3,cbox4;
    JLabel welcome ;
    JComboBox diflist ;
    int iop ;
    JButton val ;
    String nom, prenom, pseudo ;

    FomulairePanel(String n , String p , String ps) {
        iop = 0;
        this.nom=n ;
        this.prenom=p ;
        this.pseudo=ps ;
        this.setLayout(new BorderLayout());
        welcome = new JLabel(" Bienvenue "+this.prenom+" "+this.nom);
        welcome.setFont(new Font("Arial",Font.ITALIC,36));
        welcome.setOpaque(true);
        welcome.setBackground(Color.green);
        welcome.setHorizontalAlignment(JLabel.CENTER);
        this.add(welcome,BorderLayout.NORTH) ;

        JPanel GPanel = new JPanel() ;
        JPanel travail = new JPanel() ;
        travail.setBorder(BorderFactory.createTitledBorder("difficulte"));
        travail.setPreferredSize(new Dimension(390,150));
        travail.setLayout(new FlowLayout(FlowLayout.CENTER));
        String [] tab = {  "intermediaire" ,"debutant" , "difficile"} ;
        diflist = new JComboBox(tab) ;
        box1 = new JCheckBox("1") ;
        box2 = new JCheckBox("2") ;
        box3 = new JCheckBox("3") ;
        box4 = new JCheckBox("4") ;
        box5 = new JCheckBox("5") ;
        box6 = new JCheckBox("6") ;
        box1.setEnabled(false); box1.setSelected(true);
        box2.setEnabled(false); box2.setSelected(true);
        box5.setEnabled(false);box3.setSelected(false);
        box6.setEnabled(false);box4.setSelected(false);
        box3.setEnabled(true);box5.setSelected(false);
        box4.setEnabled(true);box6.setSelected(false);
        diflist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (diflist.getSelectedItem().equals("intermediaire")) {
                    box1.setEnabled(false); box1.setSelected(true);
                    box2.setEnabled(false); box2.setSelected(true);
                    box5.setEnabled(false);box3.setSelected(false);
                    box6.setEnabled(false);box4.setSelected(false);
                    box3.setEnabled(true);box5.setSelected(false);
                    box4.setEnabled(true);box6.setSelected(false);


            }
                if (diflist.getSelectedItem().equals("debutant")) {
                    box1.setSelected(false);
                    box2.setSelected(false);
                    box3.setSelected(false);
                    box4.setSelected(false);
                    box5.setSelected(false);
                    box6.setSelected(false);
                    box6.setEnabled(false);
                    box3.setEnabled(false);
                    box4.setEnabled(false);
                    box5.setEnabled(false);
                    box1.setEnabled(true);
                    box2.setEnabled(true);


                }
                if (diflist.getSelectedItem().equals("difficile")) {
                    box1.setEnabled(false); box1.setSelected(true);
                    box2.setEnabled(false); box2.setSelected(true);
                    box3.setEnabled(false);box3.setSelected(true);
                    box4.setEnabled(false);box4.setSelected(true);
                    box5.setEnabled(true);box5.setSelected(false);
                    box6.setEnabled(true);box6.setSelected(false);

                }}
        });

        diflist.setBorder(new EmptyBorder(0,10,0,50));
        diflist.setPreferredSize(new Dimension(200,30));
        JPanel newpp = new JPanel();
        JLabel Choix = new JLabel("Choisir la\\les categories") ;
        Choix.setPreferredSize(new Dimension(150,30));


        travail.add(diflist) ;
        newpp.add(Choix) ;
        newpp.add(box1) ;
        newpp.add(box2) ;
        newpp.add(box3) ;
        newpp.add(box4) ;
        newpp.add(box5) ;
        newpp.add(box6) ;
        travail.add(newpp) ;
        GPanel.add(travail,BorderLayout.CENTER) ;


        JPanel travail2 = new JPanel() ;
        b = BorderFactory.createTitledBorder("option  ");
        travail2.setBorder(b);

        travail2.setPreferredSize(new Dimension(390,100));
        travail2.setLayout(new FlowLayout(FlowLayout.CENTER));
         cbox1 = new JCheckBox("Emmetre son") ;
         cbox2 = new JCheckBox("Afficher score") ;
         cbox3 = new JCheckBox("Plein ecran") ;
         cbox4 = new JCheckBox("Ombre") ;
        cbox1.addActionListener(new ClassListener ());
        cbox2.addActionListener(new ClassListener ());
        cbox3.addActionListener(new ClassListener ());
        cbox4.addActionListener(new ClassListener ());

        travail2.add(cbox1) ;
        travail2.add(cbox2) ;
        travail2.add(cbox3) ;
        travail2.add(cbox4) ;






        GPanel.add(travail2,BorderLayout.CENTER);
        this.add(GPanel);
        val = new JButton("Valider !! ") ;
        val.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                FileOutputStream htmll = null;

                try {
                    String Categ = "" ;
                    JCheckBox[] box = {box1, box2, box3, box4, box5, box6};
                    for(int i=0; i<box.length; i++){
                        if(box[i].isSelected()){
                            Categ += "<p> categorie: "+String.valueOf(i+1)+"</p>";
                        }
                    }
                    String option = "" ;
                    JCheckBox[] box22 = { cbox1,cbox2,cbox3,cbox4} ;
                    for (JCheckBox jb : box22) {
                        if (jb.isSelected())
                            {   option +=  "<p> " +jb.getText() + " : true " ;

                    } else {
                            option +=  "<p> " +jb.getText() + " : false " ;
                        }
                    }

                    String contenu = " <!DOCTYPE >\n" +
                            "<html>\n" +
                            "<head>\n" +
                            "<title>page html</title>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "\n" +
                            "<div>\n" +
                            "<fieldset>\n" +
                            "    <legend>Informations Personnels</legend>\n" +
                            "    <p>\n" +
                            "    Nom : "+FomulairePanel.this.nom +"<br>\n" +
                            "    Prenom : "+FomulairePanel.this.prenom +"<br>\n" +
                            "        Pseudo : "+FomulairePanel.this.pseudo+ "<br>\n" +
                            "    </p>\n" +
                            "</fieldset>\n" +
                            "    <fieldset>\n" +
                            "    <legend>Configuration : </legend>\n" +
                            "        <fieldset>\n" +
                            "            <legend>Difficulte : "+ FomulairePanel.this.diflist.getSelectedItem() + "</legend>\n" +
                            Categ+
                            "        </fieldset>\n" +
                            "        <fieldset>\n" +
                            "            <legend>Options : </legend>\n" +
                            "            <p>\n" + option + " \n" +
                            "            </p>\n" +
                            "        </fieldset>\n" +
                            "</fieldset>\n" +
                            "\n" +
                            "\n" +
                            "</div>\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "</body>\n" +
                            "\n" +
                            "</html>\n" ;
                    htmll = new FileOutputStream("Page.html");
                    htmll.write(contenu.getBytes());
                    htmll.flush();
                    htmll.close();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }



            }
        });
        JPanel newp = new JPanel() ;
        newp.add(val) ;
        this.add(newp,BorderLayout.SOUTH) ;

    }

    private class ClassListener implements ActionListener {
        @Override

        public void actionPerformed(ActionEvent e) {
            JCheckBox bb = (JCheckBox)e.getSource();
                if (bb.isSelected())
                {    iop++;

                }
                else {
                    iop--;
                }
            if(iop != 0)
            b.setTitle(("option "+String.valueOf(iop)));
            else
                b.setTitle("option");
                FomulairePanel.this.repaint();
            }

        }
    }

