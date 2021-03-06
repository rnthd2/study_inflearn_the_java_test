package me.rnthd2.study_inflearn_the_java_test;

public class Study {
    private StudyStatus status;
    private int limit;
    private String name;

    public Study(int limit, String name) {
        this.limit = limit;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Study{" +
                "status=" + status +
                ", limit=" + limit +
                ", name='" + name + '\'' +
                '}';
    }

    public Study(int limit) {
        if(limit < 0) {
            throw new IllegalArgumentException("limit은 0보다 커야합니다.");
        }
        this.limit = limit;
    }

    public StudyStatus getStatus() {
        return this.status;
    }

    public int getLimit() {
        return limit;
    }
}
