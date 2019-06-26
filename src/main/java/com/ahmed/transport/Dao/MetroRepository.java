package com.ahmed.transport.Dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.ahmed.transport.entities.MetroLine;

@RepositoryRestResource
public interface MetroRepository extends JpaRepository<MetroLine, Long>{	
}
