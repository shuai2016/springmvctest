package vo;

public class Goods{
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