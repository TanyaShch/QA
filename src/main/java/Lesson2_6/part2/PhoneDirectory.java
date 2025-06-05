package Lesson2_6.part2;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class PhoneDirectory {

    private Map<String, List<String>> directory = new HashMap<>();

    public void add(String name, String phoneNumber) {
        directory.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String name) {
        return directory.getOrDefault(name, new ArrayList<>());
    }
}