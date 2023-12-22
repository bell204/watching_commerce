FROM openjdk:8-jdk

MAINTAINER bell204 <bell2016@naver.com>

ENV PROPERTIES=application.properties

# 맨처음에는 PROFILE 환경 변수 설정 안 함
ENV PROFILE=default

# 도커 빌드 인수로 jar를 함.
ARG JAR_FILE=*.jar

# 현재 디렉토리에서 해당 JAR 파일을 app.jar로 만듬.
ADD ${JAR_FILE} app.jar

# 설정 파일은 config 디렉토리에 위치함.
CMD ["java","-jar", "-Dspring.config.location:/config/${PROPERTIES}", "-Dspring.profiles.active=${PROFILE}", "/app.jar"]
