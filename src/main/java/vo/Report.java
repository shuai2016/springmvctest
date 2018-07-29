package vo;

import java.util.List;

public class Report {
    String title;
    String note;
    List<Goods> goodsList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "Report{" +
                "title='" + title + '\'' +
                ", note='" + note + '\'' +
                ", goodsList=" + goodsList +
                '}';
    }
}
