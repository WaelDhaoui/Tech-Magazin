package json;

import java.io.Serializable;

public class User implements Serializable {

    public String email;
    public String nom;
    public String prenom;
    public String mdp;

    public User(String p, String n,String e,String m) {
        this.email = e;
        this.nom = n;
        this.prenom = p;
        this.mdp = m;
    }

}
