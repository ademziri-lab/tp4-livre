package metier.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRES")
public class Livre implements Serializable {
    
    @Id
    @Column(name = "ID_LIVRE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivre;
    
    @Column(name = "TITRE")
    private String titre;
    
    @Column(name = "AUTEUR")
    private String auteur;
    
    @Column(name = "ANNEE")
    private int annee;
    
    @Column(name = "PRIX")
    private double prix;
    
   
    public Livre() {
        super();
    }
    
    
    public Livre(String titre, String auteur, int annee, double prix) {
        super();
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
        this.prix = prix;
    }
    
    
    public Long getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(Long idLivre) {
        this.idLivre = idLivre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}