package Students.src.BasicLevel;

import Students.src.BasicLevel.Exceptions.GroupOverflowException;
import Students.src.BasicLevel.Exceptions.StudentNotFoundException;

import java.util.*;

public class Group {
    private String groupName;
    private List<Student> students = new ArrayList<>();
    private final int groupSize = 10;

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        if(students.size() != groupSize) {
            if (student.getGroupName().equals(this.groupName)) {
                students.add(student);
                System.out.println("BasicLevel.Student added");
            } else {
                System.out.println("Student group name does not match");
            }
            return;
        }
        throw new GroupOverflowException();
    }

    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
        for (Student student : students) {
            if(student != null && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        throw new StudentNotFoundException();
    }

    public boolean removeStudentByID(int id) {
        List<Student> newStudents = new ArrayList<>();
        boolean remove = false;
        int removeStudentsCount = 0;
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i) != null) {
                if(students.get(i).getId() != id) {
                    newStudents.add(students.get(i));
                } else {
                    remove = true;
                    removeStudentsCount++;
                    continue;
                }
            }
        }
        if(remove) {
            for (int i = 0; i < removeStudentsCount; i++) {
                newStudents.add(null);
            }
        }
        students = newStudents;
        return remove;
    }

    public List<Student> sortStudentsByLastName() {
        Collections.sort(students, Comparator.nullsLast(new StudentLastNameComparator()));
        return students;
    }

    public boolean groupHasEqualsStudents() {
        for(int i = 0; i < students.size(); i++) {
            for (int j = 0; j < students.size(); j++) {
                if(i == j || students.get(i) == null) {
                    continue;
                }
                if(students.get(i).equals(students.get(j))) {
                    System.out.println(students.get(i).toString() + " --- equals ---" + students.get(j).toString());
                    return true;
                }
            }
        }
        System.out.println("There are no equivalent students in the group: " + groupName);
        return false;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", students=" + students.toString() +
                ", groupSize=" + groupSize +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return groupSize == group.groupSize && Objects.equals(groupName, group.groupName) && Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, students, groupSize);
    }
}
