package HomeWork1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StreamApi {
    static List<Employee> listEmployee=new ArrayList<>();
    Employee employee;
    public StreamApi(){

        listEmployee.add(new Employee("Andrew","Bespalov","AA", LocalDate.of(2000,1,21),
                7895412,Sex.MALE,LocalDate.of(2017,5,12),LocalDate.of(2017,7,30),
                12000));
        listEmployee.add(new Employee("Jack","NoOne","AB", LocalDate.of(1996,2,14),
                8563274,Sex.MALE,LocalDate.of(2015,3,24),LocalDate.of(2018,1,3),
                5000));
        listEmployee.add(new Employee("Jane","Whisper","BB", LocalDate.of(1998,11,1),
                1425638,Sex.FEMALE,LocalDate.of(2016,9,27),LocalDate.of(2017,10,8),
                4000));
        listEmployee.add(new Employee("Chris","Redfilt","CC", LocalDate.of(1962,5,26),
                7539516,Sex.MALE,LocalDate.of(2001,8,13),LocalDate.now(),
                11000));
        listEmployee.add(new Employee("Andrew","Redfilt","DD", LocalDate.of(1980,5,26),
                1478943,Sex.MALE,LocalDate.of(2001,8,13),LocalDate.now(),
                11000));
        listEmployee.add(new Employee("Anna","Ollof","FF", LocalDate.of(1985,7,26),
                1068468,Sex.FEMALE,LocalDate.of(2012,8,20),LocalDate.now(),
                8500));
    }
    public void textFileAdd() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C:\\Users\\Nightbringer\\IdeaProjects\\HomeWork\\src\\HomeWork1\\FileTxt\\File.txt")));
        int count = 1;
        for (Employee e : getListEmployee()) {
            writer.write("Person " + count + "\nName: " + e.getName() + "\nSurname: " + e.getSurname() + "\nBirthday: " + e.getBirthday() +
                    "\nINN: " +
                    e.getINN() + "\nSex: " + e.getSex() + "\nStartWork: " +
                    e.getDateOfWorkUp() + "\nEndWork: " + e.getDateOfWorkDown() + "\nEarn: " +
                    e.getEarn() + "\n--------------------");
            writer.newLine();
            writer.flush();
            count++;
        }

    }
        public  List<Employee> getListEmployee() {
            return listEmployee;
        }

    public Employee getEmployee() {
        return employee;
    }
}
