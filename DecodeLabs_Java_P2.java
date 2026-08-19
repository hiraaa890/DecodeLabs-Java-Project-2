import java.util.InputMismatchException;
import java.util.Scanner;

public class DecodeLabs_Java_P2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int subjectCount;
        String subjectName;
        int subjectMarks;
        double totalMarks = 0;
        double percentage;

        System.out.println("-----------------------------------------------------");
        System.out.println("                  GRADE CALCULATOR                   ");
        System.out.println("-----------------------------------------------------");
        System.out.println("");
        System.out.print("For how many subjects u want to calculate grades ? ");
        while (true) {
            try {
                subjectCount = sc.nextInt();
                if (subjectCount <= 0) {
                    System.out.print("Invalid...try again  ");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Invalid...try again  ");
                sc.next();
            }
        }
        System.out.println("");
        System.out.println("Enter " + subjectCount + " Subject names:  ");
        
        String[] subjects = new String[subjectCount];
        int[] marks = new int[subjectCount];
        System.out.println("");

        for (int i = 0; i < subjects.length; i++) {
            System.out.print((i + 1) + " ");
            subjectName = sc.next();
            subjects[i] = subjectName;
        }

        System.out.println("-------------------------------------------------------");
        System.out.println("Enter marks out of 100 for each Subject:");
        System.out.println("");
        for (int i = 0; i < marks.length; i++) {
            while (true) {
                try {
                    System.out.print(subjects[i] + " = ");
                    subjectMarks = sc.nextInt();
                    if (subjectMarks > 100 || subjectMarks < 0) {
                        System.out.println("Invalid Input...enter again");
                        continue;
                    }

                    marks[i] = subjectMarks;
                    totalMarks += subjectMarks;
                    break;
                    
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input...enter again");
                    sc.next();
                }
            }
        }
        System.out.println("________________________________________________________");
        System.out.println("                      RESULTS                           ");
        System.out.println("________________________________________________________");
        System.out.println("");
        System.out.println("Total Marks are : " + totalMarks + " / " + marks.length * 100);

        percentage = (totalMarks / (marks.length * 100)) * 100;
        System.out.printf("Average Percentage : %.2f%%", percentage);

        System.out.println("");
        System.out.print("Grade :");
        if (percentage >= 90) {
            System.out.println("A+");
        } else if (percentage >= 85) {
            System.out.println("A");
        } else if (percentage >= 80) {
            System.out.println("A-");
        } else if (percentage >= 75) {
            System.out.println("B+");
        } else if (percentage >= 70) {
            System.out.println("B");
        } else if (percentage >= 65) {
            System.out.println("B-");
        } else if (percentage >= 60) {
            System.out.println("C+");
        } else if (percentage >= 55) {
            System.out.println("C");
        } else if (percentage >= 50) {
            System.out.println("C-");
        } else {
            System.out.println("F");
        }

        String status;
        if (percentage < 50) {
            status = "Fail";
        } else {
            status = "Pass";
        }
        System.out.println("Status :" + status);

    }
}
