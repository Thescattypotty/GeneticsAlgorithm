import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

        public static Schedule initializeSchedule() {
                Schedule schedule = new Schedule();

                // rooms
                schedule.addRoom(1, "R10", 40, "SC");
                schedule.addRoom(2, "R11", 40, "SC");
                schedule.addRoom(3, "R12", 40, "SC");
                schedule.addRoom(4, "R13", 40, "SC");
                schedule.addRoom(5, "R14", 40, "SC");
                schedule.addRoom(6, "R15", 40, "SC");
                schedule.addRoom(7, "R16", 40, "SC");
                schedule.addRoom(8, "T10", 40, "CC");
                schedule.addRoom(9, "T11", 40, "CC");
                schedule.addRoom(10, "T12", 40, "CC");
                schedule.addRoom(11, "T13", 40, "CC");

                schedule.addRoom(12, "R17", 40, "SC");
                schedule.addRoom(13, "R18", 40, "SC");
                schedule.addRoom(14, "R19", 40, "SC");
                schedule.addRoom(15, "R20", 40, "SC");
                schedule.addRoom(16, "R21", 40, "SC");
                schedule.addRoom(17, "R22", 40, "SC");
                schedule.addRoom(18, "R23", 40, "SC");
                schedule.addRoom(19, "T14", 40, "CC");
                schedule.addRoom(20, "T15", 40, "CC");
                schedule.addRoom(21, "T16", 40, "CC");
                schedule.addRoom(22, "T17", 40, "CC");

                schedule.addRoom(23, "R24", 40, "SC");
                schedule.addRoom(24, "R25", 40, "SC");
                schedule.addRoom(25, "R26", 40, "SC");
                schedule.addRoom(26, "R27", 40, "SC");
                schedule.addRoom(27, "R28", 40, "SC");
                schedule.addRoom(28, "R29", 40, "SC");
                schedule.addRoom(29, "R30", 40, "SC");
                schedule.addRoom(30, "T18", 40, "CC");
                schedule.addRoom(31, "T19", 40, "CC");
                schedule.addRoom(32, "T20", 40, "CC");
                schedule.addRoom(33, "T21", 40, "CC");

                // timeslot
                schedule.addTimeslot(1, "9:00 - 10:30", DayOfWeek.MONDAY);
                schedule.addTimeslot(2, "10:45 - 12:30", DayOfWeek.MONDAY);
                schedule.addTimeslot(4, "14:00 - 16:00", DayOfWeek.MONDAY);
                schedule.addTimeslot(5, "16:15 - 18:00", DayOfWeek.MONDAY);

                // --> 3 && 4 -> 5

                schedule.addTimeslot(7, "9:00 - 10:30", DayOfWeek.TUESDAY);
                schedule.addTimeslot(8, "10:45 - 12:30", DayOfWeek.TUESDAY);
                schedule.addTimeslot(10, "14:00 - 16:00", DayOfWeek.TUESDAY);
                schedule.addTimeslot(11, "16:15 - 18:00", DayOfWeek.TUESDAY);

                schedule.addTimeslot(13, "9:00 - 10:30", DayOfWeek.WEDNESDAY);
                schedule.addTimeslot(14, "10:45 - 12:30", DayOfWeek.WEDNESDAY);
                schedule.addTimeslot(16, "14:00 - 16:00", DayOfWeek.WEDNESDAY);
                schedule.addTimeslot(17, "16:15 - 18:00", DayOfWeek.WEDNESDAY);

                schedule.addTimeslot(19, "9:00 - 10:30", DayOfWeek.THURSDAY);
                schedule.addTimeslot(20, "10:45 - 12:30", DayOfWeek.THURSDAY);
                schedule.addTimeslot(22, "14:00 - 16:00", DayOfWeek.THURSDAY);
                schedule.addTimeslot(23, "16:15 - 18:00", DayOfWeek.THURSDAY);

                schedule.addTimeslot(25, "9:00 - 10:30", DayOfWeek.FRIDAY);
                schedule.addTimeslot(26, "10:45 - 12:30", DayOfWeek.FRIDAY);
                schedule.addTimeslot(28, "14:00 - 16:00", DayOfWeek.FRIDAY);
                schedule.addTimeslot(29, "16:15 - 18:00", DayOfWeek.FRIDAY);

                schedule.addTimeslot(31, "9:00 - 10:30", DayOfWeek.SATURDAY);
                schedule.addTimeslot(32, "10:45 - 12:30", DayOfWeek.SATURDAY);
                schedule.addTimeslot(34, "14:00 - 16:00", DayOfWeek.SATURDAY);
                schedule.addTimeslot(35, "16:15 - 18:00", DayOfWeek.SATURDAY);

                // professor
                schedule.addProfessor(1, "P.Hafsa Bajdani",
                                new int[] { 1, 2, 4, 7, 8, 10, 11, 14, 16, 19, 20, 22, 23, 25, 26 },
                                10);
                schedule.addProfessor(2, "P.John Smith",
                                new int[] { 1, 2, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20, 22 },
                                8);
                schedule.addProfessor(3, "P.Lisa Johnson",
                                new int[] { 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20 },
                                12);
                schedule.addProfessor(4, "P.Michael Brown",
                                new int[] { 1, 2,4,5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20, 22 },
                                11);
                schedule.addProfessor(5, "P.Alice Wilson",
                                new int[] { 1, 2, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20, 22 },
                                9);
                schedule.addProfessor(6, "P.David Martinez",
                                new int[] { 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20, 22, 23 },
                                10);
                schedule.addProfessor(7, "P.Sarah Thompson",
                                new int[] { 1, 2, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20 },
                                10);
                schedule.addProfessor(8, "P.Richard Garcia",
                                new int[] { 1, 2,4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20, 22 },
                                11);
                schedule.addProfessor(9, "P.Emily Martinez",
                                new int[] { 1, 2, 4, 5, 7, 8, 10, 11, 13, 14, 17, 19, 20, 22, 23 },
                                9);
                schedule.addProfessor(10, "P.Daniel Adams",
                                new int[] { 2, 1, 4, 5, 7, 8, 10, 11, 13, 14, 19, 20, 22, 23, 25, 26 },
                                12);
                schedule.addProfessor(11, "P.Jessica Thomas",
                                new int[] { 1, 2, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20, 22 }, 10);
                schedule.addProfessor(12, "P.Kevin Rodriguez",
                                new int[] { 1, 2, 4, 5, 7, 8, 10, 11, 14, 16, 17, 19, 20, 22, 23 }, 8);
                schedule.addProfessor(13, "P.Samantha Lee",
                                new int[] { 2, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20, 22, 23 },
                                12);
                schedule.addProfessor(14, "P.Nathan Harris",
                                new int[] { 1, 2, 4, 5, 7, 8, 10, 11, 13, 14, 16, 19, 20, 22, 23 },
                                11);
                schedule.addProfessor(15, "P.Amy Clark",
                                new int[] { 2, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20, 22 , 23 }, 9);
                schedule.addProfessor(16, "P.Nicole King",
                                new int[] { 2, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20 , 22 , 23 },
                                10);
                schedule.addProfessor(17, "P.Benjamin Wright",
                                new int[] { 1, 2, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20 , 28,29 }, 10);
                schedule.addProfessor(18, "P.Amanda Evans",
                                new int[] { 1, 3, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20, 22 },
                                11);
                schedule.addProfessor(19, "P.Justin Carter",
                                new int[] { 1, 2, 4, 5, 7, 9, 11, 13, 14, 16, 19, 20,22,23 },
                                9);
                schedule.addProfessor(20, "P.Kayla Lopez",
                                new int[] { 2, 1, 4, 5, 8, 7, 10, 11, 13, 14, 16, 17, 19, 20, 22 },
                                12);

                schedule.addProfessor(21, "P.Cameron Baker",
                                new int[] { 1, 2, 4, 5, 8, 7, 10, 11, 13, 14, 17, 19, 20, 22 },
                                10);
                schedule.addProfessor(22, "P.Megan Mitchell",
                                new int[] { 1, 2, 4, 5, 7, 8, 10, 11, 14, 16, 17, 19, 20, 22 }, 8);
                schedule.addProfessor(23, "P.Brandon Rivera",
                                new int[] { 2, 5, 4, 7, 10, 11, 13, 14, 16, 17, 19, 20, 25 , 26 }, 12);
                schedule.addProfessor(24, "P.Alexandra Scott",
                                new int[] { 1, 2, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20 }, 11);
                schedule.addProfessor(25, "P.Ethan Stewart",
                                new int[] { 1, 2, 5, 7, 8,  11,  13, 14, 17, 19, 20, 22 },
                                9);
                schedule.addProfessor(26, "P.Hannah Turner",
                                new int[] { 2, 4, 5,  7, 8, 10, 11, 13, 14, 16, 17, 19, 20 },
                                10);
                schedule.addProfessor(27, "P.Logan Price",
                                new int[] { 1, 2, 4, 5, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20 },
                                10);
                schedule.addProfessor(28, "P.Ava Ward",
                                new int[] { 1, 3, 7, 8, 10, 11, 13, 14, 16, 17, 19, 20 }, 11);
                schedule.addProfessor(29, "P.Dylan Morris",
                                new int[] { 25, 26, 28 , 29 , 31 , 32 , 32 , 35 , 19 , 20 , 22 , 23 },
                                9);
                schedule.addProfessor(30, "P.Sophie Bailey",
                                new int[] { 25, 26, 28, 29, 31, 32, 32, 35, 19, 20, 22,23},
                                12);

                // course
                schedule.addCourse(1, "AA", "Algorithm", new int[] { 1, 5, 8 }, "SC");
                schedule.addCourse(2, "BB", "Data Structures", new int[] { 6, 7, 8, 9, 10 }, "CC");
                schedule.addCourse(3, "CC", "Computer Networks", new int[] { 11, 12, 13, 14, 15 }, "SC");
                schedule.addCourse(4, "DD", "Software Engineering", new int[] { 16, 17, 18, 19, 20 }, "CC");
                schedule.addCourse(5, "EE", "Database Management", new int[] { 21, 22, 23, 24, 25 }, "SC");
                schedule.addCourse(6, "FF", "Artificial Intelligence", new int[] { 26, 27, 28, 29, 30 }, "CC");
                schedule.addCourse(7, "GG", "Machine Learning", new int[] { 1, 2, 3, 4, 5 }, "SC");
                schedule.addCourse(8, "HH", "Web Development", new int[] { 6, 7, 8, 9, 10 }, "CC");
                schedule.addCourse(9, "II", "Mobile App Development", new int[] { 11, 12, 13, 14, 15 }, "SC");
                schedule.addCourse(10, "JJ", "Computer Graphics", new int[] { 16, 17, 18, 19, 20 }, "CC");
                schedule.addCourse(11, "KK", "Cybersecurity", new int[] { 21, 22, 23, 24, 25 }, "SC");
                schedule.addCourse(12, "LL", "Data Science", new int[] { 26, 27, 28, 29, 30 }, "CC");
                schedule.addCourse(13, "MM", "Operating Systems", new int[] { 1, 2, 3, 4, 5 }, "SC");
                schedule.addCourse(14, "NN", "Computer Architecture", new int[] { 6, 7, 8, 9, 10 }, "CC");
                schedule.addCourse(15, "OO", "Parallel Computing", new int[] { 11, 12, 13, 14, 15 }, "SC");
                schedule.addCourse(16, "PP", "Robotics", new int[] { 16, 17, 18, 19, 20 }, "CC");
                schedule.addCourse(17, "QQ", "Natural Language Processing", new int[] { 21, 22, 23, 24, 25 }, "SC");
                schedule.addCourse(18, "RR", "Computer Vision", new int[] { 26, 27, 28, 29, 30 }, "CC");
                schedule.addCourse(19, "SS", "Bioinformatics", new int[] { 1, 2, 3, 4, 5 }, "SC");
                schedule.addCourse(20, "TT", "Game Development", new int[] { 6, 7, 8, 9, 10 }, "CC");


                schedule.addGroup(1, 35, new int[] { 1,1, 3, 6, 8, 9, 12 });
                schedule.addGroup(2, 35, new int[] { 1, 3, 5, 7, 9, 11, 13, 15 });
                schedule.addGroup(3, 35, new int[] { 2, 4, 6, 8, 10, 12, 14, 16 });
                schedule.addGroup(4, 35, new int[] { 3, 5, 7, 9, 11, 13, 15, 17 });
                schedule.addGroup(5, 35, new int[] { 4, 6, 8, 10, 12, 14, 16, 18 });
                schedule.addGroup(6, 35, new int[] { 5, 7, 9, 11, 13, 15, 17, 19 });
                schedule.addGroup(7, 35, new int[] { 6, 8, 10, 12, 14, 16, 18, 20 });
                schedule.addGroup(8, 35, new int[] { 7, 9, 11, 13, 15, 17, 19, 18 });
                schedule.addGroup(9, 35, new int[] { 8, 10, 12, 14, 16, 18, 20, 19 });
                schedule.addGroup(10, 35, new int[] { 9, 11, 13, 15, 17, 19, 20, 20 });
                schedule.addGroup(11, 35, new int[] { 10, 12, 14, 16, 18, 20 });
                schedule.addGroup(12, 35, new int[] { 11, 13, 15, 17, 19, 20 });
                schedule.addGroup(13, 35, new int[] { 12, 14, 16, 18, 1 });
                schedule.addGroup(14, 35, new int[] { 13, 15, 17, 19, 3 });
                schedule.addGroup(15, 35, new int[] { 14, 16, 18, 20, 8, 3, 4 });

                return schedule;

        }

        public static void PrintClassAll(Schedule schedule) {
                Class classes[] = schedule.getClasses();
                int classIndex = 1;
                for (Class bestClass : classes) {
                        System.out.println("CLASS " + classIndex + ":");
                        System.out.println("COURSE: " + schedule.getCourse(bestClass.getCourseId()).getCourseName()
                                        + "Require Room "
                                        + schedule.getCourse(bestClass.getCourseId()).getRoomTypeRequirement());
                        System.out.println("STUDENT GROUP: " + schedule.getGroup(bestClass.getGroupId()).getGroupId());
                        System.out.println("ROOM: " + schedule.getRoom(bestClass.getRoomId()).getRoomNumber()
                                        + " , Type : "
                                        + schedule.getRoom(bestClass.getRoomId()).getRoomType());
                        System.out.println("PROFESSOR: "
                                        + schedule.getProfessor(bestClass.getProfessorId()).getProfessorName());
                        System.out.println("TIMESLOT: " + schedule.getTimeslot(bestClass.getTimeslotId()).getTimeslot()
                                        + schedule.getTimeslot(bestClass.getTimeslotId()).getDayOfWeek().name());
                        System.out.println("*****************************************************************");
                        classIndex++;
                }
        }

        public static void PrintClassPerGroup(Schedule schedule) {
    HashMap<Integer, List<Class>> groupMap = schedule.getGroupMap();
    
    for (Map.Entry<Integer, List<Class>> entry : groupMap.entrySet()) {
        int groupId = entry.getKey();
        List<Class> classes = entry.getValue();
        
        System.out.println("Student Group: " + groupId);
        
        if (classes.isEmpty()) {
            System.out.println("No classes scheduled for this group.");
        } else {
            int classIndex = 1;
            for (Class classItem : classes) {
                System.out.println("CLASS " + classIndex + ":");
                System.out.println("COURSE: " + schedule.getCourse(classItem.getCourseId()).getCourseName()
                        + " Require Room " + schedule.getCourse(classItem.getCourseId()).getRoomTypeRequirement());
                System.out.println("ROOM: " + schedule.getRoom(classItem.getRoomId()).getRoomNumber() + " , Type : "
                        + schedule.getRoom(classItem.getRoomId()).getRoomType());
                System.out.println("PROFESSOR: " + schedule.getProfessor(classItem.getProfessorId()).getProfessorName());
                System.out.println("TIMESLOT: " + schedule.getTimeslot(classItem.getTimeslotId()).getTimeslot()
                                + schedule.getTimeslot(classItem.getTimeslotId()).getDayOfWeek().name());
                System.out.println("*****************************************************************");
                classIndex++;
            }
        }
        
        System.out.println(); // Add a blank line between groups
    }
}


        public static List<Class> getClasses(Schedule schedule, String type, int id) {
                switch (type) {
                        case "ROOM":
                                return schedule.getRoomMap().get(id);
                        case "PROF":
                                return schedule.getProfMap().get(id);
                        case "MODULE":
                                return schedule.getCourseMap().get(id);
                        case "GROUP":
                                return schedule.getGroupMap().get(id);
                        default:
                                return null;
                }
        }

        public static void PrintClasses(Schedule schedule, String type, int id) {
                List<Class> classes = getClasses(schedule, type, id);
                for (Class bestClass : classes) {
                        printClass(schedule, bestClass);
                }
        }

        public static void printClass(Schedule schedule, Class bestClass) {
                System.out.println("COURSE: " + schedule.getCourse(bestClass.getCourseId()).getCourseName()
                                + "Require Room "
                                + schedule.getCourse(bestClass.getCourseId()).getRoomTypeRequirement());
                System.out.println("STUDENT GROUP: " + schedule.getGroup(bestClass.getGroupId()).getGroupId());
                System.out.println(
                                "CLASSROOM: " + schedule.getRoom(bestClass.getRoomId()).getRoomNumber() + " , Type : "
                                                + schedule.getRoom(bestClass.getRoomId()).getRoomType());
                System.out.println(
                                "PROFESSOR: " + schedule.getProfessor(bestClass.getProfessorId()).getProfessorName());
                System.out.println("TIMESLOT: " + schedule.getTimeslot(bestClass.getTimeslotId()).getTimeslot()
                                + schedule.getTimeslot(bestClass.getTimeslotId()).getDayOfWeek().name());
                System.out.println("*********************************************************************");
        }

        public static void main(String[] args) {
                Schedule schedule = initializeSchedule();

                GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(50, 0.0009, 0.87, 2, 40);

                Population population = geneticAlgorithm.initializingPopulation(schedule);

                geneticAlgorithm.calcPopulation(population, schedule);

                int generation = 1;

                while (!geneticAlgorithm.isTerminating(generation, 2000)
                                && !geneticAlgorithm.isTerminating(population)) {
                        System.out.println("Generation No." + generation + " Best fitness: "
                                        + population.getFittest(0).getFitness());

                        population = geneticAlgorithm.crossoverPopulation(population);

                        population = geneticAlgorithm.mutatingPopulation(population, schedule);

                        geneticAlgorithm.calcPopulation(population, schedule);

                        generation++;

                }
                // Print fitness
                schedule.createClasses(population.getFittest(0));
                System.out.println();
                System.out.println("Solution found in " + generation + " generations");
                System.out.println("Final solution fitness: " + population.getFittest(0).getFitness());
                //System.out.println("Clashes: " + schedule.calcClashes(100));
                System.out.println("Clashes: " + schedule.calcClashes2(100));
                //PrintClasses(schedule, "GROUP", 1);
                //PrintClasses(schedule, "GROUP", 10);
                //PrintClassAll(schedule);
                //PrintClassPerGroup(schedule);
        }
}
