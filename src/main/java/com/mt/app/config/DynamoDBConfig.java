package com.mt.app.customer.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
//@EnableDynamoDBRepositories(basePackages = "com.baeldung.spring.data.dynamodb.repositories")
public class DynamoDBConfig {

    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        System.out.println("\n\n\n amazonDynamoDb member function.\n\n\n" );
        AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());
        if (!StringUtils.isEmpty(amazonDynamoDBEndpoint)) {
            amazonDynamoDB.setEndpoint(amazonDynamoDBEndpoint);
        }
        return amazonDynamoDB;
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        System.out.println("\n\n\n amazonAWSCredentials member function.\n\n\n" );
        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }

    @Bean
    public DynamoDBMapper dynamoDbMapper(AmazonDynamoDB amazonDynamoDB) {
      System.out.println("\n\n\ndynamoDbMapper2 member function.\n\n\n" );

      //log.trace("Entering dynamoDbMapper()");
      return new DynamoDBMapper(amazonDynamoDB);
    }


}
