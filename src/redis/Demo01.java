package redis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class Demo01 {
	
	public static void main(String[] args) {
		
		  //���ӱ��ص� Redis ����
        Jedis jedis = new Jedis("192.168.44.130");
        // ��� Redis �������������룬��Ҫ�������У�û�оͲ���Ҫ
        // jedis.auth("123456"); 
        System.out.println("������������: "+jedis.ping());
     /*   
        
        String set = jedis.set("k1", "k2");
        System.out.println(set);*/
        
       /* Set<String> keys = jedis.keys("ke*");
        
        Iterator<String> iterator = keys.iterator();
        
        while(iterator.hasNext()){
        	System.out.println(iterator.next());
        }*/
        
        /**
         * redis�����ַ���
         * */
        jedis.set("name", "yjk");
        System.out.println(jedis.get("name"));
        jedis.append("name", "lxr");
        System.out.println(jedis.get("name"));
        jedis.mset("age","10","qq","123");
        System.out.println(jedis.get("qq"));
        jedis.incr("age");
        System.out.println(jedis.get("age"));
        
        /**redis ����  hash    map*/
        Map<String,String> map = new HashMap<String,String>();
        map.put("name", "lxr");
        map.put("age", "22");
        map.put("sex", "1");
        jedis.hmset("user", map);
        
        List<String> hmget = jedis.hmget("user", "name","age");
        for (String string : hmget) {
			System.out.println(string);
		}
        //ɾ��map�е�ĳ����ֵ
        jedis.hdel("user","age" );
        System.out.println(jedis.hget("user", "age"));
        System.out.println(jedis.hlen("user"));
        System.out.println(jedis.exists("user"));
        System.out.println(jedis.hkeys("user"));
        System.out.println(jedis.hvals("user"));
        
        Iterator<String> it= jedis.hkeys("user").iterator();
        while(it.hasNext()){
        	String key = it.next();
        	System.out.println(key+":"+jedis.hget("user", key));
        }
        /**jedis����list*/
        
        
        jedis.del("java");
        jedis.lpush("java", "1");
        jedis.lpush("java", "2");
        jedis.lpush("java", "3");
        System.out.println(jedis.lrange("java", 0, -1));
        
        
        jedis.del("net");
        jedis.rpush("net", "1");
        jedis.rpush("net", "2");
        jedis.rpush("net", "3");
        System.out.println(jedis.lrange("net", 0, -1));
        String lpop = jedis.lpop("java");
        System.out.println(lpop);
        
        /**jedis ����set*/
        jedis.sadd("set01", "s1");
        jedis.sadd("set01", "s2");
        jedis.sadd("set01", "s3");
        jedis.sadd("set01", "s4");
        System.out.println(jedis.scard("set01"));
        jedis.srem("set01", "s1");
        System.out.println(jedis.scard("set01"));
        System.out.println(jedis.smembers("set01"));
        System.out.println(jedis.sismember("set01", "s1"));
        System.out.println(jedis.srandmember("set01"));
        /**jedis����*/
        jedis.del("a");
        jedis.rpush("a", "1");
        jedis.lpush("a", "4");
        jedis.lpush("a", "5");
        jedis.lpush("a", "2");
        
        System.out.println(jedis.lrange("a", 0, -1));
        System.out.println(jedis.sort("a"));
        System.out.println(jedis.lrange("a",0,-1));  
        
        
        
        
        
        
	}

}
