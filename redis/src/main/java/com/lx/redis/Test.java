package com.lx.redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.*;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.HashMap;
import java.util.Map;


public class Test {

	
	public static void main(String[] args) {
		// org.springframework.context.support.ClassPathXmlApplicationContext
		ClassPathXmlApplicationContext appCtx = new ClassPathXmlApplicationContext("classpath:spring-redis.xml");
		
		final RedisTemplate<String, Object> redisTemplate = appCtx.getBean("redisTemplate", RedisTemplate.class);



		ZSetOperations<String,Object> zset = redisTemplate.opsForZSet();

		zset.add("embrace_rank","oV7xduHG6RFxXVCpl2X6u3iuMFIA",63);
		zset.add("embrace_rank","oV7xduBCS668ugl-5NfsFsa4XyFQ",64);
		zset.add("embrace_rank","oV7xduN-mEwahFDil5rKhaW8Pzk4",65);
		zset.add("embrace_rank","oV7xduOIf-KKi6Vxj_n5DSbH5z38",66);
		zset.add("embrace_rank","oV7xduKiPKGSgSx0PpSXiDejK444",67);
		zset.add("embrace_rank","oV7xduI1n_TgZZUkbS7lqYml9ymw",68);
		zset.add("embrace_rank","oV7xduCJmnMhqKZ6RDCsD_kgSI9w",69);
		zset.add("embrace_rank","oV7xduFl5OfhooIWtrplFIXaY0KQ",70);
		zset.add("embrace_rank","oV7xduEBG9UpJ4Mxt7z_91yeloTI",71);
		zset.add("embrace_rank","oV7xduGKMijkxJfnbN5bnxlTLmwM",72);
		zset.add("embrace_rank","oV7xduA4UExjC2BLrdlB_aVSxw4g",73);
		zset.add("embrace_rank","oV7xduGTOhREHTYR_mGPLcTIoJ00",74);
		zset.add("embrace_rank","oV7xduKOoVfsgppM2GcHmijpRNEQ",75);
		zset.add("embrace_rank","oV7xduDHHZsjmmGOUL1Pg6npsRbA",76);
		zset.add("embrace_rank","oV7xduKvKTwcQcQkSN0aRyuSxy08",77);
		zset.add("embrace_rank","oV7xduFEVRIhiqq7f3UJFl2GheQs",78);
		zset.add("embrace_rank","oV7xduLpZeXXR4QSUIaigrJgK1sU",79);
		zset.add("embrace_rank","oV7xduBHrqw4ZpYFuVZoa_g1qIHg",80);
		zset.add("embrace_rank","oV7xduO5jzf2HwMgaOIr9cUO6UG0",81);
		zset.add("embrace_rank","oV7xduL-nzJOHLCrfZhQr9_iC14s",82);
		zset.add("embrace_rank","oV7xduO4fNeZs_NOZRN-CDu6F9LQ",83);
		zset.add("embrace_rank","oV7xduMuOSlmfTG__sA92kXUhP34",84);

		// 添加一个 key
		/*ValueOperations<String, Object> value = redisTemplate.opsForValue();
		value.set("lp", "hello word");
		// 获取 这个 key 的值
		System.out.println(value.get("lp"));
		// 添加 一个 hash集合
		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "lp");
		map.put("age", "26");
		hash.putAll("lpMap", map);
		// 获取 map
		System.out.println(hash.entries("lpMap"));
		// 添加 一个 list 列表
		ListOperations<String, Object> list = redisTemplate.opsForList();
		list.rightPush("lpList", "lp");
		list.rightPush("lpList", "26");
		// 输出 list
		System.out.println(list.range("lpList", 0, 1));
		// 添加 一个 set 集合
		SetOperations<String, Object> set = redisTemplate.opsForSet();
		set.add("lpSet", "lp");
		set.add("lpSet", "26");
		set.add("lpSet", "178cm");
		// 输出 set 集合
		System.out.println(set.members("lpSet"));
		// 添加有序的 set 集合
		ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
		zset.add("lpZset", "lp", 0);
		zset.add("lpZset", "26", 1);
		zset.add("lpZset", "178cm", 2);
		// 输出有序 set 集合
		System.out.println(zset.rangeByScore("lpZset", 0, 2));*/
	}
}
