package com.willmadison;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneDirectory {

    private static class Person {
        String name;
        String phoneNumber;
        String address;

        public String toString() {
            return String.format("Phone => %s, Name => %s, Address => %s", this.phoneNumber, this.name, this.address);
        }
    }

    private static final Map<String, Collection<Person>> phoneBook = new HashMap<>();

    public static String phone(String directory, String phoneNumber) {
        phoneBook.clear();
        preprocess(directory);

        Collection<Person> people = phoneBook.get(phoneNumber);

        if (people == null) {
            return "Error => Not found: " + phoneNumber;
        } else if (people.size() > 1) {
            return "Error => Too many people: " + phoneNumber;
        } else {
            return people.iterator().next().toString();
        }
    }

    private static void preprocess(String directory) {
        String[] entries = directory.split(Pattern.quote("\n"));

        Pattern phoneNumberRegEx = Pattern.compile("(\\d{1,2}-\\d{3}-\\d{3}-\\d{4})");
        Pattern nameRegEx = Pattern.compile("<(.*)>");

        for (String entry : entries) {
            Person p = new Person();

            Matcher phoneMatcher = phoneNumberRegEx.matcher(entry);

            if (phoneMatcher.find()) {
                p.phoneNumber = phoneMatcher.group(1);
                entry = entry.replaceAll("[^\\s]*" + p.phoneNumber + "[^\\s]*", "");
            }

            Matcher nameMatcher = nameRegEx.matcher(entry);

            if (nameMatcher.find()) {
                p.name = nameMatcher.group(1);
                entry = entry.replaceAll("<" + p.name + ">", "");
            }

            entry = entry.replaceAll("[^0-9a-zA-Z\\-\\.]", " ");
            entry = entry.replaceAll("\\s+", " ");
            p.address = entry.trim();

            if (!phoneBook.containsKey(p.phoneNumber)) {
                phoneBook.put(p.phoneNumber, new ArrayList<>());
            }

            phoneBook.get(p.phoneNumber).add(p);
        }
    }
}