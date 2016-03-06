package test.com.carwash;


public class Order {
    String order_type,amount,timestamp,address;
    int user_id;

    public Order(String order_type, String amount, int user_id, String timestamp, String address) {

        this.order_type = order_type;
        this.amount = amount;
        this.user_id=user_id;
        this.timestamp = timestamp;
        this.address = address;
    }


}
