/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6.classes;

import helper.ScannerCus;
import helper.Validator;
import java.util.ArrayList;

/**
 *
 * @author Kaine
 */
public class EntityManagment extends ArrayList<Entity> {

	public EntityManagment() {
		super();
	}

	public static Entity createEntity() {
		ScannerCus sc = new ScannerCus();

		String name = sc.getString(Validator.StringType.STRING, 0, 256, "Enter name: ");
		String id = sc.getString(Validator.StringType.STRING, 0, 256, "Enter id: ");
		int point = sc.getInt(0, 10, "Invalid value", "Enter point: ");

		return new Entity(name, id, point);
	}

	public void addEntity(Entity e) {
		if (!this.contains(e)) {
			this.add(e);
		} else {
			System.out.println("This entity is existed");
		}
	}

	public Entity findEntity(String id) {
		for (Entity e : this) {
			if (e.getId() == null ? id == null : e.getId().equals(id)) {
				return e;
			}
		}
		return null;
	}

	public void updateEntity(String id) {
		ScannerCus sc = new ScannerCus();
		id = sc.getString(Validator.StringType.STRING, 0, 256, "Enter id to update: ");
		Entity e = this.findEntity(id);
		if (e == null) {
			System.out.println("Entity not found");
			return;
		}
		int index = this.indexOf(e);

		e.setName(sc.getString(Validator.StringType.STRING, 0, 256, "Enter name to update: "));
		e.setPoint(sc.getInt(0, 10, "Invalid value", "Enter point to update: "));
		this.set(index, e);
		System.out.println("Update Successful");
	}

	public void deleteEntity(String id) {
		ScannerCus sc = new ScannerCus();
		id = sc.getString(Validator.StringType.STRING, 0, 256, "Enter id to delete: ");
		Entity e = this.findEntity(id);
		if (e == null) {
			System.out.println("Entity not found");
			return;
		}
		this.remove(e);
		System.out.println("Delete Successful");
	}

	public void sortEntity() {
		int n = this.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (this.get(j).getPoint() > this.get(j + 1).getPoint()) {
					Entity temp = this.get(j);
					this.set(j, this.get(j + 1));
					this.set(j + 1, temp);
				}
			}
		}
	}

	public void sortEntityById() {
		int n = this.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (this.get(j).getId().compareTo(this.get(j + 1).getId()) > 0) {
					Entity temp = this.get(j);
					this.set(j, this.get(j + 1));
					this.set(j + 1, temp);
				}
			}
		}
	}

	public void printEntity() {
		if (!this.isEmpty()) {
			forEach(item -> System.out.println(item.toString()));
		} else {
			System.out.println("There is no entity in list");
		}
	}

}
