# 1단계: Java 애플리케이션 빌드
FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /build

COPY app/ .

RUN mvn -B clean package -PMySQL -DskipTests

# 2단계: Tomcat 실행
FROM tomcat:9.0-jre17-temurin

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=builder /build/target/*.war \
    /usr/local/tomcat/webapps/petclinic.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
