package fr.usmb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class CSVReader {

    /***
     * @return readed CSV to a set of data where each line is subdivided by chunks created
     * thanks to the separator set by the constructor
     */
    private ArrayList<String[]> read() {
        ArrayList<String[]> lines = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(AppProperties.getCSVFilePath()))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(AppProperties.getSeparator());
                lines.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /***
     *
     * @return ArrayList<Person> -> people list in the CSV
     */
    public ArrayList<Person> toPeople() {
        ArrayList<String[]> data = read();
        ArrayList<Person> people = new ArrayList<>();
        for (String[] personInfos : data) {
            /* personInfos[0] = day, personInfos[1] = month, personInfos[2] = year, personInfos[3] = surname
             * personInfos[4] = firstName, personInfos[5] = mail
             */
            LocalDate birth_day = LocalDate.of(
                    Integer.parseInt(personInfos[2]),
                    Integer.parseInt(personInfos[1]),
                    Integer.parseInt(personInfos[0]));

            String surname = personInfos[3];
            String firstName = personInfos[4];
            String mail = personInfos[5];
            people.add(new Person(birth_day, surname, firstName, mail));
        }
        return people;
    }
}