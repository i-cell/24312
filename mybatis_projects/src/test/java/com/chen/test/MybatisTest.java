package com.chen.test;

import com.chen.Dao.IUsersDao;
import com.chen.pojo.QueryVo;
import com.chen.pojo.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    InputStream re;
    SqlSessionFactoryBuilder sq;
    SqlSessionFactory build;
    SqlSession sqlSession;
    IUsersDao mapper;


    @Test
    public void testFindOne(){
        Users byId = mapper.findById(1);
        System.out.println(byId);
    }
        @Test
        public void testSave(){
            Users users = new Users();
            users.setUsername("陈小姐");
            users.setSex("女");
            users.setBirthday(new Date());
            users.setAddress("成都");
            int i = mapper.saveUsers(users);
            sqlSession.commit();
            if (i == 0){
                System.out.println("失败");
            }else {
                System.out.println("成功");
            }
        }

        @Test
        public void testFindByName(){
            List<Users> byName = mapper.findByName("%陈%");
            for (Users users : byName){
                System.out.println(users);
            }
        }

@Test
public void testFindByQueryVo(){
    Users users = new Users();
    QueryVo queryVo = new QueryVo();
    users.setUsername("%陈%");
    queryVo.setUsers(users);
    List<Users> byVo = mapper.findByVo(queryVo);
    for (Users users1:byVo){
        System.out.println(users1);
    }
}


    @Before
    public void init() throws IOException {
         re = Resources.getResourceAsStream("SqlMapConfig.xml");
         sq = new SqlSessionFactoryBuilder();
         build = sq.build(re);
         sqlSession = build.openSession();
         mapper = sqlSession.getMapper(IUsersDao.class);
    }
    @After
    public void destroy() throws IOException {
        sqlSession.close();
        re.close();
    }

}
