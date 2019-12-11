package servlet;

import hibernate.model.Employee;
import hibernate.util.HibernateUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        HibernateUtil dbh = null;
        try {
            out = response.getWriter();
            String eName = request.getParameter("emp_name");
            String eSurname = request.getParameter("emp_surname");
            String eWage = request.getParameter("emp_wage");
            String pName = request.getParameter("proj_name");
            String pTechnology = request.getParameter("proj_technology");
            String depName = request.getParameter("dep_name");
            String depBudget = request.getParameter("dep_budget");
//            out.println("Following have been injected in database:\n");
//            out.println("Name: " + eName);
//            out.println("Surname: " + eSurname);
//            out.println("Wage: " + eWage);
//            out.println("Project: " + pName);
//            out.println("Technology: " + pTechnology);
//            out.println("Department name: " + depName);
//            out.println("Department budget: " + depBudget);
//            out.println("\n\\n");

            dbh = new HibernateUtil();
//            dbh.addEmployee(eName, eSurname, Double.parseDouble(eWage), pName, pTechnology);
//            dbh.addDepartment(depName, Double.parseDouble(depBudget));
//            dbh.addProject(pName, pTechnology);
//              out.println(dbh.updateProject(pTechnology));
//            get all employees
//            List<String> info = dbh.getEmployees();
//            for (String empInfo : info ) {
//                out.println(empInfo);
//            }

//            get all projects
//            List<String> info = dbh.getProjects();
//            for (String projInfo : info) {
//                out.println(projInfo);
//            }

//            get employee by id
//            List<String> info = dbh.getEmployeeById(20);
//            for (String empInfo : info) {
//                out.println(empInfo);
//            }

//            addBuildings
//            dbh.addBuildings();


//            out.println(dbh.cacheBehavior());
//            out.println(dbh.loadEntity());

//            dbh.removeEntity(Class.forName("hibernate.model.Employee"), 51);
//            dbh.updateEmployeeName(48, "Cineva");

//            list employees with wage < 150
//            List<Employee> employees = dbh.getEmployeeWithWageLessThan(new Double(150));
//            for (Employee employee : employees) {
//                out.println(employee.toString());
//            }

            //add a shop
            dbh.addShop("Carrefour", "Chimiei", 10);
            out.println("\n\\n");
        } catch (IOException e) {
            dbh.closeEntityManagerFactory();
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }
    }
}