FROM gradle:jdk11 as gradleimage
COPY --chown=gradle:gradle . /home/gradle/source
WORKDIR /home/gradle/source
RUN gradle build --no-daemon

FROM eclipse-temurin:11
ARG JAR_FILE=/home/gradle/source/build/libs/*.jar
COPY --from=gradleimage ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
