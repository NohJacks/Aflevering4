import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MandelBrot43 {

    
    private static  int GRID_SIZE = 512; 
    private static  int MAX = 255; 
    private static  double SIDE_LENGTH = 2.0; 
    private static  double X0 = -0.5; // Real
    private static  double Y0 = 0; // Imaginary

    private static Color[] colorMap = new Color[256];

    public static int iterate(Complex z0) {
        Complex z = new Complex(z0);
        for (int i = 0; i < MAX; i++) {
            if (z.abs() > 2.0) {
                return i;
            }
            z = z.Times(z).plus(z0);
        }
        return MAX;
    }
    
    public static void main(String[] args) {
        //random color!
        Random rand = new Random();
        int red = rand.nextInt(256);
        int green = rand.nextInt(256);
        int blue = rand.nextInt(256);

        Scanner scanner = new Scanner(System.in);

        System.out.print("skrive numb på det du ville: \n1)brugt defualt kords\n2) intast ny kords \n3) mnd file ");
        double check = scanner.nextInt();
        if (check == 2){
             System.out.print("skrive numb for x0: ");
            X0 = scanner.nextDouble();//scanner over skriver værdierne
            System.out.print("skrive numb for Y0: ");
            Y0 = scanner.nextDouble();
            System.out.print("skrive numb for side længde: ");
            SIDE_LENGTH = scanner.nextDouble();

        }
        if (check == 3){
            //allternative lave så man selv kan inskrive 
            loadColorMap("src/blues.mnd");
        }
       
        

        // Set up StdDraw
        int width = 800;
        int height = 800;
        
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(X0 - SIDE_LENGTH / 2, X0 + SIDE_LENGTH / 2);
        StdDraw.setYscale(Y0 - SIDE_LENGTH / 2, Y0 + SIDE_LENGTH / 2);

        // sætter grid stræelse
        // Fill the array with iteration counts
       
        double stepSize = SIDE_LENGTH / (GRID_SIZE - 1);
        //pro tech tip in use
        StdDraw.show(0);
        // Draw Mandelbrot 
        for (int j = 0; j < GRID_SIZE; j++) {
            for (int k = 0; k < GRID_SIZE; k++) {
                
                // Calculate the complex number for the grid point
                double real = X0 - SIDE_LENGTH / 2 + stepSize * j;
                double imag = Y0 - SIDE_LENGTH / 2 + stepSize * k;
                //complex number from interate
                Complex c = new Complex(real, imag);
                int iterations = iterate(c);

                //special funktion til hvis det mnd fille
                if (check == 3){
                    if (iterations < MAX) {
                        
                        float var = (float) iterations / MAX;
                        
                        StdDraw.setPenColor(colorMap[iterations]);
                        StdDraw.filledCircle(real, imag, stepSize / 2); // 3
    
                    } else {
                        StdDraw.setPenColor(Color.BLACK);
                        StdDraw.filledCircle(real, imag, stepSize / 2);
                    }
                }
                else{ //the usaul susbects
                    if (iterations < MAX) {
                        
                        //var for varitaion!, need to make the color parts more spread out in the drawn set
                        float var = (float) iterations / MAX;
                        StdDraw.setPenColor(Color.getHSBColor(var *red, 1.0f*green, 1.0f*blue));
                         
                        //StdDraw.setPenColor(0, 0, 255); //BLUE
                
                        StdDraw.filledCircle(real, imag, stepSize / 2); // 3
    
                    } else {
                        
                        //int colorValue = 255 - (iterations * 255 / MAX);
                        //StdDraw.setPenColor(colorMap[iterations]);
                        StdDraw.setPenColor(Color.getHSBColor(1.0f *red, 1.0f*green, 1.0f*blue));
                        StdDraw.filledCircle(real, imag, stepSize / 2);
                    }
                    StdDraw.point(real, imag);
                }
               
            }
        }
        StdDraw.show(0);
    }

    private static void loadColorMap(String filename) {

    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

        String line;

        int index = 0;

        while ((line = br.readLine()) != null && index < 256) {
            //System.out.println(line);
            //String[] rgb = line.split(" "); // Split by space instead of comma
            String[] rgb = line.trim().split("\\s+");
            System.out.println("Parsed RGB: " + Arrays.toString(rgb)); 
            if (rgb.length == 3) {

                int r = Integer.parseInt(rgb[0].trim());

                int g = Integer.parseInt(rgb[1].trim());

                int b = Integer.parseInt(rgb[2].trim());

                colorMap[index++] = new Color(r, g, b);

            }

        }

    } catch (IOException e) {

        e.printStackTrace();

    } catch (NumberFormatException e) {

        System.err.println("Error parsing RGB values: " + e.getMessage());

    }
}
}