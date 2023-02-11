package session11.mocksAndStubs.config.listener

import java.io.InputStream
import java.util.Properties
import javax.mail.Message
import javax.mail.Session
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage
import org.springframework.context.annotation.Configuration
import org.subethamail.smtp.helper.SimpleMessageListener

@Configuration
class MailListener: SimpleMessageListener {
    override fun accept(from: String?, recipient: String?): Boolean {
        return from != null && recipient != null;
    }

    override fun deliver(from: String?, recipient: String?, data: InputStream) {
        try {
            val session = Session.getDefaultInstance(Properties())
            val message = MimeMessage(session, data)
            ReceivedEmail(
                subject = message.subject,
                senderAddress = InternetAddress.toString(message.from),
                recipientAddress = InternetAddress.toString(message.getRecipients(Message.RecipientType.TO))
            ).also {
                println(it)
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }
}

data class ReceivedEmail(
    private val subject: String,
    private val senderAddress: String,
    private val recipientAddress: String
)