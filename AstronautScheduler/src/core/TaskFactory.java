package core;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TaskFactory {
    public static Task createTask(String description, String startTime, String endTime, String priority) throws IllegalArgumentException {
        try {
            LocalTime start = LocalTime.parse(startTime);
            LocalTime end = LocalTime.parse(endTime);
            if (start.isAfter(end) || start.equals(end)) {
                throw new IllegalArgumentException("End time must be after start time");
            }
            if (!priority.matches("(?i)Low|Medium|High")) {
                throw new IllegalArgumentException("Priority must be Low, Medium, or High");
            }
            return new Task(description, start, end, priority);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid time format. Use HH:mm");
        }
    }
}
