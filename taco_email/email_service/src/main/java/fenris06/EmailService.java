package fenris06;

import org.springframework.integration.mail.transformer.AbstractMailMessageTransformer;
import org.springframework.integration.support.AbstractIntegrationMessageBuilder;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Arrays;

/*
@Service
public class EmailService extends AbstractMailMessageTransformer<String> {

    @Override
    protected AbstractIntegrationMessageBuilder<String> doTransform(javax.mail.Message message) throws Exception {

        return MessageBuilder.withPayload(content);
    }
}
*/
