package com.grt.redis.tutorial;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class javaMain {


    public static void javaRedis(String mode){

        if(mode.equals("pool")){
            try {
                System.out.println("Pool Connection Set");
                JedisPool jedisPool = new JedisPool("localhost", 6379);
                Jedis jedis = jedisPool.getResource();
                jedis.set("a", "1");
            }
            catch (Exception e){
                System.out.println("Exception in Redis Java");
            }

        }
        else if (mode.equals("cluster")){
            try {
                System.out.println("Cluster Connection Set");
                JedisCluster redisClusterClient = new JedisCluster(CreatePorts.getNodes());
                redisClusterClient.set("c", "3");
            }
            catch (Exception e){
                System.out.println("Exception in Redis Java");
            }
        }
        else {
            System.out.println("Mode should be specified as pool or cluster");
        }

        return;
    }

    public static void main(String[] args) {

        if(args.length==0){
            System.out.println("Need a CMD LINE Argument of Mode - either pool or cluster in lowercase");
        }

        String mode= args[0];
        scalaMain.scalaRedis(mode);
        javaRedis(mode);



    }

}
