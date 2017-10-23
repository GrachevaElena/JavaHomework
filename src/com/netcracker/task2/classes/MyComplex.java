package com.netcracker.task2.classes;

public class MyComplex {

    double real=0.0;
    double imag=0.0;

    public MyComplex() {
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public MyComplex(double real, double imag) {

        this.real = real;
        this.imag = imag;
    }

    public void setValue(double real, double imag){
        this.real=real;
        this.imag=imag;
    }

    @Override
    public String toString() {
        return "("+real+"+"+imag+"i)";
    }

    public boolean isReal(){
        if (this.imag==0) return true;
        return false;
    }

    public boolean isImaginary(){
        if (this.real==0) return true;
        return false;
    }

    public double magnitude(){
        return Math.sqrt(real*real+imag*imag);
    }

    public double argument(){
        return Math.atan(imag/real);
    }

    public MyComplex addNew(MyComplex right){
        MyComplex res=new MyComplex(this.real+right.real, this.imag+right.imag);
        return res;
    }

    public MyComplex substractNew(MyComplex right){
        MyComplex res=new MyComplex(this.real+right.real, this.imag+right.imag);
        return res;
    }

    public MyComplex add(MyComplex right){
        this.real=this.real+right.real;
        this.imag=this.imag+right.imag;
        return this;
    }

    public MyComplex substract(MyComplex right){
        this.real=this.real-right.real;
        this.imag=this.imag-right.imag;
        return this;
    }

    public MyComplex multiply(MyComplex right){
        this.real=this.real*right.real-this.imag*right.imag;
        this.imag=this.real*right.imag+this.imag*right.real;
        return this;
    }

        //in addition to class, used in divide
    private MyComplex multiplyNew (MyComplex right){
        MyComplex res = new MyComplex(this.real*right.real-this.imag*right.imag,
                this.real*right.imag+this.imag*right.real);
        return res;
    }

    public MyComplex divide(MyComplex right){
        MyComplex a=this.multiplyNew(right.conjugate());
        double r=right.magnitude()*right.magnitude();
        this.real=a.real/r;
        this.imag=a.imag/r;
        return this;
    }

    public MyComplex conjugate() {
        MyComplex res = new MyComplex( this.real , -1 * this.imag);
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==this) return true;
        if (obj==null) return false;
        if (!(obj instanceof MyComplex)) return false;
        MyComplex a=(MyComplex) obj;
        return (a.real==this.real && a.imag==this.imag);
    }

    public boolean equals(double real, double imag) {
        return (real==this.real && imag==this.imag);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(real);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(imag);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }



}
