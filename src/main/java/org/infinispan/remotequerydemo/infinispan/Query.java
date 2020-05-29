package org.infinispan.remotequerydemo.infinispan;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.Search;
import org.infinispan.commons.configuration.XMLStringConfiguration;
import org.infinispan.query.dsl.QueryFactory;
import org.infinispan.query.remote.client.ProtobufMetadataManagerConstants;
import org.infinispan.remotequerydemo.model.Sheep;

import org.infinispan.remotequerydemo.model.Gender;


public class Query {
   public static final void main(String args[]) throws Exception {
      try (RemoteCacheManager cacheManager = new RemoteCacheManager(Common.BUILDER.addContextInitializer(new ModelInitializerImpl()).build())) {
         Path proto = Paths.get(Query.class.getClassLoader().getResource("proto/sheep.proto").toURI());
         cacheManager.getCache(ProtobufMetadataManagerConstants.PROTOBUF_METADATA_CACHE_NAME)
               .put("sheep.proto", Files.readString(proto));
         Path config = Paths.get(Query.class.getClassLoader().getResource("query.xml").toURI());
         RemoteCache<Integer, Sheep> cache = cacheManager.administration().getOrCreateCache("query", new XMLStringConfiguration(Files.readString(config)));

         cache.put(1, new Sheep(1, "Shaun", Gender.MALE, 5));
         cache.put(2, new Sheep(2, "Shirley", Gender.FEMALE, 10));
         cache.put(3, new Sheep(3, "Timmy", Gender.MALE, 1));
         cache.put(4, new Sheep(4, "Nuts", Gender.MALE, 6));

         QueryFactory queryFactory = Search.getQueryFactory(cache);
         queryFactory.create("from devnation.Sheep s where s.age >= 4 s.name like 'S%'").list().forEach(System.out::println);
      }
   }
}
