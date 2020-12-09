package classes.beans;

import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/TestQueue")
public class TestMessageDrivenBEAN implements MessageListener {
    @Resource
    private MessageDrivenContext messageDrivenContext;

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage msg = (TextMessage) message;
                msg.getText();
            }
        } catch (JMSException e) {
            messageDrivenContext.setRollbackOnly();
        }
    }
}
