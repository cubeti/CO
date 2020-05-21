package co.project.logger;

public class AddValue {
    private long score;
    private int ID;
    private int threads;
    private String info;

    public AddValue(int ID, int threads, long score, String info) {
        this.score = score;
        this.ID = ID;
        this.threads = threads;
        this.info = info;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
