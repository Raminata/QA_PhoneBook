package com.phonebook.fw;

import com.phonebook.modle.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> addContactPositiveFromCsvFile() throws IOException {
        return readContactsFromFile("src/test/resources/contact.csv");
    }

    @DataProvider
    public Iterator<Object[]> addContactNegativeFromCsvFile() throws IOException {
        return readContactsFromFile("src/test/resources/contact_negative.csv");
    }

    private static Iterator<Object[]> readContactsFromFile(String pathname) throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader r = new BufferedReader(new FileReader(new File(pathname)));

        String line = r.readLine();
        while (line != null) {
            String[] split = line.split(",");

            list.add(new Object[]{new Contact()
                    .setName(split[0])
                    .setLastname(split[1])
                    .setPhone(split[2])
                    .setEmail(split[3])
                    .setAddress(split[4])
                    .setDesc(split[5])});

            line = r.readLine();
        }
        return list.iterator();
    }
}
