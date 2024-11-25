# Java 17 Base Image
FROM openjdk:17-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# 프로젝트 파일 복사
COPY . .

# Maven 빌드
RUN ./mvnw clean package

# 실행
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
