public class ListItem<T> {
    private ListItem<T> next;
    private ListItem<T> previous;
    private T content;

    public ListItem(T content) {
        this.content = content;
    }

    public ListItem() {}

    public ListItem<T> getNext() {
        return this.next;
    }
    public void setNext(ListItem<T> next) {
        this.next = next;
    }

    public ListItem<T> getPrevious() {
        return this.previous;
    }
    public void setPrevious(ListItem<T> previous) {
        this.previous = previous;
    }

    public T getContent() {
        return this.content;
    }
    public void setContent(T content) {
        this.content = content;
    }
}
