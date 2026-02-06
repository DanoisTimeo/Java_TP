package org.tds.epsib3;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOM", length = 50, nullable = false)
    private String nom;

    @Column(name = "PRENOM", length = 50, nullable = false)
    private String prenom;

    // Un client peut avoir plusieurs emprunts
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Emprunt> emprunts = new ArrayList<>();

    //<editor-fold desc="Constructeurs">
    public Client(){}

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    //</editor-fold>

    //<editor-fold desc="Getter">
    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }
    //</editor-fold>

    //<editor-fold desc="Setter">
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
    //</editor-fold>
}
