package cz.devaty.projects.gio;

/**
 * Created by MrMid on 27.04.2017.
 */

class Seminar {
    private String name;
    private char group;

    Seminar(String name, char group) {
        this.name = name;
        this.group = group;
    }

    char getGroup() {
        return group;
    }
}
