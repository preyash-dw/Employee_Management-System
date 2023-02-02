package employee;
import java.util.Scanner;
public class start {
public static void main(String args[]) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Welcome to Employee management");
	boolean isrun=true;
	while(isrun) {
		System.out.println("What do you want to do  :");
		System.out.println("1.Add");
		System.out.println("2.Delete one data");
		System.out.println("3.Retreive whole employee data");
		System.out.println("4.Retreive single employee data");
		System.out.println("5 Update any employee data");
		System.out.println("6.Exit");
		System.out.println("Your choice : ");
		int ch= sc.nextInt();
		sc.nextLine();
		boolean issucess=false;
		switch(ch) {
		case 1:
			{
				System.out.println("Enter employee name :");
		        String name=sc.nextLine();
		        System.out.println("Enter employee contact number :");
		        String phone=sc.nextLine();
		        System.out.println("Enter employee dept :");
		        int dept=sc.nextInt();
		        Employee employee=new Employee(name,phone,dept);
		        System.out.println(employee.toString());
		        issucess=Control.insertEmployeeIntoDb(employee);
		        if(issucess) {
		        	System.out.println("succesful");
		        }
		        else {
		        	System.out.println("failed");
		        }
		        break;
			}
		case 2: {
			
			System.out.println("Enter employee id to delete: ");
			int eid = sc.nextInt();
			
			issucess = Control.deleteEmployeeFromDb(eid);
			
			if(issucess) {
				System.out.println("Successful");
			}
			else {
				System.out.println("Unsuccessful");
			}
			break;
			}
		case 3: {
			issucess = Control.showAllEmployeeFromDb();
			
			break;
		}
		case 4:
		{
			System.out.println("Enter employee id");
			int eid=sc.nextInt();
	        issucess = Control.retreiveEmployeeFromDb(eid);
			
			if(issucess) {
				System.out.println("Successful");
			}
			else {
				System.out.println("Unsuccessful");
			}
			break;
		}
		case 5:
		{
			System.out.println("Enter the employee id which you want to update");
			int eid=sc.nextInt();
			issucess=Control.update(eid,sc);
		}
		case 6:
		{
			isrun=false;
			break;
		}
		default :{
			System.out.println("Invalid ");
		}
		}
	}
	System.out.println("Thanks");
}
}
