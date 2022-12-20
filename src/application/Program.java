package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TESTE 1: seller find by id ===");

        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== TESTE 2: departiment find by id ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("=== TESTE 3: find all ===");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("=== TESTE 4: insert ===");
        Seller newSeller = new Seller(null, "Teste4", "Teste4@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Insert! New ID: " + newSeller.getId());
    }

}
