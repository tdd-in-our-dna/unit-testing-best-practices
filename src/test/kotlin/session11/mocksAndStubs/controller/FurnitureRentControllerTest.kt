package session11.mocksAndStubs.controller

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import session11.mocksAndStubs.domain.Furniture
import session11.mocksAndStubs.repository.FurnitureRepository
import session11.mocksAndStubs.service.FurnitureRentService
import session11.mocksAndStubs.service.MailService

@ExtendWith(SpringExtension::class)
@WebMvcTest(value = [FurnitureRentController::class, FurnitureRentService::class])
class FurnitureRentControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var mailService: MailService

    @MockBean
    private lateinit var furnitureRepository: FurnitureRepository

    @Test
    fun `should reserve furniture and send message successfully when furniture is available`() {
        Mockito.`when`(furnitureRepository.isAvailable(Mockito.anyInt())).thenReturn(true)
        Mockito.doAnswer { it }.`when`(furnitureRepository).reserve(Mockito.anyInt())
        Mockito.`when`(furnitureRepository.getById(Mockito.anyInt())).thenReturn(Furniture(3, "Wooden Table", 8950.75, true))
        Mockito.`when`(mailService.send(Mockito.anyString())).thenReturn("Mail Sent Successfully with subject- [Furniture id- 3] Wooden Table is reserved!")

        val requestBuilder = MockMvcRequestBuilders.post("/furniture/3/rent").accept(APPLICATION_JSON)
        val result = mockMvc.perform(requestBuilder).andReturn()

        // State verification: Not necessary
        result.response.status shouldBe 200

        // Behaviour verification: Helps verify mock call
        Mockito.verify(mailService, times(1)).send("[Furniture id- 3] Wooden Table is reserved!")
    }

    @Test
    fun `should not reserve furniture and send message when furniture is unavailable`() {
        val requestBuilder = MockMvcRequestBuilders.post("/furniture/4/rent").accept(APPLICATION_JSON)
        val result = mockMvc.perform(requestBuilder).andReturn()

        result.response.status shouldBe 422
    }

    @Test
    fun `should not reserve furniture and send message when furniture id is invalid`() {
        val requestBuilder = MockMvcRequestBuilders.post("/furniture/A1/rent").accept(APPLICATION_JSON)
        val result = mockMvc.perform(requestBuilder).andReturn()

        result.response.status shouldBe 400
    }
}