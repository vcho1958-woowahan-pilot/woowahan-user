package com.woowahan.pilot.user.domain.general.entity


import jakarta.validation.Validation
import jakarta.validation.Validator
import jakarta.validation.ValidatorFactory
import spock.lang.Specification

class UserTest extends Specification {
    private static ValidatorFactory factory
    private static Validator validator

    def setupSpec() {
        factory = Validation.buildDefaultValidatorFactory()
        validator = factory.getValidator()
    }

    def "각 필드 검증"() {
        given:
        def user = new User(email, nickname, "asd", phone)
        expect:
        validator.validate(user).size() == result
        where:
        email     | nickname        | phone          | result
        "asd"     | "as"            | "asd"          | 3
        "asd@asd" | "asd"           | "asd"          | 1
        "asd@asd" | "asd4"          | "asd"          | 1
        "asd@asd" | "asd123123123"  | "asd"          | 1
        "asd@asd" | "asd123123124"  | "0101231231"   | 0
        "asd@asd" | "asd1231231254" | "0101231231"   | 1
        "asd@asd" | "asd123123125"  | "2101231231"   | 1
        "asd@asd" | "asd123123125"  | "010123123122" | 1
    }
}
