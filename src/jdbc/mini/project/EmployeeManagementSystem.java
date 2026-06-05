package jdbc.mini.project;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class EmployeeManagementSystem {
	
	public static void main(String ty[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Table Structure\nID\tName\tSalary\tDept");
		System.out.println("Int\tvarchar\tlong\tvarchar");
		while(true) {
			System.out.println("\nEmployee Management System");
		System.out.println("1.Add Employee\n2.View Employees\n3.Search Employee\n4.Update Employee\n5.Delete Employee\n6.Batch Insert\n7.Exit");
		System.out.println("\nChoose The Operation");
		int a=sc.nextInt();
		EmployeeManagementSystem obj=new EmployeeManagementSystem();
		
		switch(a) {
		case 1:
			obj.Add();
			break;
			
		case 2:
			obj.View();
			break;
			
		case 3:
			obj.Search();
			break;
			
		case 4:
			obj.Update();
			break;
			
		case 5:
			obj.Delete();
			break;
			
		case 6:
			obj.BatchInsert();
			break;
			
		case 7:
			System.out.println("Exited Successfully");
			System.exit(0);
			
			default:
				System.out.println("Invalid Choice");
			
		}
		}
	}
	
	public void Add() {
		Scanner sc=new Scanner(System.in);
		int id;
		String name,dept;
		long salary;
		 final String query="insert into Emp values(?,?,?,?);";
		try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","Your_Password");
				PreparedStatement preparedStatement=connection.prepareStatement(query)){
			connection.setAutoCommit(false);
			System.out.println("Enter the Id");
			id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Name");
			name=sc.nextLine();
		
			System.out.println("Enter the Salary");
			salary=sc.nextLong();
			sc.nextLine();
			System.out.println("Enter the Dept");
			dept=sc.nextLine();
			
			preparedStatement.setInt(1,id);
			preparedStatement.setString(2,name);
			preparedStatement.setLong(3,salary);
			preparedStatement.setString(4,dept);
			
			int rows=preparedStatement.executeUpdate();
			System.out.println("Data Inserted"+"\n"+"Rows Effected "+rows);
			connection.commit();
			
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}
	private void View() {
		try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","Your_Password");
				
				Statement statement=connection.createStatement()){
			    ResultSet resultSet=statement.executeQuery("select *from emp");
			    while(resultSet.next()) {
			    	int id=resultSet.getInt("id");
			    	String name=resultSet.getString("name");
			    	Long salary=resultSet.getLong("salary");
			    	String dept=resultSet.getString("dept");
			    	
					System.out.println(id+" "+name+" "+salary+" "+dept);
			    	
			    }
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	private void Search() {
		Scanner sc=new Scanner(System.in);
		String query="select *from emp where id=?;";
		try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","Your_Password");
				PreparedStatement preparedStatement=connection.prepareStatement(query)){
				System.out.println("Enter The Emp Id:");
				int a=sc.nextInt();
				
				preparedStatement.setInt(1, a);
				
				ResultSet resultSet=preparedStatement.executeQuery();
				if(resultSet.next()) {
			    	int id=resultSet.getInt("id");
			    	String name=resultSet.getString("name");
			    	Long salary=resultSet.getLong("salary");
			    	String dept=resultSet.getString("dept");
			    	
					System.out.println(id+" "+name+" "+salary+" "+dept);
			    	
			    }else {
			    	System.out.println("Employee Not Found");
			    }

			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void Update() {
		String query1="update emp set name=? where id=?;";
		String query2="update emp set salary=? where id=?;";
		String query3="update emp set dept=? where id=?;";
		
		Scanner sc=new Scanner(System.in);
		try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","Your_Password");
				){
			System.out.println("Select The Data You Need To Update\n1.Name\n2.Salary\n3.Dept");
			int a=sc.nextInt();
			switch(a) {
			case 1:
				PreparedStatement preparedStatement=connection.prepareStatement(query1);
				System.out.println("Enter The Employee Id:");
				int b=sc.nextInt();
				sc.nextLine();
					
				System.out.println("Enter The Name To Be Updated:");
				String n=sc.nextLine();
				preparedStatement.setString(1,n);
				preparedStatement.setInt(2, b);
				int row=preparedStatement.executeUpdate();
				
				System.out.println("Data Updated\nRows Affected"+row);
				break;
				
			case 2:
				PreparedStatement preparedStatement2=connection.prepareStatement(query2);
				System.out.println("Enter The Employee Id:");
				int c=sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter The Salary To Be Updated:");
				Long d=sc.nextLong();
				
				preparedStatement2.setLong(1,d);
				preparedStatement2.setInt(2, c);
				int row1=preparedStatement2.executeUpdate();
				
				System.out.println("Data Updated\nRows Affected "+row1);
				break;
				
			case 3:
				PreparedStatement preparedStatement3=connection.prepareStatement(query3);
				System.out.println("Enter The Employee Id:");
				int e=sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter The Dept To Be Updated:");
				String f=sc.nextLine();
				 
				preparedStatement3.setString(1,f);
				preparedStatement3.setInt(2, e);
				int row2=preparedStatement3.executeUpdate();
				System.out.println("Data Updated\nRows Affected "+row2);
				break;
				
				default:
					System.out.println("Invalid Choice");
					break;
			
			}
			
			
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}
	public void Delete() {
		Scanner sc=new Scanner(System.in);
		String query="delete from emp where id=?;";
		try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","Your_Password");
				PreparedStatement preparedStatement=connection.prepareStatement(query)){
			System.out.println("Enter The Id To Delete The Data:");
			int id=sc.nextInt();
			
			preparedStatement.setInt(1, id);
			int row=preparedStatement.executeUpdate();
			System.out.println("Data Deleted\nRows Affected:"+row);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void BatchInsert() {
		String query="insert into emp values(?,?,?,?);";
		Scanner sc=new Scanner(System.in);
		try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","Your_Password");
				PreparedStatement preparedStatement=connection.prepareStatement(query)){
			connection.setAutoCommit(false);
			System.out.println("Enter How Many Employees Data You Want To Add:");
			int N=sc.nextInt();
			for(int i=1;i<=N;i++) {
				System.out.println("Enter The "+i+" Employee Details:");
				System.out.println("Enter The Id:");
					int a=sc.nextInt();
					sc.nextLine();
				System.out.println("Enter The Name:");
					String b=sc.nextLine();
				System.out.println("Enter The Salary:");
					Long c=sc.nextLong();
					sc.nextLine();
				System.out.println("Enter The Dept:");
					String d=sc.nextLine();
					
					preparedStatement.setInt(1, a);
					preparedStatement.setString(2, b);
					preparedStatement.setLong(3, c);
					preparedStatement.setString(4, d);
					preparedStatement.addBatch();
			}
			int[] row=preparedStatement.executeBatch();
			System.out.println("Data Inserted Successfully\nNo.Of Rows Affected:"+Arrays.toString(row));
			connection.commit();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
