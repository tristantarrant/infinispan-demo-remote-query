package org.infinispan.remotequerydemo.infinispan;

import org.infinispan.client.hotrod.ProtocolVersion;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;

public class Common {
    public static final ConfigurationBuilder BUILDER = new ConfigurationBuilder()
            .security().authentication().username("user").password("password")
            .version(ProtocolVersion.PROTOCOL_VERSION_AUTO);
}
