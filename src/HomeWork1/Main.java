package HomeWork1;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
   static ReadFromFile streamApi;
    public static void streamWomen(){
        long a=streamApi.getListEmployee().stream()
                .filter(e->e.getSex()== Employee.Sex.FEMALE)
                .count();
        System.out.println("Count women: "+a);
    }
    public static void earnMan(){
        long a=streamApi.getListEmployee().stream()
                .filter(e->e.getEarn()>10000)
                .count();
        System.out.println("Earn more then 10000: "+a);
    }
    public static void maxEarnMan(){
        int a= streamApi.getListEmployee().stream()
                .filter(e -> Objects.equals(e.getName(), "Andrew"))
                .max(Comparator.comparing(Employee::getEarn)).get().getEarn();
        System.out.println("Name Andrew and max earn: "+a);
    }
    public static void minEarnWomen(){
        int a= streamApi.getListEmployee().stream()
                .filter(e -> Objects.equals(e.getName(), "Jane"))
                .min(Comparator.comparing(Employee::getEarn)).get().getEarn();
        System.out.println("Name Jane and min earn: "+a);
    }
    public static void FIOAllEmployees(){
        System.out.print("FIO: ");
       streamApi.getListEmployee().stream()
                .filter(e->(e.getDateOfWorkDown().getYear()-e.getDateOfWorkUp().getYear())>10)
                .forEach(s-> System.out.print(s.getSurname()+"."+s.getName().substring(0,1)
                        +"."+s.getPatronymic().substring(0,1)+", "));

    }
    public static void numberFireEmployees(){
        System.out.println();
        long a=streamApi.getListEmployee().stream()
                .filter(e->e.getDateOfWorkDown().getYear()==2017)
                .count();
        System.out.println("Count firing in past year: "+a);
    }
    public static void INN(){
        Map<Integer, Employee> map=new HashMap<>();
        int x=0;


    }
    public static void intemidiateAgeEmployees(){
        double a= streamApi.getListEmployee().stream()
               .mapToInt(e->
                  LocalDate.now().getYear()-e.getBirthday().getYear()
               ).average().getAsDouble();
        System.out.println("Average age all employees: "+a);
    }
    public static void intemidiateEarnMans(){
        double a=streamApi.getListEmployee().stream()
                .filter(e->e.getSex()== Employee.Sex.MALE)
                .mapToInt(e->  LocalDate.now().getYear()-e.getBirthday().getYear()).average().getAsDouble();
        System.out.println("Average age all mans: "+a);
    }
    public static void intemidiateEarnWomen(){
        double a=streamApi.getListEmployee().stream()
                .filter(e->(LocalDate.now().getYear()-e.getBirthday().getYear())>40)
                .mapToInt(e->e.getEarn()).average().getAsDouble();
        System.out.println("Average earn all women who oldest then 40 years: "+a);
    }
    public static void groubByAllWomen(){
        streamApi.getListEmployee().stream()
               .filter(e->
                   LocalDate.now().getYear()-e.getBirthday().getYear()>30 &&
                           LocalDate.now().getYear()-e.getBirthday().getYear()<40
               )
                .collect(Collectors.groupingBy(p->p.getBirthday().getMonth()))
        .forEach(((month, list) -> System.out.format("%s \t",month)));



    }
    public static void main(String[] args) throws IOException {
        streamApi=new ReadFromFile();
       streamWomen();
        earnMan();
        maxEarnMan();
        minEarnWomen();
        FIOAllEmployees();
        numberFireEmployees();
       INN();
        intemidiateAgeEmployees();
        intemidiateEarnMans();
        intemidiateEarnWomen();
        groubByAllWomen();
    }


}
