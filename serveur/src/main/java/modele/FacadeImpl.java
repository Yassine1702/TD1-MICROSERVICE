package modele;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class FacadeImpl implements Facade {


    /**
     * Dictionnaire des joueurs inscrits
     */
    private Map<String,Joueur> joueurs;

    /**
     * Dictionnaire des joueurs connectés indexés par une clé aléatoire
     */
    private Map<String,Joueur> joueursConnectes;

    public FacadeImpl() {
        this.joueurs = new HashMap<>();
        this.joueursConnectes = new HashMap<>();
    }

    /**
     * Inscription d'un nouveau joueur à la POFOL
     * @param nouveauJoueur
     * @param mdp
     * @throws PseudoDejaPrisException
     */
    @Override
    public void inscription(String nouveauJoueur, String mdp) throws PseudoDejaPrisException {

        if (joueurs.containsKey(nouveauJoueur))
            throw new PseudoDejaPrisException();

        this.joueurs.put(nouveauJoueur,new Joueur(nouveauJoueur,mdp));
    }

    private void checkIdConnexion(String idConnexion) throws MauvaisIdentifiantConnexionException {
        if (!this.joueursConnectes.containsKey(idConnexion))
            throw new MauvaisIdentifiantConnexionException();
    }

    /**
     * Connexion à POFOL
     * @param nouveauJoueur
     * @param mdp
     * @return
     * @throws JoueurInexistantException
     * @throws JoueurDejaConnecteException
     */
    @Override
    public String connexion(String nouveauJoueur, String mdp) throws
            JoueurInexistantException,
            JoueurDejaConnecteException {

        if (!joueurs.containsKey(nouveauJoueur))
            throw new JoueurInexistantException();

        Joueur j = joueurs.get(nouveauJoueur);
        if (joueursConnectes.containsValue(j)) {
            throw new JoueurDejaConnecteException();
        }
        String idConnection = UUID.randomUUID().toString();
        this.joueursConnectes.put(idConnection,j);
        return idConnection;
    }


    /**
     * Permet de jouer une partie
     * @param idConnexio
     * @param choix
     * @return le résultat de la partie
     * @throws MauvaisIdentifiantConnexionException
     */
    @Override
    public Partie jouer(String idConnexio, String choix) throws MauvaisIdentifiantConnexionException {
        this.checkIdConnexion(idConnexio);
        Joueur j = this.joueursConnectes.get(idConnexio);
        Partie partie = j.jouer(choix);
        return partie;
    }

    /**
     * Permet de récupérer le nombre de wins d'un utilisateur connecté
     * @param idConnexion
     * @return
     * @throws MauvaisIdentifiantConnexionException
     */
    @Override
    public int getNbWins(String idConnexion) throws MauvaisIdentifiantConnexionException {
        this.checkIdConnexion(idConnexion);
        Joueur j = this.joueursConnectes.get(idConnexion);
        return j.getNbPartiesGagnees();
    }


    /**
     * Permet de récupérer le nombre de parties d'un utilisateur connecté
     * @param idConnexion
     * @return
     * @throws MauvaisIdentifiantConnexionException
     */
    @Override
    public int getNbParties(String idConnexion) throws MauvaisIdentifiantConnexionException {
        this.checkIdConnexion(idConnexion);
        Joueur j = this.joueursConnectes.get(idConnexion);
        return j.getNbPartiesJouees();
    }


    /**
     * Permet de déconnecter un utilisateur connecté
     * @param idConnexion
     */
    @Override
    public void deconnexion(String idConnexion) {
        this.joueursConnectes.remove(idConnexion);
    }


    /**
     * Permet de récupérer l'historique des parties d'un joueur connecté
     * @param idConnexion
     * @return
     * @throws MauvaisIdentifiantConnexionException
     */

    @Override
    public Collection<Partie> getAllParties(String idConnexion) throws MauvaisIdentifiantConnexionException {
        this.checkIdConnexion(idConnexion);
        return this.joueursConnectes.get(idConnexion).getHistorique();
    }


}
