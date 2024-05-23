public class Professor {


    private final int professorId;
    private final String professorName;
    private final int availability[];
    private final int sceancePerWeek;

    public Professor(int professorId, String professorName, int[] availability, int sceancePerWeek) {
        this.professorId = professorId;
        this.professorName = professorName;
        this.availability = availability;
        this.sceancePerWeek = sceancePerWeek;
    }
    public Professor(int professorId, String professorName, int sceancePerWeek) {
        this.professorId = professorId;
        this.professorName = professorName;
        this.sceancePerWeek = sceancePerWeek;
        this.availability = null;
    }
    public int getProfessorId() {
        return professorId;
    }
    public String getProfessorName() {
        return professorName;
    }
    public int[] getAvailability() {
        return availability;
    }
    public int getSceancePerWeek() {
        return sceancePerWeek;
    }
}
