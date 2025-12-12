package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
    
    @Autowired 
    JdbcTemplate jdbcTemplate;

    public List<Product> findAllProducts() {
        List<Product> plist = jdbcTemplate.query("select pid, pname, qty, price, mfgdate, cid from product", (rs, numrows) -> {
            Product p = new Product();
            p.setPid(rs.getInt("pid"));
            p.setPname(rs.getString("pname"));
            p.setQty(rs.getInt("qty"));
            p.setPrice(rs.getDouble("price"));
            
            java.sql.Date sqlDate = rs.getDate("mfgdate");
            if (sqlDate == null) {
                p.setMfgdate(null);
            } else {
                p.setMfgdate(sqlDate.toLocalDate());
            }
            
            p.setCid(rs.getInt("cid"));
            
            return p;
        });
        return plist;
    }

    
    public boolean save(Product p) {
        int n = jdbcTemplate.update("insert into product values(?,?,?,?,?,?)", new Object[] {
                p.getPid(), p.getPname(), p.getQty(), p.getPrice(), p.getMfgdate(), p.getCid()
        });
        return n > 0;
    }

    
    public Product findById(int pid) {
        try {
            Product p = jdbcTemplate.queryForObject("select * from product where pid=?",
                    new Object[] {pid}, BeanPropertyRowMapper.newInstance(Product.class));
            return p;
        } catch(EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }       
    }


    public boolean modifyProduct(Product p) {
        int n = jdbcTemplate.update("update product set pname=?,qty=?,price=?,cid=? where pid=?",
                new Object[] {
                        p.getPname(), p.getQty(), p.getPrice(), p.getCid(), p.getPid()
                });
        return n > 0;
    }


    public boolean removeById(int pid) {
        int n = jdbcTemplate.update("delete from product where pid=?", new Object[] {pid});
        return n > 0;
    }
}