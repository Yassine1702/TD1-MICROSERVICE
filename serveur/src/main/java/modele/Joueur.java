package modele;

import java.util.ArrayList;
import java.util.Collection;

public class Joueur {

    private String nomJoueur;
    private String mdpJoueur;
    private Collection<Partie> historique;
    private int nbPartiesJouees;
    private int nbPartiesGagnees;


    public Joueur(String nomJoueur, String mdpJoueur) {
        this.nomJoueur = nomJoueur;
        this.mdpJoueur = mdpJoueur;
        this.historique = new ArrayList<>();
        this.nbPartiesGagnees = 0;
        this.nbPartiesGagnees = 0;
    }



    public Partie jouer(String prediction) {
        String tirage = (int)(Math.random()*100)%2 == 0?"Pile":"Face";

        this.nbPartiesJouees++;
        Partie partie = new Partie(prediction, tirage);
        if (partie.getVerdict()) {
            this.nbPartiesGagnees++;
        }
        this.historique.add(partie);
        return partie;
    }





    public String getNomJoueur() {
        return nomJoueur;
    }

    public Collection<Partie> getHistorique() {
        return historique;
    }

    public int getNbPartiesJouees() {
        return nbPartiesJouees;
    }

    public int getNbPartiesGagnees() {
        return nbPartiesGagnees;
    }

    public boolean checkPassword(String password) {
        return this.mdpJoueur.equals(password);
    }
}
