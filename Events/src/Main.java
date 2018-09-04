import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

    public class Main {

        public static void main(String a[]){
            countup(10);
        }

        public static void countup(int n) {
            if (n == 0) {
                System.out.println("Blastoff!");
            } else {
                countup(n - 1);
                System.out.println(n);
            }
        }
    }



    class MySalaryComp implements Comparator<Empl>{

        @Override
        public int compare(Empl e1, Empl e2) {
            if(e1.getSalary() < e2.getSalary()){
                return 1;
            } else {
                return -1;
            }
        }
    }

    class Empl{

        private String name;
        private int salary;

        public Empl(String n, int s){
            this.name = n;
            this.salary = s;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getSalary() {
            return salary;
        }
        public void setSalary(int salary) {
            this.salary = salary;
        }
        public String toString(){
            System.out.printf("%.2f", 11.11);
            return "Name: "+this.name+"-- Salary: "+this.salary;
        }
    }