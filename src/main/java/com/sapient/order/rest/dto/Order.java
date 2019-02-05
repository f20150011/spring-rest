package com.sapient.order.rest.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name="Orders")
public class Order {
	@Id
	private int id;
	private String item;
	private float price;
	private int quantity;
}
