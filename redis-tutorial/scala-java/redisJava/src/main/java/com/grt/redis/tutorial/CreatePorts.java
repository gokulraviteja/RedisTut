package com.grt.redis.tutorial;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

public class CreatePorts {


    public static  Set<HostAndPort>getNodes(){

        HostAndPort node1=new HostAndPort("127.0.0.1", 30001);
        HostAndPort node2=new HostAndPort("127.0.0.1", 30002);
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        jedisClusterNodes.add(node1);
        jedisClusterNodes.add(node2);
        return jedisClusterNodes;
    }

}
