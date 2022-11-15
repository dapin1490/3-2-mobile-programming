public class Memo {
    private long id;
    private String str;

    public Memo(Long id, String str) {
        this.id = id;
        this.str = str;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return str;
    }
}