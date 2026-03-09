package com.evaluation;

import java.util.Objects;

public class TotalPrixMarque {
    private double totalPrix;

    public TotalPrixMarque() {}

    public TotalPrixMarque(double totalPrix) {
        this.totalPrix = totalPrix;
    }

    public double getTotalPrix() {
        return totalPrix;
    }

    public void setTotalPrix(double totalPrix) {
        this.totalPrix = totalPrix;
    }

    @Override
    public String toString() {
        return "TotalPrixMarque{" +
                "totalPrix=" + totalPrix +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TotalPrixMarque)) return false;
        TotalPrixMarque that = (TotalPrixMarque) o;
        return Double.compare(that.totalPrix, totalPrix) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalPrix);
    }
}
