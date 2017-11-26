package com.mt.app.inventory;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.mt.app.inventory.InvItem;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@DynamoDBTable(tableName = "Inventory")
public class InvItem {
	  private String name;
	  private String description;
	  private String code;
	  
	  @DynamoDBAttribute(attributeName = "Name")
	  @NotNull(message = "Name must not be empty")
	  public String getName() {

	    return name;
	  }

	  public void setName(String name) {

	    this.name = name;
	  }

	  public InvItem withName(String name) {

	    setName(name);
	    return this;
	  }

	  @DynamoDBAttribute(attributeName = "Description")
	  @NotNull(message = "Description must not be empty")
	  public String getDescription() {

	    return description;
	  }

	  public void setDescription(String description) {

	    this.description = description;
	  }

	  public InvItem withDescription(String description) {

	    setDescription(description);
	    return this;
	  }

	  @DynamoDBHashKey(attributeName = "Code")
	  @NotNull(message = "Code must not be empty")
	  public String getCode() {

	    return code;
	  }

	  public void setCode(String code) {

	    this.code = code;
	  }

	  public InvItem withCode(String code) {

	    setCode(code);
	    return this;
	  }

	  @Override
	  public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    InvItem invItem = (InvItem) o;
	    return Objects.equals(getName(), invItem.getName()) &&
	        Objects.equals(getDescription(), invItem.getDescription()) &&
	        Objects.equals(getCode(), invItem.getCode());
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(getName(), getDescription(), getCode());
	  }

}
