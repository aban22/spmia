Para sobreescribir variables al arranque
	java -Dspring.cloud.config.uri=http://localhost:8888 -Dspring.profiles.active=dev -jar target/licensing-service-0.0.1-SNAPSHOT.jar