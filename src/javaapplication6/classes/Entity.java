/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6.classes;

/**
 *
 * @author Kaine
 */
public class Entity {

	private String name;
	private String id;
	private int point;

	public Entity() {
	}

	public Entity(String name, String id, int point) {
		this.name = name;
		this.id = id;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return this.name + ", " + this.id + ", " + this.point;
	}

}
