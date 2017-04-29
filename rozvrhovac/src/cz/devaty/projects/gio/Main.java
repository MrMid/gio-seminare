package cz.devaty.projects.gio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    /**
     * předmět a -> 3., 7.O
     * předmět b -> 4., 8.O
     * předmět c -> 3., 7.O, 4., 8.O
     */

    private static String FILE = "a.csv";


    public static void main(String[] args) {
        try {
            ArrayList<Student> students = loadData();
            computeGroups(students);

        } catch (FileNotFoundException e) {
            System.out.println("Error loading data");
        }
    }

    private static void computeGroups(ArrayList<Student> students) {

    }

    private static ArrayList<Student> loadData() throws FileNotFoundException {
        BufferedReader in = new BufferedReader(new FileReader(FILE));
        ArrayList<Student> students = new ArrayList<>();
        while(true){
            try {
                String[] line = (in.readLine()).split(";");
                ArrayList<Seminar> sem = new ArrayList<>();
                for(int i = 2;i<line.length;i++){
                    String[] s = line[i].split(" ");
                    sem.add(new Seminar(s[1], s[2].charAt(0)));
                }
                students.add(new Student(line[1], line[2], sem));
            } catch (IOException e) {
                return students;
            }
        }
    }
}
