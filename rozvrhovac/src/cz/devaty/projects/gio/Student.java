package cz.devaty.projects.gio;

import java.util.ArrayList;

/**
 * Created by MrMid on 27.04.2017.
 */
public class Student {


    private String name;
    private String surname;
    private ArrayList<Seminar> seminars;

    public Student(String name, String surname, ArrayList<Seminar> seminars) {
        this.name = name;
        this.surname = surname;
        this.seminars = seminars;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public ArrayList<Seminar> getSeminars() {
        return seminars;
    }

    public static double conflictsPerStudent(Student student){
        double result = 0;
        for(int i = 0; i < student.seminars.size();i++){
            for (int j = i+1; j < student.seminars.size(); j++) {
                if(student.seminars.get(i).getGroup() == student.seminars.get(j).getGroup()){
                    result++;
                }
            }
        }
        return result;
    }
}
