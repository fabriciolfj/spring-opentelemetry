echo "Api"
cd api-service
mvn clean install spring-boot:build-image
cd ..
echo "Customer"
cd customer-service
mvn clean install spring-boot:build-image