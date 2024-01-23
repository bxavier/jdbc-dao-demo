package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("---- Test 1 - findById ----");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n---- Test 2 - findByDepartment ----");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n---- Test 3 - findAll ----");
        list = sellerDao.finAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n---- Test 4 - insert ----");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println(newSeller.getId());

        System.out.println("\n---- Test 5 - update ----");
        seller = sellerDao.findById(1);
        seller.setName("Marta Wayne");
        sellerDao.update(seller);
        System.out.println("Update complete.");

        Scanner sc = new Scanner(System.in);
        System.out.println("\n---- Test 6 - delete ----");
        System.out.println("Enter id for deletion: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Line with Id " + id + " deleted!");

        seller = sellerDao.findById(1);
        seller.setName("Marta Wayne");
        sellerDao.update(seller);
        System.out.println("Update complete.");

    }
}
