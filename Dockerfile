FROM gradle:7.6-jdk17-alpine AS build
ENV APP_HOME /apps

WORKDIR $APP_HOME
COPY build.gradle.kts  $APP_HOME/build.gradle.kts
COPY settings.gradle.kts $APP_HOME/settings.gradle.kts
COPY gradlew $APP_HOME/gradlew
COPY gradle $APP_HOME/gradle

COPY gradle/wrapper $APP_HOME/gradle/wrapper
RUN ls -al $APP_HOME
RUN chmod +x ./gradlew

RUN ./gradlew build || return 0
COPY src $APP_HOME/src

RUN ./gradlew clean build

FROM openjdk:17.0.2-jdk

ENV APP_HOME=/apps
ARG ARTIFACT_NAME=app.jar
ARG JAR_FILE_PATH=build/libs/*.jar

WORKDIR $APP_HOME

COPY --from=build $APP_HOME/$JAR_FILE_PATH $ARTIFACT_NAME

ENTRYPOINT ["java", "-jar", "app.jar"]
