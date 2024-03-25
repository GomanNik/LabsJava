public class Student extends Human {
    private String faculty;

    public Student (String lastName, String firstName, String Surname, int age, String faculty) {
        super(lastName, firstName, Surname, age);
        if (faculty.isEmpty()){
            throw new IllegalArgumentException("У неотчисленного студента должен быть факультет!");
        }
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        if (faculty.isEmpty()){
            throw new IllegalArgumentException("У неотчисленного студента должен быть факультет!");
        }
        this.faculty = faculty;
    }
}