package com.selenium.automated.tests;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Task {

  List<Map<String, Object>> dataForParse = List.of(
    Map.of(
      "id", 1,
      "name", "Janusz",
      "age", 12
    ),
    Map.of(
      "id", 1,
      "name", "Karl",
      "age", 22
    ),
    Map.of(
      "id", 2,
      "name", "Vanya",
      "age", 13
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

  List<Client> parse(List<Map<String, Object>> data) {
    // implement
    ArrayList<Client> list = new ArrayList<>();

    for (Map<String, Object> elem : data) {
      list.add(new Client((int) elem.get("id"), (String) elem.get("name"), (int) elem.get("age")));
    }
    return list;
  }

  @Test
  public void testName() {

    List<Client> parse = parse(dataForParse);
    System.out.println(parse);
  }
}
