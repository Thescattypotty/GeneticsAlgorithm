# Genetic Algorithm for Course Scheduling

This project is a Java implementation of a Genetic Algorithm for solving the course scheduling problem. The goal is to generate an optimal schedule for courses, assigning them to appropriate classrooms and timeslots while considering various constraints such as room capacity, professor availability, and course conflicts.

## Problem Description

The course scheduling problem involves assigning courses to classrooms and timeslots while satisfying the following constraints:

1. **Room Capacity**: The number of students enrolled in a course should not exceed the capacity of the assigned classroom.
2. **Professor Availability**: A professor can teach only one course at a time.
3. **Course Conflicts**: Students should not be scheduled for multiple courses at the same timeslot.

## Genetic Algorithm Approach

The Genetic Algorithm is a metaheuristic optimization technique inspired by the process of natural selection. It operates on a population of candidate solutions (individuals), iteratively applying genetic operators such as selection, crossover, and mutation to evolve better solutions over successive generations.

The key components of the Genetic Algorithm implementation in this project are:

1. **Individual**: Represents a single candidate solution, which is a complete schedule for all courses.
2. **Population**: A collection of individuals.
3. **Fitness Function**: Evaluates the quality of an individual by assigning a fitness score based on the number of constraints satisfied.
4. **Selection**: Selects individuals from the current population for reproduction based on their fitness scores.
5. **Crossover**: Combines the genetic information of two selected individuals to produce new offspring.
6. **Mutation**: Randomly modifies the genetic information of an individual to introduce diversity.

## Project Structure

The project consists of the following Java classes:

- `GeneticAlgorithm.java`: Implements the Genetic Algorithm logic.
- `Population.java`: Manages the population of individuals.
- `Individual.java`: Represents an individual solution (course schedule).
- `Course.java`: Represents a course with its details.
- `Professor.java`: Represents a professor with their availability.
- `Classroom.java`: Represents a classroom with its capacity.
- `Timeslot.java`: Represents a timeslot for scheduling courses.
- `Schedule.java`: Utility class for generating and evaluating schedules.
- `Studentgroup.java`: Represents a group of students enrolled in a course.
- `Main.java`: Entry point of the application.

## Usage

1. Set up the input data (courses, professors, classrooms, and student groups) in the respective classes or read from external sources.
2. Configure the parameters of the Genetic Algorithm, such as population size, number of generations, and mutation rate.
3. Run the `Main` class to execute the Genetic Algorithm.
4. The best schedule found will be printed to the console and/or written to a file (`output.txt`).

## Future Improvements

- Implement additional constraints (e.g., preferred timeslots for professors, course prerequisites).
- Enhance the fitness function to prioritize certain criteria (e.g., minimize classroom changes for students).
- Explore other optimization techniques (e.g., hill climbing, simulated annealing) and compare their performance.
- Develop a graphical user interface (GUI) for better visualization and user interaction.

## Contributing

Contributions to this project are welcome. If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.