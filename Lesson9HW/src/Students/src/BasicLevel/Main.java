package Students.src.BasicLevel;

import Students.src.BasicLevel.Exceptions.GroupOverflowException;
import Students.src.BasicLevel.Exceptions.StudentNotFoundException;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Student newStudent11 = new Student("Alexey", "Sidorov", Gender.Male, 13, "group1");
        Student newStudent12 = new Student("Maria", "Petrova", Gender.Female, 12, "group1");
        Student newStudent13 = new Student("Ivan", "Ivanovich", Gender.Male, 11, "group1");
        Student newStudent14 = new Student("Anton", "Antonovich", Gender.Female, 10, "group1");

        Student newStudent21 = new Student("Anton", "Antonovich", Gender.Female, 10, "group2");
        Student newStudent22 = new Student("Ivan", "Ivanovich", Gender.Male, 11, "group2");
        Student newStudent23 = new Student("Maria", "Petrova", Gender.Female, 12, "group2");
        Student newStudent24 = new Student("Alexey", "Sidorov", Gender.Male, 13, "group2");

        Group group1 = new Group();
        group1.setGroupName("group1");
        try {
            group1.addStudent(newStudent11);
            group1.addStudent(newStudent12);
            group1.addStudent(newStudent13);
            group1.addStudent(newStudent14);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Group group2 = new Group();
        group2.setGroupName("group2");
        try {
            group2.addStudent(newStudent21);
            group2.addStudent(newStudent22);
            group2.addStudent(newStudent23);
            group2.addStudent(newStudent24);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(group1.toString());
        System.out.println(group2.toString());

        System.out.println("------------------------------------------------------");

        StudentKeyboardInput studentKeyboardInput = new StudentKeyboardInput();
        Student newStudent = studentKeyboardInput.addStudent();

        try {
            group1.addStudent(newStudent);
            group2.addStudent(newStudent);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(group1.toString());
        System.out.println(group2.toString());

        System.out.println("------------------------------------------------------");

        CSVStringConverter csvStringConverter = new CSVStringConverter();
        String newStr = csvStringConverter.toStringRepresentation(newStudent);
        System.out.println(newStr);
        Student newCSVstudent = csvStringConverter.fromStringRepresentation(newStr);
        System.out.println(newCSVstudent.toString());

        System.out.println("------------------------------------------------------");

        GroupFileStorage groupFileStorage = new GroupFileStorage();
        groupFileStorage.saveGroupToCSV(group1);
        groupFileStorage.saveGroupToCSV(group2);
        Group newGroup = groupFileStorage.loadGroupFromCSV(new File("group1.txt"));
        System.out.println(newGroup.toString());
        try {
            File groupFile = groupFileStorage.findFileByGroupName(group1.getGroupName(), new File("C:\\Users\\User\\IdeaProjects\\Lesson5"));
            System.out.println(groupFile.getName());
            Group foundedGroup = groupFileStorage.loadGroupFromCSV(groupFile);
            System.out.println(foundedGroup.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------------------------------------------------------");

        Student newStudent15 = new Student("Anton", "Antonovich", Gender.Female, 10, "group1");
        try {
            group1.addStudent(newStudent15);
        } catch (GroupOverflowException e) {
            System.out.println(e.getMessage());
        }

        boolean equalsStudents1 = group1.groupHasEqualsStudents();
        boolean equalsStudents2 = group2.groupHasEqualsStudents();
    }
}