# Chọn base image cho ứng dụng Java, ví dụ OpenJDK
FROM openjdk:17-jdk-slim

# Sao chép New Relic agent và file cấu hình vào container
COPY libs/newrelic-agent-8.16.0.jar newrelic.jar
COPY src/main/resources/newrelic.yml newrelic.yml

# Thêm ứng dụng Java của bạn vào container
COPY target/mynewrelic-0.0.1-SNAPSHOT.jar app.jar

# Set môi trường cho New Relic
ENV NEW_RELIC_AGENT_PATH=newrelic.jar
ENV NEW_RELIC_CONFIG_FILE=newrelic.yml

# Mở port ứng dụng (ví dụ port 8080)
EXPOSE 8080

# Lệnh chạy ứng dụng với New Relic Java Agent
CMD ["java", "-javaagent:newrelic.jar", "-jar", "app.jar"]
