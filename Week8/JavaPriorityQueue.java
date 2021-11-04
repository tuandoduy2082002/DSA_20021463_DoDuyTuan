package Week8;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class JavaPriorityQueue {
    static class Student implements Comparable<Student> {
        String ID;
        String Name;
        Double CGPA;

        public Student(String Name,Double CGPA,String ID) {
            this.Name = Name;
            this.CGPA = CGPA;
            this.ID = ID;
        }

        @Override
        public int compareTo(Student student) {
            if (CGPA.compareTo(student.CGPA) != 0)
                return -CGPA.compareTo(student.CGPA);
            if (this.Name.compareTo(student.Name) != 0)
                return Name.compareTo(student.Name);
            return -ID.compareTo(student.ID);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        PriorityQueue<Student> list = new PriorityQueue<>();
        Queue<Student> served = new PriorityQueue<>();
        for (int i = 0;i < n;i++) {
            if (scan.next().compareTo("SERVED") == 0) {
                if (list.size() != 0) served.add(list.poll());
            }
            else {
                Student student = new Student(scan.next(),scan.nextDouble(),scan.next());
                list.add(student);
            }
        }
        if (list.size() == 0) System.out.println("EMPTY");
        else while (list.size() != 0) System.out.println(list.poll().Name);
    }
}
