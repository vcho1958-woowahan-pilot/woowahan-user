package com.woowahan.pilot.user.common.advice

import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import org.hamcrest.core.Is
import org.hamcrest.core.IsNull
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GeneralAdviceTest extends Specification {
    private RequestSpecification given;
    @LocalServerPort
    private int port;

    void setup() {
        def spec = new RequestSpecBuilder().build()
        RestAssured.port = port
        given = RestAssured.given(spec).port(port)
    }

    def "BaseException Advice 동작 테스트"() {
        given:
        def given = given
                .accept("application/json")
                .contentType(ContentType.JSON)
        when:
        def when = given.when()
                .get("/test/custom")
        then:
        when.then()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("success", Is.is(false))
                .body("data", IsNull.nullValue())
    }

    def "InternalException Advice 동작 테스트"() {
        given:
        def given = given
                .accept("application/json")
                .contentType(ContentType.JSON)
        when:
        def when = given.when()
                .get("/test/internal")
        then:
        when.then()
                .assertThat()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body("success", Is.is(false))
                .body("data", IsNull.nullValue())
    }
}
