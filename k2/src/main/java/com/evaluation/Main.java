package com.evaluation;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        DataRetriever dr = new DataRetriever();

        System.out.println("=== Nombre de pièces vendues par marque ===");
        try {
            List<PieceParMarque> piecesParMarque = dr.getPiecesParMarque();
            for (PieceParMarque ppm : piecesParMarque) {
                System.out.println(ppm);
            }
        } catch (RuntimeException e) {
            System.err.println("Erreur récupération pièces par marque : " + e.getMessage());
        }

        System.out.println();

        System.out.println("=== Nombre de pièces vendues par modèle ===");
        try {
            PiecesParModele ppmModele = dr.getPiecesParModele();
            System.out.println(ppmModele);
        } catch (RuntimeException e) {
            System.err.println("Erreur récupération pièces par modèle : " + e.getMessage());
        }

        System.out.println();

        System.out.println("=== Prix total des pièces vendues pour KIA ===");
        try {
            TotalPrixMarque tpm = dr.getTotalPrixKIA();
            System.out.println(tpm);
        } catch (RuntimeException e) {
            System.err.println("Erreur récupération prix total KIA : " + e.getMessage());
        }
    }
}