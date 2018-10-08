/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Anlage
{
    private double aK;
    private double iNahme;
    private String bez;
    private double nD;
    
    private int actYear;

    public Anlage(int aK, double iNahme, String bez, double nD)
    {
        this.aK = aK;
        this.iNahme = iNahme;
        this.bez = bez;
        this.nD = nD;
    }
    
    public void setActYear(int year)
    {
        actYear = year;
    }
    
    public double getBisND()
    {
        return actYear-iNahme;
    }
    
    public double getAfaBisher()
    {
        return aK/nD*getBisND();
    }
    
    public double getWVorAfa()
    {
        return aK - getAfaBisher();
    }
    
    public double getAfa()
    {
        double afa = aK / nD;
        
        if(aK - getAfaBisher() > afa)
            return afa;
        else 
            return aK - getAfaBisher();
    }
    
    public double bW()
    {
        return aK - getAfa() - getAfaBisher();
    }
    
    
}
