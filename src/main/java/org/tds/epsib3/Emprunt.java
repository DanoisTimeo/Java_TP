package org.tds.epsib3;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DATE_DEBUT")
    private LocalDateTime dateDebut;  // pour TIMESTAMP

    @Column(name = "DATE_FIN")
    private LocalDateTime dateFin;

    @Column(name = "DELAI")
    private Integer delai;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT", nullable = false)
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "COMPO",
            joinColumns = @JoinColumn(name = "ID_EMP"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIV")
    )
    private List<Livre> livres = new ArrayList<>();

    //<editor-fold desc="Constructeurs">
    public Emprunt(){}

    public Emprunt(LocalDateTime dateDebut, LocalDateTime dateFin, Integer delai, Client client, List<Livre> livres) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.delai = delai;
        this.client = client;
        this.livres = livres;
    }
    //</editor-fold>

    //<editor-fold desc="Getter">

    public Integer getId() {
        return id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public Integer getDelai() {
        return delai;
    }

    public Client getClient() {
        return client;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    //</editor-fold>

    //<editor-fold desc="Setter">

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    //</editor-fold>
}
