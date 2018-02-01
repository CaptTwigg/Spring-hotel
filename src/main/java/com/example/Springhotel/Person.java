package com.example.Springhotel;

public class Person {

  private String name;
  private String last_name;
  private int id;
  private String startDate;
  private String endDate;

  public Person() {
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

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return String.format("name: %s last_name: %s id: %s startDate: %s endDate: %s "
      , this.name, this.last_name, this.id, this.startDate, this.endDate);
  }


  public static final class Builder {

    private String name;
    private String last_name;
    private int id;
    private String startDate;
    private String endDate;

    public Builder() {
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder last_name(String last_name) {
      this.last_name = last_name;
      return this;
    }

    public Builder id(int id) {
      this.id = id;
      return this;
    }

    public Builder startDate(String startDate) {
      this.startDate = startDate;
      return this;
    }

    public Builder endDate(String endDate) {
      this.endDate = endDate;
      return this;
    }

    public Person build() {
      Person person = new Person();
      person.setName(name);
      person.setLast_name(last_name);
      person.setId(id);
      person.setStartDate(startDate);
      person.setEndDate(endDate);
      return person;
    }
  }
}
