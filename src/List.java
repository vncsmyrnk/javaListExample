public class List<T> {
    private ListItem<T> firstItem;
    private ListItem<T> lastItem;

    public void add(T content, int position) {
        ListItem<T> referenceItem = findItem(position);
        addItemByReference(content, referenceItem);
    }

    public T remove(int position) throws Exception {
        ListItem<T> searchedItem = findItem(position);
        throwExceptionIfItemIsInvalid(searchedItem);
        removeItem(searchedItem);
        return searchedItem.getContent();
    }

    public T remove(T content) throws Exception {
        ListItem<T> searchedItem = findItem(content);
        throwExceptionIfItemIsInvalid(searchedItem);
        removeItem(searchedItem);
        return searchedItem.getContent();
    }

    public void clearList() {
        this.firstItem = null;
        this.lastItem = null;
    }

    public ListItem<T> findItem(int position) {
        ListItem<T> currentItem = this.firstItem;
        int currentPosition = 0;

        while (currentItem != null) {
            if (currentPosition == position) {
                return currentItem;
            }
            currentPosition++;
            currentItem = currentItem.getNext();
        }

        return null;
    }

    public ListItem<T> findItem(T content) {
        ListItem<T> currentItem = this.firstItem;

        while (currentItem != null) {
            if (currentItem.getContent().equals(content)) {
                return currentItem;
            }
            currentItem = currentItem.getNext();
        }

        return null;
    }

    public boolean isItemValid(ListItem<T> item) {
        return item != null;
    }

    public boolean isListEmpty() {
        return this.firstItem == null && this.lastItem == null;
    }

    public boolean isItemTheFirst(ListItem<T> item) {
        return this.firstItem == item;
    }

    public boolean isItemTheLast(ListItem<T> item) {
        return this.lastItem == item;
    }

    public boolean listHasOnlyOneMember() {
        return this.firstItem == this.lastItem;
    }

    private void addItemByReference(T content, ListItem<T> referenceItem) {
        ListItem<T> newItem = new ListItem<T>(content);
        if (isListEmpty()) {
            includeItemInEmpty(newItem);
            return;
        }

        if (referenceItem == null) {
            includeItemLastPositionNonEmpty(newItem);
            return;
        }

        includeItemBeforeReference(newItem, referenceItem);
    }

    private void includeItemInEmpty(ListItem<T> item) {
        this.firstItem = item;
        this.lastItem = item;
    }

    private void includeItemLastPositionNonEmpty(ListItem<T> item) {
        this.lastItem.setNext(item);
        item.setPrevious(this.lastItem);
        this.lastItem = item;
    }

    private void includeItemBeforeReference(ListItem<T> item, ListItem<T> referenceItem) {
        ListItem<T> referenceItemPrevious = referenceItem.getPrevious();
        if (referenceItemPrevious != null) {
            referenceItemPrevious.setNext(item);
        }

        item.setNext(referenceItem);
        item.setPrevious(referenceItemPrevious);
        referenceItem.setPrevious(item);

        if (isItemTheFirst(referenceItem)) {
            setItemAsFirst(item);
        }
    }

    private void setItemAsFirst(ListItem<T> item) {
        this.firstItem = item;
    }

    private void setItemAsLast(ListItem<T> item) {
        this.lastItem = item;
    }

    private void removeItem(ListItem<T> item) throws Exception {
        if (isListEmpty()) throwEmptyListException();
        if (listHasOnlyOneMember()) {
            clearList();
            return;
        }

        removeItemOnTwoOrMoreMemberList(item);
    }

    private void removeItemOnTwoOrMoreMemberList(ListItem<T> item) {
        ListItem<T> nextItem = item.getNext();
        ListItem<T> previousItem = item.getPrevious();

        if (!isItemValid(nextItem)) {
            previousItem.setNext(null);
            setItemAsLast(previousItem);
            return;
        }

        if (!isItemValid(previousItem)) {
            nextItem.setPrevious(null);
            setItemAsFirst(nextItem);
            return;
        }

        nextItem.setPrevious(previousItem);
        previousItem.setNext(nextItem);
    }

    private void throwExceptionIfItemIsInvalid(ListItem<T> item) throws Exception {
        if (!isItemValid(item)) throw new Exception("Invalid item.");
    }

    private void throwEmptyListException() throws Exception {
        throw new Exception("Empty list.");
    }

    public void print() {
        ListItem<T> currentItem = this.firstItem;

        if (currentItem == null) {
            this.log("Empty List.\n");
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