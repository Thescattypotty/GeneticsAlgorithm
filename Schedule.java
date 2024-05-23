import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Schedule {

    private final HashMap<Integer, Classroom> rooms;
    private final HashMap<Integer, Professor> professors;
    private final HashMap<Integer, Course> courses;
    private final HashMap<Integer, Studentgroup> groups;
    private final HashMap<Integer, Timeslot> timeslots;
    
    private final HashMap<Integer, List<Class>> roomMap;
    private final HashMap<Integer, List<Class>> profMap;
    private final HashMap<Integer, List<Class>> courseMap;
    private final HashMap<Integer, List<Class>> groupMap;
    private Class classes[];

    public HashMap<Integer, List<Class>> getRoomMap() {
        return roomMap;
    }

    public HashMap<Integer, List<Class>> getProfMap() {
        return profMap;
    }

    public HashMap<Integer, List<Class>> getCourseMap() {
        return courseMap;
    }

    public HashMap<Integer, List<Class>> getGroupMap() {
        return groupMap;
    }

    private int numClasses = 0;

    public Schedule() {
        this.rooms = new HashMap<Integer, Classroom>();
        this.professors = new HashMap<Integer, Professor>();
        this.courses = new HashMap<Integer, Course>();
        this.groups = new HashMap<Integer, Studentgroup>();
        this.timeslots = new HashMap<Integer, Timeslot>();

        this.roomMap = new HashMap<>();
        this.profMap = new HashMap<>();
        this.courseMap = new HashMap<>();
        this.groupMap = new HashMap<>();
    }

    public Schedule(Schedule cloneable) {
        this.rooms = cloneable.getRooms();
        this.professors = cloneable.getProfessors();
        this.courses = cloneable.getCourses();
        this.groups = cloneable.getGroups();
        this.timeslots = cloneable.getTimeslots();

        this.roomMap = new HashMap<>();
        this.profMap = new HashMap<>();
        this.courseMap = new HashMap<>();
        this.groupMap = new HashMap<>();
    }

    private HashMap<Integer, Studentgroup> getGroups() {
        return this.groups;
    }

    private HashMap<Integer, Timeslot> getTimeslots() {
        return this.timeslots;
    }

    private HashMap<Integer, Course> getCourses() {
        return this.courses;
    }

    private HashMap<Integer, Professor> getProfessors() {
        return this.professors;
    }

    public Classroom getRoom(int roomId) {
        if (!this.rooms.containsKey(roomId)) {
            System.out.println("Rooms doesn't contain key " + roomId);
        }
        return (Classroom) this.rooms.get(roomId);
    }

    public HashMap<Integer, Classroom> getRooms() {
        return this.rooms;
    }

    public Classroom getRandomRoom() {
        Object[] roomsArray = this.rooms.values().toArray();
        Classroom room = (Classroom) roomsArray[(int) (roomsArray.length * Math.random())];
        return room;
    }

    public Professor getProfessor(int professorId) {
        return (Professor) this.professors.get(professorId);
    }

    public Course getCourse(int courseId) {
        return (Course) this.courses.get(courseId);
    }

    public int[] getGroupCourses(int groupId) {
        Studentgroup group = (Studentgroup) this.groups.get(groupId);
        return group.getCourseIds();
    }

    public Studentgroup getGroup(int groupId) {
        return (Studentgroup) this.groups.get(groupId);
    }

    public Studentgroup[] getGroupsAsArray() {
        return (Studentgroup[]) this.groups.values().toArray(new Studentgroup[this.groups.size()]);
    }

    public Timeslot getTimeslot(int timeslotId) {
        return (Timeslot) this.timeslots.get(timeslotId);
    }

    public Timeslot getRandomTimeslot() {
        Object[] timeslotArray = this.timeslots.values().toArray();
        Timeslot timeslot = (Timeslot) timeslotArray[(int) (timeslotArray.length * Math.random())];
        return timeslot;

    }

    public Class[] getClasses() {
        return this.classes;
    }

    public int getNumClasses() {
        if (this.numClasses > 0) {
            return this.numClasses;
        }
        int numClasses = 0;
        Studentgroup groups[] = (Studentgroup[]) this.groups.values().toArray(new Studentgroup[this.groups.size()]);
        for (Studentgroup group : groups) {
            numClasses += group.getCourseIds().length;
        }
        this.numClasses = numClasses;

        return this.numClasses;
    }

    public void addRoom(int roomId, String roomName, int capacity, String roomType) {
        this.rooms.put(roomId, new Classroom(roomId, roomName, capacity, roomType));
    }

    public void addProfessor(int professorId, String profName, int availability[], int sceancePerWeek) {
        this.professors.put(professorId, new Professor(professorId, profName, availability, sceancePerWeek));
    }

    public void addCourse(int courseId, String courseCode, String course, int professorIds[],
            String roomTypeRequirement) {
        this.courses.put(courseId, new Course(courseId, courseCode, course, professorIds, roomTypeRequirement));
    }

    public void addCourse(int courseId, String courseCode, String course, int professorIds[]) {
        this.courses.put(courseId, new Course(courseId, courseCode, course, professorIds));
    }

    public void addGroup(int groupId, int groupSize, int courseIds[]) {
        this.groups.put(groupId, new Studentgroup(groupId, groupSize, courseIds));
        this.numClasses = 0;
    }

    public void addTimeslot(int timeslotId, String timeslot, DayOfWeek dayOfWeek) {
        this.timeslots.put(timeslotId, new Timeslot(timeslotId, timeslot, dayOfWeek));
    }

    public void createClasses(Individual individual) {
        Class classes[] = new Class[this.getNumClasses()];

        int chromosome[] = individual.getChromosome();
        int chromosomePos = 0;
        int classIndex = 0;

        for (Studentgroup group : this.getGroupsAsArray()) {
            int courseIds[] = group.getCourseIds();

            for (int courseId : courseIds) {

                Class newClass = new Class(classIndex, group.getGroupId(), courseId);

                newClass.setTimeslot(chromosome[chromosomePos]);
                chromosomePos++;

                newClass.setRoomId(chromosome[chromosomePos]);
                chromosomePos++;

                newClass.setProfessor(chromosome[chromosomePos]);
                chromosomePos++;

                this.roomMap.putIfAbsent(newClass.getRoomId(), new ArrayList<>());
                this.groupMap.putIfAbsent(newClass.getGroupId(), new ArrayList<>());
                this.courseMap.putIfAbsent(newClass.getCourseId(), new ArrayList<>());
                this.profMap.putIfAbsent(newClass.getProfessorId(), new ArrayList<>());

                this.roomMap.get(newClass.getRoomId()).add(newClass);
                this.groupMap.get(newClass.getGroupId()).add(newClass);
                this.courseMap.get(newClass.getCourseId()).add(newClass);
                this.profMap.get(newClass.getProfessorId()).add(newClass);

                classes[classIndex] = newClass;
                classIndex++;

            }

        }
        this.classes = classes;
    }

    public int countClassesForProfessor(int professorId, Class[] classes) {
        int count = 0;
        for (Class aClass : classes) {
            if (aClass != null && aClass.getProfessorId() == professorId) {
                count++;
            }
        }
        return count;
    }

    public int calcClashes(int size) {
        int clashes = 100;

        for (Class classA : this.classes) {
            int roomCapacity = this.getRoom(classA.getRoomId()).getCapacity();
            int groupSize = this.getGroup(classA.getGroupId()).getGroupSize();

            // room capacity !
            if (roomCapacity < groupSize) {
                clashes = clashes - 10 * size;
                // System.out.println("Room Capacity breaked");
            }
            String roomType = this.getRoom(classA.getRoomId()).getRoomType();
            String roomTypeRequirements = this.getCourse(classA.getCourseId()).getRoomTypeRequirement();
            // room requirements
            if (!roomType.equals(roomTypeRequirements)) {
                clashes = clashes - 10 * size;
                // System.out.println("Room Requirements breaked");
            }
            // sceance per week
            if (countClassesForProfessor(classA.getProfessorId(), classes) > getProfessor(classA.getProfessorId())
                    .getSceancePerWeek()) {
                clashes = clashes - 12 * size;
                // System.out.println("Prof Sceance per week breaked");
            }
            // room occupied
            for (Class classB : this.classes) {
                if (classA.getRoomId() == classB.getRoomId()
                        && classA.getTimeslotId() == classB.getTimeslotId()
                        && classA.getClassId() != classB.getClassId()) {
                    clashes = clashes - 19 * size;
                    // System.out.println("Room Availability breaked");
                    break;
                }
            }

            // professor available
            for (Class classB : this.classes) {
                if ((classA.getProfessorId() == classB.getProfessorId()
                        && classA.getTimeslotId() == classB.getTimeslotId()
                        && classA.getClassId() != classB.getClassId())) {
                    clashes = clashes - 19 * size;
                    // System.out.println("Prof teach at one time breaked");
                    break;
                }
            }
            // prof timeslot availability !
            for (Class classB : this.classes) {
                if (classA.getProfessorId() == classB.getProfessorId()
                        && classA.getTimeslotId() == classB.getTimeslotId()
                        && classA.getClassId() == classB.getClassId()
                        && contain(getProfessor(classA.getProfessorId()).getAvailability(),
                                classA.getTimeslotId())) {
                    clashes = clashes - 10 * size;
                    // System.out.println("Prof Availability breaked");
                    break;
                }
            }
            // successive lessons
            /* */
            for (Class classB : this.classes) {
                if (classA.getGroupId() == classB.getGroupId() &&
                        classA.getCourseId() == classB.getCourseId() &&
                        getCourse(classA.getCourseId()).getCourseName()
                                .equals(getCourse(classB.getCourseId()).getCourseName())
                        && !classA.equals(classB)
                        ) {
                    if (classA.getRoomId() != classB.getRoomId()) {
                        clashes = clashes - 5 * size;
                        // System.out.println("Same course but different room");
                    }
                    if (classA.getProfessorId() != classB.getProfessorId()) {
                        clashes = clashes - 5 * size;
                        // System.out.println("Same course but different professor");
                    }/*
                    if (getTimeslot(classA.getTimeslotId()).getDayOfWeek() != getTimeslot(classB.getTimeslotId())
                            .getDayOfWeek()) {
                        clashes = clashes - 4 * size;*//*
                        if(classA.getTimeslotId() != classB.getTimeslotId() + 1
                                    || classB.getTimeslotId() != classA.getTimeslotId() + 1)
                                    {
                                        clashes = clashes -4*size;
                                    }*/
                        // System.out.println("Same course but different Day");
                    //}
                    if (classA.getTimeslotId() != classB.getTimeslotId() + 1
                                    || classB.getTimeslotId() != classA.getTimeslotId() + 1){
                                        
                        clashes = clashes - 8 * size;
                        // System.out.println("Same course same day but different Crenaux");
                    }
                    break;
                }
            }
        }

        return clashes;
    }
    
    public int calcClashes2(int size) {
        int clashes = 100;

        for (Class classA : this.classes) {
            int roomCapacity = this.getRoom(classA.getRoomId()).getCapacity();
            int groupSize = this.getGroup(classA.getGroupId()).getGroupSize();

            // room capacity !
            if (roomCapacity < groupSize) {
                clashes = clashes - 10 * size;
                System.out.println("Room Capacity breaked");
            }
            String roomType = this.getRoom(classA.getRoomId()).getRoomType();
            String roomTypeRequirements = this.getCourse(classA.getCourseId()).getRoomTypeRequirement();
            // room requirements
            if (!roomType.equals(roomTypeRequirements)) {
                clashes = clashes - 10 * size;
                System.out.println("Room Requirements breaked");
            }
            // sceance per week
            if (countClassesForProfessor(classA.getProfessorId(), classes) > getProfessor(classA.getProfessorId())
                    .getSceancePerWeek()) {
                clashes = clashes - 12 * size;
                System.out.println("Prof Sceance per week breaked");
            }
            // room occupied
            for (Class classB : this.classes) {
                if (classA.getRoomId() == classB.getRoomId()
                        && classA.getTimeslotId() == classB.getTimeslotId()
                        && classA.getClassId() != classB.getClassId()) {
                    clashes = clashes - 19 * size;
                    System.out.println("Room Availability breaked");
                    break;
                }
            }

            // professor available
            for (Class classB : this.classes) {
                if ((classA.getProfessorId() == classB.getProfessorId()
                        && classA.getTimeslotId() == classB.getTimeslotId()
                        && classA.getClassId() != classB.getClassId())) {
                    clashes = clashes - 19 * size;
                    System.out.println("Prof teach at one time breaked");
                    break;
                }
            }
            // prof timeslot availability !
            for (Class classB : this.classes) {
                if (classA.getProfessorId() == classB.getProfessorId()
                        && classA.getTimeslotId() == classB.getTimeslotId()
                        && classA.getClassId() == classB.getClassId()
                        && contain(getProfessor(classA.getProfessorId()).getAvailability(),
                                classA.getTimeslotId())) {
                    clashes = clashes - 10 * size;
                    System.out.println("Prof Availability breaked");
                    break;
                }
            }
            // successive lessons
            /* */
            for (Class classB : this.classes) {
                if (classA.getGroupId() == classB.getGroupId() &&
                        classA.getCourseId() == classB.getCourseId() &&
                        getCourse(classA.getCourseId()).getCourseName()
                                .equals(getCourse(classB.getCourseId()).getCourseName())
                    && !classA.equals(classB)            
                    ) {
                                    System.out.println("Student classA : group --> " + getGroup(classA.getGroupId()).getGroupId());
                                    System.out.println("Student classB : group --> " + getGroup(classB.getGroupId()).getGroupId());
                    if (classA.getRoomId() != classB.getRoomId()) {
                        clashes = clashes - 5 * size;
                        System.out.println("Same course but different room :"+ classA.getRoomId() + " , " + classB.getRoomId());
                    }
                    if (classA.getProfessorId() != classB.getProfessorId()) {
                        clashes = clashes - 5 * size;
                        System.out.println("Same course but different professor");
                    }/* 
                    if (getTimeslot(classA.getTimeslotId()).getDayOfWeek() != getTimeslot(classB.getTimeslotId())
                            .getDayOfWeek()) {
                        clashes = clashes - 4 * size;
                        System.out.println("Same course" +"("+classA.getCourseId()+","+classB.getCourseId()+")" + "but different Day");
                    }*/
                    if (classA.getTimeslotId() != classB.getTimeslotId() + 1
                                    || classB.getTimeslotId() != classA.getTimeslotId() + 1) {
                        clashes = clashes - 8 * size;
                        System.out.println("Same course" + "(" + classA.getCourseId() + "," + classB.getCourseId() + ")"+"same day but different Crenaux");
                    }
                    break;
                }
            }
        }

        return clashes;
    }

    public boolean contain(int availability[], int timeslot) {
        for (int value : availability) {
            if (value == timeslot)
                return true;
        }
        return false;
    }

    public boolean isTimeslotsAvailable(int timeslotId) {
        return this.timeslots.containsKey(timeslotId);
    }

    public boolean isRoomAvailable(int roomId) {
        return this.rooms.containsKey(roomId);
    }

    public boolean isProfessorAvailable(int professorId, int timeslotId) {
        if (getProfessor(professorId) != null) {
            int[] availability = getProfessor(professorId).getAvailability();
            return availability != null && contain(availability, timeslotId);
        }
        return false;
    }

}

