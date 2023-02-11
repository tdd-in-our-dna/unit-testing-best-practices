package session11.mocksAndStubs.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service


@Service
class MailService(
    private val javaMailSender: JavaMailSender,
    @Value("\${spring.mail.username}") private val senderMail: String
) {
    companion object {
        const val RECEIVER_MAIL = "customer-furniture-rental@mail.com"
    }

    fun send(messageSubject: String): String {
        return try {
            val mailMessage = SimpleMailMessage()

            mailMessage.from = senderMail
            mailMessage.setTo(RECEIVER_MAIL)
            mailMessage.subject = messageSubject
            mailMessage.text = messageSubject

            javaMailSender.send(mailMessage)
            "Mail Sent Successfully with subject- $messageSubject"
        } catch (exception: Exception) {
            throw Exception(exception)
        }
    }
}