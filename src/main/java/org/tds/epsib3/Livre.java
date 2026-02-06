package org.tds.epsib3;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    // Relation inverse vers Emprunt
    @ManyToMany(mappedBy = "livres")
    private List<Emprunt> emprunts = new ArrayList<>();

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

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    //</editor-fold>

    //<editor-fold desc="Setter">

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    //</editor-fold>
}
