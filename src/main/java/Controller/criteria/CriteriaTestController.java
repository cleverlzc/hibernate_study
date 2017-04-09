package Controller.criteria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.sql.JoinType;

import java.util.List;

import entity.criteria.CriteriaStudent;
import entity.criteria.CriteriaTeacher;

/**
 * Created by root on 17-3-8.
 */
public class CriteriaTestController {
    public static void main(String[] args) {
        Configuration cf = new Configuration().configure();
        SessionFactory sf = cf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction ts = session.beginTransaction();
        try {
            //1、整表查询
            /*Criteria c = session.createCriteria(CriteriaTeacher.class);
            List<CriteriaTeacher> list = c.list();
            for (CriteriaTeacher t : list) System.out.println(t.getName());*/

            //2、加入查询条件（通过Criteria的add() 方法和Restrictions的静态方法添加）
            /*Criteria c = session.createCriteria(CriteriaTeacher.class).add(Restrictions.like("name", "%1%"));
            List<CriteriaTeacher> list = c.list();
            for (CriteriaTeacher t : list) System.out.println(t.getName());*/

            //3、关联查询（前提持久化类内部有映射关系）
            //如果需要使用关联实体的属性来增加查询条件，则需再次使用createCriteria() 方法

            //a、默认链接方式
            /*Criteria c = session
                    .createCriteria(CriteriaStudent.class)
                    .add(Restrictions.like("name", "%1%"))
                    .createCriteria("criteriaTeacher")
                    //.createCriteria("criteriaTeacher", "ct")//为关联实体指定别名
                    .add(Restrictions.like("name", "%1%"));
            List<CriteriaStudent> list = c.list();
            for (CriteriaStudent s : list)
                System.out.println("studentName = " + s.getName() + " | teacherName = " + s.getCriteriaTeacher().getName());*/

            //b、指定链接方式
            /*Criteria c = session
                    .createCriteria(CriteriaStudent.class)
                    .add(Restrictions.like("name", "%1%"))
                    .createCriteria("criteriaTeacher", JoinType.LEFT_OUTER_JOIN);//左连接方式
            List<CriteriaStudent> list = c.list();
            for (CriteriaStudent s : list)
                System.out.println("studentName = " + s.getName() + " | teacherName = " + s.getCriteriaTeacher().getName());*/

            //c、也可以使用createAlias（）方法代替createCriteria（）方法
            /*Criteria c = session
                    .createCriteria(CriteriaStudent.class)
                    .add(Restrictions.like("name", "%1%"))
                    .createAlias("criteriaTeacher", "ct")
                    .add(Restrictions.like("ct.name", "%1%"));
            List<CriteriaStudent> list = c.list();
            for (CriteriaStudent s : list)
                System.out.println("studentName = " + s.getName() + " | teacherName = " + s.getCriteriaTeacher().getName());*/

            //4、投影、聚合、分组查询
            //hibernate中使用Projection接口代表投影运算，hibernate通过Criteria的setProjection(Projections p) 方法进行投影运算，其中Projections作为产生Projection的工厂。

            //a、投影运算查询
            /*Criteria c = session
                    .createCriteria(CriteriaStudent.class)
                    .setProjection(Projections.projectionList()
                            .add(Projections.rowCount()));//统计表中记录条数
            System.out.println(c.uniqueResult());*/

            /*Criteria c = session
                    .createCriteria(CriteriaStudent.class)
                    .setProjection(Projections.projectionList()
                            .add(Projections.count("name"))
                            .add(Projections.groupProperty("name")));//据name值分组统计
            List list = c.list();
            for (Object ob : list) {
                Object[] ob1 = (Object[]) ob;
                System.out.println(ob1[1] + " | " + ob1[0]);
            }*/

            /*Criteria c = session
                    .createCriteria(CriteriaStudent.class)
                    .setProjection(Projections.projectionList()
                            .add(Projections.groupProperty("name")));//name去重后列表
            List<String> list = c.list();
            for (String s : list) {
                System.out.println(s);
            }*/

            //用alias() 方法为指定投影指定别名
            /*Criteria c = session
                    .createCriteria(CriteriaStudent.class)
                    .setProjection(Projections.projectionList()
                            .add(Projections.alias(Projections.count("name"), "count"))//指定别名
                            .add(Projections.groupProperty("name")))
                    .addOrder(Order.desc("count"));//用别名排序
            List list = c.list();
            for (Object ob : list) {
                Object[] ob1 = (Object[]) ob;
                System.out.println(ob1[1] + " | " + ob1[0]);
            }*/
            //b、选择查询（指定要查找的列）

            //查询一列
            /*Criteria c = session
                    .createCriteria(CriteriaStudent.class)
                    .setProjection(Projections.projectionList()
                            .add(Property.forName("name")));
            List<String> list = c.list();
            for (String s : list) {
                System.out.println(s);
            }*/

            //查询多列
            /*Criteria c = session
                    .createCriteria(CriteriaStudent.class)
                    .createAlias("criteriaTeacher", "ct")
                    .setProjection(Projections.projectionList()
                            .add(Property.forName("ct.name"))
                            .add(Property.forName("name")));
            List list = c.list();
            for (Object ob : list) {
                Object[] ob1 = (Object[]) ob;
                System.out.println(ob1[1] + " | " + ob1[0]);
            }*/

            //5、离线查询和子查询

            //DetachedCriteria代表离线查询（允许再session范围之外创建一个查询）和子查询（把DetachedCriteria的查询结果传入Criteria中作为查询条件时，DetachedCriteria就变成了子查询）
            DetachedCriteria sub = DetachedCriteria
                    .forClass(CriteriaTeacher.class)
                    .setProjection(Projections.projectionList()
                            .add(Property.forName("id")))
                    .add(Restrictions.like("name", "%1%"));

            Criteria c = session
                    .createCriteria(CriteriaStudent.class)
                    .add(Subqueries.propertyIn("criteriaTeacher", sub));
            List<CriteriaStudent> list = c.list();
            for (CriteriaStudent s : list) {
                System.out.println(s.getName() + " | " + s.getCriteriaTeacher().getName());
            }
            ts.commit();
        } finally {
            session.close();
            sf.close();
        }
    }
}
