 package br.com.manygames.restdockerkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestDockerKotlinApplication

fun main(args: Array<String>) {
    runApplication<RestDockerKotlinApplication>(*args)
}
