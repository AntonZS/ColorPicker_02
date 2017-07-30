package sample;

import javafx.scene.paint.Color;

import java.util.*;

/**
 * Created by anton on 30.07.2017.
 */
public class UColor extends java.awt.Color {
    private String name;
    private double lab_L;
    private double lab_a;
    private double lab_b;


    public UColor(String name, int r, int g, int b) {
        super(r,g,b);
        this.name = name;

    }

    public UColor(String name, double l, double a, double b) {
        super((lab2rgb(l,a,b))[0],(lab2rgb(l,a,b))[0],(lab2rgb(l,a,b))[0]);
        this.name = name;
        this.lab_L = l;
        this.lab_a = a;
        this.lab_b = b;

    }

    public double getL() {
        return this.lab_L;
    }

    public double getA() {
        return this.lab_a;
    }

    public double getB() {
        return this.lab_b;
    }

    public String getName() {
        return name;
    }

    public double dE76(UColor color) {
        return Math.sqrt(Math.pow((this.getL() - color.getL()), 2) + Math.pow(this.getA() - color.getA(), 2) + Math.pow(this.getB() + color.getB(), 2));
    }
    public static int[] lab2rgb(double lab_l, double lab_a, double lab_b) {
        // first, map CIE L*a*b* to CIE XYZ
        double x = lab2xyz(lab_l, lab_a, lab_b)[0];
        double y = lab2xyz(lab_l, lab_a, lab_b)[1];
        double z = lab2xyz(lab_l, lab_a, lab_b)[2];

        // second, map CIE XYZ to sRGB
        double r =  3.2404542*x - 1.5371385*y - 0.4985314*z;
        double g = -0.9692660*x + 1.8760108*y + 0.0415560*z;
        double b =  0.0556434*x - 0.2040259*y + 1.0572252*z;
        r = r <= 0.00304 ? 12.92*r : 1.055*Math.pow(r,1/2.4) - 0.055;
        g = g <= 0.00304 ? 12.92*g : 1.055*Math.pow(g,1/2.4) - 0.055;
        b = b <= 0.00304 ? 12.92*b : 1.055*Math.pow(b,1/2.4) - 0.055;

        // third, get sRGB values
        int ir = (int)Math.round(255*r); ir = Math.max(0, Math.min(ir, 255));
        int ig = (int)Math.round(255*g); ig = Math.max(0, Math.min(ig, 255));
        int ib = (int)Math.round(255*b); ib = Math.max(0, Math.min(ib, 255));
        return new int[]{ir,ig,ib};
    }
    public static double[] lab2xyz(double lab_l, double lab_a, double lab_b){
        double y = (lab_l + 16) / 116;
        double x = y + lab_a/500;
        double z = y - lab_b/200;

        // D65 standard referent
        double X = 0.950470, Y = 1.0, Z = 1.088830;

        x = X * (x > 0.206893034 ? x*x*x : (x - 4.0/29) / 7.787037);
        y = Y * (y > 0.206893034 ? y*y*y : (y - 4.0/29) / 7.787037);
        z = Z * (z > 0.206893034 ? z*z*z : (z - 4.0/29) / 7.787037);
        return new double[]{z, y, z};
    }
}



