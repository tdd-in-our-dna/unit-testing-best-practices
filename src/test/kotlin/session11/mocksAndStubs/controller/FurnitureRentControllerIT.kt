package session11.mocksAndStubs.controller

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

@SpringBootTest
@AutoConfigureMockMvc
class FurnitureRentControllerIT {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var javaMailSender: JavaMailSender

    @Test
    fun `should reserve furniture and send message successfully when furniture is available`() {
        Mockito.`when`(javaMailSender.send(Mockito.any(SimpleMailMessage::class.java))).thenAnswer { it }

        val requestBuilder = MockMvcRequestBuilders.post("/furniture/3/rent").accept(APPLICATION_JSON)
        val result = mockMvc.perform(requestBuilder).andReturn()

        result.response.status shouldBe 200

        // Behaviour verification: Helps verify mock call
        val expectedSimpleMailMessage = buildExpectedSimpleMailMessage("[Furniture id- 3] Double size bed is reserved!")
        Mockito.verify(javaMailSender, times(1)).send(expectedSimpleMailMessage)
    }

    @Test
    fun `should not reserve furniture and send message when furniture is unavailable`() {
        val requestBuilder = MockMvcRequestBuilders.post("/furniture/5/rent").accept(APPLICATION_JSON)
        val result = mockMvc.perform(requestBuilder).andReturn()

        result.response.status shouldBe 422
    }

    @Test
    fun `should not reserve furniture and send message when furniture id is invalid`() {
        val requestBuilder = MockMvcRequestBuilders.post("/furniture/A1/rent").accept(APPLICATION_JSON)
        val result = mockMvc.perform(requestBuilder).andReturn()

        result.response.status shouldBe 400
    }

    private fun buildExpectedSimpleMailMessage(messageSubject: String): SimpleMailMessage {
        val expectedSimpleMailMessage = SimpleMailMessage()
        expectedSimpleMailMessage.from = "furniture-rental@mail.com"
        expectedSimpleMailMessage.setTo("customer-furniture-rental@mail.com")
        expectedSimpleMailMessage.subject = messageSubject
        expectedSimpleMailMessage.text = messageSubject
        return expectedSimpleMailMessage
    }
}