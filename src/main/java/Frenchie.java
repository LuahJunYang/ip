import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frenchie {
    public List<Task> tasks;

    //constructor
    public Frenchie() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task NEW_TASK) {
        tasks.add(NEW_TASK);
    }

    public void listTasks() {
        int counter = 1;
        for (Task task : tasks) {
            System.out.println(counter + ". " + task.toString());
            counter += 1;
        }
    }

    public void completeTask(int index) {
        tasks.get(index).mark_as_completed();
    }

    public void uncompleteTask(int index) {
        tasks.get(index).mark_as_incomplete();
    }

    public int getNumOfTasks() {
        return this.tasks.size();
    }

    public static void main(String[] args) {
        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo); */
        Frenchie frenchie = new Frenchie();
        String skeleton = "____________________________________________________________\n" +
                " Hello! I'm Frenchie\n" +
                " What can I do for you?\n" +
                "____________________________________________________________"
                /* " Bye. Hope to see you again soon!\n" +
                "____________________________________________________________\n" */;
        System.out.println(skeleton);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("bye")) {
                System.out.println("____________________________________________________________\n" +
                        " Bye. Hope to see you again soon!\n" +
                        "____________________________________________________________");
                break;

            } else if (input.equals("list")) { //Checking if user is looking to list all tasks
                frenchie.listTasks();
            } else if (input.contains("mark")) { //Checking if user input is to mark/unmark tasks
                String[] parts = input.split(" ");
                int index = Integer.parseInt(parts[1]) - 1;
                Task target_task = frenchie.tasks.get(index);
                //Checking if user is looking to mark task as done or incomplete
                if (parts[0].equals("mark")) {
                    frenchie.completeTask(index);
                    System.out.println("____________________________________________________________\n" +
                            " Nice! I've marked this task as done: \n" +
                            target_task.toString() + "\n" +
                            "____________________________________________________________");
                } else {
                    frenchie.uncompleteTask(index);
                    System.out.println("____________________________________________________________\n" +
                            " OK, I've marked this task as not done yet: \n" +
                            target_task.toString() + "\n" +
                            "____________________________________________________________");
                }
            } else {
                if (input.contains("event") || input.contains("todo") || input.contains("deadline")) {
                    String[] parts = input.split(" ");
                    String taskType = parts[0];
                    if (taskType.equals("todo")) {
                        String taskName = input.split("todo")[1];
                        ToDo currentTask = new ToDo(taskName);
                        frenchie.addTask(currentTask);
                        System.out.println("____________________________________________________________\n" +
                                " Got it! I've added this task: \n" +
                                currentTask + "\n" +
                                "Now you have " + frenchie.getNumOfTasks() + " tasks in the list.");
                    } else if (taskType.equals("deadline")) {
                        String taskName = input.split("/")[0].split("deadline")[1].trim();
                        String deadline = input.split("/")[1].replace("by ", "by: ");
                        Deadline currentTask = new Deadline(taskName, deadline);
                        frenchie.addTask(currentTask);
                        System.out.println("____________________________________________________________\n" +
                                " Got it! I've added this task: \n" +
                                currentTask + "\n" +
                                "Now you have " + frenchie.getNumOfTasks() + " tasks in the list.");
                    } else {
                        String taskName = input.split("/")[0].split("event")[1].trim();
                        String startTime = input.split("/")[1].replace("from ", "from: ");
                        String endTime = input.split("/")[2].replace("to ", "to: ");
                        Event currentTask = new Event(taskName, startTime, endTime);
                        frenchie.addTask(currentTask);
                        System.out.println("____________________________________________________________\n" +
                                " Got it! I've added this task: \n" +
                                currentTask + "\n" +
                                "Now you have " + frenchie.getNumOfTasks() + " tasks in the list.");
                    }
                } else {
                    ToDo currentTask = new ToDo(input);
                    frenchie.addTask(currentTask);
                    System.out.println("____________________________________________________________\n" +
                            " Got it! I've added this task: \n" +
                            currentTask + "\n" +
                            "Now you have " + frenchie.getNumOfTasks() + " tasks in the list.");
                }
            }
        }
    }
}
