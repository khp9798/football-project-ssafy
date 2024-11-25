# Java 17 Base Image
FROM openjdk:17-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# 프로젝트 파일 복사
COPY . .

# Maven 빌드
RUN chmod +x ./mvnw && ./mvnw clean package

# 컨테이너에서 포트 노출
EXPOSE 8080

# Render의 환경 변수 PORT 사용
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar", "--server.port=${PORT}"]