/*
 * for (int courseId : courseIds) {
 * Class newClass = new Class(classIndex, group.getGroupId(), courseId);
 * 
 * // Find the first available timeslot and room for the class
 * boolean scheduled = false;
 * for (int i = 0; i < chromosome.length; i += 3) {
 * int timeslotId = chromosome[i];
 * int roomId = chromosome[i + 1];
 * int professorId = chromosome[i + 2];
 * 
 * // Check if the timeslot, room, and professor are available
 * if (isTimeslotsAvailable(timeslotId) && isRoomAvailable(roomId)
 * && isProfessorAvailable(professorId, timeslotId)) {
 * newClass.setTimeslot(timeslotId);
 * newClass.setRoomId(roomId);
 * newClass.setProfessor(professorId);
 * 
 * this.roomMap.putIfAbsent(roomId, new ArrayList<>());
 * this.groupMap.putIfAbsent(group.getGroupId(), new ArrayList<>());
 * this.courseMap.putIfAbsent(courseId, new ArrayList<>());
 * this.profMap.putIfAbsent(professorId, new ArrayList<>());
 * 
 * this.roomMap.get(roomId).add(newClass);
 * this.groupMap.get(group.getGroupId()).add(newClass);
 * this.courseMap.get(courseId).add(newClass);
 * this.profMap.get(professorId).add(newClass);
 * 
 * classes[classIndex] = newClass;
 * classIndex++;
 * scheduled = true;
 * break;
 * }
 * }
 * 
 * if (!scheduled) {
 * System.out.println("Could not schedule class " + classIndex + " for group " +
 * group.getGroupId()
 * + " and course " + courseId +
 * ". No available timeslot, room, or professor.");
 * }
 * }
 */

