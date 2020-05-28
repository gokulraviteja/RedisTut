#Cluster architecture not supported  by redis-py
#pip install redis-py-cluster

import time 
from rediscluster import RedisCluster
startup_nodes = [{"host": "127.0.0.1", "port": "30001"},{"host": "127.0.0.1", "port": "30002"},{"host": "127.0.0.1", "port": "30003"}]
#startup_nodes = [{"host": "127.0.0.1", "port": "7000"}]

try:
	rc = RedisCluster(startup_nodes=startup_nodes, decode_responses=True)
	print("Hey Your cluster is Up!\n")
	rc.set("foo", "bar")
	rc.setex('dead',5,'itsmyvalue')
	while(1):
		k=rc.get('dead')
		if(k==None):
			print("Dead is Dead:)")
			break
		else:
			print("LMAO Dead is Alive in Cluster ! , It also has a value ,Actually value is in bytes to be managed by the user:( -> ",k)
			time.sleep(1)

except:

	print("Hey Caught an Exception --> redis.exceptions.ResponseError: This instance has cluster support disabled !!!")
	print("Read the file creating_cluster.txt to enable cluster or just google it!\n")

