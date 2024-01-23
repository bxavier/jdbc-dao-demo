package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("---- Test 1 - find seller by id ----");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n---- Test 2 - find seller by department ----");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n---- Test 3 - find all sellers ----");
        list = sellerDao.finAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n---- Test 4 - insert seller ----");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Seller id: " + newSeller.getId());

        System.out.println("\n---- Test 5 - update seller ----");
        seller = sellerDao.findById(1);
        seller.setName("Marta Wayne");
        sellerDao.update(seller);
        System.out.println("Update complete.");

        Scanner sc = new Scanner(System.in);
        System.out.println("\n---- Test 6 - delete seller ----");
        System.out.println("Enter id for deletion: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Line with Id " + id + " deleted!");

        seller = sellerDao.findById(1);
        seller.setName("Marta Wayne");
        sellerDao.update(seller);
        System.out.println("Update complete.");

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\n---- Test 7 - find department by id ----");
        Department dep = departmentDao.findById(3);
        System.out.println(dep);

        System.out.println("\n---- Test 8 - find all departments ----");
        List<Department> depList = departmentDao.finAll();
        for (Department obj : depList) {
            System.out.println(obj);
        }

        System.out.println("\n---- Test 9 - insert department ----");
        Department newDepartment = new Department(null, "Bugiganga");
        departmentDao.insert(newDepartment);
        System.out.println("Department id: " + newDepartment.getId());

        System.out.println("\n---- Test 10 - update department ----");
        dep = departmentDao.findById(1);
        dep.setName("Department changed");
        departmentDao.update(dep);
        System.out.println("Update complete.");

        System.out.println("\n---- Test 11 - delete department ----");
        System.out.println("Enter id for deletion: ");
        id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Line with Id " + id + " deleted!");

    }
}
