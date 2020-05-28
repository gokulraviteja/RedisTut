package com.grt.redis.tutorial


import redis.clients.jedis.{HostAndPort, JedisCluster, JedisPool}


object scalaMain {

  def scalaRedis(mode : String): Unit ={


    mode match {
      case Constants.Type.pool =>{

        try {
          println("Pool Connection Set")
          val redisPoolClient = new JedisPool("localhost", 6379)
          val jedis = redisPoolClient.getResource
          jedis.set("a", "1");
        }
        catch {
          case exception: Exception => println("Oops , Is Redis UP????")
        }

      }
      case  Constants.Type.cluster=>{

        try {
          println("Cluster Connection Set")
          val redisClusterClient = new JedisCluster(CreatePorts.getNodes)
          redisClusterClient.set("c", "3")
        }
        catch {
          case exception: Exception => println("Oops , I Guess cluster was not set up????")
        }

      }
      case _ => {
        println("Mode should be specified as pool or cluster")
      }

    }


  }


}
