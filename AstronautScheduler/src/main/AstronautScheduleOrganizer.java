package main;

import java.util.Scanner;
import java.io.File;
import observers.TaskConflictObserver;
import core.ScheduleManager;
import core.Task;
import core.TaskFactory;

public class AstronautScheduleOrganizer {
    private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        TaskConflictObserver conflictObserver = new TaskConflictObserver();
        scheduleManager.addObserver(conflictObserver);

        while (true) {
            System.out.println("\nAstronaut Daily Schedule Organizer");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. Edit Task");
            System.out.println("5. Mark Task as Completed");
            System.out.println("6. View Tasks by Priority");
            System.out.println("7. Exit");

            System.out.print("Enter your choice (1-7): ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        addTask(scheduleManager);
                        break;
                    case "2":
                        removeTask(scheduleManager);
                        break;
                    case "3":
                        scheduleManager.viewTasks();
                        break;
                    case "4":
                        editTask(scheduleManager);
                        break;
                    case "5":
                        markTaskCompleted(scheduleManager);
                        break;
                    case "6":
                        viewTasksByPriority(scheduleManager);
                        break;
                    case "7":
                        System.out.println("Exiting program. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addTask(ScheduleManager scheduleManager) {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter start time (HH:mm): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter end time (HH:mm): ");
        String endTime = scanner.nextLine();
        System.out.print("Enter priority (Low/Medium/High): ");
        String priority = scanner.nextLine();

        Task task = TaskFactory.createTask(description, startTime, endTime, priority);
        scheduleManager.addTask(task);
    }

    private static void removeTask(ScheduleManager scheduleManager) {
        System.out.print("Enter task description to remove: ");
        String description = scanner.nextLine();
        scheduleManager.removeTask(description);
    }

    private static void editTask(ScheduleManager scheduleManager) {
        System.out.print("Enter task description to edit: ");
        String oldDescription = scanner.nextLine();
        System.out.print("Enter new task description: ");
        String newDescription = scanner.nextLine();
        System.out.print("Enter new start time (HH:mm): ");
        String newStartTime = scanner.nextLine();
        System.out.print("Enter new end time (HH:mm): ");
        String newEndTime = scanner.nextLine();
        System.out.print("Enter new priority (Low/Medium/High): ");
        String newPriority = scanner.nextLine();

        Task newTask = TaskFactory.createTask(newDescription, newStartTime, newEndTime, newPriority);
        scheduleManager.editTask(oldDescription, newTask);
    }

    private static void markTaskCompleted(ScheduleManager scheduleManager) {
        System.out.print("Enter task description to mark as completed: ");
        String description = scanner.nextLine();
        scheduleManager.markTaskCompleted(description);
    }

    private static void viewTasksByPriority(ScheduleManager scheduleManager) {
        System.out.print("Enter priority to filter by (Low/Medium/High): ");
        String priority = scanner.nextLine();
        scheduleManager.viewTasksByPriority(priority);
    }
}
