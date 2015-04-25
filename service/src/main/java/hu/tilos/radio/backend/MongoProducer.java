package hu.tilos.radio.backend;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
public class MongoProducer {

    private static final Logger LOG = LoggerFactory.getLogger(MongoProducer.class);

    private DB db;

    @Inject
    @Configuration(name = "mongo.db")
    private String dbName;

    @Inject
    @Configuration(name = "mongo.host")
    private String host;

    public MongoProducer() {

    }

    @PostConstruct
    public void init() {
        try {
            LOG.debug("Connecting to the mongodb " + host + " " + dbName);
            MongoClient mongoClient = new MongoClient(host);
            mongoClient.setWriteConcern(WriteConcern.ACKNOWLEDGED);
            db = mongoClient.getDB(dbName);
        } catch (Exception ex) {
            throw new AssertionError("Can't connect to the mongodb");
        }
    }

    @Produces
    @Named
    public DB getDb() {
        return db;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}