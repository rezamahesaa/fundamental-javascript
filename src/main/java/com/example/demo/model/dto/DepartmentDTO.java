package com.example.demo.model.dto;

public class DepartmentDTO {
  private String name;

  private Integer id;

  private Integer regionId;

    public DepartmentDTO(Integer id, String name, Integer regionId) {
    this.id = id;
    this.name = name;
    this.regionId = regionId;
  }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public Integer getRegionId() {
      return regionId;
    }

    public void setRegionId(Integer regionId) {
      this.regionId = regionId;
    }

  

  
  
  
  
}
