package Controller.hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

import entity.hql.HQLStudent;
import entity.hql.HQLTeacher;
import entity.hql.StudentTeacher;


/**
 * Created by root on 17-4-8.
 */
public class HQLTestController {
    public static void main(String[] args) {
        Configuration cf = new Configuration().configure();
        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction ts = session.beginTransaction();
        try {
            //1、from子句
            /*String hql = "from HQLTeacher";
            Query query = session.createQuery(hql);
            List<HQLTeacher> list = query.list();
            for (HQLTeacher t : list) System.out.println(t.getName());*/
            //from后面还可以出现多个持久化类，此时将产生一个笛卡尔积或跨表的连接

            //a、笛卡尔积
            /*String hql = "from HQLTeacher,HQLStudent";
            Query query = session.createQuery(hql);
            List list = query.list();
            int i = 0;
            for (Object t : list) {//此时t时长度为2的数组
                Object[] ob = (Object[]) t;
                HQLTeacher ht = (HQLTeacher) ob[0];
                HQLStudent hs = (HQLStudent) ob[1];
                System.out.println(++i + " : " + ht.getName() + " | " + hs.getName());//结果条数为teacher和student条数的积
            }*/

            //b、连接
            /*String hql = "from HQLTeacher as t,HQLStudent as s where t.id = s.hqlTeacher";//hqlTeacher为Teacher在Student中的关联，如果没有关联映射填写相应关联键的名称即可
            Query query = session.createQuery(hql);
            List list = query.list();
            int i = 0;
            for (Object t : list) {
                Object[] ob = (Object[]) t;
                HQLTeacher ht = (HQLTeacher) ob[0];
                HQLStudent hs = (HQLStudent) ob[1];
                System.out.println(++i + " : " + ht.getName() + " | " + hs.getName());
            }*/
            //在实际开发中用到跨表连接时，通常会选择使用隐式或显式连接，而不是在from后紧跟多个持久话类。

            //2、关联和连接（前提持久化类内部做了映射关联）
            //HQL支持两种关联连接：隐式和显式
            //a、隐式（不使用join关键字，使用英文.来隐式连接关联实体）
            /*String hql = "from HQLStudent as s where s.hqlTeacher.name = :name";
            Query query = session.createQuery(hql);
            query.setString("name", "teacher 1");//此时只取得name为teacher 1的student列
            List<HQLStudent> list = query.list();
            for (HQLStudent s : list) {
                System.out.println(s.getName() + " | " + s.getHqlTeacher().getName());
            }*/
            //上述代码中用到了占位符(:name)，HQL提供两种占位符方式：英文问号+索引形式（?N）和名字前面加冒号（:参数名）

            //b、显式
            /*String hql = "from HQLStudent as s inner join s.hqlTeacher";//显式关联的并不是对方的持久化类，而是对方持久化类在本类中的关联实体，并省去了sql语句中关联条件（on后面内容）
            Query query = session.createQuery(hql);
            List list = query.list();//同隐式关联不同，此时结果集中存储的为被查询持久化对象和关联持久化对象所组成的Object数组对象
            int i = 0;
            for (Object t : list) {
                Object[] ob = (Object[]) t;
                HQLStudent hs = (HQLStudent) ob[0];
                HQLTeacher ht = (HQLTeacher) ob[1];
                System.out.println(++i + " : " + ht.getName() + " | " + hs.getName());
            }*/
            //同sql关联一样，显式关联有四种，inner join（内连接）、left join（左连接）、right join（右lianjie）、full join（外连接）

            //3、select子句
            //select用于选择指定属性或直接选择某个实体

            //a、select后只有一项
            /*String hql = "select s.name from HQLStudent as s";
            Query query = session.createQuery(hql);
            List<String> list = query.list();//此时结果集是属性对应的集合
            int i = 0;
            for (String s : list) {
                System.out.println(++i + " : " + s);
            }*/

            //b、select后有多项
            /*String hql = "select s.name,s.hqlTeacher.name from HQLStudent as s";
            Query query = session.createQuery(hql);
            List list = query.list();//此时的结果集的元素为选择项组成的数组
            int i = 0;
            for (Object ob : list) {
                Object[] ob1 = (Object[]) ob;
                System.out.println(++i + " : " + ob1[0] + " | " + ob1[1]);
            }*/

            //c、select也支持将选择出的属性存入一个List对象
            /*String hql = "select new list(s.name,s.hqlTeacher.name) from HQLStudent as s";//通过new list（）实现
            Query query = session.createQuery(hql);
            List<List> list = query.list();
            int i = 0;
            for (List ob : list) {
                System.out.println(++i + " : " + ob.get(0) + " | " + ob.get(1));
            }*/

            //d、select也支持将选择出的属性直接封装成对象
            String hql = "select new entity.hql.StudentTeacher(s.name as studentName,s.hqlTeacher.name as teacherName) from HQLStudent as s";
            Query query = session.createQuery(hql);
            List<StudentTeacher> list = query.list();
            int i = 0;
            for (StudentTeacher st : list) {
                System.out.println(++i + " : " + st.getStudentName() + " | " + st.getTeacherName());
            }
            ts.commit();
        } finally {
            session.close();
            sf.close();
        }
    }
}
