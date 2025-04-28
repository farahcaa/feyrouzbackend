plugins {
	java
	id("org.springframework.boot") version "3.4.5"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "us.feyrouzbackend"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.keycloak:keycloak-admin-client:26.0.5")
	implementation("org.keycloak:keycloak-core:26.2.1")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
	implementation("org.springframework.boot:spring-boot-starter-validation")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	implementation("com.squareup.okhttp3:okhttp:4.12.0")
	implementation("org.slf4j:slf4j-api:2.0.16")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.18.1")

	implementation("org.hibernate.orm:hibernate-core:6.6.2.Final")
	implementation("org.hibernate.validator:hibernate-validator:8.0.2.Final")

	implementation("org.apache.commons:commons-math4-legacy:4.0-beta1")

	testImplementation("ch.qos.logback:logback-classic:1.5.16")

	implementation("org.postgresql:postgresql:42.7.4")
	implementation("org.liquibase:liquibase-core:4.30.0")

	implementation("org.mapstruct:mapstruct:1.6.3")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.6.3")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
