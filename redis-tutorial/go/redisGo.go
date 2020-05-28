
package main

import ("fmt"
		"context"
		"os"
		"github.com/go-redis/redis/v8")


		


func redisPool() {
	ctx := context.Background()
    poolClient := redis.NewClient(&redis.Options{
        Addr:	"localhost:6379",
    })
    pong , err := poolClient.Get(ctx,"c").Result()
    fmt.Println(pong, err)
}

func redisCluster() {
	ctx := context.Background()
	clusterClient := redis.NewClusterClient(&redis.ClusterOptions{
		Addrs: []string{"127.0.0.1:30003","127.0.0.1:30002","127.0.0.1:30001"},
	})
	va :=clusterClient.Get(ctx,"c")
	fmt.Println(va)
}


	
func main(){

   	args :=os.Args
    if(len(args)==2){
    	if(os.Args[1]=="pool"){
    		fmt.Println("Pool Mode")
    		redisPool()


    	}else if(os.Args[1]=="cluster"){
    		fmt.Println("Cluster Mode")
    		redisCluster()

    	}else{
    		fmt.Println("Specify Mode correctly")
    	}
    }else{
    	fmt.Println("One command line arg to be given either pool or cluster")
    }

	
}