import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import javax.swing.*;


public class Tp4  extends JFrame {


    public static ArrayList <Contact>  data = new ArrayList<Contact>() ;
   // public static ArrayList <Component> panneau_actif = new ArrayList <Component>();



    JLabel nom,prenom,pseudo;
    JTextField nomtf,prenomtf,pseudotf;
    JButton val,affliste;

    JList pseudolist;
    private JLabel helplb;
    private JSplitPane jsp;
    private JTabbedPane pseudotab;
    private DefaultListModel<Object> model;


    public Tp4() {


        JPanel pn=new JPanel();

        nom=new JLabel("nom");
        nom.addMouseListener( new CustomMouseListener ());

        nomtf=new JTextField(10);
        nomtf.setText("Tapper votre nom");
        nomtf.addMouseListener(new CustomMouseListener());
        nomtf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (e.getSource()==nomtf) {
                    if (nomtf.getText().equals("Tapper votre nom")) {
                        nomtf.setText("") ; ;
                    }
                }
            }


            @Override
            public void focusLost(FocusEvent e) {
                if (e.getSource()==nomtf) {
                    if (nomtf.getText().equals("")) {
                        nomtf.setText("Tapper votre nom");
                    }
                }

        }
        });


        prenom=new JLabel("prenom");
        prenom.addMouseListener( new CustomMouseListener ());

        prenomtf=new JTextField(10);
        prenomtf.setText("Tapper votre prenom");
        prenomtf.addMouseListener(new CustomMouseListener());
        prenomtf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (e.getSource()==prenomtf) {
                    if (prenomtf.getText().equals("Tapper votre prenom")) {
                        prenomtf.setText("") ;
                    }
                }
            }
            public void focusLost(FocusEvent e) {
                if (e.getSource()==prenomtf) {
                    if (prenomtf.getText().equals("")) {
                        prenomtf.setText("Tapper votre prenom");
                    }
                }
            } });


        pseudo=new JLabel("pseudo");
        pseudo.addMouseListener( new CustomMouseListener ());
        pseudotf=new JTextField(10);
        pseudotf.setText("Tapper votre pseudo");
        pseudotf.addMouseListener( new CustomMouseListener ());
        pseudotf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(e.getSource()==pseudotf) {
                    if (pseudotf.getText().equals("Tapper votre pseudo")) {
                        pseudotf.setText(""); }
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(e.getSource()==pseudotf) {
                    if (pseudotf.getText().equals("")) {
                        pseudotf.setText("Tapper votre pseudo"); }
                }
            }
        });

        val=new JButton("Valider");
        affliste=new JButton(" afficher liste ");
        affliste.setToolTipText(" do you want to see all the list ? ");
        val.setToolTipText("are you sure ?");

        pn.setLayout(new FlowLayout());
        pn.add(nom);
        pn.add(nomtf);

        pn.add(prenom);
        pn.add(prenomtf);

        pn.add(pseudo);
        pn.add(pseudotf);

        pn.add(val);

        this.setLayout(new BorderLayout());
        this.add(pn,BorderLayout.NORTH);


        model=new DefaultListModel<>();
        //pseudolist=new Maliste(model);
        pseudolist = new JList<>() ;
        pseudolist.setModel(model);
        pseudolist.setPreferredSize(new Dimension(190,0));


        pseudotab=new JTabbedPane();

        //splitPane
        jsp=new JSplitPane();
        jsp.setLeftComponent(pseudolist);
        jsp.setRightComponent(pseudotab);

        this.add(jsp,BorderLayout.CENTER);



        JPanel p3 = new JPanel() ;
        p3.setLayout(new FlowLayout(FlowLayout.TRAILING));
        helplb=new JLabel("help:");
        helplb.setPreferredSize(new Dimension(550,15));
        p3.add(helplb);
        affliste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Affichage (data) ;

            }
        });
        p3.add(affliste);
        this.add(p3,BorderLayout.SOUTH) ;


        val.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==val) {
                    boolean exist = false;
                    if (pseudotf.getText().equals("Tapper votre pseudo") || nomtf.getText().equals("Tapper votre nom") || prenomtf.getText().equals("Tapper votre prenom")) {
                        JOptionPane.showMessageDialog(getContentPane(), " saisir des coordonees :v ");
                    }
                    else {

                        for (int i=0; i <data.size();i++) {
                            if (data.get(i).getPseudo().equals(pseudotf.getText())) {
                                exist=true ;  break;
                            }  }

                        if (exist) {
                            JOptionPane.showMessageDialog(getContentPane()," changer votre pseudo :v ");                    }
                        else {
                            model.addElement(pseudotf.getText());
                            Contact c = new Contact(nomtf.getText(),prenomtf.getText(),pseudotf.getText()) ;
                            data.add(c) ;



                        }}}}
        });
        pseudolist.addMouseListener(new Ecoutlist ());

        this.setTitle(" * GESTION PROFIL * ");
        this.setSize(700, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    }



    private class CustomMouseListener implements MouseListener {


        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource()==nomtf) {
                helplb.setText("help : veuillez saisir le nom ");

            }
            if (e.getSource()==pseudotf) {
                helplb.setText("help : veuillez saisir le pseudo");

            }
            if (e.getSource()==prenomtf) {
                helplb.setText("help : veuillez saisir le prenom ");

            }
            if (e.getSource()==pseudo) {
                pseudo.setOpaque(true);
                pseudo.setBackground(Color.ORANGE);

            }
            if (e.getSource()==prenom) {
                prenom.setOpaque(true);
                prenom.setBackground(Color.ORANGE);
            }
            if (e.getSource()==nom) {
               nom.setOpaque(true);
                nom.setBackground(Color.ORANGE);

            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource()==pseudo) {
                pseudo.setBackground(null);
            }
            if (e.getSource()==nom) {
               nom.setBackground(null);
            }
            if (e.getSource()==prenom) {
                prenom.setBackground(null);
            }
            if (e.getSource()==nomtf) {
                helplb.setText("help : ");
            }
            if (e.getSource()==pseudotf) {
                helplb.setText("help :");

            }
            if (e.getSource()==prenomtf) {
                helplb.setText("help : ");

            }

        }
    }





    private class Ecoutlist extends MouseAdapter {
        @Override

        public void mouseClicked(MouseEvent e) {
            if(e.getClickCount()==2) {
                int clk = pseudolist.locationToIndex(new Point (e.getX(),e.getY()));
                if(clk>=0) {
                    int hint = pseudotab.indexOfTab(data.get(clk).pseudo);
                    if(hint == -1) {
                        FomulairePanel fp = new FomulairePanel(data.get(clk).prenom, data.get(clk).nom, data.get(clk).pseudo);
                        Component c = pseudotab.add("" + model.getElementAt(clk), fp);
                        pseudotab.setSelectedComponent(c);

                        //Object[][] datatab = {};
                        //DataTab.add(datatab,data.get(clk).nom,data.get(clk).prenom, data.get(clk).pseudo) ;
                    }
                    else { JOptionPane.showMessageDialog(getContentPane()," il est ouvert deja ! ATTENTION  ");
                    pseudotab.setSelectedIndex(hint);
                    }
                }  }



            if(e.getButton()==e.BUTTON3) {
                int i = pseudolist.locationToIndex(new Point (e.getX(),e.getY()));
                if(i>=0) {
                JPopupMenu pop = new JPopupMenu() ;
                JMenuItem renom = new JMenuItem("rennomer ");
                pop.add(renom) ;
                JMenuItem supp = new JMenuItem("supprimer ") ;
                pop.add(supp) ;
                JMenuItem supptout = new JMenuItem("supprimer tout ");
                pop.add(supptout) ;
                pop.show(pseudolist,e.getX(),e.getY());



                renom.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        Boolean test=false ;
                        String old = data.get(i).getPseudo() ;
                        String s =  JOptionPane.showInputDialog(Tp4.this," entrer la nouvelle valeur ") ;

                        //pour savoir que notre nouv pseudo existe ou non
                        for (int k = 0 ; k<data.size(); k++) {
                            if (data.get(k).pseudo.equals(s)) {

                                test = true ; break ;
                            }
                        }

                        if (test == false) {

                            data.get(i).setPseudo(s);
                            model.setElementAt(s,i);
                            int j = pseudotab.indexOfTab(old) ;

                            //verifier s'il est ouvert dans pseudotab ou non
                        if (j != -1 ) {
                            pseudotab.setTitleAt(j,s); } }



                    else {JOptionPane.showMessageDialog(getContentPane(),"  existe deja "); }} });




                supptout.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        model.clear();
                        pseudotab.removeAll();   }         });




                supp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int hint = pseudotab.indexOfTab(data.get(i).pseudo);
                        //si la formulairepanel est ouverte on la supprime
                        if (hint != -1) {
                            pseudotab.remove(hint);
                        }

                        model.remove(i);
                        data.remove(i); }  });
            } }
        }}


         }

