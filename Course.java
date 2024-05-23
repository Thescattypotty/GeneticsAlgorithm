public class Course {

    private final int courseId;
    private final String courseCode;
    private final String course;
    private final int professorIds[];
    private final String roomTypeRequirement;

   
    public Course(int courseId, String courseCode, String course, int[] professorIds, String roomTypeRequirement) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.course = course;
        this.professorIds = professorIds;
        this.roomTypeRequirement = roomTypeRequirement;
    }

    public Course(int courseId, String courseCode, String course, int[] professorIds) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.course = course;
        this.professorIds = professorIds;
        this.roomTypeRequirement = "SC";
    }
    
    public String getRoomTypeRequirement() {
        return roomTypeRequirement;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public String getCourseName() {
        return this.course;
    }

    public int getRandomProfessorId() {
        int professorId = professorIds[(int) (professorIds.length * Math.random())];
        return professorId;
    }

}
