package com.netcracker.task2.classes;

public class MyPolynomial implements Cloneable {

    private double[] coeffs;

    public MyPolynomial(){
        coeffs=new double[0];
    }

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public int GetDegree() {
        return coeffs.length - 1;
    }

    public MyPolynomial(int deg) {
        coeffs = new double[deg + 1];
        for (double c : coeffs)
            c = 0;
    }

    @Override
    public String toString() {
        String s = new String("");
        for (int i = coeffs.length - 1; i > 1; i--) {
            s += coeffs[i] + "x^" + i + "+";
        }
        s += coeffs[1] + "x" + "+" + coeffs[0];
        return s;
    }

    double evaluate(double x) {
        double res = 0;
        for (int i = 0; i < coeffs.length; i++)
            res += coeffs[i] * Math.pow(x, i);
        return res;
    }

    public MyPolynomial add(MyPolynomial right) {
        MyPolynomial res = new MyPolynomial(Math.max(right.GetDegree(),this.GetDegree()));
        if (right.GetDegree() > this.GetDegree())
            System.arraycopy(right.coeffs,0,res.coeffs,0,right.coeffs.length);
        else
            System.arraycopy(this.coeffs,0,res.coeffs,0,this.coeffs.length);
        for (int i = 0; i < Math.min(right.GetDegree(), this.GetDegree())+1; i++)
            res.coeffs[i] = coeffs[i] + right.coeffs[i];

        return res;
    }

    private MyPolynomial mulMonom(double c, int d) {
        MyPolynomial res = new MyPolynomial(this.GetDegree() + d);
        for (int i = res.GetDegree(); i >= d; i--)
            res.coeffs[i] = this.coeffs[i-d]*c;
        return res;
    }

    public MyPolynomial multiply(MyPolynomial right) {
        MyPolynomial res = new MyPolynomial(right.GetDegree()+GetDegree());
        for (int i = 0; i < coeffs.length; i++)
            res=res.add(right.mulMonom(this.coeffs[i], i));
        return res;
    }




}
