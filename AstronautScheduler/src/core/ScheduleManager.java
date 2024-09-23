package core;

import config.LoggerConfig;
import observers.Observer;
import java.util.*;
import java.util.logging.Logger;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private List<Observer> observers;
    private static final Logger LOGGER;

    static {
        LOGGER = LoggerConfig.setupLogger("astronaut_schedule.log");
    }

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void addTask(Task task) throws IllegalArgumentException {
        for (Task existingTask : tasks) {
            if (isConflict(existingTask, task)) {
                String conflictMessage = "New task conflicts with existing task: " + existingTask;
                notifyObservers(conflictMessage);
                throw new IllegalArgumentException(conflictMessage);
            }
        }
        tasks.add(task);
        tasks.sort(Comparator.comparing(Task::getStartTime));
        LOGGER.info("Task added: " + task);
    }

    private boolean isConflict(Task task1, Task task2) {
        return (task1.getStartTime().isBefore(task2.getEndTime()) && task2.getStartTime().isBefore(task1.getEndTime()));
    }

    public void removeTask(String description) throws IllegalArgumentException {
        tasks.removeIf(task -> task.getDescription().equals(description));
        LOGGER.info("Task removed: " + description);
    }

    public void viewTasks() {
        tasks.forEach(System.out::println);
    }

    public void editTask(String oldDescription, Task newTask) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDescription().equals(oldDescription)) {
                tasks.set(i, newTask);
                tasks.sort(Comparator.comparing(Task::getStartTime));
                LOGGER.info("Task edited: " + oldDescription + " -> " + newTask);
                return;
            }
        }
        throw new IllegalArgumentException("Task not found: " + oldDescription);
    }

    public void markTaskCompleted(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                task.setCompleted(true);
                LOGGER.info("Task marked as completed: " + description);
                return;
            }
        }
    }

    public void viewTasksByPriority(String priority) {
        tasks.stream()
                .filter(task -> task.getPriority().equalsIgnoreCase(priority))
                .forEach(System.out::println);
    }
}