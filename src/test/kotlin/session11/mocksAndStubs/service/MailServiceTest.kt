package session11.mocksAndStubs.service

import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import org.junit.jupiter.api.Test
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender

class MailServiceTest {
    @Test
    fun `should successfully send email with given message when no failure occurs`() {
        val javaMailSender = mockk<JavaMailSender>()
        val senderMail = "furniture-rental@mail.com"
        val mailService = MailService(javaMailSender, senderMail)
        val messageSubject = "[Furniture id- 1] Wooden Cupboard is reserved!"

        every { javaMailSender.send(any<SimpleMailMessage>()) } just runs

        val mailMessage = mailService.send(messageSubject)

        mailMessage shouldBe "Mail Sent Successfully with subject- [Furniture id- 1] Wooden Cupboard is reserved!"
    }

    @Test
    fun `should throw exception to send email with given message when failure occurs`() {
        val javaMailSender = mockk<JavaMailSender>()
        val senderMail = "furniture-rental@mail.com"
        val mailService = MailService(javaMailSender, senderMail)
        val messageSubject = "[Furniture id- 1] Wooden Cupboard is reserved!"

        every { javaMailSender.send(any<SimpleMailMessage>()) } throws Exception()

        shouldThrow<Exception> {
            mailService.send(messageSubject)
        }
    }
}