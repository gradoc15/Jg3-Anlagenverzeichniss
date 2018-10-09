/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Anlage {

    private double aK;
    private double iNahme;
    private String bez;
    private double nD;

    private static int actYear = 2016;

    public Anlage(String bez, int aK, double iNahme, double nD) {
        this.aK = aK;
        this.iNahme = iNahme;
        this.bez = bez;
        this.nD = nD;
    }

    public static void setActYear(int year) {
        actYear = year;
    }

    public double getBisND() {
        if (actYear - iNahme > 0) {
            return actYear - iNahme;
        } else {
            return 0;
        }
    }

    public double getAfaBisher() {
        if (aK / nD * getBisND() <= aK) {
            return aK / nD * getBisND();
        } else {
            return aK;
        }
    }

    public double getWVorAfa() {
        return aK - getAfaBisher();
    }

    public double getAfa() {
        double afa = aK / nD;

        if (aK - getAfaBisher() > afa) {
            return afa;
        } else {
            return aK - getAfaBisher();
        }
    }

    public double bW() {
        return aK - getAfa() - getAfaBisher();
    }

    public double getaK() {
        return aK;
    }

    public double getiNahme() {
        return iNahme;
    }

    public String getBez() {
        return bez;
    }

    public double getnD() {
        return nD;
    }

    public int getActYear() {
        return actYear;
    }

}
