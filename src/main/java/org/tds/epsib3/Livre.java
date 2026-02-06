package org.tds.epsib3;

import jakarta.persistence.*;

@Entity
@Table(name = "LIVRE")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TITRE", length = 255, nullable = false)
    private String titre;

    @Column(name = "AUTEUR", length = 50, nullable = false)
    private String auteur;

    //<editor-fold desc="Constructeurs">
    public Livre(){}

    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }
    //</editor-fold>

    //<editor-fold desc="Getter">
    public Integer getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }
    //</editor-fold>

    //<editor-fold desc="Setter">
    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    //</editor-fold>
}
