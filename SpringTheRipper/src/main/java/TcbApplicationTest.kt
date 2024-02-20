//import com.fasterxml.jackson.databind.DeserializationFeature
//import com.fasterxml.jackson.databind.ObjectMapper
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
//import com.fasterxml.jackson.module.kotlin.KotlinModule
//import org.junit.jupiter.api.Test
//import org.springframework.core.io.ClassPathResource
//import ru.tinkoff.bpm.topmortgageprimaryfiller.util.easyRandom
//import ru.tinkoff.bpm.topmortgageprimaryfiller.util.invoke
//
//class TcbApplicationTest {
//
//    @Test
//    fun testSerialization() {
//        val application = easyRandom<TcbApplication>()
//
//        val mapper = ObjectMapper()
//        mapper.registerModules(JavaTimeModule(), KotlinModule())
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
//
//        val read = mapper.readValue(
//            ClassPathResource("/tcbApplication.json").inputStream,
//            TcbApplication::class.java
//        )
////        val writeValueAsString = mapper.writeValueAsString(application)
//
//        println("writeValueAsString = $read")
//        read.metadata?.stage
//    }
//}
