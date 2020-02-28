package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {

    public static void main(String [] args) {

        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Instructor.class)
                                 .addAnnotatedClass(InstructorDetail.class)
                                 .addAnnotatedClass(Course.class)
                                 .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{


            Instructor tempInstructor =
                    new Instructor("Klaudia", "Kriva", "klaudia.kriva@akademiasovy.sk");

                    InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://www.klaudia.sk/youtube", "Religion");

            tempInstructor.setInstructorDetail(tempInstructorDetail);



            session.beginTransaction();

            System.out.println("Saving instructor:" + tempInstructor);
            session.save(tempInstructor);



            session.getTransaction().commit();

            System.out.println("Done!");




        }
        finally {
            session.close();
            factory.close();
        }



    }

}
