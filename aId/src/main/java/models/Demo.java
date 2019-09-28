package models;

import java.util.ArrayList;
import java.util.List;

import dao.RoleDAO;
import dao.TourDAO;
import dao.TourUserDAO;
import dao.UserDAO;
import impl.DefaultTourDAO;
import impl.DefaultTourUserDAO;
import impl.DefaultUserDAO;
import impl.DefaultRoleDAO;

public class Demo {
    public static void main(String[] args) {
        UserDAO userDao = new DefaultUserDAO();
        TourDAO tourDao = new DefaultTourDAO();
        RoleDAO roleDao = new DefaultRoleDAO();
        TourUserDAO tourUserDao = new DefaultTourUserDAO();

        List<UserData> allUsers = new ArrayList<>();
        List<TourData> allTours = new ArrayList<>();
        List<RoleData> allRoles = new ArrayList<>();
        List<TourUserData> allToursUsers = new ArrayList<>();

        UserData userData = userDao.getUserById(1);
        System.out.println(userData);

        System.out.println("------------------------");

        allUsers = userDao.getAllUsers();
        for (UserData userDataFromList : allUsers) {
            System.out.println(userDataFromList);
        }

        System.out.println("------------------------");

        UserData myUser = new UserData("firstName", "lastName", "dateBirthday", "email", "password", 0, 3);
        boolean insertUserResult = userDao.saveUser(myUser);

        System.out.println("------------------------");

        boolean deleteUserResult = userDao.deleteUser(7);

        System.out.println("------------------------");

        boolean updateUserResult = userDao.updateUser(5, "new_email@gmail.com");

        System.out.println("------------------------");

        allUsers = userDao.getAllUsers();
        for (UserData userDataFromList : allUsers) {
            System.out.println(userDataFromList);
        }

        System.out.println("============================");

        TourData tourData = tourDao.getTourById(1);
        System.out.println(tourData);

        System.out.println("------------------------");

        allTours = tourDao.getAllTours();
        for (TourData tourDataFromList : allTours) {
            System.out.println(tourDataFromList);
        }

        System.out.println("------------------------");

        TourData myTour = new TourData("title", "description", "dateTour", 100.0, "hotel");
        boolean insertTourResult = tourDao.saveTour(myTour);
        
        System.out.println("------------------------");

        boolean deleteTourResult = tourDao.deleteTour(7);

        System.out.println("------------------------");

        boolean updateTourResult = tourDao.updateTour(5, 1_000_000.0);

        System.out.println("------------------------");

        allTours = tourDao.getAllTours();
        for (TourData tourDataFromList : allTours) {
            System.out.println(tourDataFromList);
        }
        
        System.out.println("============================");
        
        RoleData roleData = roleDao.getRoleById(1);
        
        System.out.println(roleData);

        System.out.println("------------------------");

        allRoles = roleDao.getAllRoles();
        for (RoleData roleDataFromList : allRoles) {
            System.out.println(roleDataFromList);
        }

        System.out.println("------------------------");

        RoleData myRole = new RoleData("roleName", "discount");
        boolean insertRoleResult = roleDao.saveRole(myRole);
        
        System.out.println("------------------------");

        boolean deleteRoleResult = roleDao.deleteRole(7);

        System.out.println("------------------------");

        boolean updateRoleResult = roleDao.updateRole(6, "10%");

        System.out.println("------------------------");
        
        allRoles = roleDao.getAllRoles();
        for (RoleData roleDataFromList : allRoles) {
            System.out.println(roleDataFromList);
        }
        
        System.out.println("============================");
        
        TourUserData tourUserData = tourUserDao.getTourUserByIdTourAndByIdUser(2,1);
        
        System.out.println(tourUserData);

        System.out.println("------------------------");

        allToursUsers = tourUserDao.getAllToursUsers();
        for (TourUserData tourUserDataFromList : allToursUsers) {
            System.out.println(tourUserDataFromList);
        }

        System.out.println("------------------------");

        TourUserData myTourUser = new TourUserData(1001, 2001);
        boolean insertTourUserResult = tourUserDao.saveTourUser(myTourUser);
        
        System.out.println("------------------------");
        
        boolean updateTourUserResult = tourUserDao.updateTourUser(2, 1, 200_001, 100_001);


        System.out.println("------------------------");

        boolean deleteTourUserResult = tourUserDao.deleteTourUser(200_000, 100_000);

        System.out.println("------------------------");
        
        allToursUsers = tourUserDao.getAllToursUsers();
        for (TourUserData tourUserDataFromList : allToursUsers) {
            System.out.println(tourUserDataFromList);
        }

    }
}