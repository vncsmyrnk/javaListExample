public class List<T> {
    private ListItem<T> firstItem;
    private ListItem<T> lastItem;

    public void addItem(T item, int position) {
        ListItem<T> referenceItem = this.find(position);
        if (!isItemValid(referenceItem)) {
            referenceItem = null;
        }

        ListItem<T> newItem = new ListItem<T>(item);

        if (isListEmpty()) { // Empty list
            this.firstItem = newItem;
            this.lastItem = newItem;
            this.print();
            return;
        }

        if (referenceItem == null) { // Including on last postion
            this.lastItem.setNext(newItem);
            newItem.setPrevious(this.lastItem);
            this.lastItem = newItem;
            this.print();
            return;
        }
        
        ListItem<T> referenceItemPrevious = referenceItem.getPrevious();

        newItem.setNext(referenceItem);
        newItem.setPrevious(referenceItemPrevious);

        if (referenceItemPrevious == null) {
            this.firstItem = newItem; // Including on first postion
        } else {
            referenceItemPrevious.setNext(newItem);
        }

        referenceItem.setPrevious(newItem);

        this.print();
    }

    public boolean removeItem(int position) {
        ListItem<T> searchedItem = this.find(position);
        if (!isItemValid(searchedItem)) {
            this.print();
            return false;
        }

        boolean removed = this.removeItem(searchedItem);

        this.print();

        return removed;
    }

    public boolean removeItem(T content) {
        ListItem<T> searchedItem = this.find(content);
        if (!isItemValid(searchedItem)) {
            return false;
        }

        boolean removed = this.removeItem(searchedItem);

        this.print();

        return removed;
    }

    private boolean removeItem(ListItem<T> item) {
        if (isListEmpty()) {
            this.log("Empty List");
            return false;
        }

        if (this.firstItem == this.lastItem) { // One member list
            this.firstItem = null;
            this.lastItem = null;
            return true;
        }

        ListItem<T> nextItem = item.getNext();
        ListItem<T> previousItem = item.getPrevious();

        if (nextItem == null) { // Removing last item
            previousItem.setNext(null);
            this.lastItem = previousItem;
            return true;
        }

        if (previousItem == null) { // Removing first item
            nextItem.setPrevious(null);
            this.firstItem = nextItem;
            return true;
        }

        // Mid item remove
        nextItem.setPrevious(previousItem);
        previousItem.setNext(nextItem);
        return true;
    }

    public ListItem<T> find(int position) {
        ListItem<T> currentItem = this.firstItem;
        int currentPosition = 0;

        while (currentItem != null) {

            if (currentPosition == position) {
                return currentItem;
            }

            currentPosition++;
            currentItem = currentItem.getNext();
        }

        return new ListItem<T>();
    }

    public ListItem<T> find(T content) {
        ListItem<T> currentItem = this.firstItem;

        while (currentItem != null) {

            if (currentItem.getContent().equals(content)) {
                return currentItem;
            }

            currentItem = currentItem.getNext();
        }

        return new ListItem<T>();
    }

    public boolean isItemValid(ListItem<T> item) {
        return item.getNext() != null || item.getPrevious() != null;
    }

    public boolean isListEmpty() {
        return this.firstItem == null && this.lastItem == null;
    }

    public void print() {
        ListItem<T> currentItem = this.firstItem;

        if (currentItem == null) {
            this.log("Empty List\n");
            return;
        }

        int currentPosition = 0;

        while (currentItem != null) {
            this.log("[" + currentPosition + "] -> " + currentItem.getContent() + "; ");

            currentItem = currentItem.getNext();
            currentPosition++;
        }

        this.log("\n");
    }

    public void log(String message) {
        System.out.print(message);
    }
}