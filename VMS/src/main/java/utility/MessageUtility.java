package utility;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import model.Order;

/**
 * Created by apple on 24/09/16.
 */
public class MessageUtility {

    public static Boolean sendMessage(Order order){
        Twilio.init("ACd83e6d73d0c73c89b9a8010944eadef4","3d4829cd9e8f8975e9a310b71bbc6fcc");

        String orderId = order.getOrderId();
        String productId = order.getProductId();
        String mobileNumber = order.getMobileNumber();

        String messageFormat = "Hi your order with orderId" +orderId+"and productId"+productId+"costing"
                +order.getAmount().getCurrency()+" "+order.getAmount().getAmount()+"has been shipped to your shipping address";
        if(!mobileNumber.trim().equalsIgnoreCase("7030615522") && !mobileNumber.trim().equalsIgnoreCase("8939563581")){

            Message.create(new PhoneNumber("+91"+mobileNumber), new PhoneNumber("+13107766392"),
                    messageFormat)
                    .execute();
            return true;
        }
        return false;

    }
}
