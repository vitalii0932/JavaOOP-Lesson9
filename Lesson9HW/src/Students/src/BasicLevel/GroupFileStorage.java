package Students.src.BasicLevel;

import Students.src.BasicLevel.Exceptions.GroupOverflowException;
import Students.src.BasicLevel.Exceptions.StudentNotFoundException;

import java.io.*;
import java.util.List;

public class GroupFileStorage {
    public GroupFileStorage() {
    }

    public void saveGroupToCSV(Group gr) {
        String groupCSVString = "";
        groupCSVString = String.format("%s\"%s\",\"", groupCSVString, gr.getGroupName());
        List<Student> students = gr.getStudents();
        int i = 0;
        for(Student student : students) {
            if(student != null) {
                if(i == 0) {
                    groupCSVString = String.format("%s{\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"}", groupCSVString, student.getName(), student.getLastName(), student.getGender(), student.getId(), student.getGroupName());
                } else {
                    groupCSVString = String.format("%s,{\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"}", groupCSVString, student.getName(), student.getLastName(), student.getGender(), student.getId(), student.getGroupName());
                }
                i++;
            }
        }
        groupCSVString = groupCSVString + "\"";
        try{
            File file = new File(String.format("%s.txt", gr.getGroupName()));
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(groupCSVString);
            bufferedWriter.newLine();

            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Group saving to CSV completed successfully");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Group loadGroupFromCSV(File file) {
        Group newGroup = new Group();
        String CVSString = "";
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            CVSString = bufferedReader.readLine();

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if(CVSString.length() != 0) {
            String groupNameStr = CVSString.substring(0, CVSString.indexOf(","));
            String studentsArrayStr = CVSString.substring(CVSString.indexOf(",") + 1);

            //set group name
            groupNameStr = groupNameStr.replaceAll("\"", "");
            newGroup.setGroupName(groupNameStr);

            //set array of students
            studentsArrayStr = studentsArrayStr.substring(1, studentsArrayStr.length()-1);

            studentsArrayStr = studentsArrayStr.substring(1, studentsArrayStr.length() - 1);

            String[] elements = studentsArrayStr.split("\\},\\{");

            for (String element : elements) {
                Student groupStudent = new Student();

                element = element.substring(1, element.length() - 1);
                String[] fields = element.split("\",\"");

                groupStudent.setName(fields[0]);
                groupStudent.setLastName(fields[1]);
                groupStudent.setGender(Gender.valueOf(fields[2]));
                groupStudent.setId(Integer.parseInt(fields[3]));
                groupStudent.setGroupName(fields[4]);
                try {
                    newGroup.addStudent(groupStudent);
                } catch (GroupOverflowException e) {
                    System.out.println("Group overflow");
                }
            }
            System.out.println("Group loading from CSV completed successfully");
        } else {
            System.out.println("File read ERROR");
        }

        return newGroup;
    }

    public File findFileByGroupName(String groupName, File workFolder) throws IOException {
        File[] files = workFolder.listFiles();
        for(File file : files) {
            if(file.isFile()) {
                if(file.getName().substring(0, file.getName().indexOf(".")).equals(groupName)) {
                    System.out.println("The group has been founded");
                    return file;
                }
            }
        }
        System.out.println("The group has not been found");
        return new File("");
    }

    @Override
    public String toString() {
        return "GroupFileStorage{}";
    }
}
