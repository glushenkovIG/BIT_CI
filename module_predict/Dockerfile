FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
ENV APP_HOST=8081
ENV DB_HOST="http://db/"
ENV WEATHER_HOST="http://weather/weather/"

RUN mvn clean package


CMD java -jar ./target/gs-spring-boot-0.1.0.jar