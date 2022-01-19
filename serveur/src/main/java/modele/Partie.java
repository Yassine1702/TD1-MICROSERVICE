package modele;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement
public class Partie implements Serializable {

    private String prediction;
    private String tirage;


    public Partie() {
    }

    public Partie(String prediction, String tirage) {
        this.prediction = prediction;
        this.tirage = tirage;
    }


    public String getPrediction() {
        return prediction;
    }

    public String getTirage() {
        return tirage;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public void setTirage(String tirage) {
        this.tirage = tirage;
    }

    public boolean isPartieGagnante() {
        return this.prediction.equals(this.tirage);
    }

}
