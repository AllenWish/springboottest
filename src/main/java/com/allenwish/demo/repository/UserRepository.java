package com.allenwish.demo.repository;

import java.util.List;  

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.jpa.repository.Query;  
import org.springframework.data.repository.query.Param;  
import org.springframework.stereotype.Repository;  

import com.allenwish.demo.domain.TSUser;
  
@Repository  
public interface UserRepository extends JpaRepository<TSUser,Long> {  
	List<TSUser> findByName(String name);  
    
    List<TSUser> findByAddress(String address);  
      
    List<TSUser> findByNameAndAddress(String name,String address);  
    
    @Query("select p from TSUser p where p.name=:name and p.address=:address")  
    List<TSUser> withNameAndAddressQuery(@Param("name")String Name,@Param("address")String address);  
}
