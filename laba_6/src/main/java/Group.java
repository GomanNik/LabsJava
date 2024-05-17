public class Group {
    private int groupId;
    private int[] data;

    public Group(int groupId, int... data) {
        this.groupId = groupId;
        this.data = data;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getLength() {
        return data.length;
    }
}