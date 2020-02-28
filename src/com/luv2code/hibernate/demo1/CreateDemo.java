package com.luv2code.hibernate.demo1;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {

    public static void main(String [] args) {

        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Instructor.class)
                                 .addAnnotatedClass(InstructorDetail.class)
                                 .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            //Instructor tempInstructor =
                    //new Instructor("Roman", "Spak", "roman.spak@akademiasovy.sk");

            //InstructorDetail tempInstructorDetail =
                    //new InstructorDetail("http://www.akademiasovy.sk/youtube", "Akademia sovy!");

            Instructor tempInstructor =
                    new Instructor("Jan", "Pavuk", "jan.pavuk@akademiasovy.sk");

                    InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://www.jano.sk/youtube", "Gymnastic!");

            tempInstructor.setInstructorDetail(tempInstructorDetail);



            session.beginTransaction();

            System.out.println("Saving instructor:" + tempInstructor);
            session.save(tempInstructor);



            session.getTransaction().commit();

            System.out.println("Done!");




        }
        finally {
            factory.close();
        }



    }

}
