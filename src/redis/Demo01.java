package redis;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class Demo01 {
	
	public static void main(String[] args) {
		
		  //���ӱ��ص� Redis ����
        Jedis jedis = new Jedis("192.168.44.129");
        // ��� Redis �������������룬��Ҫ�������У�û�оͲ���Ҫ
        // jedis.auth("123456"); 
        System.out.println("������������: "+jedis.ping());
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
