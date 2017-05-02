package cz.devaty.projects.gio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

    /**
     * předmět a -> 3., 7.O
     * předmět b -> 4., 8.O
     * předmět c -> 3., 7.O, 4., 8.O
     */

    private static String FILE = "a.csv";
    private static ArrayList<Student> students;
    private static ArrayList<Seminar> seminars;


    public static void main(String[] args) {
        try {
            students = loadData();
            seminars = seminars.stream().distinct().collect(Collectors.toCollection(ArrayList::new));

            computeGroups();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading data");
        }
    }

    private static void computeGroups() {


    }

    private static double countConflicts(int lastIndex){
        double result = 0;
        for(int i = 0;i<lastIndex;i++){
            result += Student.conflictsPerStudent(students.get(i));
        }
        return result;
    }

    private static ArrayList<Student> loadData() throws FileNotFoundException {
        seminars = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader(FILE));
        ArrayList<Student> students = new ArrayList<>();
        while(true){
            try {
                String s = in.readLine();
                if(s == null) return students;
                String[] line = s.split(";");
                ArrayList<Seminar> sem = new ArrayList<>();
                for(int i = 2;i<line.length;i++){
                    sem.add(new Seminar(line[i]));
                    seminars.add(new Seminar(line[i]));
                }
                students.add(new Student(line[1], line[2], sem));
            } catch (IOException e) {
                return students;
            }
        }
    }
}
