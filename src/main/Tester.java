/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import helper.MenuHelper;
import helper.ScannerCus;
import helper.Validator;
import javaapplication6.classes.Entity;
import javaapplication6.classes.EntityManagment;

/**
 *
 * @author Kaine
 */
public class Tester {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here

		ScannerCus sc = new ScannerCus();

		EntityManagment list = new EntityManagment();
		Entity e = null;
		String id = "";

		MenuHelper menu = new MenuHelper(6);
		int choice = 0;

		menu.add("Add new entity");
		menu.add("Print all Entitiy");
		menu.add("Find Entity by Id");
		menu.add("Update Entity by Id");
		menu.add("Delete Entity by Id");
		menu.add("Sort Entity by Point");
		menu.add("Exit program");

		do {
			System.out.println("====================Menu====================");
			choice = menu.getChoice();
			System.out.println("============================================");
			switch (choice) {
				case 1:
					e = EntityManagment.createEntity();
					list.addEntity(e);
					break;
				case 2:

					list.printEntity();
					break;
				case 3:
					id = sc.getString(Validator.StringType.STRING, 0, 256, "Enter id to find: ");
					e = list.findEntity(id);
					if (e != null) {
						System.out.println(e.toString());
					} else {
						System.out.println("Entity not found");
					}
					break;
				case 4:
					list.updateEntity(id);
					break;
				case 5:
					list.deleteEntity(id);
					break;
				case 6:
					list.sortEntity();
					break;
				case 7:
					list.sortEntityById();
				default:
					break;
			}
		} while (choice != 8);
		System.out.println("With X is a number");
		System.out.println("S127 : SXXX = " + Validator.regexCheck("S127", "^S*[0-9]{3}"));
		System.out.println("S12E : SXXX = " + Validator.regexCheck("S12E", "^S*[0-9]{3}"));
	}

}
