/* Jacobi Method  from:  https://www.codesansar.com/numerical-methods/system-of-linear-equation-using-jacobi-iteration-using-c-programming.htm
 * Modified by Emilio Carcamo Dec 2022
*/
package javaapplication1;

import java.util.Scanner;

public class Jacobi {
    // Defining function 
 static double f1(double x, double y, double z) {
  return (17-y+2*z)/20;
 }
 static double f2(double x, double y, double z) {
  return (-18-3*x+z)/20;
 }
 static double f3(double x, double y, double z) {
  return (25-2*x+3*y)/20;
 }
 
    public static void main(String[] args) {
        // Declaration of variables
        double x0 = 0, y0 = 0, z0 = 0;
        double[] x = {x0, y0, z0};
        int iteration;
        
     
        
        System.out.println("Enter the maximum number of iterations");
        Scanner sc = new Scanner(System.in);
        iteration = sc.nextInt();
        
        // Number of iterations and accuracy
        double epsilon = 0.0001;
         System.out.println("Enter the desired accuracy:");
        epsilon = sc.nextDouble();
        
        // Step 1: Iterate until reach max iter or accuracy
        while (iteration > 0 && !checkError(x, new double[] {f1(x0, y0, z0), f2(x0, y0, z0), f3(x0, y0, z0)}, epsilon)) {
            // Step 2: Compute new approximations
            x0 = f1(x0, y0, z0);
            y0 = f2(x0, y0, z0);
            z0 = f3(x0, y0, z0);
            x[0] = x0;
            x[1] = y0;
            x[2] = z0;
            
            // Step 3: Decrease number of iterations
            iteration--;
        }
        
        // Step 4: Print results
        System.out.println("x = " + x0);
        System.out.println("y = " + y0);
        System.out.println("z = " + z0);
    }
    
    private static boolean checkError(double[] x, double[] newX, double error) {
        for (int i = 0; i < x.length; i++) {
            if (Math.abs(x[i] - newX[i]) > error) {
                return false;
            }
        }
        return true;
    }
}
