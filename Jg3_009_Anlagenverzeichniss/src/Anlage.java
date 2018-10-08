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

    public Anlage(int aK, double iNahme, String bez, double nD)
    {
        this.aK = aK;
        this.iNahme = iNahme;
        this.bez = bez;
        this.nD = nD;
    }
    
    public double getBisND()
    {
        double bND = 0;
        
        double erg = 0;
        double help = aK/nD/2;
        double c = 0;
        
        while(erg != aK)
        {
            c+=0.5;
            erg = help * c;
            System.out.println("++++++");
            System.out.println(erg);
            System.out.println(aK);
            
        }
        
        
        return c;
    }
    
    
}
