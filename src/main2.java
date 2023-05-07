import java.util.*;
public class main2 {

	public static void main(String[] args) throws BonusTooLowException  {
		Scanner scan = new Scanner(System.in);
		BonusTooLowException problem = new BonusTooLowException("Too low");
		int size = scan.nextInt();
		Executive[] e = new Executive[size];
		
		for(int i=0;i<e.length;i++) {
			System.out.println("please type name, address, phone number, social, and rate of pay.");
			
			String name = scan.nextLine();
			String place = scan.nextLine();
			String number = scan.nextLine();
			String ss = scan.nextLine();
			scan.nextLine();
			double rate = scan.nextDouble();
			
			e[i]= new Executive(name,place,number,ss,rate);
			
			
		}
		for(Executive i: e) {
			System.out.println("please award a bonus.");
			double bonus = scan.nextDouble();
			try {
				if(bonus<5000) {
					throw problem;
				}
				else {
					i.awardBonus(bonus);
				}
				
			}
			catch(Exception error) {
				System.out.println("No bonus is awarded.");
				i.awardBonus(0);
				
			}
			
		}

	}

}
