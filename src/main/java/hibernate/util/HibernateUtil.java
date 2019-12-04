package hibernate.util;

import hibernate.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class HibernateUtil {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("Employee");

    public void addEmployee(String name, String surname, Double wage, String pName, String pTechnology) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            Employee employee = new Employee(name, surname, wage);
            Project project = new Project(pName, pTechnology);
//            employee.setProject(project);
//            project.setEmployee(employee);
            manager.persist(employee);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }

    public void addDepartment(String name, Double budget) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            Department department = new Department(name, budget);
            Employee employee0 = new Employee("Employee", "One", 15.0, department);
            Employee employee1 = new Employee("Employee", "Two", 25.0, department);
            department.setEmployees(new HashSet<>(Arrays.asList(employee0, employee1)));
            manager.persist(department);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }

    public void addProject(String name, String technology) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            Project project = new Project(name, technology);
            Employee employee0 = new Employee("Employee", "One", 15.0);
            Employee employee1 = new Employee("Employee", "Two", 25.0);
            Employee employee2 = new Employee("Employee", "Three", 25.0);
            Employee employee3 = new Employee("Employee", "Four", 25.0);
            Employee employee4 = new Employee("Employee", "Five", 25.0);
            project.setEmployees(new HashSet<>(Arrays.asList(employee0, employee1, employee2, employee3, employee4)));
            manager.persist(project);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }

    public List<String> getEmployees() {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<String> info = new ArrayList<>();

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            javax.persistence.Query query = manager.createQuery("from Employee");
            List<Employee> employees = query.getResultList();
            for (Employee emp : employees) {
                StringBuilder out = new StringBuilder();
                out.append(emp.getName());
                out.append(" ");
                out.append(emp.getSurname());
                out.append(" with a wage of ");
                out.append(emp.getWage());
                info.add(out.toString());
            }

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
        return info;
    }

    public List<String> getProjects() {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<String> info = new ArrayList<>();

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            javax.persistence.Query query = manager.createQuery("from Project");
            List<Project> projects = query.getResultList();
            for (Project proj : projects) {
                StringBuilder out = new StringBuilder();
                out.append("Project ");
                out.append(proj.getName());
                out.append(" using ");
                out.append(proj.getTechnology());
                info.add(out.toString());
            }

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
        return info;
    }

    public List<String> getEmployeeById(int id) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        List<String> info = new ArrayList<>();

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            javax.persistence.Query query = manager.createNamedQuery("find employee by id");
            query.setParameter("id", id);
            List<Employee> employees = query.getResultList();
            for (Employee emp : employees) {
                StringBuilder out = new StringBuilder();
                out.append("Employee ");
                out.append(emp.getName());
                out.append(" ");
                out.append(emp.getSurname());
                out.append(" with a wage of ");
                out.append(emp.getWage());
                out.append(" and ID = ");
                out.append(emp.getId());
                info.add(out.toString());
            }

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
        return info;
    }

    public void addBuildings() {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            Factory factory1 = new Factory("Factory1", "Owner1", "Manager1");
            Factory factory2 = new Factory("Factory2", "Owner2", "Manager2");

            School school1 = new School("School1", "Owner3", "Principal1");
            School school2 = new School("School2", "Owner4", "Principal2");

            manager.persist(factory1);
            manager.persist(factory2);
            manager.persist(school1);
            manager.persist(school2);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }

    public void closeEntityManagerFactory() {
        ENTITY_MANAGER_FACTORY.close();
    }
}
