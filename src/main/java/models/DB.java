package models;

import org.sql2o.*;
import java.net.URI;
import java.net.URISyntaxException;
//public class DB {
//    private static URI dbUri;
//    public static Sql2o sql2o;
//
//    static {
//
//        try {
//            if (System.getenv("DATABASE_URL") == null) {
//                dbUri = new URI("postgres://localhost:5432/wildlife_tracker2");
//            } else {
//                dbUri = new URI(System.getenv("DATABASE_URL"));
//            }
//
//            int port = dbUri.getPort();
//            String host = dbUri.getHost();
//            String path = dbUri.getPath();
//            String username = (dbUri.getUserInfo() == null) ? "kev" : dbUri.getUserInfo().split(":")[0];
//            String password = (dbUri.getUserInfo() == null) ? "garfield" : dbUri.getUserInfo().split(":")[1];
//
////            sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + path, username, "d6sl4bahb94ot0"  password);
//        } catch (URISyntaxException e) {
//
//        }
//    }
//}

public class DB {
   public static String connectionString = "jdbc:postgresql://ec2-52-203-160-194.compute-1.amazonaws.com/d6h28pq7taeg2l";
    public static Sql2o sql2o = new Sql2o(connectionString, "pcfuribhbzhumr", "ec6ee572fe3654798fdbd3e35bdedc2a6c1d6fc0462bbcf6e035fa11bea8be3b");

        }

