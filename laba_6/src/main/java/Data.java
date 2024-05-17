import java.util.Iterator;

public class Data {
    private String name;
    private Group[] groups;

    public Data(String name, Group... groups) {
        this.name = name;
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public int getTotalLength() {
        int totalLength = 0;
        for (Group group : groups) {
            totalLength += group.getLength();
        }
        return totalLength;
    }
    public Iterator<Integer> iterator() {
        return new DataIterator();
    }
    private class DataIterator implements Iterator<Integer> {
        private int currentGroupIndex = 0;
        private int currentElementIndex = 0;

        @Override
        public boolean hasNext() {
            return currentGroupIndex < groups.length && currentElementIndex < groups[currentGroupIndex].getData().length;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more elements to iterate over");
            }

            int nextElement = groups[currentGroupIndex].getData()[currentElementIndex];
            currentElementIndex++;

            if (currentElementIndex == groups[currentGroupIndex].getData().length) {
                currentGroupIndex++;
                currentElementIndex = 0;
            }
            return nextElement;
        }
    }
}