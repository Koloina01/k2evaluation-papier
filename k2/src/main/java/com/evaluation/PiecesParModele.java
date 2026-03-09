package com.evaluation;

import java.util.Objects;

public class PiecesParModele {
    private int nbGETZ;
    private int nbPRIDE;
    private int nbLACETTI;

    public PiecesParModele() {}

    public PiecesParModele(int nbGETZ, int nbPRIDE, int nbLACETTI) {
        this.nbGETZ = nbGETZ;
        this.nbPRIDE = nbPRIDE;
        this.nbLACETTI = nbLACETTI;
    }

    public int getNbGETZ() {
        return nbGETZ;
    }

    public void setNbGETZ(int nbGETZ) {
        this.nbGETZ = nbGETZ;
    }

    public int getNbPRIDE() {
        return nbPRIDE;
    }

    public void setNbPRIDE(int nbPRIDE) {
        this.nbPRIDE = nbPRIDE;
    }

    public int getNbLACETTI() {
        return nbLACETTI;
    }

    public void setNbLACETTI(int nbLACETTI) {
        this.nbLACETTI = nbLACETTI;
    }

    @Override
    public String toString() {
        return "PiecesParModele{" +
                "GETZ=" + nbGETZ +
                ", PRIDE=" + nbPRIDE +
                ", LACETTI=" + nbLACETTI +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PiecesParModele)) return false;
        PiecesParModele that = (PiecesParModele) o;
        return nbGETZ == that.nbGETZ && nbPRIDE == that.nbPRIDE && nbLACETTI == that.nbLACETTI;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nbGETZ, nbPRIDE, nbLACETTI);
    }
}
