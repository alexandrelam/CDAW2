FROM openjdk:11
RUN addgroup --system --gid 1002 app && adduser --system --uid 1002 --gid 1002 appuser
USER 1002
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]