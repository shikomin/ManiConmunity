package com.wander;

import com.wander.core.utils.KemingCodeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManifoldKnowledgeCommunityApplicationTests {

	//@Autowired
//	private RedisTemplate<String,Object> redisTemplate;

	@Test
	public void contextLoads() {
		String str="keming_xu@163.com";
		String key="abc";

		int sccc=(int)(Math.random()*100000);

		String code=KemingCodeUtil.encode(str+"#div#"+sccc,key);

		System.out.println("原文:"+str+"#div#"+sccc);

		System.out.println("加密:"+code);

		System.out.println("解密:"+KemingCodeUtil.decode(code,key));

		String str2=KemingCodeUtil.decode(code,key);
		String[] strArr=str2.split("#div#");
		System.out.println(Arrays.toString(strArr));


		/**ValueOperations<String,Object> value=redisTemplate.opsForValue();
		value.set("clazz","190201",10, TimeUnit.SECONDS);
		try {
			MailUtil.sendMail("doudoow@163.com","xukeming");
		} catch (Exception e) {
			e.printStackTrace();
		}*/


	}

}
