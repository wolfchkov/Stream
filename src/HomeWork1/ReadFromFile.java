package HomeWork1;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFromFile {
    Employee employee;
    List<Employee> list=new ArrayList<>();
    public  void read() throws IOException {


    }

    public ReadFromFile() throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader(
                new File("C:\\Users\\Nightbringer\\IdeaProjects\\HomeWork\\src\\HomeWork1\\FileTxt\\1.txt")));
        String s;
        while((s=reader.readLine())!=null){
            String[] arr= s.split(";");
            list.add(new Employee(arr[0],
                    arr[1],
                    arr[2],
                    LocalDate.parse(arr[3]),
                    Integer.parseInt(arr[4])
                    , Employee.Sex.valueOf(arr[5]),
                    LocalDate.parse(arr[6]),
                    arr[7]==null ? null:LocalDate.parse(arr[7]),
                    Integer.parseInt(arr[8])));

        }
    }

    public List<Employee> getListEmployee() {
        return list;
    }

    public Employee getEmployee() {
        return employee;
    }
}
