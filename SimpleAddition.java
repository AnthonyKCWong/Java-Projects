import java.util.Scanner;
public class SimpleAddition {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int v1 = input.nextInt();
		System.out.print("Enter another integer: ");
		int v2 = input.nextInt();
		
		int v3 = v1+v2;
		
		System.out.println("Added Number: " + v3);
		
		input.close();
	}
}
