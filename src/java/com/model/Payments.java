/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author adylh
 */
public class Payments {
        protected int id;
	protected String name;
        protected String invoice;
	protected int amount;
        
        public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

	public Payments(int id, String name, String invoice, int amount) {
		super();
		this.id = id;
		this.name = name;
                this.invoice = invoice;
		this.amount = amount;
	}
	public Payments() {
		super();
	}
}
