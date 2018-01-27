package com.example.Springhotel;

import com.vaadin.ui.Button;

public class Person {

  private String name;
  private String last_name;
  private int id;


  public Person(PersonBuilder builder) {
    this.name = builder.name;
    this.last_name = builder.last_name;
    this.id = builder.id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return String.format("name: %s last_name: %s id: %s "
            , this.name, this.last_name, this.id);
  }

  public String delete() {
    return "Delete";
  }

  public final static class PersonBuilder {

    private String name;
    private String last_name;
    private int id;

//    private PersonBuilder() {
//    }

//    public PersonBuilder(String name, String last_name, int id) {
//      this.name = name;
//      this.last_name = last_name;
//      this.id = id;
//
//    }

//    public PersonBuilder aPerson() {
//      return new PersonBuilder();
//    }

    public PersonBuilder BuilderName(String name) {
      this.name = name;
      return this;
    }

    public PersonBuilder BuilderLast_name(String last_name) {
      this.last_name = last_name;
      return this;
    }

    public PersonBuilder BuilderId(int id) {
      this.id = id;
      return this;
    }

    public Person build() {
      return new Person(this);
    }
  }

}