/*
 * //successive lessons
 * for(Class classB : this.classes)
 * {
 * if(getCourse(classA.getCourseId()).equals(getCourse(classB.getCourseId())) &&
 * classA.getGroupId() == classB.getGroupId())
 * {
 * Timeslot timeslotA = getTimeslot(classA.getTimeslotId());
 * Timeslot timeslotB = getTimeslot(classB.getTimeslotId());
 * if(
 * !timeslotA.getDayOfWeek().equals(timeslotB.getDayOfWeek())
 * &&(
 * timeslotA.getTimeslotId()!=timeslotB.getTimeslotId() + 1
 * || timeslotB.getTimeslotId() != timeslotA.getTimeslotId() + 1
 * )
 * && classA.getProfessorId() != classB.getProfessorId()
 * )
 * {
 * clashes = clashes -14 *size;
 * //System.out.println("Lesson should be successive in timeslot")
 * break;
 * }
 * }
 * 
 * 
 * for(int courseId : getGroup(classA.getGroupId()).getCourseIds())
 * {
 * if()
 * }
 * if(classA.getGroupId() == classB.getGroupId() && classA.getCourseId() ==
 * classB.getCourseId() &&
 * getCourse(classA.getCourseId()).getCourseCode().equals(getCourse(classB.
 * getCourseId()).getCourseCode()))
 * {
 * Timeslot timeslotA = getTimeslot(classA.getTimeslotId());
 * Timeslot timeslotB = getTimeslot(classB.getTimeslotId());
 * if(!timeslotA.getDayOfWeek().equals(timeslotB.getDayOfWeek()))
 * {
 * clashes = clashes-7*size;
 * System.out.println("Same courses("+classA.getCourseId()+" , "
 * +classB.getCourseId()+") are not in the same day !");
 * break;
 * }
 * else if(
 * timeslotA.getDayOfWeek().equals(timeslotB.getDayOfWeek())
 * && (classA.getTimeslotId() != classB.getTimeslotId()+1
 * || classB.getTimeslotId() != classA.getTimeslotId() + 1)
 * )
 * {
 * clashes = clashes - 7 * size;
 * System.out.println("Same courses("+classA.getCourseId()+" , "
 * +classB.getCourseId()+") are not Successive the same day !");
 * break;
 * }
 * }
 * }
 */