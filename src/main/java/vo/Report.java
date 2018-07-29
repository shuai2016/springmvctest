package vo;

import java.util.Arrays;
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
class Goods{
    String goodsNumber;
    String goodsName;

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsNumber='" + goodsNumber + '\'' +
                ", goodsName='" + goodsName + '\'' +
                '}';
    }
}
