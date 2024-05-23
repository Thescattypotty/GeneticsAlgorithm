public class Studentgroup {

    private final int groupId;
    private final int groupSize;
    private final int courseIds[];


    public Studentgroup(int groupId, int groupSize, int courseIds[]){
        this.groupId = groupId;
        this.groupSize = groupSize;
        this.courseIds = courseIds;
    }

    public int getGroupId(){
        return this.groupId;
    }

    public int getGroupSize(){
        return this.groupSize;
    }

    public int[] getCourseIds(){
        return this.courseIds;
    }


}
