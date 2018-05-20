package polls;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories()
public class MongoConfig extends AbstractMongoConfiguration {
    @Bean(name = "mongoClient")
    public MongoClient mongo() throws Exception {
        String connection = "mongodb://heroku_temp_test_user:temp_password@ds119820.mlab.com:19820/heroku_90t758ft";
        return new MongoClient(new MongoClientURI(connection));
    }
}
