

import java.util.ArrayList;

public class TaskList {
    public ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public void listTasks() {
        int counter = 1;
        for (Task task : tasks) {
            System.out.println(counter + ". " + task.toString());
            counter += 1;
        }
    }

    public Task get(int index) {
        return this.tasks.get(index);
    }
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public int size() {
        return this.tasks.size();
    }
    public void deleteTask(int index) {
        this.tasks.remove(index);
    }

    public void markTaskAsCompleted(int index) {
        this.tasks.get(index).mark_as_completed();
    }

    public void markTaskAsIncomplete(int index) {
        this.tasks.get(index).mark_as_incomplete();
    }
    // Other methods for updating tasks
}

