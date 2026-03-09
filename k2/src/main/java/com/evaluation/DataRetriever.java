package com.evaluation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

    public List<PieceParMarque> getPiecesParMarque() {

        DBConnection dbConnection = new DBConnection();
        List<PieceParMarque> results = new ArrayList<>();

        String sql = """
            SELECT mv.marque, SUM(v.quantite) AS nbrePiece
            FROM Modele_voiture mv
            JOIN Piece_auto pa ON mv.id = pa.id_modele_voiture
            JOIN Vente v ON pa.id = v.id_piece_auto
            GROUP BY mv.marque
        """;

        try (
            Connection connection = dbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            while(rs.next()){
                PieceParMarque obj = new PieceParMarque();
                obj.setMarque(rs.getString("marque"));
                obj.setNbrePiece(rs.getInt("nbrePiece"));
                results.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des pièces par marque", e);
        }

        return results;
    }

    public PiecesParModele getPiecesParModele() {

        DBConnection dbConnection = new DBConnection();
        PiecesParModele obj = new PiecesParModele();

        String sql = """
            SELECT
                SUM(CASE WHEN mv.modele='GETZ' THEN v.quantite ELSE 0 END) AS nbGETZ,
                SUM(CASE WHEN mv.modele='PRIDE' THEN v.quantite ELSE 0 END) AS nbPRIDE,
                SUM(CASE WHEN mv.modele='LACETTI' THEN v.quantite ELSE 0 END) AS nbLACETTI
            FROM Modele_voiture mv
            JOIN Piece_auto pa ON mv.id = pa.id_modele_voiture
            JOIN Vente v ON pa.id = v.id_piece_auto
        """;

        try (
            Connection connection = dbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            if(rs.next()){
                obj.setNbGETZ(rs.getInt("nbGETZ"));
                obj.setNbPRIDE(rs.getInt("nbPRIDE"));
                obj.setNbLACETTI(rs.getInt("nbLACETTI"));
            }
        } catch (SQLException e) {
           throw new RuntimeException("Erreur lors de la récupération des pièces par modèle", e);
        }

        return obj;
    }

    public TotalPrixMarque getTotalPrixKIA() {

        DBConnection dbConnection = new DBConnection();
        TotalPrixMarque obj = new TotalPrixMarque();

        String sql = """
            SELECT SUM(pa.prix * v.quantite) AS totalPrixKIA
            FROM Modele_voiture mv
            JOIN Piece_auto pa ON mv.id = pa.id_modele_voiture
            JOIN Vente v ON pa.id = v.id_piece_auto
            WHERE mv.marque = 'KIA'
        """;

        try (
            Connection connection = dbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            if(rs.next()){
                obj.setTotalPrix(rs.getDouble("totalPrixKIA"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération du prix total pour KIA", e);
        }

        return obj;
    }
}
