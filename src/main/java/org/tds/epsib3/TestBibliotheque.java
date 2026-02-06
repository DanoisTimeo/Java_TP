package org.tds.epsib3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class TestBibliotheque {
    public static void main(String[] args) {
        try (
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
                EntityManager em = emf.createEntityManager();
        ) {
            em.getTransaction().begin();

            //<editor-fold desc="Réalisez une requête qui permet d’extraire un emprunt et tous ses livres associés">
            int empruntId = 1;

            Emprunt emprunt = em.createQuery(
                            "SELECT e FROM Emprunt e JOIN FETCH e.livres WHERE e.id = :id", Emprunt.class)
                    .setParameter("id", empruntId)
                    .getSingleResult();

            System.out.println("Emprunt ID : " + emprunt.getId());
            System.out.println("Livres :");
            emprunt.getLivres().forEach(l -> System.out.println("- " + l.getTitre()));

            //</editor-fold>

            //<editor-fold desc="Réalisez une requête qui permet d’extraire tous les emprunts d’un client donné">
            int clientId = 1;

            List<Emprunt> empruntsClient = em.createQuery(
                            "SELECT e FROM Emprunt e WHERE e.client.id = :clientId", Emprunt.class)
                    .setParameter("clientId", clientId)
                    .getResultList();

            System.out.println("Emprunts du client " + clientId + " :");
            for (Emprunt e : empruntsClient) {
                System.out.println("Emprunt ID : " + e.getId() + ", Livres : ");
                e.getLivres().forEach(l -> System.out.println("- " + l.getTitre()));
            }
            //</editor-fold>

            em.getTransaction().commit();
        }
        catch (Exception e) {
            System.out.println("oups");
            throw new RuntimeException(e);
        }
    }
}
