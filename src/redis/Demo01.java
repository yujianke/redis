package redis;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class Demo01 {
	
	public static void main(String[] args) {
		
		  //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.44.129");
        // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
        // jedis.auth("123456"); 
        System.out.println("服务正在运行: "+jedis.ping());
     /*   
        
        String set = jedis.set("k1", "k2");
        System.out.println(set);*/
        
        Set<String> keys = jedis.keys("ke*");
        
        Iterator<String> iterator = keys.iterator();
        
        while(iterator.hasNext()){
        	System.out.println(iterator.next());
        }
		
	}

}
