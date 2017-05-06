package cz.devaty.projects.gio;

/**
 * Created by MrMid on 27.04.2017.
 */

class Seminar {
    private String name;
    private char group;

    public void setGroup(char group) {
        this.group = group;
    }

    public Seminar(String name) {
        this.name = name;
        this.group = 'a';
    }

    Seminar(String name, char group) {
        this.name = name;
        this.group = group;
    }

    char getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o){
        return this.name.equals(((Seminar)o).name);
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    protected Seminar clone() throws CloneNotSupportedException {
        return new Seminar(this.name, this.group);
    }
}
