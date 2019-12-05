package hibernate.util;

import hibernate.model.*;

import javax.persistence.*;
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

            Employee employee = new Employee();
            employee.setName(name);
            employee.setSurname(surname);
            employee.setWage(wage);
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
            Employee employee0 = new Employee();
            employee0.setName("Employee");
            employee0.setSurname("One");
            employee0.setWage(15.0);
            Employee employee1 = new Employee();
            employee0.setName("Employee");
            employee0.setSurname("Two");
            employee0.setWage(25.0);
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
            Employee employee0 = new Employee();
            employee0.setName("Employee");
            employee0.setSurname("One");
            employee0.setWage(15);
            Employee employee1 = new Employee();
            employee0.setName("Employee");
            employee0.setSurname("Two");
            employee0.setWage(25);
            Employee employee2 = new Employee();
            employee0.setName("Employee");
            employee0.setSurname("Three");
            employee0.setWage(35);
            Employee employee3 = new Employee();
            employee0.setName("Employee");
            employee0.setSurname("Four");
            employee0.setWage(45);
            Employee employee4 = new Employee();
            employee0.setName("Employee");
            employee0.setSurname("Five");
            employee0.setWage(55);
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

            javax.persistence.Query query = manager.createNamedQuery("Employee.findById");
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

            Factory factory1 = new Factory();
            factory1.setName("Factory1");
            factory1.setOwner("Owner1");
            factory1.setManager("Manager1");
            Factory factory2 = new Factory();
            factory2.setName("Factory2");
            factory2.setOwner("Owner2");
            factory2.setManager("Manager2");

            School school1 = new School();
            school1.setName("School1");
            school1.setOwner("Owner3");
            school1.setPrincipal("Principal1");
            School school2 = new School();
            school2.setName("School2");
            school2.setOwner("Owner4");
            school2.setPrincipal("Principal2");

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

    public String cacheBehavior() {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            Employee employee = new Employee();
            employee.setName("Employee1");
            employee.setSurname("Random");
            employee.setWage(150);
            Building building = new Building();
            building.setName("Building1");
            building.setOwner("Cineva");

            manager.persist(employee);
            manager.persist(building);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
        return printCacheState();
    }

    public String loadEntity() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        Employee employee = em.find(Employee.class, 40);
        System.out.println("Employee loaded: " + employee);
        Building building = em.find(Building.class, 11);
        System.out.println("Building loaded: " + building);
        em.close();
        return printCacheState();
    }

    public String printCacheState() {
        Cache cache = ENTITY_MANAGER_FACTORY.getCache();
        boolean eContains = cache.contains(Employee.class, 22);
        boolean bContains = cache.contains(Building.class, 11);
        return "Cache#contains() for Employee: " + eContains + "\n" + "Cache#contains() for Building: " + bContains;
    }

    public void closeEntityManagerFactory() {
        ENTITY_MANAGER_FACTORY.close();
    }
}
