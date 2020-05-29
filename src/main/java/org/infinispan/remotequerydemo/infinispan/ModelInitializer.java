package org.infinispan.remotequerydemo.infinispan;

import org.infinispan.protostream.SerializationContextInitializer;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

import org.infinispan.remotequerydemo.model.Gender;
import org.infinispan.remotequerydemo.model.Sheep;

@AutoProtoSchemaBuilder(
      includeClasses = {
            Gender.class,
            Sheep.class,
      },
      schemaFileName = "sheep.proto",
      schemaFilePath = "proto/", 
      schemaPackageName = "org.infinispan.remotequerydemo.model")
interface ModelInitializer extends SerializationContextInitializer {
}