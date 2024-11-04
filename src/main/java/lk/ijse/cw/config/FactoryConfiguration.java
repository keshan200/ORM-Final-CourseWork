package lk.ijse.cw.config;

import lk.ijse.cw.entity.Program;
import lk.ijse.cw.entity.Register;
import lk.ijse.cw.entity.Student;
import lk.ijse.cw.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.management.relation.Role;

public class FactoryConfiguration {


    private static FactoryConfiguration sessionFactoryConfiguration;

    private SessionFactory session;

    private FactoryConfiguration(){
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Student.class)
                 .addAnnotatedClass(Program.class)
                .addAnnotatedClass(Register.class);

        session = configuration.buildSessionFactory();

    }
    public static FactoryConfiguration getInstance(){
        if (sessionFactoryConfiguration == null){
            sessionFactoryConfiguration = new FactoryConfiguration();
        }
        return sessionFactoryConfiguration;
    }
    public Session getSession() {
        return session.openSession();
    }



}
