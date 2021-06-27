public class Contact {


    String nom ,prenom , pseudo ;
    public Contact  (String n, String pr , String ps) {
        this.nom=n ; this.prenom=pr;this.pseudo=ps ;

    }
    public String getNom () {
        return nom ;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
}
