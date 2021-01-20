package com.ahyaemon.todo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class TodoApplication

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration: WebSecurityConfigurerAdapter() {
	override fun configure(web: WebSecurity) {
		web.ignoring().antMatchers("/**/**")
	}

	override fun configure(http: HttpSecurity) {
		super.configure(http)
	}
}

fun main(args: Array<String>) {
	runApplication<TodoApplication>(*args)
}

@RestController
@RequestMapping
class HelloController {

	@GetMapping
	fun hello(): String = "hello!! world!!"
}
