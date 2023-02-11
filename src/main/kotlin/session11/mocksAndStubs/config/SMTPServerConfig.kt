package session11.mocksAndStubs.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.subethamail.smtp.helper.SimpleMessageListener
import org.subethamail.smtp.server.SMTPServer

@Configuration
class SMTPServerConfig {

    private lateinit var smtpServer: SMTPServer
    private lateinit var mailListener: SimpleMessageListener

    @Bean
    fun smtpServerConfig(mailListener: SimpleMessageListener): SMTPServer {
        this.mailListener = mailListener
        this.smtpServer = SMTPServer
            .port(25000)
            .simpleMessageListener(mailListener)
            .build()
        smtpServer.start()
        return smtpServer
    }
}