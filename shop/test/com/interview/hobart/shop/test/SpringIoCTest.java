package com.interview.hobart.shop.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.interview.hobart.shop.dao.AccountDao;
import com.interview.hobart.shop.dao.CategoryDao;
import com.interview.hobart.shop.entity.CategoryInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class SpringIoCTest {
	// @Resource
	// Date date;
	@Resource
	private CategoryDao categoryDao;
	// @Resource
	// private AccountDao accountDao;
	//

	// @Test // 测试Spring IOC的开发环境
	// public void springIoc() {
	// System.out.println(date);
	// }

	// @Test // 测试Hibernate和Spring整合后
	// public void hibernateAndSpring() {
	// System.out.println(categoryDao);
	// categoryDao.save(new CategoryInfo(accountDao.get(2), "休闲女式", true)); //
	// categoryService通过Spring从上面注入进来的
	// }
	//
	@Test
	public void testQueryJoinAccount() {
		for (CategoryInfo c : categoryDao.queryJoinAccount("", 1, 2)) { // 显示第一页，每页2条数据
			System.out.println(c + "," + c.getAccount());
		}
	}

}
