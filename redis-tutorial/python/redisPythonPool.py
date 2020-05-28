# Pool 

import redis
import time
r=redis.Redis(host='localhost', port=6379, db=0)
r.set('foo', 'bar')
r.get('foo')
r.setex('dead',5,'itsmyvalue')
while(1):
	k=r.get('dead')
	if(k==None):
		print("Dead is Dead:)")
		break
	else:
		print("LMAO Dead is Alive ! , It also has a value ,Actually value is in bytes to be managed by the user:( -> ",k)
		time.sleep(1)