package fenris06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.mail.dsl.Mail;

@Configuration
public class TacoOrderEmailIntegrationConfig {
  /*  @Bean
    public IntegrationFlow tacoOrderEmailFlow(
            EmailProperties emailProps,
            EmailToOrderTransformer emailToOrderTransformer,
            OrderSubmitMessageHandler orderSubmitHandler) {

        return IntegrationFlows
                .from(Mail.imapInboundAdapter("imaps://fenris06Programmer@yandex.ru:pmhtenuonxolgzpb@imap.yandex.ru:993/inbox"),
                        e -> e.poller(
                                Pollers.fixedDelay(emailProps.getPollRate())))
                .transform(emailToOrderTransformer)
                .handle(orderSubmitHandler)
                .get();
    }*/

    @Bean
    public IntegrationFlow imapMailFlow() {
        return IntegrationFlows
                .from(Mail.imapInboundAdapter("imaps://fenris06Programmer:numpefxrcdhxgwpq@imap.yandex.ru:993/inbox")
                                .javaMailProperties(p -> p
                                        .put("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory")
                                        .put("mail.imap.socketFactory.fallback", false)
                                        .put("mail.store.protocol", "imaps")
                                        .put("mail.debug", true))
                                .simpleContent(true)
                                .shouldDeleteMessages(false) // Не удалять письма после обработки
                                .autoCloseFolder(false), // Не закрывать папку после проверки
                        e -> e.poller(p -> p.fixedDelay(5000)))
                .transform(Mail.toStringTransformer())// Проверять почту каждые 5 секунд
                .handle(message -> {
                    ;
                    System.out.println("Received email: " + message.getPayload());
                    // Обработка входящего письма

                })
                .get();
    }
}