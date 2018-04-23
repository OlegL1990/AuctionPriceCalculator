package AuctionPriceCalculator;

public class Request {
    char type;
    int quantity;
    float price;

    public Request(char type,int quantity,float price){
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (type != request.type) return false;
        if (quantity != request.quantity) return false;
        return Float.compare(request.price, price) == 0;
    }

    @Override
    public int hashCode() {
        int result = (int) type;
        result = 31 * result + quantity;
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Request{" +
                "type=" + type +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
