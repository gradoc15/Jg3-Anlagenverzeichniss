/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class main
{
    public static void main(String[] args)
    {
        Anlage a = new Anlage(10000, 2002.5, "Name", 20);
        a.setActYear(2016);
        System.out.println(a.getBisND());
        System.out.println(a.getAfaBisher());
        System.out.println(a.getWVorAfa());
        System.out.println(a.getAfa());
        System.out.println(a.bW());
    }
}
