# Java-Project
Used IntelliJ

This is a project that simulates processor execution for tasks according to their priority. The program reads an input text file which describes the tasks' characteristics such as creation time and execution time. For example, a task described as 131 means that the creation time was on the 1 second, the time to execute it is 3 seconds and the priority of this task is considered high because it ends with the digit 1. Tasks ending with digit 0 are low priority which means they will get executed later. 

An example of a tasks text file would be 140, 151, 131, 341, 410, 530. The program reads the file, sorts the tasks in high and low priority like, high priority = [151, 131, 341] and low priority as = [140, 410, 530]. If we have 2 processors then from [151, 131, 341] the tasks 151 and 131 will get executed first since their first digit starts with 1. So, we would have processor 1 = 151 and processor 2 = 131. Processor 2 finishes executing faster than processor 1 since the execution time is 3 seconds whereas for processor 1 the task has execution time of 5 seconds. Hence, processor 2 will proceed with task 341. 

This program consists of a Main class, 5 other classes; Simulator, Task, Processor, Clock, Schedular, and an Interface named Schedule.

The Simulator class allows user input. The Task class reads the text file. The Schedular breaks tasks into different categories. The Clock class gets the execution time of tasks and delays until a processor is available again. The Processor class assigns the tasks into the processors. The Main contains all the important functions of all the other classes, and the Schedule Interface is to be implemented by the Schedular class.
