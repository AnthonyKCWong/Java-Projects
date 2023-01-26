import java.util.Scanner;
public static class Lab3
{
    public static void Main()
    {
    	Scanner myObj = new Scanner(System.in);
        double inpRadius;
        // create a circle object with no arg constructor
        Circle cir1 = new Circle();
        // create a circle object with one arg constructor
        Circle cir2 = new Circle(10);

        // print out the area of the circles
        System.out.println("Circle 1 has radius {0} and area {1:F2}",
         cir1.Radius, cir1.GetArea);
        System.out.println("Circle 2 has radius {0} and area {1:F2}",
        cir2.Radius, cir2.GetArea());

        //prompt the user for a radius
        do
        {
        	System.out.println("Enter a positive radius => ");
            inpRadius = Convert.ToDouble(Console.ReadLine());
        } while (inpRadius < 0);
        cir1.Radius = inpRadius;

        // print out the area of the circles
        System.out.println("Circle 1 has radius {0} and area {1:F2}",
         cir1.Radius, cir1.GetArea());
        System.out.println("Circle 2 has radius {0} and area {1:F2}",
        cir2.Radius, cir2.GetArea());

        //add circles
        if(cir1 > cir2)
        	System.out.println("Circle 1, with radius {0} is bigger the Circle 2 with radius {1}", cir1.Radius, cir2.Radius)
       else
    	   System.out.println("Circle 1, with radius {0} is not bigger the Circle 2 with radius {1}", cir1.Radius, cir2.Radius)
    	   System.out.println();
    }
}