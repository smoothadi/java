import java.io.*; 
import java.util.*;

class StudentInfo {
public static void main(String[] args) throws IOException { 
Scanner sc = new Scanner(System.in);

System.out.print("Name: "); 
String name = sc.nextLine();

System.out.print("Age: "); 
int age = sc.nextInt();
 
System.out.print("Java marks: "); 
int javaMarks = sc.nextInt();

System.out.print("RDBMS marks: "); 
int rdbmsMarks = sc.nextInt();

System.out.print("OS marks: "); 
int osMarks = sc.nextInt();

// Writing student data to file
try (BufferedWriter writer = new BufferedWriter(new 
FileWriter("student_marks.txt"))) {
writer.write("Name: " + name + "\nAge: " + age + "\nMarks:\n");
writer.write("Java: " + javaMarks + "\nRDBMS: " + rdbmsMarks + "\nOS:" + osMarks);
}

// Reading and displaying student data from file 
BufferedReader reader = new BufferedReader(new
FileReader("student_marks.txt"));
System.out.println("\nDisplaying information from text file: "); 
reader.lines().forEach(System.out::println);
}
}
