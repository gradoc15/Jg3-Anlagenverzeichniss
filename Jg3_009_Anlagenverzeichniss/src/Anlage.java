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

    private static double akSUM = 0;
    private static double afABSUM = 0;
    private static double wVAfaSUM = 0;
    private static double afADJSUM = 0;
    private static double bwSUM = 0;

    private static double zugang = 0;

    public Anlage(String bez, int aK, double iNahme, double nD) {
        this.aK = aK;
        this.iNahme = iNahme;
        this.bez = bez;
        this.nD = nD;

        akSUM += getaK();
        afABSUM += getAfaBisher();
        wVAfaSUM += getWVorAfa();
        afADJSUM += getAfa();
        bwSUM += getBW();
        zugang += (int) iNahme == actYear ? aK : 0;
    }

    public static void setActYear(int year) {
        actYear = year;
    }

    Anlage() {

    }

    public double getBisND() {
        if (nD <= (actYear - iNahme)) {
            return nD;
        } else if (actYear - iNahme > 0) {
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

    public double getBW() {
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

    public double getSum(int r) {
        double d = 0;
        switch (r) {
            case 1:
                d = akSUM;
                break;
            case 5:
                d = afABSUM;
                break;
            case 6:
                d = wVAfaSUM;
                break;
            case 7:
                d = afADJSUM;
                break;
            case 8:
                d = bwSUM;
                break;
        }
        return d;
    }

    public double getZugang() {
       
        return zugang;
    }
}
