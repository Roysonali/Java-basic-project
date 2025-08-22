package org;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListManager {
	private static ArrayList<String> tasks = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean exit = false;
		
		while(!exit) {
			System.out.println("\n ===To-Do List Manager ===");
			System.out.println("1. Add task");
			System.out.println("2. View task");
			System.out.println("3. Remove task");
			System.out.println("4. Exit");
			System.out.println("Choose an option");
			
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				addTask();
				break;
			case 2:
				viewTask();
				break;
			case 3:
				removeTask();
				break;
			case 4:
				exit=true;
				System.out.println("Exited....");
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
		sc.close();
	}
	
	private static void addTask() {
		System.out.println("Enter task:");
		String task = sc.nextLine();
		tasks.add(task);
		System.out.println("Task added successfully.");
		
	}
	
	private static void viewTask() {
		for(int i=0; i<tasks.size();i++) {
			System.out.println((i+1) + "." + tasks.get(i));
		}
		
	}
	
	private static void removeTask() {
		System.out.println("Enter tasknumber to remove task");
		int taskNumber = sc.nextInt();
		sc.nextLine();
		if(taskNumber > 0 && taskNumber <= tasks.size()) {
			String removeTask = tasks.remove(taskNumber-1);
			System.out.println("task" + removeTask + " removed.");
		}else {
			System.out.println("Invalid task");
		}
	}
}
