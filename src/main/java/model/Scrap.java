package model;

public class Scrap {
    private int sc_id;  //scrap table의 고유id
    private int s_id;
    private int scrap_id;  //scrap된 학생의 id

    public Scrap() {}
    public Scrap(int sc_id, int s_id, int scrap_id) {
        this.sc_id = sc_id;
        this.s_id = s_id;
        this.scrap_id = scrap_id;
    }

    public int getSc_id() {
        return sc_id;
    }

    public void setSc_id(int sc_id) {
        this.sc_id = sc_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getScrap_id() {
        return scrap_id;
    }

    public void setScrap_id(int scrap_id) {
        this.scrap_id = scrap_id;
    }
}
