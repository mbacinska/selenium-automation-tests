package com.selenium.automated.tests;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Task2 {

  List<Map<String, String>> dataForParse = List.of(
    Map.of(
      "id", "1",
      "name", "Janusz",
      "age", "12"
    ),
    Map.of(
      "id", "1",
      "name", "Karl",
      "age", "22"
    ),
    Map.of(
      "id", "2",
      "name", "Vanya",
      "age", "13"
    )
  );

  class Client {
    int id;
    String name;
    int age;

    public Client(int id, String name, int age) {
      this.id = id;
      this.name = name;
      this.age = age;
    }

    public int getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    public int getAge() {
      return age;
    }

    @Override
    public String toString() {
      return "Client{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        '}';
    }
  }

  List<Client> parse(List<Map<String, String>> data) {
    // implement
    ArrayList<Client> list = new ArrayList<>();

    for (Map<String, String> elem : data) {
      list.add(new Client(Integer.parseInt(elem.get("id")),elem.get("name"), Integer.parseInt(elem.get("age"))));
    }
    return list;
  }

  @Test
  public void testName() {

    List<Client> parse = parse(dataForParse);
    System.out.println(parse);
  }
}
