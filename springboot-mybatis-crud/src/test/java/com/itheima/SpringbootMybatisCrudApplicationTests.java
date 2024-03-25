package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

	@Autowired
	private EmpMapper empMapper;
	@Test
	public void testDelete() {
		empMapper.deleteById(17);
	}

	@Test
	public void testInsert() {
		Emp emp = new Emp();
        emp.setUsername("test1");
        emp.setName("test1");
        emp.setGender((short)1);
        emp.setImage("test");
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2001, 1, 17));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

		empMapper.insertEmp(emp);
		System.out.println(emp.getId());
	}

	@Test
	public void testUpdate() {
		Emp emp = new Emp();
		emp.setId(18);
        emp.setUsername("update");
        emp.setName("update");
        emp.setGender((short)1);
        emp.setImage("test");
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2001, 1, 17));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

		empMapper.updateEmp(emp);
	}

	@Test
	public void testSelect() {
		Emp emp = empMapper.selectById(18);
        System.out.println(emp);
	}

	@Test
	public void testList(){
		List<Emp> empList = empMapper.list(null, null, null, null);

//		List<Emp> empList = empMapper.list("张", (short)1, LocalDate.of(2001,1,1), LocalDate.of(2020,1,1));
		System.out.println(empList);
	}

	@Test
	public void testUpdate2() {
		Emp emp = new Emp();
		emp.setId(19);
        emp.setUsername("update2");
        emp.setName("update2");
        emp.setGender((short)2);
        emp.setUpdateTime(LocalDateTime.now());

		empMapper.updateEmp2(emp);
	}

	//批量删除18，19，20号员工信息
	@Test
	public void testDelteByIds() {
		List<Integer> ids = Arrays.asList(18, 19, 20);
		empMapper.deleteByIds(ids);
	}
}
