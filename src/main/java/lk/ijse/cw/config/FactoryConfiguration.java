package lk.ijse.cw.config;

import lk.ijse.cw.entity.Program;
import lk.ijse.cw.entity.Register;
import lk.ijse.cw.entity.Student;
import lk.ijse.cw.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.management.relation.Role;
import java.io.IOException;
import java.util.Properties;

public class FactoryConfiguration {


    private static FactoryConfiguration sessionFactoryConfiguration;

    private SessionFactory session;

    private FactoryConfiguration() throws IOException {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();

        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
        configuration.setProperties(properties);
           configuration.addAnnotatedClass(User.class);
           configuration.addAnnotatedClass(Student.class);
           configuration.addAnnotatedClass(Program.class);
           configuration.addAnnotatedClass(Register.class);

        session = configuration.buildSessionFactory();

    }
    public static FactoryConfiguration getInstance(){
        if (sessionFactoryConfiguration == null){
            try {
                sessionFactoryConfiguration = new FactoryConfiguration();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sessionFactoryConfiguration;
    }
    public Session getSession() {
        return session.openSession();
    }



}
