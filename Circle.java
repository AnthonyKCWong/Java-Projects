// Code File Circle
public class Circle

{
    private double radius;
    private static double PI = 3.14159;

    // no argument Constructor
    public Circle()
    {
        radius = 0;
    }
    // one argument Constructor
    public Circle(double rad)
    {
        // make sure the parameter is not negative
        if (rad < 0)
            radius = 0;
        else
            radius = rad;
    }
    // Radius Property
    public double Radius
    {
        // return the private data value on
        get
        {
            return radius;
        }
        // make sure the implicit parameter is not negative on set
        set
        {
            if (value < 0)
                radius = 0;
            else
                radius = value;
        }
    }
    // GetArea Method
    public double GetArea()
    {
        double area;
        // compute the area = radius^2 * PI
        area = radius * radius * PI;
        return area;
    }
    //overloaded > operator to compare circles
    public static bool operator>(Circle circle1, Circle circle2) {
      if(circle1.Radius > circle2.Radius)
        return true;

      return false;
  }
}