package Students.src.BasicLevel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVStringConverter implements StringConverter {
    @Override
    public String toStringRepresentation(Student student) {
        String CSVString = "";
        CSVString = String.format("%s\"%s\",", CSVString, student.getName());
        CSVString = String.format("%s\"%s\",", CSVString, student.getLastName());
        CSVString = String.format("%s\"%s\",", CSVString, student.getGender());
        CSVString = String.format("%s\"%s\",", CSVString, student.getId());
        CSVString = String.format("%s\"%s\"", CSVString, student.getGroupName());
        return CSVString;
    }

    @Override
    public Student fromStringRepresentation(String str) {
        String[] studentStrings = new String[5];
        Student student = new Student();
        String regex = "\"([^\"]*)\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        int i = 0;
        while (matcher.find()) {
            String element = matcher.group(1);
            //System.out.println(element);
            studentStrings[i] = element;
            i++;
        }
        try {
            student.setName(studentStrings[0]);
            student.setLastName(studentStrings[1]);
            student.setGender(Gender.valueOf(studentStrings[2]));
            student.setId(Integer.parseInt(studentStrings[3]));
            student.setGroupName(studentStrings[4]);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return student;
    }
}
