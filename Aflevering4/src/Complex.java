public class Complex {
    
    private double re; // Real part

    private double im; // Imaginary part


    

    public Complex() {
        this.re = 0.0;
        this.im = 0.0;
    }
// Constructor to initialize a complex number with real and imaginary parts
    public Complex(double re, double im) {
        this.re =re;
        this.im = im;

    }


    // Constructor to initialize a complex number from another complex number

    public Complex(Complex other) {
        this.re = other.re;
        this.im = other.im;
    }


    // Constructor to initialize a complex number with only the real part (imaginary part is 0)

    
    // Getters for real and imaginary parts
    public double getReal() {
        return re;
    }
    public double getImaginary() {
        return im;
    }

    //method absolute til at find absolute værdi
    public double abs(){
        return Math.sqrt(this.re * this.re + this.im * this.im);

    }


    // Method to add two complex numbers

    public Complex plus(Complex other) {
        return new Complex(this.re + other.re, this.im + other.im);

    }


    // Method to multiply two complex numbers

    public Complex Times(Complex other) {
        double newReal = this.re * other.re - this.im * other.im;
        double newImaginary = this.re * other.im + this.im * other.re;

        return new Complex(newReal, newImaginary);
    }

    // Method to get the string representation of the complex number

    @Override

    public String toString() {

        if (im >= 0) {

            return re + " + " + im + "i";

        } else {

            return re + " - " + (-im) + "i";

        }

    }

    double Abs() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
    



    
}
