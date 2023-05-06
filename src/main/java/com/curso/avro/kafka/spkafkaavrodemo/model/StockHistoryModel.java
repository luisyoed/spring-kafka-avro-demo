package com.curso.avro.kafka.spkafkaavrodemo.model;

public class StockHistoryModel {

	private int registrationNumber;
	private String city;
	private String name;
	private String lastName;
	private float tuitionCost;
	private float monthlyPayment;

	public int getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public float getTuitionCost() {
		return tuitionCost;
	}

	public void setTuitionCost(float tuitionCost) {
		this.tuitionCost = tuitionCost;
	}

	public float getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(float monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

}
