package modele;

import java.util.Collection;

public interface Facade {
    /**
     * Inscription d'un nouveau joueur à la POFOL
     *
     * @param nouveauJoueur
     * @param mdp
     * @throws PseudoDejaPrisException
     */
    void inscription(String nouveauJoueur, String mdp) throws PseudoDejaPrisException;

    /**
     * Connexion à POFOL
     *
     * @param nouveauJoueur
     * @param mdp
     * @return
     * @throws JoueurInexistantException
     * @throws JoueurDejaConnecteException
     */
    String connexion(String nouveauJoueur, String mdp) throws
            JoueurInexistantException,
            JoueurDejaConnecteException;

    /**
     * Permet de vérifier si l'identifiant temporaire existe bien
     *
     * @param idConnexion
     * @throws MauvaisIdentifiantConnexionException
     */



    /**
     * Permet de jouer une partie
     *
     * @param idConnexio
     * @param choix
     * @return le résultat de la partie
     * @throws MauvaisIdentifiantConnexionException
     */
    Partie jouer(String idConnexio, String choix) throws MauvaisIdentifiantConnexionException;

    /**
     * Permet de récupérer le nombre de wins d'un utilisateur connecté
     *
     * @param idConnexion
     * @return
     * @throws MauvaisIdentifiantConnexionException
     */
    int getNbWins(String idConnexion) throws MauvaisIdentifiantConnexionException;

    /**
     * Permet de récupérer le nombre de parties d'un utilisateur connecté
     *
     * @param idConnexion
     * @return
     * @throws MauvaisIdentifiantConnexionException
     */
    int getNbParties(String idConnexion) throws MauvaisIdentifiantConnexionException;

    /**
     * Permet de déconnecter un utilisateur connecté
     *
     * @param idConnexion
     */
    void deconnexion(String idConnexion);

    /**
     * Permet de récupérer l'historique des parties d'un joueur connecté
     *
     * @param idConnexion
     * @return
     * @throws MauvaisIdentifiantConnexionException
     */

    Collection<Partie> getAllParties(String idConnexion) throws MauvaisIdentifiantConnexionException;
}
