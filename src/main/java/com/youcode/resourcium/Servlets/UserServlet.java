package com.youcode.resourcium.Servlets;

import com.youcode.resourcium.Entities.Departement;
import com.youcode.resourcium.Entities.Role;
import com.youcode.resourcium.Entities.Tache;
import com.youcode.resourcium.Entities.User;
import com.youcode.resourcium.Exceptions.UserAlreadyExistsException;
import com.youcode.resourcium.Service.DepartementService;
import com.youcode.resourcium.Service.TacheService;
import com.youcode.resourcium.Service.UserService;
import com.youcode.resourcium.repository.DepartementRepository;
import com.youcode.resourcium.repository.TacheRepository;
import com.youcode.resourcium.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet(urlPatterns = {"/users" , "/addEmployee" , "/removeEmployee" , "/removeUser" ,"/updateEmployee" ,"/assignTaskToEmployee","/getTasks"})
public class UserServlet extends HttpServlet {
    private EntityManagerFactory entityManagerFactory;
    private UserService userService;
    private  DepartementService departmentService;
    private TacheService tacheService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        UserRepository userRepository = new UserRepository(entityManagerFactory);
        userService = new UserService(userRepository);
        DepartementRepository departementRepository = new DepartementRepository(entityManagerFactory);
        departmentService = new DepartementService(departementRepository);
        TacheRepository tacheRepository = new TacheRepository(entityManagerFactory);
        tacheService = new TacheService(tacheRepository);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            List<User> employees = userService.getAllEmployees();
            req.setAttribute("employees", employees);
            List<Departement> departments = departmentService.getAllDepartements();
            req.setAttribute("departments", departments);
            req.setAttribute("url","users");
            req.getRequestDispatcher("home.jsp").forward(req, resp);

        } else {
            resp.sendRedirect("login.jsp"); // Redirect to the login page if the user is not logged in
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/removeUser") && req.getMethod().equals("POST")) {
            Long id = Long.parseLong(req.getParameter("EmpId"));
            userService.deleteUser(id);
            List<User> employees = userService.getAllEmployees();
            req.setAttribute("employees", employees);
            resp.sendRedirect("users");
        }else if(path.equals("/updateEmployee") && req.getMethod().equals("POST")){
            Long id = Long.parseLong(req.getParameter("EmpIdUpdate"));
            String Fname = req.getParameter("first-name-update");
            String Lname = req.getParameter("last-name-update");
            String Username = req.getParameter("username-update");
            String email = req.getParameter("email-update");
            String Phone = req.getParameter("number-update");
            String departmentId = req.getParameter("dep-id");

            // Assuming you have a method to retrieve the Departement by its ID
            Departement department = departmentService.getDepartementById(Long.parseLong(departmentId));

            User user = userService.getUserById(id);
            user.setEmail(email);
            user.setFirstName(Fname);
            user.setLastName(Lname);
            user.setNumberPhone(Phone);
            user.setUsername(Username);
            user.setDepartement(department);

            userService.updateUser(user);

            List<User> employees = userService.getAllEmployees();
            req.setAttribute("employees", employees);
            resp.sendRedirect("users");
         }else if (path.equals("/assignTaskToEmployee") && req.getMethod().equals("POST")) {
            String title = req.getParameter("task-title");
            String description = req.getParameter("task-description");
            String deadlineString = req.getParameter("task-deadline");
            String priority = req.getParameter("task-priority"); // Assuming priority is a String
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String status = "pending";
            Date deadline = null;
            try {
                deadline = formatter.parse(deadlineString);
            } catch (ParseException e) {
                e.printStackTrace(); // Handle or log the exception as needed
            }
            Long employeeId = Long.parseLong(req.getParameter("employee-id"));

            // Retrieve the employee by ID using the employeeId
            User employee = userService.getUserById(employeeId);

            // Create a new task and set its details
            Tache task = new Tache();
            task.setTitle(title);
            task.setDescription(description);
            task.setDeadline(deadline);
            task.setPriority(priority);
            task.setAssignedEmployee(employee);
            task.setStatus(status);

            tacheService.saveTask(task);

            // Assign the task to the employee
            employee.addTask(task);

            userService.updateUser(employee);

            List<User> employees = userService.getAllEmployees();
            req.setAttribute("employees", employees);
            resp.sendRedirect("users");

        }else if(path.equals("/getTasks") && req.getMethod().equals("GET")){
            String employeeIdString = req.getParameter("employeeId");
            Long employeeId = Long.parseLong(employeeIdString);

            List<Tache> tasks = tacheService.getTasksByEmployeeId(employeeId);

            req.setAttribute("tasks", tasks);
            List<User> employees = userService.getAllEmployees();
            req.setAttribute("employees", employees);
            resp.sendRedirect("users");

        }else if(path.equals("/addEmployee") && req.getMethod().equals("POST")){
            String firstName = req.getParameter("first-name");
            String lastName = req.getParameter("last-name");
            String username = req.getParameter("username-add");
            String departmentId = req.getParameter("dep_id");
            String email = req.getParameter("email-add");
            String password = req.getParameter("password-add");
            String phone = req.getParameter("phone-add");
            Long dep = Long.parseLong(departmentId);

           Departement department =  departmentService.getDepartementById(dep);

            EntityManager entityManager = entityManagerFactory.createEntityManager();
            Role role = entityManager.find(Role.class, 1L);
            entityManager.close();
            User u = new User(firstName,lastName,username,department,email,password,phone);
            u.setRole(role);

            try {
                userService.addNewUser(u);

            } catch (UserAlreadyExistsException e) {
                throw new RuntimeException(e);
            }

            List<User> employees = userService.getAllEmployees();
            req.setAttribute("employees", employees);
            resp.sendRedirect("users");


        }

    }
}
