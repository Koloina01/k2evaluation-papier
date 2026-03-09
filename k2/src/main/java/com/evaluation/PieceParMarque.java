package com.evaluation;

import java.util.Objects;

public class PieceParMarque {
    private String marque;
    private int nbrePiece;

    public PieceParMarque() {}

    public PieceParMarque(String marque, int nbrePiece) {
        this.marque = marque;
        this.nbrePiece = nbrePiece;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getNbrePiece() {
        return nbrePiece;
    }

    public void setNbrePiece(int nbrePiece) {
        this.nbrePiece = nbrePiece;
    }

    @Override
    public String toString() {
        return "PieceParMarque{" +
                "marque='" + marque + '\'' +
                ", nbrePiece=" + nbrePiece +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PieceParMarque)) return false;
        PieceParMarque that = (PieceParMarque) o;
        return nbrePiece == that.nbrePiece && Objects.equals(marque, that.marque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marque, nbrePiece);
    }
}
