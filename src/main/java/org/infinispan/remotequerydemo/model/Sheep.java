package org.infinispan.remotequerydemo.model;


import org.infinispan.protostream.annotations.ProtoDoc;
import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

@ProtoDoc("@Indexed")
public class Sheep {

   @ProtoField(number = 1, required = true)
   Integer id;

   @ProtoDoc("@Field(index = Index.YES)")
   @ProtoField(number = 2)
   String name;

   @ProtoDoc("@Field(index = Index.YES)")
   @ProtoField(number = 3)
   Gender gender;

   @ProtoDoc("@Field(index = Index.YES)")
   @ProtoField(number = 4, required = true)
   Integer age;

   Sheep(){}

   @ProtoFactory
   public Sheep(Integer id, String name, Gender gender, Integer age) {
      this.id = id;
      this.name = name;
      this.gender = gender;
      this.age = age;
   }

   public int getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public Integer getAge() {
      return age;
   }

   public Gender getGender() {
      return gender;
   }

   @Override
   public String toString() {
      return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", gender=" + gender +
            '}';
   }
}
